/**
 * Sym
 * 
 * This class holds the type for the type for the symbol
 */
public class Sym{

    // Symbol type TODO: Should it be private?
    private String type;

    /**
     * Consturctor
     */
    public Sym(String type){
        this.type = type;
    }

    /**
     * Getter for the type
     */
    public String getType(){
        return type;
    }

    /**
     * Another getter method (Will be changed later)
     */
    public String toString(){
        return type;
    }

}