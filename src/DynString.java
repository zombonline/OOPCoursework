import java.util.Arrays;

public class DynString {
    private char[] data;

    //Constructors
	public DynString(){ // Construct with no given size
	    resizeData(0);
	}
    public DynString(int len){ //Construct with given size
        resizeData(len);
    }
    public DynString(int len, char fill){ //Construct with given size and fill with given char
        resizeData(len);
        Arrays.fill(data, fill);
    }
    public DynString(String s){ //Construct with given string.
        data = s.toCharArray();
    }
    public DynString(char[] src){ // Construct with given char array
        data = Arrays.copyOf(src, src.length);
    }

    //Methods
    public char get(int index) throws ArrayIndexOutOfBoundsException { //Returns the character stored at the given index
        if(index < 0 || index >= size()) {
        	throw new ArrayIndexOutOfBoundsException("Index out of bounds of dynstring.");
    	}
    	return data[index];
    }
    
    public void set(int index, char value) throws ArrayIndexOutOfBoundsException { //Sets the character at the given index to the character passed in
    	if(index < 0 || index >= size()) {
        	throw new ArrayIndexOutOfBoundsException("Index out of bounds of dynstring.");
    	}
    	data[index] = value;
    }
    
    public void clear(){ //Sets the data array to length 0.
        resizeData(0);
    }
    
    public int size(){ //Returns current size of the data array.
        return data.length;
    }
    
    public boolean empty(){ //Returns true if the data is length 0.
        return size() == 0;
    }  
    
    public boolean equals(Object obj) { //Returns true if data array matches given dynstring, string, or char array
        if (obj instanceof DynString) {
            return Arrays.equals(data, ((DynString) obj).data);
        } else if (obj instanceof String) {
            return new String(data).equals(obj);
        } else if (obj instanceof char[]) {
            return Arrays.equals(data, (char[]) obj);
        }
        return false;
    }

    public String substr(int startInclusive, int endExclusive) throws ArrayIndexOutOfBoundsException { //Returns a string starting from given position and ending at given position
    	if(Math.min(startInclusive, endExclusive) < 0 || Math.max(startInclusive, endExclusive) > size()) {
        	throw new ArrayIndexOutOfBoundsException("Index out of bounds of dynstring.");
    	}
    	return new String(data, startInclusive, endExclusive - startInclusive);
    }
    public String substr(int startInclusive) { //Returns a string starting at given position and ending at the end of the data array
    	return substr(startInclusive, data.length);
    }
    
    public DynString concat(String s){ //Returns a new dynstring with values of this one and the given string on the end
    	char[] concatData = Arrays.copyOf(data, size() + s.length());
    	System.arraycopy(s.toCharArray(), 0, concatData, size(), s.length());
        return new DynString(concatData);
    }
    public DynString concat(DynString d){ //Returns a new dynstring with values of this one and given dynstring on the end
    	return concat(d.substr(0));
    }

    public void resize(int len){ //Resizes data array, retaining values where possible.
        data = Arrays.copyOf(data, len);
    }
    
    private void resizeData(int n){ //Resize internal array; zeroes all values
        data = new char[n];
    }
}