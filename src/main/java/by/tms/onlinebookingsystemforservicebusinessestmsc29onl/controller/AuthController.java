package by.tms.onlinebookingsystemforservicebusinessestmsc29onl.controller;

import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.dto.UserLoginDto;
import by.tms.onlinebookingsystemforservicebusinessestmsc29onl.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDto userLoginDto) {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userLoginDto.getUsername(), userLoginDto.getPassword()));
            String token = jwtUtil.createToken(userLoginDto.getUsername());
            return ResponseEntity.ok().header("Authorization", "Bearer " + token).body("Token: " + token);
    }
}
