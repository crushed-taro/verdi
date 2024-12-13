package verdi_server.member.controller;

import org.aspectj.lang.reflect.MemberSignature;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import verdi_server.common.ResponseDTO;
import verdi_server.member.service.MemberService;

@RestController
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<ResponseDTO> selectMyMemberInfo(@PathVariable String memberId) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "조회 성공", memberService.selectMyInfo(memberId)));
    }
}
