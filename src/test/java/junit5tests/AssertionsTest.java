package junit5tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    void assertEqualsTest() {
        assertEquals("first string", "second string", "The String values were not equals");
    }

    @Test
    void assertEqualsListTest() {
        List<String> expectedValues = Arrays.asList("first string", "second string", "third string");
        List<String> actual = Arrays.asList("first string", "second string");
        assertEquals(expectedValues, actual);
    }

    @Test
    void assertArraysEqualsTest() {
        int[] expectedValues = {1, 5, 3};
        int[] actualValues = {1, 2, 3};
        assertArrayEquals(expectedValues, actualValues);
    }

    @Test
    void assertTrueTest() {
        assertTrue(true, "This boolean condition is not true");
    }

    @Test
    void assertThrowsTest() {
        assertThrows(NullPointerException.class, null);
    }

    @Test
    void assertAllTest() {
        assertAll(
                () -> assertEquals("first string", "second string", "The String values were not equals"),
                () -> assertThrows(NullPointerException.class, null),
                () -> assertTrue(false, "This boolean condition is not true")
        );
    }

}
