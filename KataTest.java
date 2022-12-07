import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KataTest {
	Kata kata;
	@BeforeEach
	public void setUp() {
		kata = new Kata();
	}

	@Test
	void testSumEmptyString() throws Exception  {
		String empty = "";
		assertEquals(0,kata.Add(empty));
	}
	@Test
	void testSumOneDigit() throws Exception  {
		String one = "1";
		assertEquals(1,kata.Add(one));
	}
	@Test
	void testSumTwoDigits() throws Exception  {
		String two = "1,2";
		assertEquals(3,kata.Add(two));
	}
	@Test
	void testUnknownNumberOfDigits() throws Exception  {
		String numbers = "1,2,3,4,5,6,7,8,9";
		assertEquals(45,kata.Add(numbers));
	}
	@Test
	void testNewLineSeparator() throws Exception  {
		String numbers = "1\n2,3";
		assertEquals(6,kata.Add(numbers));
	}
	@Test
	void testSupportDifferentDelimiters() throws Exception  {
		String numbers = "//;\\n1;2";
		assertEquals(3,kata.Add(numbers));
	}
	@Test
	void testAddNegativeNumbersThrowsExceptionCase1() throws Exception {
		String numbers = "-1,2,-3";
		try {
			kata.Add(numbers);
		} catch (Exception e) {
			assertEquals("negatives not allowed [-1, -3]",e.getMessage());
		}
		
	}
	@Test
	void testAddNegativeNumbersThrowsExceptionCase2()  {
		String numbers = "//;\\n-1;2;5;-3";
		try {
			kata.Add(numbers);
		} catch (Exception e) {
			assertEquals("negatives not allowed [-1, -3]",e.getMessage());
		}
		
	}
	@Test
	void testAddNegativeNumbersThrowsExceptionCase3() throws Exception {
		String numbers = "-1\n2,-3";
		try {
			kata.Add(numbers);
		} catch (Exception e) {
			assertEquals("negatives not allowed [-1, -3]",e.getMessage());
		}
		
	}
	@Test
	void testIgnoreGreaterThan1000() throws Exception {
		String numbers = "2,1001";
		assertEquals(2,kata.Add(numbers));
		
	}
}
