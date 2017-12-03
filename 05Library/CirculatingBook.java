public class CirculatingBook extends LibraryBook{
    private String currentHolder;
    private String dueDate;

    public CirculatingBook(String a, String t, String i, String c){
	super(a, t, i, c);
    }

    public String getCurrentHolder(){
	return currentHolder;
    }

    public void setCurrentHolderg(String ch){
	currentHolder = ch;
    }

    public String getDueDate(){
	return dueDate;
    }

    public void setDueDate(String d){
	dueDate = d;
    }

    public void checkout(String patron, String due){
	currentHolder = patron;
	dueDate = due;
    }

    public void returned(){
	currentHolder = null;
	dueDate = null;
    }

    public String circulationStatus(){
	if(currentHolder == null){
	    return "Book available on shelves";
	}

	return currentHolder + "Due Date: " + dueDate;
    }


    public String toString(){
	if(currentHolder == null){
	    return super.toString();
	} else {
	    return super.toString() + ", " + currentHolder + ", " + dueDate;
	}
    }

    
}
