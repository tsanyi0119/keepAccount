package com.example.keepaccounts.assets;

import com.example.keepaccounts.appUser.AppUserEntity;
import com.example.keepaccounts.expenses.ExpensesEntity;
import com.example.keepaccounts.expenses.ExpensesRepository;
import com.example.keepaccounts.expenses.ExpensesRequest;
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
public class AssetsService {

    private final AssetsRepository assetsRepository;

    public Map<String, Object> getAssets(String request) {
        var response = new LinkedHashMap<String, Object>();
        var appUser = (AppUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var Data = new ArrayList<>();
        LocalDate date = LocalDate.parse(request, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        var assetsData = assetsRepository.findAssetsByDateAndAppUser(date,appUser);
        if (!assetsData.isEmpty()){
            for(var assets:assetsData){
                Data.add(assets);
            }
        }
        response.put("status", "0");
        response.put("message","ok");
        response.put("assetsDataList", Data);
        return  response;
    }

    public Map<String, Object> addAssets(AssetsRequest request){
        var response = new LinkedHashMap<String, Object>();
        var appUser = (AppUserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        var assetsData = AssetsEntity
                .builder()
                .appUser(appUser)
                .assetsType(request.getAssetsType())
                .assetsName(request.getAssetsName())
                .assetsValue(request.getAssetsValue())
                .recorded_at(request.getRecorded_at())
                .build();
        assetsRepository.save(assetsData);
        response.put("status", "0");
        response.put("message", "ok");
        return response;
    }

    public Map<String, Object> deleteAssets(Long request){
        var response = new LinkedHashMap<String, Object>();
        assetsRepository.deleteById(request);
        response.put("status", "0");
        response.put("message", "ok");
        return response;
    }

}
