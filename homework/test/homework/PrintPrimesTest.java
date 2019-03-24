package homework;

import org.junit.Before;
import org.junit.Test;


public class PrintPrimesTest {
	private PrintPrimes pptest;
	
    @Before
    public void setUp() throws Exception {
        pptest = new PrintPrimes();
    }


	@Test
	public void testPrintPrimes() {
		//assertEquals(this.expected,pptest.printPrimes(this.input));
		pptest.printPrimes(0);
		pptest.printPrimes(5);
		pptest.printPrimes(6);
	}
	
    
    

}
