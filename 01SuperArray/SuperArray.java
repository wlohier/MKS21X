public class SuperArray{
    private String[] data;
    private int size;

    public SuperArray(int len){
    data = new String[len];
    size = 0;
    } public SuperArray(){
    this(10);
    }
    
    public void clear(){
    data = new String[data.length];
    size = 0;
    }

    public int size(){
    return size;
    }

    public boolean add(String element){
	if(data.length >= size - 1){
	    resize();
	}
	data[size] = element;
        size += 1;
	return true;
    }

    public String get(int index){
	if(index > -1 && index < size()){
	    return data[index];
	}else{
	    throw new ArrayIndexOutOfBoundsException();
	}
    }

    public String set(int index, String element){
	if(index >= 0 && index < data.length){
	    String old = data[index];
	    data[index] = element;
	    return old;
	} else {
	    throw new IndexOutOfBoundsException();
	}
    }

    public String toString(){
    String p = "[";
    for(int i = 0; i < size; i++){
        p += data[i] + ",";
    }
    p = p.substring(0, p.length() - 1);
    p += "]";
    return p;
    }

    private void resize(){
	String[] larger = new String[2 * data.length + 1];
	for(int i = 0; i < size; i++){
	    larger[i] = data[i];
	} data = larger;
    }

    public boolean contains(String element){
	for(int i = 0; i < size; i++){
	    if(data[i].equals(element)){
		return true;    
	    }
	}System.out.println("Element not in array");
	return false;
    }

    public int indexOf(String element){
	for(int i = 0; i < size; i++){
	    if(data[i].equals(element)){
		return i;
	    }
	} System.out.println("element not in array");
	return -1;
    }

    public int lastIndexOf(String element){
	for(int i = size - 1; i > 0; i--){
	    if(data[i].equals(element)){
		return i;
	    }
	} System.out.println("element not in array");
	return -1;
    }

    public void add(int index, String element){
	if(index > data.length|| index < 0){
	    System.out.println("add index out of range");
	}else{
	    if(size >= data.length - 1){
		System.out.println("Need to resize");
		resize();
	    } for(int i = size + 1; i > index; i--){
		data[i] = data[i - 1];
	    } data[index] = element;
	    size += 1;
	}
    }

    public String remove(int index){
	if(index > size - 1 || index < 0){
	    System.out.println("remove index out of range");
	    return null;
	}else{
	    String val = data[index];
	    for(int i = index; i < size - 2; i++){
		data[i] = data[i + 1];
		data[size - 1] = null;
	    } size -= 1;
	    return val;
	}
    }

    public String remove(String element){
	if(!contains(element)){
	    System.out.println("Error - element not in Array");
	    return null;
	}else{
	    System.out.println("remove element in array");
	    return remove(indexOf(element));
	}
    }
  
}
