package com.score.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Anup on 24/5/19.
 */

@CrossOrigin(origins = "*")
@RestController
public class LoginController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> getTestMessage() {

        return new ResponseEntity("welcome to project", HttpStatus.OK);

    }
}
