package com.example.keepaccounts.auth.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(name = "RegisterRequest", description = "註冊請求")
public class RegisterRequest {
    @Schema(description = "使用者的名稱")
    @NotBlank
    private String userName;
    @Schema(description = "使用者的信箱")
    @NotBlank
    @Email
    private String email;
    @Schema(description = "使用者的密碼")
    @NotBlank
    private String password;

}
