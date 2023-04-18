package com.github.curriculeon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public interface DocumentInterface {

    default void write(String contentToBeWritten, boolean append) {
        try {
            final FileWriter fileWriter = getFileWriter(append);
            fileWriter.write(contentToBeWritten);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    default DocumentInterface append(String contentToBeWritten) {
        write(contentToBeWritten, true);
        return this;
    }


    default void replaceAllContent(String content) {
        write(content, false);
    }

    default void replaceLine(Integer lineNumber, String valueToBeWritten) {
        final StringBuilder result = new StringBuilder();
        final List<String> lines = toList();
        lines.set(lineNumber, valueToBeWritten);
        lines.forEach(line -> result.append(line).append("\n"));
        replaceAllContent(result.toString().replaceAll("$\n", ""));
    }

    default void replaceAllOccurrences(String stringToReplace, String replacementString) {
        replaceAllContent(read().replaceAll(stringToReplace, replacementString));
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


    default FileWriter getFileWriter(boolean append) {
        try {
            return new FileWriter(getFile(), append);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    File getFile();
}
