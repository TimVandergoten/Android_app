package com.timvandergoten.beercollect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class MainActivityTest {
    //needed for api doesn't accept strings with spaces
    @Test
    public void cleanInputHasNoSpaces() {
        String testString = "punk software ";
        String result = MainActivity.cleanInput(testString);

        assertEquals("punk_software", result);
    }
}