package com.langworthytech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {

    @Test
    public void testAdd() {
        MathUtils mathUtils = new MathUtils();

        int expected = 2;
        int actual = mathUtils.add(1, 1);

        Assertions.assertEquals(expected, actual, "Method should add 2 integers");
    }

    @Test
    public void testComputeCircleRadius() {
        MathUtils mathUtils = new MathUtils();
        Assertions.assertEquals(314.1592653589793,
                mathUtils.computeCircleArea(10), "Should return right circle area");
    }
}
