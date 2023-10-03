package com.example.keepaccounts.assets;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "AssetsDeleteRequest", description = "資產紀錄刪除請求")
public class AssetsDeleteRequest {
    @JsonProperty(value = "id")
    private Long id;
}
