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
	void testSumEmptyString() {
		String empty = "";
		assertEquals(0,kata.Add(empty));
	}
	@Test
	void testSumOneDigit() {
		String one = "1";
		assertEquals(1,kata.Add(one));
	}
	@Test
	void testSumTwoDigits() {
		String two = "1,2";
		assertEquals(3,kata.Add(two));
	}

}
