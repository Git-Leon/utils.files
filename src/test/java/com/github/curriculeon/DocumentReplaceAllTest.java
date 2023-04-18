package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author leon on 16/11/2018.
 */
public class DocumentReplaceAllTest {
    private String fileName;

    @Before
    public void setup() {
        this.fileName = "target/file.txt";
        new File(fileName).delete();
    }

    @Test
    public void writeTest1() throws IOException {
        // given
        String contentToBeOverwritten = "The quick brown fox";
        String expected = "The quick browner fox";
        Document documentWriter = new Document(fileName);
        documentWriter.append(contentToBeOverwritten);

        // when
        documentWriter.replaceAll(expected);
        String actual = documentWriter.read();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void writeTest2() throws IOException {
        // given
        String contentToBeOverwritten = "The quick brown fox";
        String expected = "The quick brownest fox";
        Document documentWriter = new Document(fileName);
        documentWriter.append(contentToBeOverwritten);

        // when
        documentWriter.replaceAll(expected);
        String actual = documentWriter.read();

        // then
        Assert.assertEquals(expected, actual);
    }
}