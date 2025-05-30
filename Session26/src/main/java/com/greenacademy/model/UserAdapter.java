package com.greenacademy.model;

import com.greenacademy.domain.UserEntity;
import com.greenacademy.domain.UserRoleEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserAdapter implements UserDetails {
    private final UserEntity user;

    public UserAdapter(UserEntity userEntity) {
        this.user = userEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        // user.role = "ROLE_ADMIN,ROLE_CUSTOMER"
        for (UserRoleEntity ur : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(ur.getId().getRoleId()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isEnabled() {
        return user.getStatus() == 1;
    }
}
