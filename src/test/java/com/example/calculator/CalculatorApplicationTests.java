package com.example.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculatorApplicationTests {

	@Test
	void testAdd() {
		assertEquals(5, CalculatorApplication.add(2, 3), "2 + 3 should equal 5");
	}

	@Test
	void testSubtract() {
		assertEquals(1, CalculatorApplication.subtract(3, 2), "3 - 2 should equal 1");
	}

	@Test
	void testMultiply() {
		assertEquals(6, CalculatorApplication.multiply(2, 3), "2 * 3 should equal 6");
	}

	@Test
	void testDivide() {
		assertEquals(2, CalculatorApplication.divide(4, 2), "4 / 2 should equal 2");
		assertEquals(Double.NaN, CalculatorApplication.divide(4, 0), "Divide by zero should return NaN");
	}

	@Test
	void testRoot() {
		assertEquals(2, CalculatorApplication.root(4), "Square root of 4 should be 2");
	}

	@Test
	void testFactorial() {
		assertEquals(120, CalculatorApplication.factorial(5), "Factorial of 5 should be 120");
		assertEquals(Double.NaN, CalculatorApplication.factorial(-1), "Factorial of negative number should return NaN");
	}

	@Test
	void testLog() {
		assertEquals(Math.log(1), CalculatorApplication.log(1), "Log of 1 should equal 0");
	}

	@Test
	void testExponent() {
		assertEquals(8, CalculatorApplication.exponent(2, 3), "2 raised to power 3 should be 8");
	}

}
