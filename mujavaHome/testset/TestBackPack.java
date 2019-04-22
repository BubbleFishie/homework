import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBackPack {
	
	public BackPack backPack=null;
	
	@Before
	public void setUp() {
		backPack=new BackPack();
	}
	
	@After
	public void setDown() {
		backPack=null;
	}
	
	@Test 
	public void test1() {
		int m = 10;
        int n = 3;
        int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};

        int c[][]= {
        		{0,0,0,0,0,0,0,0,0,0,0},
        		{0,0,0,4,4,4,4,4,4,4,4},
        		{0,0,0,4,5,5,5,9,9,9,9},
        		{0,0,0,4,5,6,6,9,10,11,11}};
        assertArrayEquals(c, backPack.BackPack_Solution(m, n, w, p));
	}

	@Test 
	public void test2() {
		int m = 5;
        int n = 1;
        int w[] = {4};
        int p[] = {5};

        int c[][]= {
        		{0,0,0,0,0,0},
        		{0,0,0,0,5,5}};
        assertArrayEquals(c, backPack.BackPack_Solution(m, n, w, p));
	}
	
	@Test 
	public void test3() {
		int m = 3;
        int n = 3;
        int w[] = {6,7,8};
        int p[] = {8,9,9};

        int c[][]= {
        		{0,0,0,0},
        		{0,0,0,0},
        		{0,0,0,0},
        		{0,0,0,0}
        		};
        assertArrayEquals(c, backPack.BackPack_Solution(m, n, w, p));
	}
	
	@Test 
	public void test4() {
		int m = 5;
        int n = 0;
        int w[] = {};
        int p[] = {};

        int c[][]= {
        		{0,0,0,0,0,0}};
        assertArrayEquals(c, backPack.BackPack_Solution(m, n, w, p));
	}
	
	@Test 
	public void test5() {
		int m = 7;
        int n = 2;
        int w[] = {3, 4};
        int p[] = {4, 5};

        int c[][]= {
        		{0,0,0,0,0,0,0,0},
        		{0,0,0,4,4,4,4,4},
        		{0,0	,0	,4	,5	,5	,5	,9}};
        assertArrayEquals(c, backPack.BackPack_Solution(m, n, w, p));
	}
}
