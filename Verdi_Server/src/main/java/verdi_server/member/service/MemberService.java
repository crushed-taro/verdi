package verdi_server.member.service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import verdi_server.member.dto.MemberDTO;
import verdi_server.member.entity.Member;
import verdi_server.member.repository.MemberRepository;

@Service
public class MemberService {

    private static final Logger log = LoggerFactory.getLogger(MemberService.class);
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;

    // Autowired는 적지 않아도 되나 암묵적으로 많이 적는다고 함.
    @Autowired
    public MemberService(MemberRepository memberRepository, ModelMapper modelMapper) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
    }

    public MemberDTO selectMyInfo(String memberId) {
        log.info("[MemberService] selectMyInfo Call...");

        Member member = memberRepository.findByMemberId(memberId);
        log.info("[MemberService] : ", member);
        log.info("[MemberService] selectMyInfo End");

        return modelMapper.map(member, MemberDTO.class);
    }
}
