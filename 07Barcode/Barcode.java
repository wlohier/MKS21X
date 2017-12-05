public class Barcode implements Comparable<Barcode>{
	private String zip;
	
	public Barcode(String z){
		if(correctZip(z)){
			zip = z;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	private boolean correctZip(String z){ //makes sure z is a correctly formatted zip
		if(zip.length() != 5){ //makes sure the length is correct
			return false;
		}
		
		for(int i = 0; i < 5; i++){ //makes sure all characters are digits
			if(!Character.isDigit(zip.charAt(i))){
				return false;
			}
		}
		
		return true;
	}
	
	private boolean correctCode(String c){ //NEED TO COMPLETE ******************************************************
		if(c.length() != 32){
			return false;
		}
		
		return true;
	}
	
	public static String toCode(String z){ //generates the barcode given a zip
		
		String codes[] = {"||:::", ":::||", "::|:|", "::||:",
							":|::|", ":|:|:", ":||::", "|:::|", 
							"|::|:", "|:|::"};
		
		String ans = "|";
		for(int i = 0; i < 5; i++){
			ans += codes[z.charAt(i) - '0'];
		}
		
		int check = 0; //The next couple lines generate the check number
		for(int i = 0; i < 5; i++){
			check += z.charAt(i) - '0';
		}
		check = check % 10;
		
		ans += codes[check];
		ans += "|";
		return ans;
	}
	
	public static String toZip(String c){ //NEED TO COMPLETE *************************************************
		return null;
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










