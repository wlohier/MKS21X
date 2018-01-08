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
		if(z.length() != 5){ //makes sure the length is correct
			return false;
		}
		
		for(int i = 0; i < 5; i++){ //makes sure all characters are digits
			if(!Character.isDigit(z.charAt(i))){
				return false;
			}
		}
		
		return true;
	}
	
	public static String toZip(String c){
		
		String codes[] = {"||:::", ":::||", "::|:|", "::||:",
					":|::|", ":|:|:", ":||::", "|:::|", 
					"|::|:", "|:|::"};
		
		if(c.length() != 32){ //Makes sure code is correct length
			throw new IllegalArgumentException();
		}

		if(c.charAt(0) == '|' && c.charAt(31) == '|'){ //makes sure front and end are |
		    c = c.substring(1, 31);
		} else {
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i < c.length(); i++){ // makes sure all characters are barcode characters
			if(c.charAt(i) != '|' && c.charAt(i) != ':'){
				throw new IllegalArgumentException();
			}
		}
		
		int numCol = 0;
		int numSlash = 0;
		for(int i = 0; i < 30; i++){
			if(c.charAt(i) == ':'){
				numCol += 1;
			}
			
			if(c.charAt(i) == '|'){
				numSlash +=1;
			}
			
			if(numCol != 3 || numSlash != 2){ // makes sure you have right number of columns and dashes
				throw new IllegalArgumentException();
			}
			
			if(i%5 == 4){
				numCol = 0;
				numSlash = 0;
			}
		}
		
		String ans = "";
		int checkDig = 0;
		for(int codeNum = 0; codeNum < 6; codeNum++){
			for(int i = 0; i < 10; i++){
				if(c.substring(5*codeNum, 5*codeNum + 5).equals(codes[i])){ //generates the zip equivalent
					ans += "" + i;
					checkDig += i;
				}
			}
			
		}
		
		if(!ans.substring(4, 5).equals("" + (checkDig % 10))){ // makes sure checkSum is correct
			throw new IllegalArgumentException();
		}
		
		return ans;
		
	}
	
	
	public static String toCode(String z){ //generates the barcode given a zip
		if(z.length() != 5){ //makes sure the length is correct
			throw new IllegalArgumentException();
		}

	    for(int i = 0; i < 5; i++){ //makes sure all characters are digits
			if(!Character.isDigit(z.charAt(i))){
				throw new IllegalArgumentException();
			}
	    }

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
	

        public String toString(){
		String ans = toCode(zip) + " ";
		ans += "(" + zip + ")";
		return ans;
	}

	public int compareTo(Barcode other){
	    return Integer.parseInt(zip) - Integer.parseInt(other.getZip());
	}

        public boolean equals(Barcode other){
	    return this.compareTo(other) == 0;
        }
	
	public String getZip(){
	    return zip;
	}
	
	public String getCode(){
	    return toCode(zip);
	}
		
	
}










