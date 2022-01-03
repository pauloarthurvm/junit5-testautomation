package junit5tests;

import listeners.Listener;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(Listener.class)
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

    @Test
    void assertForMapTest() {
        Map<String, Integer> map = new HashMap<>();
        map.put("firstKey", 1);
        map.put("secondKey", 2);
        map.put("thirdKey", 3);

        assertThat(map, Matchers.hasValue(22));
        assertThat(map, Matchers.hasKey("secondKey"));
    }

    @Test
    void assertForList() {
        List<String> list = Arrays.asList("firstString", "secondString", "thirdString");
        assertThat(list, Matchers.hasItem("thirdStrings"));
    }


    @Test
    void assertForAnyOf() {
        List<String> list = Arrays.asList("firstString", "secondString", "thirdString");
//        assertThat(list, Matchers.anyOf(Matchers.hasItem("thirdString"), Matchers.hasItem("noString")));
        assertThat(list, Matchers.allOf(Matchers.hasItem("thirdString"), Matchers.hasItem("noString")));
    }

    @Test
    void assertForContainsAnyOrder() {
        List<String> list = Arrays.asList("firstString", "secondString", "thirdString");
        assertThat(list, Matchers.containsInAnyOrder("firstString", "thirdString", "secondString"));
    }

}
