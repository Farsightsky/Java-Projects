import java.util.Scanner;
public class PigLatin {
    
    public static void main(String[] args) {
    	int [] array = { 0, 7, 9, 5, 5, 8, 7, 4, 7, 3};
    	int pointer=0;
    	int currNumber;
    	while(pointer<array.length)
    	{   
    	  currNumber=array[pointer];
    	  for(int i=0;i<array.length;i++){          
    	    if(currNumber==array[i] && i>pointer){
    	        System.out.println("Duplicate for "+currNumber +" in " +i);
    	        break;
    	    }
    	  }   
    	  pointer++;
    	}
    }

}
