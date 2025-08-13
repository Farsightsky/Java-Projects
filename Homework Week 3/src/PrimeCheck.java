public class PrimeCheck{
	private static int[] array= {4,1,6,7,32, 37,5,7,11,100,400157};
	public static void main(String args[]){
		getData(array);
		
		listPrimeNumbers();
		countPrimeNumbers();
	}
	public static int[] getData(int[] array) {
		System.out.format("Original elements of the array: ");
		for(int i=0;i<array.length;i++) {
			System.out.format("%d ", array[i]);
		}
		return array;
	}
	
	public static void listPrimeNumbers(){
		int m=0;
		System.out.format("\nPrime number of the array: ");
		for(int i=0;i<array.length;i++) {
			m=array[i]/2;
			if(array[i]==0||array[i]==1){
			}
			else{
				for(int d=2;d<=m;){
					if(array[i]%d==0){ 
						break;
					}
					else  {
						System.out.format("%d ",array[i]);
						break;
					}
				}
			}
		}
		return;
	}
	public static void countPrimeNumbers(){
		int m=0, primeCounter=0;
		System.out.format("\nNumber of prime numbers of the array: ");
		for(int i=0;i<array.length;i++) {
			m=array[i]/2;
			if(array[i]==0||array[i]==1){
			}
			else{
				for(int d=2;d<=m;){
					if(array[i]%d==0){ 
						break;
					}
					else  {
						primeCounter++;
						break;
					}
				}
			}
		}
		System.out.print(primeCounter);
		return;
	}
}