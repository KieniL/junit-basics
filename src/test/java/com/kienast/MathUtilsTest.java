package com.kienast;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {
	
	MathUtils mathUtils;

	@BeforeEach
	void init () {
		mathUtils = new MathUtils();
	}
	
	//Nested Test
	@Nested
	@Tag("Math") //use Tag for Tagging with Certain Names
	class AddTest {
		@Test
		@DisplayName("Testing add method for +") //Add better Name instead of Methodname to JUnit-Report
		void testAddPositive() {
			assertEquals(2, mathUtils.add(1, 1));
		}
		
		@Test
		@DisplayName("Testing add method for -") //Add better Name instead of Methodname to JUnit-Report
		void testAddNegative() {
			assertEquals(-2, mathUtils.add(-1, -1));
		}
	}
	
	@AfterEach
	void cleanup() {
		System.out.println("Cleaning up...");
	}
	

	
	@Tag("Circle")
	@RepeatedTest(3) //run Test multiple times
	void testComputeCircleArea() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10),
				"should return right circle area");
	}
	
	@Test
	@Tag("Math")
	@DisplayName("multiply Method")
	void testMultiply() {
		//assertEquals(4, mathUtils.multiply(2, 2));
		
		//Multiple Asserts for Testing
		assertAll(
				() -> assertEquals(4, mathUtils.multiply(2, 2)),
				() -> assertEquals(0, mathUtils.multiply(2, 0)),
				() -> assertEquals(-2, mathUtils.multiply(2, -1))
				);
	}
	
	@Test
	@Tag("Math")
	void testDivide() {
		//assumeTrue(true); Assume that value is true
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),
				"divide by zero should throw");
		
		
	}
	
	@Test
	@Disabled //Annotation to skip test
	@DisplayName("TDD. Should not run")
	void TestDisabled() {
		fail("This test should be disabled");
	}

}
