package com.dailycodebuffer.userservice.service;

import com.dailycodebuffer.userservice.VO.Department;
import com.dailycodebuffer.userservice.VO.ResponseTemplate;
import com.dailycodebuffer.userservice.entity.UserInfo;
import com.dailycodebuffer.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public UserInfo saveUser(UserInfo userInfo) {
        log.info("In saveUser method of UserService");
        return userRepository.save(userInfo);
    }

    public ResponseTemplate getUserWithDepartment(Long userId) {
        log.info("In getUserWithDepartment method of UserService");
        ResponseTemplate responseTemplate = new ResponseTemplate();
        UserInfo userInfo = userRepository.findByUserId(userId);
        responseTemplate.setUserInfo(userInfo);
        Department department = restTemplate.getForObject("http://localhost:9090/departments/"+userInfo.getDepartmentId(), Department.class);
        responseTemplate.setDepartment(department);
        return responseTemplate;
    }
}
