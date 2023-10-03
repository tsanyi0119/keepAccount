package com.example.keepaccounts.expenses;

import com.example.keepaccounts.appUser.AppUserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class ExpensesService {
    private final ExpensesRepository expensesRepository;

    public Map<String, Object> getExpenses(String request) {
        var response = new LinkedHashMap<String, Object>();
        var appUser = (AppUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var Data = new ArrayList<>();
        LocalDate date = LocalDate.parse(request, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        var expensesData = expensesRepository.findExpensesByDateAndAppUser(date,appUser);
        if (!expensesData.isEmpty()){
            for(var expenses:expensesData){
                Data.add(expenses);
            }
        }
        response.put("status", "0");
        response.put("message","ok");
        response.put("expensesDataList", Data);
        return  response;
    }
    public Map<String, Object> getAllExpenses() {
        var response = new LinkedHashMap<String, Object>();
        var appUser = (AppUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var Data = new ArrayList<>();
        var expensesData = expensesRepository.findAllExpensesByAppUser(appUser);
        if (!expensesData.isEmpty()){
            for(var expenses:expensesData){
                Data.add(expenses);
            }
        }
        response.put("status", "0");
        response.put("message","ok");
        response.put("expensesDataList", Data);
        return  response;
    }
    public Map<String, Object> addExpenses(ExpensesRequest request){
        var response = new LinkedHashMap<String, Object>();
        var appUser = (AppUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var expensesData = ExpensesEntity
                .builder()
                .appUser(appUser)
                .expensesType(request.getExpensesType())
                .expensesName(request.getExpensesName())
                .expensesValue(request.getExpensesValue())
                .recorded_at(request.getRecorded_at())
                .build();
        expensesRepository.save(expensesData);
        response.put("status", "0");
        response.put("message", "ok");
        return response;
    }

    public Map<String, Object> deleteExpenses(Long request){
        var response = new LinkedHashMap<String, Object>();
        expensesRepository.deleteById(request);
        response.put("status", "0");
        response.put("message", "ok");
        return response;
    }
}
