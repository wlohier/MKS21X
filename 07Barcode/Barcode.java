public class Barcode{
	private String zip;
	private String barcode;
	private String codes[] = {"||:::", ":::||", "::|:|", "::||:",
								":|::|", ":|:|:", ":||::", "|:::|", 
								"|::|:", "|:|::"};
	
	public Barcode(String z){
		if(zip.length() != 5){ //makes sure the length is correct
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i < 5; i++){ //makes sure all characters are digits
			if(!Character.isDigit(zip.charAt(i))){
				throw new IllegalArgumentException();
			}
		}
		
		zip = z;	
	}
	
	public int calcCheck(){ //calculates the check number
		int sum = 0;
		for(int i = 0; i < 5; i++){
			sum += zip.charAt(i) - '0';
		}
		sum = sum % 10;
		return sum;
	}
	
	public String genCode(){ //generates the barcode
		String ans = "|";
		for(int i = 0; i < 5; i++){
			ans += codes[zip.charAt(i) - '0'];
		}
		ans += codes[calcCheck()];
		ans += "|";
		return ans;
	}
	
	public String toString(){
		String ans = genCode() + " ";
		ans += "(" + zip + ")";
		return ans;
	}
	
}










