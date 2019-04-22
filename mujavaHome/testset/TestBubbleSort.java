
import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBubbleSort {
	private BubbleSort bs=null;
	
	@Before
	public void setUp() {
		bs=new BubbleSort();
	}
	
	@After
	public void setDown() {
		bs=null;
	}
	
	@Test
	public void test1() {
		int [] st1=new int [] {1,4,5,6};
		int [] st2=new int [] {1,5,6,4};
		assertArrayEquals(st1,bs.BubbleSort(st2));
	}
	
	@Test
	public void test2() {
		int [] st3=new int [] {10,9,3,4,5,6};
		int [] st4=new int [] {3,4,5,6,9,10};
		assertArrayEquals(st4,bs.BubbleSort(st3));
	}
	
	@Test
	public void test3() {
		int [] st5=new int [] {0,1};
		int [] st6=new int [] {0,1};
		assertArrayEquals(st6,bs.BubbleSort(st5));
	}
	
	@Test
	public void test4() {
		int [] st7=new int [] {3,6,2,5,3};
		int [] st8=new int [] {2,3,3,5,6};
		assertArrayEquals(st8,bs.BubbleSort(st7));
	}
	
	@Test
	public void test() {
		int [] st9=new int [] {7};
		int [] st10=new int [] {7};
		assertArrayEquals(st10,bs.BubbleSort(st9));
	}

}
