package com.score.app.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anup on 27/5/19.
 */

@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private final Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);

    public Map<String, Object> getUser(String email,String password){
        Map<String,Object> user = new HashMap<>();
        try
        {
            user = jdbcTemplate.queryForMap("select id,first_name as firstName, last_name as lastName,email,dob,gender "+
            "from users where email = '"+email+"' and password = '"+password+"'");
        }catch (Exception e){
            LOGGER.error("error fetching user "+e.getMessage());
        }
        return user;
    }
}
