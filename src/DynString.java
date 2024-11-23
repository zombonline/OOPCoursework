import java.util.Arrays;

public class DynString {
    private char[] data;

//CONSTRUCTORS    
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
        resizeData(s.length());
        for(int i = 0; i < data.length; i++)
        {
            data[i] = s.charAt(i);
        }
    }
    
    public char get(int index)
    {
        return data[index];
    }
    public void set(int index, char value)
    {
        data[index] = value;
    }
    public void clear()
    {
        data = new char[0];
    }
    
    
    public boolean empty()
    {
        return data.length ==0;
    }
    
    public boolean equals(String s)
    {
    	if(data.length != s.length())
        {
            return  false;
        }
        for(int i = 0; i < s.length(); i++)
        {
            if (data[i] != s.charAt(i))
            {
                return false;
            }
        }
        return  true;
    }
    public boolean equals(DynString d) {
    	return equals(d.substr(0));
    }
    public boolean equals(char[] c) {
    	return equals(new String(c));
    }

    public String substr(int startInclusive, int endExclusive)
    {
        StringBuilder substr = new StringBuilder();
        for(int i = startInclusive; i < endExclusive; i++)
        {
            substr.append(data[i]);
        }
        return substr.toString();
    }
    public String substr(int startInclusive)
    {
    	return substr(startInclusive, data.length);
    }
    
    public DynString concat(DynString s)
    {
    	DynString copy = new DynString(substr(0));
    	int originalSize = copy.size();
        copy.resize(originalSize+s.size());
        for(int i = originalSize, j = 0; i < copy.size(); i++, j++)
        {
            copy.set(i, s.get(j));
        }
        return copy;
    }
    public DynString concat(String s)
    {
    	DynString dynString = new DynString(s);
    	return concat(dynString);
    }

    
    
    
    
    
    
    // Construct copying values from char array
    public DynString(char[] src){
        this(src.length);
        for(int i=0; i<size(); ++i){
            data[i] = src[i];
        }
    }
    
    // Get current size
    public int size(){
        return data.length;
    }
    //resize data; maintaining values
    public void resize(int len)
    {
        char[] newData = new char[len];
        for(int i = 0; i < newData.length && i < data.length; i++)
        {
            newData[i] = data[i];
        }
        data = newData;
    }

    // Resize internal array; zeroes all values
    private void resizeData(int n){
        data = new char[n];
    }

}