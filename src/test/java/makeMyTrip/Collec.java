package makeMyTrip;

import java.util.HashMap;

public class Collec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int a[]= {1,2,0,4,7,0,0};
//		
//		int l=a.length-1;
//		int k[]=new int[a.length];
//		int r=0;
//		for(int i=0;i<a.length;i++) {
//			if(a[i]!=0) {
//				System.out.println("i value"+a[i]);
//				k[r]=a[i];
//				r++;
//			
//			}
//			else {
//				k[l]=a[i];
//				l--;
//			}
//		}
//		for(int i=0;i<a.length;i++) {
//			System.out.println(k[i]);
//		}
		
		String str="hcl-tech";
		HashMap<Character, Integer> map=new HashMap();
		int k=1;
		for(int i=0;i<str.length();i++) {
			for(int j=i+1;j<str.length();j++) {
			if(str.charAt(i)==str.charAt(j)) {
				k++;
			}
			
			}
			map.put(str.charAt(i),k);
			k=1;
			System.out.println(map);
			
		}
//		for(int i=0;i<map.size();i++) {
//			System.out.println(map.get(i));
//		}
		

}
		

}
