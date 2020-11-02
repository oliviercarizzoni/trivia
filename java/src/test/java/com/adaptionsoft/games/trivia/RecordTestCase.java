package com.adaptionsoft.games.trivia;

import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class RecordTestCase {
    protected ByteArrayOutputStream SYSOUT_BYTES_STREAM;
    private PrintStream SYSOUT_PRINT_STREAM;

    @Before
    public void before() {
        SYSOUT_BYTES_STREAM = new ByteArrayOutputStream();
        SYSOUT_PRINT_STREAM = new PrintStream(SYSOUT_BYTES_STREAM);
    }

    @After
    public void after() {
        try {
            SYSOUT_BYTES_STREAM.close();
            SYSOUT_PRINT_STREAM.close();
        } catch (IOException e) {
            throw new RuntimeException("Error: cannot close recording streams", e);
        }
    }

    protected void recording() {
        System.setOut(SYSOUT_PRINT_STREAM);
    }

    protected void stopRecording() {
        System.setOut(System.out);
    }

    protected String getRecording() {
        return SYSOUT_BYTES_STREAM.toString();
    }
}
