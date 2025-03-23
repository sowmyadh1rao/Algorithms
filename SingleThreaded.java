package Question5;

public class SingleThreaded {
	
	
	public int findPosition(int[] a,int start, int end,int number) {
		int position1=-1;
		int position2=-1;
		
		if(start==end) {
			if(a[start]<number) {
				return 1; 
			}
			else return 0;
		}
		else {
		int mid=(start+end)/2;
		position1= findPosition(a,start,mid,number);
		position2= findPosition(a,mid+1,end,number);
		return position1+position2;
		}
		
		
	}
	
	public int[] divideArray(int[] a,int start,int end,int[] b) {
		int position=-1;
		if(start==end) {
			position=findPosition(a,0,a.length-1,a[start]);
			b[position]=a[start];
		}
		else {
			int mid=(start+end)/2;
			b=divideArray(a,start,mid,b);
			b=divideArray(a,mid+1,end,b);	
		}
		return b;
	}
	
	
	
	public static void main(String[] arg) {
		SingleThreaded m=new SingleThreaded();
		
		int[] a = {0,9,-7,5,7,4,12,-3};
		int[] b = {0,0,0,0,0,0,0,0};
		
		b=m.divideArray(a,0,a.length-1,b);
		
		System.out.println();
		for(int i=0;i<b.length;i++) {
			System.out.print(" "+b[i]);
		}
		
	}

}
