import java.util.arrays;
public class Sorts{
	
	public static String name(){
		return "9.Lohier.William";
	}
	
	public static boolean isSorted(int[] ary){ //checks to see whether Array is in order, only has to loop through once
		for(int i = 0; i < ary.length - 1; i++){
			if(ary[i] > ary[i + 1]){
				return false;
			}
		}
		return true;
	}
	
	public static void insertionSort(int[] ary){
		
	}
	
	public static void selectionSort(int[] ary){
		
	}
}