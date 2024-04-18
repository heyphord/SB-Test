/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmfs.demo.controller;

import com.gmfs.demo.dto.DemoRequestDto;
import com.gmfs.demo.dto.DemoResponseDto;
import com.gmfs.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("api/v1")
public class DemoController {


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<Object> demo4() {


        return new ResponseEntity<>("Testing v1", HttpStatus.OK);
    }
    /**
     * Demo controller with path variable
     */
    @RequestMapping(path = "/test/{testValue}", method = RequestMethod.GET)
    public ResponseEntity<Object> demo(@PathVariable("testValue") String testValue) {


        return new ResponseEntity<>(testValue, HttpStatus.OK);
    }
    /**
     * Demo controller with Request and Response DTO (Data transfer object)
     */
    @RequestMapping(path = "/test", method = RequestMethod.GET)
    public ResponseEntity<Object> demo2(@RequestBody DemoRequestDto request) {


        DemoResponseDto responseDto = new DemoResponseDto();
        responseDto.setValue("Response from DTO");

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * Demo controller with reusable service
     */
    @Autowired
    DemoService demoService;
    @RequestMapping(path = "/test-with-service", method = RequestMethod.GET)
    public ResponseEntity<Object> demo3() {


        String resultsFromService = demoService.reusableServiceMethod();


        return new ResponseEntity<>(resultsFromService, HttpStatus.OK);
    }


}
