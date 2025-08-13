package hw2;

/*Output by:
Jimenez, Jeremy D.
Matic, Marwin O.
*/

public class DynamicArray<T> {

	public static void main(String[] args) {
		DynamicArray<String> arr = new DynamicArray();		//create and initialize variables
		
		arr.add("Linux");
		arr.add("Microsoft");
		arr.add("Nvdia");
		
		System.out.println("Elements of array:");	//for loop prints out the contents of the array
		for (int i = 0; i < arr.size; i++) {
			System.out.print(arr.array[i] + " ");
		}
		System.out.println();
		System.out.println();
		System.out.println("Array size: " + arr.Size());	//prints out the array size
		
		System.out.println();
		System.out.println("Cap size: " + arr.Capacity());	//prints out how many elements are stored in the array
		int index = 6;
		System.out.println();
		System.out.println("Element at index "+ index+ " is " + arr.GetElementAtIndex(index));		//prints out the element placed on the index
		
		System.out.println();
		System.out.println(arr.Find("Xiaomi"));
	}

	private int capacity;
	private int size;
	private String array[];

	public DynamicArray() {					//initialization of variables in the constructor
		capacity = 0;						//number of elements added
		size = 4;							//initial array size
		array = new String[size];			//the array
	}


	void add(String element) {				//adding new elements into the array
		if (capacity == size) {				//*if number of elements is equal to the array size
			String temp[] = null;			//create a temporary empty array
			temp = new String[size * 2]; 	//doubles the size of the array with the current array size
			for (int i = 0; i < size; i++) {
				temp[i] = array[i];			//pass the contents of the array containing the elements to the temporary array
			}	
			array = temp;					//array takes the contents of the temporary array
			size = size * 2;				//doubles the size counter
		}
		array[capacity] = element;			//added element is inserted in the array
		capacity++;							//the capacity counter is increased by one
	}
	
	
	Boolean Find(String e) {				//finding if the element is present in the array
		for(int i=0; i<size;i++) {			//iterate through the array and return true if the element exists
			if(e==array[i]) {
				return true;
			}
		}
		return false;					//will always return false if the element isn't present in the array
	}
	
	
	String GetElementAtIndex(int index) {			//getting the element of an index
		try {						//try catch for exceptions
			return array[index];			//returns the element present at the index
		}
		catch (ArrayIndexOutOfBoundsException e) {	//an exception for when the given index is more than the array size
			return " non-existent since array index is out of bounds";
		}	
	}
	
	int Size() {		//returns the size
		return size;
	}
	
	int Capacity() {		//returns the capacity
		return capacity;
	}
}
