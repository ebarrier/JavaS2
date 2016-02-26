package practice2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProdNum0Test {

	@Test
	public void testProdSimple() {
		assertEquals(6, ProdNum0.prod(123));
		assertEquals(27, ProdNum0.prod(333));
		assertEquals(30, ProdNum0.prod(56));
	}
	
	@Test
	public void testProdZero() {
		assertEquals(0, ProdNum0.prod(324320234));
		assertEquals(0, ProdNum0.prod(0));
		assertEquals(0, ProdNum0.prod(1223024233));
		assertEquals(0, ProdNum0.prod(1212310));
	}
	
	@Test
	public void testProdMax() {
		int bigNum = 999999999;
		assertEquals((int)Math.pow(9, String.valueOf(bigNum).length()), ProdNum0.prod(bigNum));
	}
	
	@Test
	public void testProdNeg() {
		assertEquals(10, ProdNum0.prod(-25));
		assertEquals(42, ProdNum0.prod(-732));
		assertEquals(81, ProdNum0.prod(-99));
	}
	
	@Test
	public void testProdNull() {
		assertEquals(0, ProdNum0.prod(null));
		
	}
}
