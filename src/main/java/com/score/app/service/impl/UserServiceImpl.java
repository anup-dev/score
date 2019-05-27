package com.score.app.service.impl;

import com.score.app.repository.UserRepository;
import com.score.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Anup on 27/5/19.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Map<String, Object> getUser(String email, String password) {
        return userRepository.getUser(email,password);
    }
}
