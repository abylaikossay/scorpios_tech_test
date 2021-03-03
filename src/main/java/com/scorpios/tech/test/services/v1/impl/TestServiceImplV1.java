package com.scorpios.tech.test.services.v1.impl;

import com.scorpios.tech.test.services.v1.TestServiceV1;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
public class TestServiceImplV1 implements TestServiceV1 {
    @Override
    public void task1(MultipartFile multipartFile) {
        System.out.println("FILE 1 " + multipartFile);
    }
}
