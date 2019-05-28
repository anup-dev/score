package com.score.app.controller;

import com.score.app.model.Fixture;
import com.score.app.service.FixtureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anup on 28/5/19.
 */

@CrossOrigin(origins = "*")
@RestController
public class FixtureController {

    @Autowired
    private FixtureService fixtureService;

    @GetMapping("/getFixture")
    public ResponseEntity<?> getFixture(){
        Map<String,Object> fixture = new HashMap<>();
        fixture = fixtureService.getFixture();
        if(fixture.get("status").equals("success")){
            return new ResponseEntity(fixture, HttpStatus.OK);
        }else{
            return new ResponseEntity(fixture, HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/postFixture")
    public ResponseEntity<?> createFixture(@RequestBody Fixture fixture){
        Map<String,Object> response = new HashMap<>();
        response = fixtureService.postFixture(fixture);
        if(response.get("status").equals("success")){
            return new ResponseEntity(response, HttpStatus.OK);
        }else{
            return new ResponseEntity(response, HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/putFixture")
    public ResponseEntity<?> updateFixture(@RequestBody Fixture fixture){
        Map<String,Object> response = new HashMap<>();
        response = fixtureService.putFixture(fixture);
        if(response.get("status").equals("success")){
            return new ResponseEntity(response, HttpStatus.OK);
        }else{
            return new ResponseEntity(response, HttpStatus.CONFLICT);
        }
    }


}
