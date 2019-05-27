package com.score.app.repository;

import com.score.app.model.User;
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

    public Map<String, Object> postUser(User user){
        Map<String,Object> result = new HashMap<>();
        try
        {
            int row = jdbcTemplate.update("INSERT INTO users(" +
                    "id, first_name, last_name, email, password, dob, gender)\n" +
                    "VALUES ((select max(id)+1 from users), '"+user.getFirstName()+"', '"+user.getLastName()+"', '"+user.getEmail()+"','"+user.getPassword()+"','"+user.getDob()+"', '"+user.getGender()+"')");
            if(row > 0){
                result.put("status","success");
            }
        }catch (Exception e){
            LOGGER.error("error creating user "+e.getMessage());
            result.put("status","fail");

        }
        return result;
    }
}
