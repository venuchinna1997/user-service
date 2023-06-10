package com.dailycodebuffer.userservice.controller;

import com.dailycodebuffer.userservice.VO.ResponseTemplateVO;
import com.dailycodebuffer.userservice.entity.UserInfo;
import com.dailycodebuffer.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public UserInfo saveUser(@RequestBody UserInfo userInfo){
        log.info("In saveUser method of UserController");
        return userService.saveUser(userInfo);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("In getUserWithDepartment method of UserController");
        return userService.getUserWithDepartment(userId);
    }

}
