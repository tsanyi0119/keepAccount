package com.example.keepaccounts.assets;

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
@Table(name = "_assets")
public class AssetsEntity {
    @CreatedBy
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private AppUserEntity appUser;
    @Id
    @GeneratedValue
    private Long id;
    private String assetsType;
    private String assetsName;
    private Integer assetsValue;
    @LastModifiedDate
    @JsonIgnore
    private LocalDate recorded_at;
}
