package simpleProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class SimpleTest {
	
	
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void test() {
		
		assertTrue(false);
		
		// fail("Not yet implemented");
	}
	
	@Test
	void testAdd() {
		
		assertEquals(2, 1+1);
		
		//assertTrue(true);
		
		// fail("Not yet implemented");
	}
	
	Multiply m = new Multiply();
	
	@Test
	void testMultiply() {
		
		assertEquals(4, m.execute(2,2));
		
	}
	
	@Test
	void testRead() {
		
//		var department;
//		
//		// var department = Crud.read(10);
//		assertNotNull(department);
//		assertAll("Read", 
//				() -> assertEquals("Ventas", department.getName()),
//				() -> assertEquals("Soria", department.getLoc()));
	}

}
