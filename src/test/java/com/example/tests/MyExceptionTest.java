package com.example.tests;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyExceptionTest {

    public static void validate(int age) throws MyException {

        if (age < 18) {
            throw new MyException("Выдача кредита невозможна");
        } else {
            System.out.println("Кредит одобрен");
        }
    }

    public static void main(String[] args) {
        try {
            validate(17);
        } catch (MyException e) {
            System.out.println("мое исключение поймано " + e.getMessage());
        }
















//        List<Integer> ages = Arrays.asList(10, 17, 19, 20, 0, 151);
//
//        try {
//            List<Integer> validAges = ages.stream()
//                    .map(age -> {
//                        if (age < 18) {
//                            throw new IllegalArgumentException("Кредит не выдается: " + age);
//                        }
//                        return age;
//                    })
//                    .toList();
//
//            System.out.println("Валидные возрасты: " + validAges);
//
//        } catch (IllegalArgumentException e) {
//            System.err.println("Ошибка: " + e.getMessage());
//        }
    }


}

