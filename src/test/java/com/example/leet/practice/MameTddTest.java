package com.example.leet.practice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MameTddTest {

    @Test
    public void whenTwoIntegersGivenReturnsSum(){
        int sum = new MameTdd().absoluteSum(4, 7);

        assertEquals(sum, Math.addExact(4, 7));
    }

    @Test
    public void whenTwoNegativeIntegersGivenReturnsSum(){
        int sum = new MameTdd().absoluteSum(-4, -7);

        assertEquals(sum, Math.addExact(4, 7));
    }

}