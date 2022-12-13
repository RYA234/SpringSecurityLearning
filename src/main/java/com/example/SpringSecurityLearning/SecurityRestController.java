package com.example.SpringSecurityLearning;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class SecurityRestController {


    @PostMapping("/api/test")
    public @ResponseBody HumanEntity getRestController(){
        HumanEntity humanEntity = new HumanEntity(21,"nick");
        return humanEntity;
    }


}
