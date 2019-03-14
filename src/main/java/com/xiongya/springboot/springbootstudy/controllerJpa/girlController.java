package com.xiongya.springboot.springbootstudy.controllerJpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "girl")
public class girlController {

    @Autowired
    private GirlRepository girlRepository;

    //增
    @RequestMapping(value = "add")
    public Girl add(@RequestParam("cupSize") String cupSize,
                    @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);

        return girlRepository.save(girl);
    }

    //删
    @RequestMapping(value = "delete")
    public void delete(@RequestParam("id") Integer id){
        girlRepository.deleteById(id);
    }

    //改
    @RequestMapping(value = "update")
    public Girl update(@RequestParam("cupSize") String cupSize,
                       @RequestParam("age") Integer age,
                       @RequestParam("id") Integer id){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        girl.setId(id);

        return girlRepository.save(girl);
    }

    //查
    @RequestMapping(value = "select")
    public List<Girl> select(){
        return girlRepository.findAll();
    }

    //根据年龄查
    @RequestMapping(value = "select1")
    public List<Girl> select(@RequestParam("age") Integer age){
        return girlRepository.findByAge(age);
    }



}
