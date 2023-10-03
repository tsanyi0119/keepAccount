package com.example.keepaccounts.auth.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(name = "LoginRequest", description = "登入請求")
public class LoginRequest {
    @Schema(description = "使用者的信箱")
    @NotBlank
    @Email
    private String email;

    @Schema(description = "使用者的密碼")
    @NotBlank
    private String password;
}
