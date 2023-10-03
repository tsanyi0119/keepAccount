package com.example.keepaccounts.expenses;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "ExpensesDeleteRequest", description = "花費紀錄刪除請求")
public class ExpensesDeleteRequest {
    @JsonProperty(value = "id")
    private Long id;
}
