import java.util.*;
import java.io.*;
import java.util.Scanner;


public class WordSearch{
    private char[][]data;
    private char[][]puzzle;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;
    private Random randgen;

    public static void main(String[] args){
	String directions = " Welcome to WordSearchGenV1. please input the height, width,\n and the name of a plaintext file containing words (one per line) in that order./n If you wish you may also input a seed if you want to regenerate a puzzle previously generated,\n and input the word key after that if you wish to see the answer key to that problem.\n However, keep in mind these paramaters are both optional. For example, \n you could type in the terminal: /njava WordSearch 5 10 words.txt 857 key/n this would print a wordsearch of 5 by 10 that is identical to other searches with the seed 857 and also has the solutions printed out below.";

	if(args.length == 0){ //If there are no given parameters prints out directions
	    System.out.println(directions);
	}

	if(args.length == 3){ //If there are three parameters, inputs a random seed and doesn't print the answer
	    Random seed = new Random();  //randomly generates a seed
	    WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], seed);
	}

	if(args.length == 4){ //If four parameters, uses the fourth as a random seed
	    WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]));
	}

        if(args.length == 5){ //If five parameters, checks if 5th is "key" and if so prints the key as well as the puzzle
	    WordSearch(Integer.parseInt(args[0]), Integer.parseInt(args[1]), args[2], Integer.parseInt(args[3]), args[5]);
	}

	
    }

    public WordSearch(int rows, int cols, String fileName, int randSeed){
	data = new char[rows][cols];
	
	try{
	    File f = new File(fileName);//can combine
	    Scanner in = new Scanner(f);//into one line
	    while(in.hasNext()){
		String line = in.nextLine();
	        wordsToAdd.add(line);
		//System.out.println(line);
	    }  
	}catch(FileNotFoundException e){
      System.out.println("File not found: " + fileName);
      //e.printStackTrace();
      System.exit(1);
      }
	randgen = new Random(randSeed);	
    }

    public WordSearch(int rows, int cols, String fileName, int randSeed, String answers){
	this(rows, cols, fileName, randSeed);
	if(answers.equals("key")){
	    System.out.println(data);
	}
    }

    /**Set all values in the WordSearch to underscores'_'*/
    private void clear(){
        for(int i = 0; i < data.length; i++){
	    for(int j = 0; j < data[i].length; j++){
		data[i][j] = '_';
	    }
	}
    }

    /**The proper formatting for a WordGrid is created in the toString.
     *@return a String with each character separated by spaces, and rows
     *separated by newlines.
     */
    public String toString(){
	String ans = "";
        for(int i = 0; i < data.length; i++){
	    String line = "";
	    for(int j = 0; j < data[i].length; j++){
		line += data[i][j];
		line += " ";
	    }
	    line += "\n";
	}
    }

    /*

    /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from left to right, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     * or there are overlapping letters that do not match, then false is returned 
     * and the board is NOT modified.
     
    public boolean addWordHorizontal(String word,int row, int col){
	if(word.length() > data[0].length - col){
	    return false;
	} for(int i = 0; i < word.length(); i++){
	    if(word.charAt(i) != word[row][i + col]){
		return false;
	    }
	} for(int i = 0; i <  word.length(); i++){
	    data[row][col + i] = word.charAt(i);
	} return true;
    }

   /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top to bottom, must fit on the WordGrid, and must
     *have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     *and the board is NOT modified.
     
    public boolean addWordVertical(String word,int row, int col){
        if(word.length() > data.length - row){
	    return false;
	} for(int i = 0; i < word.length(); i++){
	    if(word.charAt(i) != word[row + i][col]){
		return false;
	    }
	} for(int i = 0; i <  word.length(); i++){
	    data[row + i][col] = word.charAt(i);
	} return true;
    }


       /**Attempts to add a given word to the specified position of the WordGrid.
     *The word is added from top left to bottom right, must fit on the WordGrid,
     *and must have a corresponding letter to match any letters that it overlaps.
     *
     *@param word is any text to be added to the word grid.
     *@param row is the vertical locaiton of where you want the word to start.
     *@param col is the horizontal location of where you want the word to start.
     *@return true when the word is added successfully. When the word doesn't fit,
     *or there are overlapping letters that do not match, then false is returned.
     
    public boolean addWordDiagonal(String word,int row, int col){
	if(word.length() > data.length - row || word.lengt() > data[0].length - col){
	    return false;
	} for(int i = 0; i < word.length(); i++){
	    if(word.charAt(i) != word[row + i][col + i]){
		return false;
	    }
	} for(int i = 0; i <  word.length(); i++){
	    data[row + i][col + 1] = word.charAt(i);
	} return true;
    }


    */

    private boolean addWord(int row, int col, String word, int rowIncrement, int colIncrement){
	if(rowIncrement == 0 && colIncrement == 0){
	    return false;
	}

	try{
	    for(int i = 0; i < word.length(); i++){
		if(word.charAt(i) != data[row + i*rowIncrement][col + i*colIncrement] &&
		   data[row + i*rowIncrement][col + i*colIncrement] != '_'){
		    return false;
	        }
	    }
	} catch(ArrayIndexOutOfBoundsException e){
	    return false;
	}

	for(int i = 0; i < word.length(); i++){
	    data[row + i*rowIncrement][col + i*colIncrement] = word.charAt(i);
	    wordsToAdd.remove(word);
	    wordsAdded.add(word);
	    }
	
	return true;
	    
    }
    

}
