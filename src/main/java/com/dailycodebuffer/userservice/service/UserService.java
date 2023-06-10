package com.dailycodebuffer.userservice.service;

import com.dailycodebuffer.userservice.VO.Department;
import com.dailycodebuffer.userservice.VO.ResponseTemplateVO;
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

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("In getUserWithDepartment method of UserService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        UserInfo userInfo = userRepository.findByUserId(userId);
        vo.setUserInfo(userInfo);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+userInfo.getDepartmentId(), Department.class);
        vo.setDepartment(department);
        return vo;
    }
}
