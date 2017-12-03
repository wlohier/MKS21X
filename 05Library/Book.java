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

    public String getTitle(){
	return title;
    }

    public String getISBN(){
	return ISBN;
    }

    public String toString(){
	return title + "," + author + "," + ISBN;
    }

    
}
