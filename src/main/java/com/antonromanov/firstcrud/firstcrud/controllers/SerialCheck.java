package com.antonromanov.firstcrud.firstcrud.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

@RestController
@RequestMapping("/rest")
public class SerialCheck {

    @PostMapping("/addlog")
    public ResponseEntity<String> addLog(@RequestBody String requestParam, HttpServletRequest request, HttpServletResponse resp) throws ParseException {

        System.out.println("################################");
        System.out.println("BODY:  " + requestParam);
        System.out.println("################################");

        ResponseEntity<String> responseEntity = null;

        responseEntity = new ResponseEntity<>("{}", HttpStatus.OK);

        return responseEntity;
    }
}
