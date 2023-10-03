package com.example.keepaccounts.expenses;

import com.example.keepaccounts.base.StatusResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Tag(name = "花費模塊")
public class ExpensesController {

    private final ExpensesService service;

    @GetMapping("/expenses")
    @Operation(summary = "花費列表資料")
    public ResponseEntity<?> getExpenses(
            @RequestParam("date") String date
    ) {
        return ResponseEntity.ok(service.getExpenses(date));
    }

    @GetMapping("/expenses/all")
    @Operation(summary = "花費列表資料")
    public ResponseEntity<?> getAllExpenses() {
        return ResponseEntity.ok(service.getAllExpenses());
    }



    @PostMapping("/expenses")
    @Operation(summary = "新增負債資料")
    public ResponseEntity<?> addExpenses(
            @RequestBody ExpensesRequest request
    ) {
        return ResponseEntity.ok(service.addExpenses(request));
    }

    @DeleteMapping("/expenses")
    @Operation(summary = "刪除負債記錄")
    public ResponseEntity<?> deleteExpenses(
            @RequestParam("id") Long request
    ) {
        return ResponseEntity.ok(service.deleteExpenses(request));
    }
}
