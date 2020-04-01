package com.langworthytech;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeEach
    public void init() {
        this.mathUtils = new MathUtils();
    }

    @Test
    public void testAdd() {
        int expected = 2;
        int actual = mathUtils.add(1, 1);

        assertEquals(expected, actual, "Method should add 2 integers");
    }

    @Test
    public void testDivide() {
        assertThrows(ArithmeticException.class,
                () -> mathUtils.divide(1, 0),
                "Divide by zero should throw exception");
    }

    @Test
    public void testComputeCircleRadius() {
        assertEquals(314.1592653589793,
                mathUtils.computeCircleArea(10), "Should return right circle area");
    }
}
