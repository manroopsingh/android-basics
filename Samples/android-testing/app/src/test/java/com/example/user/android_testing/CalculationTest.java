package com.example.user.android_testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by singh on 7/17/17.
 */


public class CalculationTest {

    Calculation calculation;

    Multiplication multiplication;


    @Before
    public void setup() throws Exception {

        multiplication = mock(Multiplication.class);

        calculation = new Calculation(multiplication);
        calculation.setVal1(5);
        calculation.setVal2(10);

    }

    @Test
    public void testing_calculation_multiple() {

        assertEquals(calculation.multiply(), 50);

    }

    @Test
    public void testing_calculation_multipleDouble() {

        when(multiplication.multiplyFloat(3.4, 5.4)).thenReturn(3.8);
        assertEquals(calculation.multipleDouble(), 5.0);


    }

    @After
    public void tearDown() {

        calculation.changeBack();

    }


}
