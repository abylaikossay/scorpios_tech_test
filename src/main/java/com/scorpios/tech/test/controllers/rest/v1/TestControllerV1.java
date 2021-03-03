package com.scorpios.tech.test.controllers.rest.v1;

import com.scorpios.tech.test.controllers.BaseController;
import com.scorpios.tech.test.services.v1.TestServiceV1;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/test")
@AllArgsConstructor
public class TestControllerV1 extends BaseController {

    private TestServiceV1 testServiceV1;

    @PostMapping("/1")
    public ResponseEntity<?> Task1(@RequestParam("file") MultipartFile file) throws IOException {
        return buildSuccess("OUTPUT.TXT", testServiceV1.task1(file));
    }

    @PostMapping("/2")
    public ResponseEntity<?> Task2(@RequestParam("file") MultipartFile file) throws IOException {
        return buildSuccess("OUTPUT.TXT", testServiceV1.task2(file));
    }

    @PostMapping("/3")
    public ResponseEntity<?> Task3(@RequestParam("file") MultipartFile file) throws IOException {
        return buildSuccess("OUTPUT.TXT", testServiceV1.task3(file));
    }

    @PostMapping("/4")
    public ResponseEntity<?> Task4(@RequestParam("file") MultipartFile file) throws IOException {
        return buildSuccess("OUTPUT.TXT", testServiceV1.task4(file));
    }

    @PostMapping("/5")
    public ResponseEntity<?> Task5(@RequestParam("file") MultipartFile file) throws IOException {
        return buildSuccess("OUTPUT.TXT", testServiceV1.task5(file));
    }

    @PostMapping("/6")
    public ResponseEntity<?> Task6(@RequestParam("file") MultipartFile file) throws IOException {
        return buildSuccess("OUTPUT.TXT", testServiceV1.task6(file));
    }

    @PostMapping("/7")
    public ResponseEntity<?> Task7(@RequestParam("file") MultipartFile file) throws IOException {
        return buildSuccess("OUTPUT.TXT", testServiceV1.task7(file));
    }

    @PostMapping("/8")
    public ResponseEntity<?> Task8(@RequestParam("file") MultipartFile file) throws IOException {
        return buildSuccess("OUTPUT.TXT", testServiceV1.task8(file));
    }

    @PostMapping("/9")
    public ResponseEntity<?> Task9(@RequestParam("file") MultipartFile file) throws IOException {
        return buildSuccess("OUTPUT.TXT", testServiceV1.task9(file));
    }

    @PostMapping("/10")
    public ResponseEntity<?> Task10(@RequestParam("file") MultipartFile file) throws IOException {
        return buildSuccess("OUTPUT.TXT", testServiceV1.task10(file));
    }

    @PostMapping("/11")
    public ResponseEntity<?> Task11(@RequestParam("file") MultipartFile file) throws IOException {
        return buildSuccess("OUTPUT.TXT", testServiceV1.task11(file));
    }

    @PostMapping("/12")
    public ResponseEntity<?> Task12(@RequestParam("file") MultipartFile file) throws IOException {
        return buildSuccess("OUTPUT.TXT", testServiceV1.task12(file));
    }


}
