package com.example.tests;

import com.codeborne.selenide.SelenideElement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.Selenide.$;

public class TestMethods {
    SelenideElement upload = $("#file-upload");

    public  String readFile(File file) throws IOException{
            Path path = file.toPath();  // используем переданный файл
            return Files.readString(path);
    }

    public void fillFile (String text) throws IOException {
        File file = new File("src/test/resources/test_en.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        fileOutputStream.write(text.getBytes());
        fileOutputStream.close();
    }


}
