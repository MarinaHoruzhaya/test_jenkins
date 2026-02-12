package com.example.tests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ExampleTest extends TestMethods {

    String text = "Привет. Меня зовут Марина";

    @Test()
    @Description("Переход на сайт с формой загрузки и загрузка файла")
    public void uploadFileTest() {
        File file = new File("src/test/resources/test-upload.txt");

        open("https://the-internet.herokuapp.com/upload");
        try {
            readFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        $("#file-upload").uploadFile(file);
        $("#file-submit").click();
        //  $("#uploaded-files").shouldHave(text("test-upload.txt"));
    }

    @Test()
    @Description("Переход на сайт с формой загрузки и загрузка файла")
    public void uploadFileTest2() throws FileNotFoundException {
        File file = new File("src/test/resources/test_en.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        open("https://the-internet.herokuapp.com/upload");


        try {
            fileOutputStream.write(text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        $("#file-upload").uploadFile(file);
        $("#file-submit").click();
        // $("#uploaded-files").shouldHave(text("test-en.txt"));
    }

    @Test()
    @Description("Переход на сайт с формой загрузки и загрузка файла")
    public void uploadFileTest3() {
        File file = new File("src/test/resources/test_en.txt");

        open("https://the-internet.herokuapp.com/upload");

        try (FileOutputStream fileOutputStream = new FileOutputStream(file);) {
            fileOutputStream.write(text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        $("#file-upload").uploadFile(file);
        $("#file-submit").click();
        // $("#uploaded-files").shouldHave(text("test-en.txt"));
    }

}
