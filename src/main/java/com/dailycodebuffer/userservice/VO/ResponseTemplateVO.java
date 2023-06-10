package com.dailycodebuffer.userservice.VO;

import com.dailycodebuffer.userservice.entity.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseTemplateVO {

    private UserInfo userInfo;
    private Department department;
}
