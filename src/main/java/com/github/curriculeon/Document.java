package com.github.curriculeon;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author leon on 16/11/2018.
 */
public class Document implements DocumentInterface {
    private final File file;

    public Document(File file) {
        this.file = file;
    }

    public Document(String fileName) {
        this.file = new File(fileName);
    }

    @Override
    public File getFile() {
        return file;
    }
}
