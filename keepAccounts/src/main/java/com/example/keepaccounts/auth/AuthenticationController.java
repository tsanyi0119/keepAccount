package com.example.keepaccounts.auth;

import com.example.keepaccounts.auth.request.LoginRequest;
import com.example.keepaccounts.auth.request.RegisterRequest;
import com.example.keepaccounts.base.StatusResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationService service;

    @Operation(summary = "註冊接口")
    @PostMapping("/register")
    public ResponseEntity<StatusResponse> register(
            @RequestBody @Validated RegisterRequest request
    ){
        return ResponseEntity.ok(service.register(request));
    }

    @Operation(summary = "登入接口")
    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody @Validated LoginRequest request
    ) {
        return ResponseEntity.ok(service.login(request));
    }

}
