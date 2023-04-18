package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author leon on 16/11/2018.
 */
public class DocumentAppendTest {
    private String fileName;

    @Before
    public void setup() {
        this.fileName = "target/file.txt";
        new Document(fileName).replaceAllContent("");
    }


    @Test
    public void test1() throws IOException {
        // given
        String expected1 = "The quick brown fox";
        String expected2 = "The quicker brown fox";
        String expected = expected1 + expected2;
        Document documentWriter = new Document(fileName);

        // when
        documentWriter
                .append(expected1)
                .append(expected2);
        String actual = documentWriter.read();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test2() throws IOException {
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
    public void test3() throws IOException {
        // given
        String expected = "123";
        Document documentWriter = new Document(fileName);

        // when
        documentWriter.replaceAllContent(expected);
        String actual = documentWriter.read();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test4() throws IOException {
        // given
        String expected = "123";
        Document documentWriter = new Document(fileName);

        // when
        documentWriter.replaceAllContent(expected);
        String actual = documentWriter.read();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test5() throws IOException {
        // given
        String expected = "123";
        Document documentWriter = new Document(fileName);

        // when
        documentWriter.replaceAllContent(expected);
        String actual = documentWriter.read();

        // then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test6() throws IOException {
        // given
        String expected = "123";
        Document documentWriter = new Document(fileName);

        // when
        documentWriter.replaceAllContent(expected);
        String actual = documentWriter.read();

        // then
        Assert.assertEquals(expected, actual);
    }
}
