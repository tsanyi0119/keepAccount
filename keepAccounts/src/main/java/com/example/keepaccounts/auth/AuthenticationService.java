package com.example.keepaccounts.auth;

import com.example.keepaccounts.appUser.AppUserEntity;
import com.example.keepaccounts.appUser.AppUserRepository;
import com.example.keepaccounts.appUser.AppUserRole;
import com.example.keepaccounts.auth.request.LoginRequest;
import com.example.keepaccounts.auth.request.RegisterRequest;
import com.example.keepaccounts.base.StatusResponse;
import com.example.keepaccounts.security.JwtService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class AuthenticationService {

    private final AppUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public StatusResponse register(RegisterRequest request){
        var user = AppUserEntity.builder()
                .userName(request.getUserName())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .userRole(AppUserRole.USER)
                .build();
        userRepository.save(user);

        return StatusResponse.SUCCESS();
    }

    public AuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        log.info(jwtToken);
        return AuthenticationResponse.builder()
                .status("0")
                .token(jwtToken)
                .build();
    }
}
