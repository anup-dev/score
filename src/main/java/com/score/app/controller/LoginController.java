package com.score.app.controller;

import com.score.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anup on 24/5/19.
 */

@CrossOrigin(origins = "*")
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getTestMessage() {

        return new ResponseEntity("welcome to project", HttpStatus.OK);

    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String email,@RequestParam String password){
        Map<String,Object> user = new HashMap<>();
        if(!email.isEmpty() && !password.isEmpty()){
            user = userService.getUser(email, password);
            if(!user.isEmpty()){
                return new ResponseEntity(user,HttpStatus.OK);
            }else {
                return new ResponseEntity("user not found", HttpStatus.UNAUTHORIZED);
            }

        }else {
            return new ResponseEntity("user not found", HttpStatus.UNAUTHORIZED);
        }

    }
}
