package com.scorpios.tech.test.controllers.rest.v1;

import com.scorpios.tech.test.controllers.BaseController;
import com.scorpios.tech.test.services.v1.TestServiceV1;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/test")
@AllArgsConstructor
public class TestControllerV1 extends BaseController {

    private TestServiceV1 testServiceV1;

    @PostMapping("/task1")
    public ResponseEntity<?> firstTask(@RequestParam("file") MultipartFile file) {
        testServiceV1.task1(file);
        return buildSuccess("Success", "Task 1");
    }


}
