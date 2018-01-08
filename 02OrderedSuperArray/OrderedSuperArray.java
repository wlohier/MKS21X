import java.util.*;

public class OrderedSuperArray extends SuperArray{
    
    public OrderedSuperArray(){
	this(10);
    }

    public OrderedSuperArray(int capacity){
	super(capacity);
    }

    public OrderedSuperArray(String[] ary){
        this(ary.length);
	for(int i = 0; i < ary.length; i++){
	    add(ary[i]);
	}
    }
    
    public void add(int index, String value){
    add(value);
    }

    public String set(int index, String element){
	throw new UnsupportedOperationException();
    }


    public boolean add(String value){
	int index = findIndex(value);
        super.add(index, value);
        return true;
    }



    public int findIndex(String str){
	for(int i = 0; i < size(); i++){
	    if(str.compareTo(get(i)) < 1){
		return i;
	    }
	}
	return size();
    }


    public int indexOf(String str){
	for(int i = findIndex(str); i >= 0; i--){
	    System.out.println("i = " + i);
	    if(str.compareTo(get(i)) > 0){
		return i + 1;
	    }
	}
	return -1;
    }

    public int lastIndexOf(String str){
	for(int i = findIndex(str); i <= size(); i++){
	    if(str.compareTo(get(i)) < 0){
		return i - 1;
	    }
	}
	return -1;
    }
}
