import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{
    private String[] data;
    private int end;
    private int current = 0;

    public SuperArrayIterator(String[] d, int s){
        data = d;
	end = s;
	current = 0;
    }
    
    public void remove(){
	throw new UnsupportedOperationException();
    }

    public boolean hasNext(){
	return current < end;
    }

    public String next(){
	if (hasNext()){
	    current++;
	} else{
	    System.exit(0);
	}

	return data[current - 1];
    }

    
}
