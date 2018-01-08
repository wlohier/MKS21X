import java.lang.CharSequence;

public class ReversedCharSequence implements CharSequence{
    private String data;

    
    public ReversedCharSequence(String s){
	data = s;
    }

    public char charAt(int index){
	try{
	    return data.charAt(length() - index - 1);
	} catch(StringIndexOutOfBoundsException e){
	    return Character.MIN_VALUE;
	}
    }

    public int length(){
	return data.length();
    }

    public CharSequence subSequence(int start, int end){
	String ans = "";
	
	if(start < 0 || start > length() || end < start || end > length()){
	    throw new IllegalArgumentException();
        }
    
	for(int i = start; i < end; i++){
	    ans += charAt(i);
	}
	
	CharSequence CS = new ReversedCharSequence(ans);
        return CS;
    }

    public String toString(){
	String rev = "";
	for(int i = 0; i < length(); i++){
	    rev += charAt(i);
	}
	return rev;
    }

}
