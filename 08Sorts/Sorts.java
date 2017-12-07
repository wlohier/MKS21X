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
	
	public static void main(String[] args){
		int[] beyonce = new int[15];
		for(int i = 0; i < beyonce.length; i++){
			beyonce[i] = (int)(Math.random()*beyonce.length);
		}
		
		System.out.println(Arrays.toString(beyonce));
		selectionSort(beyonce);
		System.out.println(Arrays.toString(beyonce));
	}
	
	
}