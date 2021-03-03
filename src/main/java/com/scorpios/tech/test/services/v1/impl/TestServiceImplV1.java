package com.scorpios.tech.test.services.v1.impl;

import com.scorpios.tech.test.models.responses.error.ErrorCode;
import com.scorpios.tech.test.models.responses.error.ServiceException;
import com.scorpios.tech.test.services.v1.TestServiceV1;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
public class TestServiceImplV1 implements TestServiceV1 {
    @Override
    public String task1(MultipartFile multipartFile) throws IOException {
        String content = this.fileText(multipartFile);
        char[] ch = content.toCharArray();
        int number = 0;
        int max = 0;
        for (char c : ch) {
            if (c == '0') number++;
            if (number > max) max = number;
            if (c != '0') number = 0;
        }
        return Integer.toString(max);
    }

    @Override
    public String task2(MultipartFile multipartFile) throws IOException {
        String str1 = ">>-->";
        String str2 = "<--<<";
        int count = 0;

        String content = this.fileText(multipartFile);
        return content;
    }

    @Override
    public String task3(MultipartFile multipartFile) throws IOException {
        String content = this.fileText(multipartFile);
        return content;
    }

    @Override
    public String task4(MultipartFile multipartFile) throws IOException {
        String content = this.fileText(multipartFile);
        return content;
    }

    @Override
    public String task5(MultipartFile multipartFile) throws IOException {
        String content = this.fileText(multipartFile);
        return content;
    }

    @Override
    public String task6(MultipartFile multipartFile) throws IOException {
        String content = this.fileText(multipartFile);
        return content;
    }

    @Override
    public String task7(MultipartFile multipartFile) throws IOException {
        String content = this.fileText(multipartFile);
        return content;
    }

    @Override
    public String task8(MultipartFile multipartFile) throws IOException {
        String content = this.fileText(multipartFile);
        return content;
    }

    @Override
    public String task9(MultipartFile multipartFile) throws IOException {
        String content = this.fileText(multipartFile);
        return content;
    }

    @Override
    public String task10(MultipartFile multipartFile) throws IOException {
        String content = this.fileText(multipartFile);
        return content;
    }

    @Override
    public String task11(MultipartFile multipartFile) throws IOException {
        String content = this.fileText(multipartFile);
        return content;
    }

    @Override
    public String task12(MultipartFile multipartFile) throws IOException {
        String content = this.fileText(multipartFile);
        return content;
    }

    private String fileText(MultipartFile multipartFile) throws IOException {
        return new String(multipartFile.getBytes());
    }
}
