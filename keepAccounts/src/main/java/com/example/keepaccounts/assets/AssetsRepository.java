package com.example.keepaccounts.assets;

import com.example.keepaccounts.appUser.AppUserEntity;
import com.example.keepaccounts.expenses.ExpensesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AssetsRepository extends JpaRepository<AssetsEntity, Long> {

    @Query("SELECT e FROM AssetsEntity e WHERE DATE(e.recorded_at) = :date AND e.appUser = :appUser")
    List<AssetsEntity> findAssetsByDateAndAppUser(@Param("date") LocalDate date, AppUserEntity appUser);

}
