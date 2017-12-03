public class ReferenceBook extends LibraryBook{
    private String collection;

    public ReferenceBook(String a, String t, String i, String c, String col){
	super(a, t, i, c);
	collection = col;
    }

    public String getCollection(){
	return collection;
    }

    public void setCollection(String col){
	collection = col;
    }

    public void checkout(String patron, String due){
	System.out.println("Cannot checkout reference book");
    }

    public void returned(){
	System.out.println("reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus(){
	return "Non-Circulating Reference Book";
    }

    public String toString(){
	return super.toString() + ", " + collection;
    }

}
