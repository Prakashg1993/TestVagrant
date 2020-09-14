package interview_test;

public class test2 {
	public static void main(String[]args){
		 String s="14, 625, 498.002";
		s=s.replaceAll("\\s", "");
		 char c = 0;
		for(int i=0;i<+s.length();i++) {
	 c=s.charAt(i);
	
	if(c==',') {
	c='.';	
	}else if(c=='.') {
		c=',';	
	}
	 System.out.print(c);

		}
		
	}
}
