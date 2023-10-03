package com.example.keepaccounts.expenses;

import com.example.keepaccounts.appUser.AppUserEntity;
import com.example.keepaccounts.assets.AssetsEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExpensesRepository extends JpaRepository<ExpensesEntity, Long> {

    @Query("SELECT e FROM ExpensesEntity e WHERE DATE(e.recorded_at) = :date AND e.appUser = :appUser")
    List<ExpensesEntity> findExpensesByDateAndAppUser(@Param("date") LocalDate date, AppUserEntity appUser);

    @Query("SELECT e FROM ExpensesEntity e WHERE e.appUser = :appUser")
    List<ExpensesEntity> findAllExpensesByAppUser(AppUserEntity appUser);

    @Transactional
    @Modifying
    @Query("DELETE FROM ExpensesEntity d WHERE d.id = :id AND d.appUser = :appUser")
    void deleteByIdAndAppUser(@Param("id") Long id, @Param("appUser") AppUserEntity appUser);

}
