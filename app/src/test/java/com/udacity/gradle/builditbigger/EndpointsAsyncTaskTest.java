package com.udacity.gradle.builditbigger;

import org.junit.Test;

import static org.junit.Assert.*;

public class EndpointsAsyncTaskTest {

    @Test
    public void check_empty_string () {

        assertTrue(MainActivity.testAsyncTask());

    }
}