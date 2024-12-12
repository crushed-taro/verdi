package verdi_server.member.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import verdi_server.exception.LoginFailedException;
import verdi_server.jwt.TokenProvider;
import verdi_server.member.dto.MemberDTO;
import verdi_server.member.dto.TokenDTO;
import verdi_server.member.entity.Member;
import verdi_server.member.repository.MemberRepository;
import verdi_server.member.repository.MemberRoleRepository;

@Service
public class AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);

    private final TokenProvider tokenProvider;
    private final ModelMapper modelMapper;

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final MemberRoleRepository memberRoleRepository;

    @Autowired
    public AuthService(TokenProvider tokenProvider, ModelMapper modelMapper, MemberRepository memberRepository, PasswordEncoder passwordEncoder, MemberRoleRepository memberRoleRepository) {
        this.tokenProvider = tokenProvider;
        this.modelMapper = modelMapper;
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.memberRoleRepository = memberRoleRepository;
    }

    public Object login(MemberDTO memberDTO) {
        log.info("[AuthService] login() Call...");
        log.info("[AuthService] memberDTO : ", memberDTO);

        Member member = memberRepository.findByMemberId(memberDTO.getMemberId());

        if (member == null) {
            log.info("[AuthService] login() Required User Not Found");
            throw new LoginFailedException(memberDTO.getMemberId() + " 유저를 찾을 수 없습니다.");
        }

        if (!passwordEncoder.matches(memberDTO.getMemberPassword(), member.getPassword())) {
            log.info("[AuthService] login() Password Match Failed");
            throw new LoginFailedException("잘못된 비밀번호 입니다.");
        }

        TokenDTO newToken = tokenProvider.generateTokenDTO(member);

        return newToken;
    }
}
