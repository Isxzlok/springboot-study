package com.xiongya.springboot.springbootstudy.controller;


import com.xiongya.springboot.springbootstudy.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Autowired
    private Person person;

    @RequestMapping(value = "person")
    public String test(){
        return person.getName()+person.getAge()+person.getSex();
    }

    @RequestMapping(value = "hello")
    public String say(){
        return "hello world";
    }

    //接受url的参数
    @RequestMapping(value = "/say/{id}", method = RequestMethod.GET)  //http://127.0.0.1:8080/say/10
    public String say1(@PathVariable("id") String id){
        return id;
    }

    @RequestMapping(value = "/say", method = RequestMethod.GET)   //http://127.0.0.1:8080/say?id=10
    public String say2(@RequestParam("id") String id){

        return id;
    }

}
