package com.langworthytech;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class MathUtilsTest {

    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    public static void beforeAllInit() {
        System.out.println("This needs to run before all");
    }

    @AfterAll
    public static void afterAllInit() {
        System.out.println("This needs to run after all");
    }

    @BeforeEach
    public void init(TestInfo testInfo, TestReporter testReporter) {
        System.out.println("Initiating objects...");
        this.mathUtils = new MathUtils();
        this.testInfo = testInfo;
        this.testReporter = testReporter;
    }

    @AfterEach
    public void cleanup() {
        System.out.println("Cleaning up...");
    }

    @Nested
    @DisplayName("Add Test")
    @Tag("Math")
    class AddTest {

        @Test
        @DisplayName("Add Positive Test")
        public void testAddPositive() {
            int expected = 2;
            int actual = mathUtils.add(1, 1);
            assertEquals(expected, actual, "Method should add 2 integers");
        }

        @Test
        @DisplayName("Add Negative Test")
        public void testAddNegative() {
            assertEquals(-2, mathUtils.add(-1, -1), "Should return the right sum");
        }
    }

    @Test
    @DisplayName("Multiply Test")
    @Tag("Math")
    public void testMultiply() {
        testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tag " + testInfo.getTags());
        assertAll(
            () -> assertEquals(4, mathUtils.multiply(2, 2)),
            () -> assertEquals(16, mathUtils.multiply(4, 4)),
            () -> assertEquals(256, mathUtils.multiply(16, 16)),
            () -> assertEquals(0, mathUtils.multiply(0, 4)),
            () -> assertEquals(-2, mathUtils.multiply(2, -1))
        );
    }

    @Test
    @DisplayName("Divide Test")
    @Tag("Math")
    public void testDivide() {
        boolean isServerUp = true;
        assumeTrue(isServerUp); //Will not run if server is down
        assertThrows(ArithmeticException.class,
                () -> mathUtils.divide(1, 0),
                "Divide by zero should throw exception");
    }

    @Test
    @DisplayName("Compute Circle Radius Test")
    @Tag("Circle")
    public void testComputeCircleRadius() {
        assertEquals(314.1592653589793,
                mathUtils.computeCircleArea(10), "Should return right circle area");
    }

    @Test
    @Disabled
    @DisplayName("Fail Test")
    public void testDisabled() {
        fail("This test is disabled."); // this test should fail
    }

    @RepeatedTest(3)
    public void repeatableTest(RepetitionInfo repetitionInfo) {
        System.out.println("Repetition " + repetitionInfo.getCurrentRepetition());

    }
}
