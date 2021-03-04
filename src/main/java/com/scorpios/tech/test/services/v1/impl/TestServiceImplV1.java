package com.scorpios.tech.test.services.v1.impl;

import com.scorpios.tech.test.models.responses.error.ErrorCode;
import com.scorpios.tech.test.models.responses.error.ServiceException;
import com.scorpios.tech.test.services.v1.TestServiceV1;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
        return String.valueOf(max);
    }

    @Override
    public String task2(MultipartFile multipartFile) throws IOException {
        String content = this.fileText(multipartFile);
        int answer = 0;
        String arr1 = ">>-->";
        String arr2 = "<--<<";
        //Длина стринга 5 ==>
        for (int i = 0; i < content.length() - 5; i++) {
            String compare = content.substring(i, i + 5);
            if(compare.equals(arr1) || compare.equals(arr2)){
                answer++;
            }
        }
        return String.valueOf(answer);
    }

    @Override
    public String task3(MultipartFile multipartFile) throws IOException {
        String content = this.fileText(multipartFile);
        int max = 0;
        int count = 0;
        String countTemp = "";
        int resultcount=0;
        for (int i = 1; i < content.length(); i++) {
            count = 0;
            String tempStr = content.substring(0, i);
            for (int j = 0; j < content.length(); j += i) {
                if (j + i < content.length()) {
                    countTemp = content.substring(j, j + i);
                    if (tempStr.equals(countTemp)) {
                        count++;
                        if (count > 1 && count>max) {
                            max = count;
                            resultcount=((j+i)-j);
                        }
                    }
                    else break;
                }
            }
        }
        return String.valueOf(resultcount);
    }

    @Override
    public String task4(MultipartFile multipartFile) throws IOException {
        String content = this.fileText(multipartFile);
        String[] parts = content.split("\n");
//        int length = Integer.parseInt(parts[0]);
        String[] strNumbers = parts[1].split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String number : strNumbers) {
            numbers.add(Integer.valueOf(number));
        }
        int sum = 0;
        int max = numbers.get(0);
        int min = numbers.get(0);
        int maxIndex = 0;
        int minIndex = 0;
        int multiplication = 1;
        for (int i = 0; i < numbers.size(); i ++) {
            if (numbers.get(i) > 0) {
                sum += numbers.get(i);
            }
            if (numbers.get(i) > max) {
                max = numbers.get(i);
                maxIndex = i;
            }
            if (numbers.get(i) < min) {
                min = numbers.get(i);
                minIndex = i;
            }
        }
        maxIndex++;
        minIndex++;
        if (maxIndex > minIndex) {
            for (int i = minIndex; i < maxIndex - 1; i++) {
                if (maxIndex - minIndex != 1) {
                    multiplication *= numbers.get(i);
                }
            }
        } else {
            for (int i = maxIndex; i < minIndex - 1; i++) {
                if (minIndex - maxIndex != 1) {
                    multiplication *= numbers.get(i);
                }
            }
        }
        return String.valueOf(sum) + " " + String.valueOf(multiplication);
    }

    @Override
    public String task5(MultipartFile multipartFile) throws IOException {
        String content = this.fileText(multipartFile);
        String[] parts = content.split("\n");
        int length = Integer.parseInt(parts[0]);
        String[] strNumbers = parts[1].split(" ");
        int[] numbers = new int[strNumbers.length];
        for (int i = 0; i < strNumbers.length; i++ ) {
            numbers[i] = Integer.parseInt(strNumbers[i]);
        }
        int maxPos = 0;
        int sum = 0;
        while (numbers.length > 0) {
            maxPos = findLargestPosition(numbers);
            sum += (maxPos + 1) * numbers[maxPos];
            numbers = Arrays.copyOfRange(numbers, maxPos + 1, numbers.length);
        }
        return String.valueOf(sum);
    }

    private Integer findLargestPosition(int [] numbers) {
        int maxPos = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= numbers[maxPos]) {
                maxPos = i;
            }
        }
        return maxPos;
    }

    @Override
    public String task6(MultipartFile multipartFile) throws IOException {
        String content = this.fileText(multipartFile);
        int number = Integer.parseInt(content);
        if (isTwoFold(number)) {
            return String.valueOf(number);
        }
        int asc = number;
        int desc = number;
        while (true) {
            asc++;
            desc--;
            if (isTwoFold(asc)) {
                return String.valueOf(asc);
            }
            if (isTwoFold(desc)) {
                return String.valueOf(desc);
            }
        }
    }
    //task 6 funct
    private boolean isTwoFold(int number) {
        Integer firstDigit = null;
        Integer secondDigit = null;
        while (number > 0) {
            int currentDigit = number % 10;
            number /= 10;

            if (firstDigit == null) {
                firstDigit = currentDigit;
                continue;
            } else if (firstDigit == currentDigit) {
                continue;
            }
            if (secondDigit == null) {
                secondDigit = currentDigit;
            } else if (secondDigit != currentDigit) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String task7(MultipartFile multipartFile) throws IOException {
        String content = this.fileText(multipartFile);
        String answer = "";
        int number = Integer.valueOf(content);
        if (number < 2 || number > 40) {
            throw ServiceException.builder()
                    .message("Число меньше 2 или больше 40")
                    .errorCode(ErrorCode.INVALID_NUMBER)
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .build();
        }
        int length = number;
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            numberList.add(1);
        }
        answer = numberList.stream().map(String::valueOf)
                .collect(Collectors.joining("+"));
        answer = answer + System.lineSeparator() + "1+1+2";
        System.out.println("ANSWER " + answer);
//        do {
//            length = findLength(numberList, length);
//        } while (length > 1);
        return answer;
    }
    private int findLength(List<Integer> numberS, int length) {
        return 1;
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
        int amount = Integer.parseInt(content);
        switch (amount) {
            case 0:
            case 1:
                return "0";
            case 2:
                return "1";
            case 3:
                return "2";
        }
        long combinations = 2;
        long repeatComb = 3;
        for (int i = Math.toIntExact(repeatComb); i < amount; i++) {
            long noRepeatComb = repeatComb * i;
            repeatComb = noRepeatComb + combinations;
            combinations = noRepeatComb;
        }
        return String.valueOf(combinations);
    }

    private String fileText(MultipartFile multipartFile) throws IOException {
        return new String(multipartFile.getBytes());
    }
}
