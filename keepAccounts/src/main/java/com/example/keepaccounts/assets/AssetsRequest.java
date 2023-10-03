package com.example.keepaccounts.assets;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Schema(name = "AssetsRequest", description = "資產新增請求")
public class AssetsRequest {
    @Schema(description = "資產名稱")
    private String assetsName;
    @Schema(description = "資產金額")
    private Integer assetsValue;
    @Schema(description = "資產類型")
    private String assetsType;
    @Schema(description = "使用者的記錄時間")
    private LocalDate recorded_at;
}
