class fibonacci {

	public static void main(String args[]){
		long m=50;						//nth term
		long n=m-1;
		long a1=4, a2=6;
		long fib[]=new long[(int) (n+1)];
		fib[0] = a1; fib[1] = a2;
		long sum = fib[0] + fib[1];
		if (n < 0) {
			sum=0;
		}
		if (n == 0) {
			sum=a1;
		}
		
		for (int i=2; i<=n; i++) {
			fib[i] = fib[i-1]+fib[i-2];
			sum += fib[i];
			}
		int element=(int) fib[(int) n];
		System.out.println("Sum of terms of Fibonacci until F_"+m+
			" is : "+ sum +"\na_"+n+" is: "+element);
	}
}