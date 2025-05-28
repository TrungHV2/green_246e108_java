package com.greenacademy.service.impl;

import com.greenacademy.entity.UserEntity;
import com.greenacademy.model.UserAdapter;
import com.greenacademy.repository.UserRepository;
import com.greenacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails userDetails = new UserAdapter(user);
        return userDetails;
    }
}
