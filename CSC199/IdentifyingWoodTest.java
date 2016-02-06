import static org.junit.Assert.*;

class IdentifyingWoodTest {
	@Test
	public void test() {
		IdentifyingWood test = new IdentifyingWood();
		String output = test.check("absdefgh", "asdf");
		assertEquals(output, "Yep, it's wood.");
		
		output = test.check("happy", "asdf");
		assertEquals(output, "Nope.");
	}
}