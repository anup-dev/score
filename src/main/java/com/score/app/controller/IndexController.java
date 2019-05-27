package com.score.app.controller;

import com.score.app.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anup on 27/5/19.
 */

@CrossOrigin(origins = "*")
@RestController
public class IndexController {

    @Autowired
    private IndexService indexService;

    @GetMapping("/dashboard")
    public ResponseEntity<?> dashboard(){

        Map<String,Object> dashboard = new HashMap<>();
        dashboard = indexService.getDashboard();
        if(!dashboard.isEmpty()){
            return new ResponseEntity(dashboard, HttpStatus.OK);
        }else{
            return new ResponseEntity("Data not available", HttpStatus.NO_CONTENT);
        }
    }
}
