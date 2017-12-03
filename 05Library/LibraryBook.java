abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String a, String t, String i, String c){
	super(a, t, i);
	callNumber = c;
    }

    public String getCallNumber(){
	return callNumber;
    }

    public abstract void checkout(String patron, String due);

    public abstract void returnd();

    public abstract String circulationStatus();

    public int compareTo(LibraryBook other){
	return 0;
    }


}
