public class Barcode{
	private String zip;
	private String barcode;
	private String codes[] = {"||:::", ":::||", "::|:|", "::||:",
								":|::|", ":|:|:", ":||::", "|:::|", 
								"|::|:", "|:|::"};
	
	public Barcode(String z){
		if(zip.length() != 5){
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i < 5; i++){
			if(!Character.isDigit(zip.charAt(i))){
				throw new IllegalArgumentException();
			}
		}
		
		zip = z;	
	}
	
}