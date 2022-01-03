package junit5tests;

import org.junit.jupiter.api.*;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//This is to dont have to create static non-test methods

//@TestMethodOrder(MethodOrderer.MethodName.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class OrderedTestClass1 {

    @BeforeAll
    void beforeAll() {
        System.out.println("-- This is beforeAll() method.");
    }

    @BeforeEach
    void beforeEah() {
        System.out.println("---- This is beforeEach() method.");
    }

    @AfterAll
    void afterAll() {
        System.out.println("-- This is afterAll() method.");
    }

    @AfterEach
    void afterEach() {
        System.out.println("---- This is afterEach() method.");
    }

//    accessModifier returnType nameOfMethod(params)
    @Test
    void firstMethod() {
        System.out.println("First test");
    }

    @Test
    @DisplayName("USER2374 - TC2356 - TestCase information")
    void secondMethod() {
        System.out.println("Second test");
    }

    @Test
    @DisplayName("A display name")
    void thirdTest() {
        System.out.println("Third test");
    }

}
