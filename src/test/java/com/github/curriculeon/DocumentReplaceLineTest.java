package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author leon on 16/11/2018.
 */
public class DocumentReplaceLineTest {
    private String fileName;

    @Before
    public void setup() {
        this.fileName = "target/file.txt";
        new File(fileName).delete();
    }


    @Test
    public void writeToLineTest1() throws IOException {
        // given
        String contentToBeWritten = "The\nquick\nbrown\nfox";
        String replacement = "quicker";
        String expected = contentToBeWritten.replaceAll("quick", replacement);

        Document documentWriter = new Document(fileName);
        documentWriter.replaceAllContent(contentToBeWritten);

        // when
        documentWriter.replaceLine(1, replacement);

        // then
        Assert.assertEquals(expected, documentWriter.read());
    }

    @Test
    public void writeToLineTest2() throws IOException {
        // given
        String contentToBeWritten = "The\nquick\nbrown\nfox";
        String replacement = "quickest";
        String expected = contentToBeWritten.replaceAll("The", replacement);

        Document documentWriter = new Document(fileName);
        documentWriter.replaceAllContent(contentToBeWritten);

        // when
        documentWriter.replaceLine(0, replacement);

        // then
        Assert.assertEquals(expected, documentWriter.read());
    }
}