import java.lang.CharSequence;

public class ReverseCharSequence implements CharSequence{
    private String data;

    
    public ReverseCharSequence(String s){
	data = s;
    }

    public char charAt(int index){
        return data.charAt(length() - index - 1);
    }

    public int length(){
	return data.length();
    }

    public CharSequence subSequence(int start, int end){
	String ans = "";
	for(int i = start; i < end; i++){
	    ans += charAt(i);
	}
	
	CharSequence CS = new ReverseCharSequence(ans);
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
