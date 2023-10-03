package com.example.keepaccounts.appUser;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class AppUserEntity implements UserDetails {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String email;
    private String userName;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole userRole; // 使用者角色(ex: USER或ADMIN等)

    public AppUserEntity(String userName, String email, String password, AppUserRole userRole) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userRole = userRole;
    }

    /**
     * 用於提供該用戶授權權限集合
     * @return 用戶被授權的權限集合
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(userRole.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    /**
     * 用來判斷使用者的帳戶是否過期
     * @return 如果帳戶已過期，返回false，表示使用者不應該被授權，反之則true。
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 用來判斷使用者的帳戶是否被鎖定
     * @return 如果帳戶被鎖定，返回false，表示使用者不應該被授權。
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 用來判斷使用者的認證信息是否過期，例如密碼是否過期
     * @return 如果認證信息已過期，返回false，表示使用者不應該被授權。
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 用來判斷使用者是否啟用，如果使用者已被禁用
     * @return 返回false，表示使用者不應該被授權。
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
