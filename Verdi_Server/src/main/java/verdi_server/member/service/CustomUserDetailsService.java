package verdi_server.member.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import verdi_server.member.dto.MemberDTO;
import verdi_server.member.entity.Member;
import verdi_server.member.entity.MemberRole;
import verdi_server.member.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CustomUserDetailsService(MemberRepository memberRepository, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(username);
        MemberDTO memberDTO = modelMapper.map(member, MemberDTO.class);
        List<GrantedAuthority> authorities = new ArrayList<>();

        for(MemberRole memberRole : member.getMemberRole()) {
            String authorityName = memberRole.getAuthority().getAuthorityName();
            authorities.add(new SimpleGrantedAuthority(authorityName));
        }

        memberDTO.setAuthorities(authorities);

        return memberDTO;
    }
}
