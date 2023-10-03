package com.example.keepaccounts.assets;

import com.example.keepaccounts.expenses.ExpensesRequest;
import com.example.keepaccounts.expenses.ExpensesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@Tag(name = "資產模塊")
public class AssetsController {

    private final AssetsService service;

    @GetMapping("/assets")
    @Operation(summary = "資產列表資料")
    public ResponseEntity<?> getAssets(
            @RequestParam("date") String date
    ) {
        return ResponseEntity.ok(service.getAssets(date));
    }

    @PostMapping("/assets")
    @Operation(summary = "新增資產資料")
    public ResponseEntity<?> addAssets(
            @RequestBody AssetsRequest request
    ) {
        return ResponseEntity.ok(service.addAssets(request));
    }

    @DeleteMapping("/assets")
    @Operation(summary = "刪除資產記錄")
    public ResponseEntity<?> deleteAssets(
            @RequestParam("id") Long request
    ) {
        return ResponseEntity.ok(service.deleteAssets(request));
    }
}
