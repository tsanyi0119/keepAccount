package com.example.keepaccounts.expenses;

import com.example.keepaccounts.appUser.AppUserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_expenses")
public class ExpensesEntity {
    @CreatedBy
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private AppUserEntity appUser;
    @Id
    @GeneratedValue
    private Long id;
    private String expensesType;
    private String expensesName;
    private Integer expensesValue;
    @LastModifiedDate
    @JsonIgnore
    private LocalDate recorded_at;
}
