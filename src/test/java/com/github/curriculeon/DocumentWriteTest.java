package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author leon on 16/11/2018.
 */
public class DocumentWriteTest {
    private String fileName;

    @Before
    public void setup() {
        this.fileName = "target/file.txt";
        new File(fileName).delete();
    }



    @Test
    public void writeAlphaValuesTest() throws IOException {
        // given
        String expected = "The quick brown fox";
        Document documentWriter = new Document(fileName);

        // when
        documentWriter.append(expected);
        String actual = documentWriter.read();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void writeSpecialCharactersTest() throws IOException {
        // given
        String expected = "()";
        Document documentWriter = new Document(fileName);

        // when
        documentWriter.append(expected);
        String actual = documentWriter.read();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void writeNumericValuesTest() throws IOException {
        // given
        String expected = "123";
        Document documentWriter = new Document(fileName);

        // when
        documentWriter.append(expected);
        String actual = documentWriter.read();

        // then
        Assert.assertEquals(expected, actual);
    }
}
