package ManualArrayList;

public class ChristianContainer {
    
    //global variables
    private String[] dataContainer;
    private int filledElements;
    
    //default constructor
    public ChristianContainer(){
    }
    //constructor
    public ChristianContainer(int aSize){
        dataContainer = new String[aSize];
        filledElements = 0;
    }
    
    //getters
    public String[] getContainer(){
        return dataContainer;
    }
    
    public int getElements(){
        return filledElements;
    }
    
    //setters
    public void setContainer(String[] anArray){
        dataContainer = anArray;
    }
    
    public void setElements(int anElements){
        filledElements = anElements;
    }
    
    //addElement adds value and updates filledElements
    public void addElement(String aString){
        dataContainer[getElements()] = aString;
        filledElements++;
    }
    
    //toString overridden to concatenate array contents into return string
    @Override
    public String toString(){
        String result = "";
        if(dataContainer != null){
            for(int i = 0; i < getElements(); i++){
                result += dataContainer[i] + " ";
            }
        }
        return result;
    }
    
    //method to check size of array and double size if filled Elements are greater than ten
    public void doubleArraySize(){
        if(getElements() > 10){
            String[] newArray = new String[getElements()*2];
            for(int i = 0; i < getElements(); i++){
                newArray[i] = dataContainer[i];
            }
            setContainer(newArray);
        }
    }
    
    //method to remove a specific element and shift the remaining elements so there is no empty space
    public void removeElement(String aString){
        if(dataContainer != null){
            for(int i = 0; i < getElements(); i++){
                if(contains(aString)){
                    dataContainer[i] = "";
                    for(int j = i; j < getElements(); j++){
                        dataContainer[j] = dataContainer[j+1];
                    }
                filledElements--;
                }
            }
        }
    }
    
    //method to insert an element in a specific position
    public void insert(int aPosition, String aString){
        if(dataContainer != null){
            if(getElements() == dataContainer.length){
                doubleArraySize();
            }    
            filledElements++;
            for(int i = getElements() - 1; i > aPosition; i--){ 
                dataContainer[i+1] = dataContainer[i];
            }
            dataContainer[aPosition] = aString;
        }
    }
    
    //method to clear the array and set size to 0
    public void clear(){
        dataContainer[0] = "";
        setElements(0);
    }
    
    //contains
    public boolean contains(String aString){
        if(dataContainer != null){
            for(int i = 0; i < getElements(); i++){
                if(dataContainer[i].equals(aString)){
                    return true;
                }
            }
        }
        return false;
    }
    
    //get an element
    public String getElement(int anElement){
        return dataContainer[anElement];
    }
    
    //isEmpty
    public boolean isEmpty(){
        return (getElements() > 0);
    }
    
    //remove all of a specific element
    public void removeThisElement(String aString){
        if(dataContainer != null){
            for(int i = 0; i < getElements(); i++){
                if(dataContainer[i].equals(aString)){
                    removeElement(dataContainer[i]);
                }
            }
        }
    }
    
    //remove at position
    public void removeAt(int pos){
        if(dataContainer != null){
            if(pos <= getElements()){
                removeElement(dataContainer[pos]);
            }
        }
    }
    
    //remove one instance of a specific element
    public void removeOneSpecificElement(String aString){
        if(dataContainer != null){
            for(int i = 0; i < getElements(); i++){
                if(dataContainer[i].equals(aString)){
                    removeElement(dataContainer[i]);
                    break;
                }
            }
        }
    }
}