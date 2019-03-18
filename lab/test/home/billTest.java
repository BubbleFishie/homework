package home;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class billTest {
		private int input;
		private boolean expected;
		private bill bi=null;
		
		public billTest(boolean expected,int input) {
			this.input=input;
			this.expected=expected;
		}
		
		@Before
		public void setUp() {
			bi=new bill();
		}
		
		@Parameters
		public static Collection<Object[]> getData() {
			return Arrays.asList(new Object[][] {
				{true,2},
				{true,3},
				{false,4},
				{true,32},
				{true,33},
				{false,34},
				{true,51},
				{true,72},
				{true,83},
				{false,100},
			});
		}
		
		@Test
		public void test() {
			assertEquals(this.expected,bi.hasin(this.input));
		}
}