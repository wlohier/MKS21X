public class Barcode implements Comparable<Barcode>{
	private String zip;
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
	
	private int calcCheck(String z){ //calculates the check number
		int sum = 0;
		for(int i = 0; i < 5; i++){
			sum += z.charAt(i) - '0';
		}
		sum = sum % 10;
		return sum;
	}
	
	private String toCode(String z){ //generates the barcode given a zip
		String ans = "|";
		for(int i = 0; i < 5; i++){
			ans += codes[z.charAt(i) - '0'];
		}
		ans += codes[calcCheck(z)];
		ans += "|";
		return ans;
	}
	
	public String toString(){
		String ans = toCode(zip) + " ";
		ans += "(" + zip + ")";
		return ans;
	}
	
	public int compareTo(Barcode other){
		return zip.compareTo(other.getZip());
	}
	
	public String getZip(){
		return zip;
	}
	
	public String getCode(){
		return toCode(zip);
	}
		
	
}










