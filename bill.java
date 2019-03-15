package home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

//口袋里有一张50元，一张20元，两张5元钞票和三张1元硬币。写一个程序，看看你是否可以拿出给定数字（x）元。
public class bill {
	
	public int S[]= {1,1,1,5,5,20,50};
	
	public boolean hasin(int x) {
		ArrayList<ArrayList<Integer>> res=subsets_1(S);
    	int sum_list[]=sum(res);
		if(x>83||x<=0)
			return false;
		else {
			for(int i=0;i<sum_list.length;i++) {
				if(x==sum_list[i])
					return true;
			}
		}
		return false;
	}
	//求得每个子数组的元素之和
	public static int [] sum(ArrayList<ArrayList<Integer>> res){
		int [] sum_list=new int [res.size()];
		for(int i=1;i<res.size();i++) {
			for(int j=0;j<res.get(i).size();j++) {
				sum_list[i-1]+=res.get(i).get(j);	
			}
		}
		return sum_list;
	}
	//列举出数组的所有子数组
	public static ArrayList<ArrayList<Integer>> subsets_1(int[] S){
        ArrayList<Integer> current=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();

        Arrays.sort(S);  //排序
        subsets_(S,current,0,res);
        return res;
    }
	
    private static void subsets_(int[] s,ArrayList<Integer> current, int level, ArrayList<ArrayList<Integer>> res) {
        if(level==s.length){
            res.add(new ArrayList<Integer>(current));
            return;
        }
        subsets_(s,new ArrayList<Integer>(current),level+1,res);

        current.add(s[level]);
        subsets_(s,new ArrayList<Integer>(current),level+1,res);
    } 
}