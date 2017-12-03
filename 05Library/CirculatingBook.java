public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String a, String t, String i, String c,
			   String ch, String d){
	super(a, t, i, c);
    }

    public String getCurrentHolder(){
	return currentHolder
    }

    public void setCurrentHolder(String ch){
	currentHolder = ch;
    }

    public String getDueDate(){
	return dueDate;
    }

    public void setDueDate(String d){
	dueDate = d;
    }
    




    
}
