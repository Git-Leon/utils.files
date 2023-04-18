package com.github.curriculeon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public interface DocumentInterface {


    default void append(String contentToBeWritten) {
        try {
            final FileWriter fileWriter = getFileWriter();
            fileWriter.write(contentToBeWritten);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    default void replaceLine(Integer lineNumber, String valueToBeWritten) {
        final StringBuilder result = new StringBuilder();
        final List<String> lines = toList();
        lines.set(lineNumber, valueToBeWritten);
        for (String line : lines) {
            result.append(line);
            result.append("\n");
        }
        append(result.toString().replaceAll("$\n", ""));
    }


    default void replaceAll(String content) {
        try {
            final FileWriter overWriter = new FileWriter(getFile(), false);
            overWriter.write(content);
            overWriter.flush();
            overWriter.close();
        } catch (IOException e) {
            throw new Error(e);
        }
    }

    default void replaceAllOccurrences(String stringToReplace, String replacementString) {
        replaceAll(read().replaceAll(stringToReplace, replacementString));
    }

    default String read(Integer lineNumber) {
        return toList().get(lineNumber);
    }

    default String read() {
        final StringBuilder contents = new StringBuilder();
        try {
            final Scanner scanner = new Scanner(getFile());
            while (scanner.hasNextLine()) {
                final String currentLine = scanner.nextLine();
                contents.append(currentLine);
                contents.append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contents.toString().replaceAll("$\n", "");
    }



    default List<String> toList() {
        return Arrays.asList(read().split("\n"));
    }


    default FileWriter getFileWriter() {
        try {
            return new FileWriter(getFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    File getFile();
}
