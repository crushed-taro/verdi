package verdi_server.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import verdi_server.common.ResponseDTO;
import verdi_server.member.dto.MemberDTO;
import verdi_server.member.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // swagger
//    @Operation
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "로그인 성공", authService.login(memberDTO)));
    }

    @PostMapping("/signup")
    public ResponseEntity<ResponseDTO> signup(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.CREATED, "회원가입 성공", authService.signup(memberDTO)));
    }
}
