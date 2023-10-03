package com.example.keepaccounts.expenses;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Schema(name = "ExpensesRequest", description = "負債新增請求")
public class ExpensesRequest {
    @Schema(description = "負債名稱")
    private String expensesName;
    @Schema(description = "負債金額")
    private Integer expensesValue;
    @Schema(description = "負債類型")
    private String expensesType;
    @Schema(description = "使用者的記錄時間")
    private LocalDate recorded_at;
}
