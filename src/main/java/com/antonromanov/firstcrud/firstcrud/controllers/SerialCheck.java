package com.antonromanov.firstcrud.firstcrud.controllers;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/rest")
public class SerialCheck {



    @GetMapping("/rest")
    public String newRequest() {

        return "1111";
    }


}
