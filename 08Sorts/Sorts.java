import java.util.Arrays;
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
	
	public static void swap(int[] ary, int a, int b){ //swaps two ints in an array given their indexes
		int temp = ary[a];
		ary[a] = ary[b];
		ary[b] = temp;
	}
	
	public static void insertionSort(int[] ary){
		if(!isSorted(ary)){
			for(int l = 1; l < ary.length; l++){
				int comp = l; //the index of where the value being added should go
				for(int i = l; i >= 0; i--){
					if(ary[l] < ary[i]){  //compares the value to each one before it
						comp = i;
					}
				}
				int temp = ary[l];
				for(int j = l - 1; j >= comp; j--) {
					ary[j + 1] = ary[j];
				}
				ary[comp] = temp;
			}
		}
	}
	
	public static void selectionSort(int[] ary){
		if(!isSorted(ary)){
			for(int l = 0; l < ary.length; l++){
				int sm = l; //index of the smallest element in the array
				for(int i = l; i < ary.length; i++){
					if(ary[i] < ary[sm]){
						sm = i;
					}
				}
				swap(ary, l, sm);
			}
		}
	}
	
	public static void bubbleSort(int[] ary){
		for(int end = ary.length - 1; end > 0; end--){
			int numSwaps = 0;
			for(int i = 0; i < end; i++){
				if(ary[i] > ary[i + 1]){
					swap(ary, i, i + 1);
					numSwaps += 1;
				}
			}
			if(numSwaps == 0){
				return;
			}
		}
	}
	
	public static void main(String[] args){
		int[] beyonce = new int[15];
		for(int i = 0; i < beyonce.length; i++){
			beyonce[i] = (int)(Math.random()*100);
		}
		
		System.out.println(Arrays.toString(beyonce));
		bubbleSort(beyonce);
		System.out.println(Arrays.toString(beyonce));
	}
	
	
}