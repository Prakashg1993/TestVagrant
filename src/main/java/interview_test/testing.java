package interview_test;

public class testing {
	public static void main(String[]args){
		 int[] arr= new int[6];
	        arr[0]=25;
	        arr[1]=45;
	        arr[2]=25;
	        arr[3]=96;
	        arr[4]=45;
	        arr[5]=250;
	        
	    
	        
	        for(int i=0;i<=arr.length;i++){
	            
	            for(int j=i+1;j<=arr.length-1;j++){
	                if(arr[i]==arr[j]){
	                   
	                    System.out.print(i+" "+arr[i]+" "+j);
	                }
	                
	            }
	             System.out.println();
	            
	        }
		
	}

}
