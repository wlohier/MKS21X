public class Book{
    public String author;
    public String title;
    public String ISBN;

    public Book(){
    }

    public Book(String a, String t, String i){
	author = a;
	title = t;
	ISBN = i;
    }

    public String getAuthor(){
	return author;
    }

    public void setAuthor(String a){
	author = a;
    }

    public String getTitle(){
	return title;
    }

    public void setTitle(String t){
	title = t;
    }

    public String getISBN(){
	return ISBN;
    }

    public void setISBN(String i){
	ISBN = i;
    }
    
    public String toString(){
	return title + ", " + author + ", " + ISBN;
    }

    
}
