import java.util.*;

/**
 * SymTable
 * 
 * This class is the table that holds all of the symbols
 */
public class SymTable{
    
    //Linked List of HashMaps
    private LinkedList<HashMap<String, Sym>> symTable;

    /**
     * Constructor that initalizes the List with a single empty HashMap
     */
    public SymTable(){
        symTable = new LinkedList<HashMap<String, Sym>>();
        symTable.addFirst(new HashMap<String, Sym>());
    }

    /**
     * Adds a key value pair to the first HashMap in the SymTable, otherwise throws an error
     * @param name is the key for the symTable
     * @param sym is the value to be added to the symTable
     * @throws DuplicateSymException thrown if the name param is a key in the first HashMap
     * @throws EmptySymTableException thrown if the SymTable's list is empty
     */
    public void addDecl(String name, Sym sym) throws DuplicateSymException, 
        EmptySymTableException{
        // Error checking
        if(symTable.isEmpty()){
            throw new EmptySymTableException();
        }

        if(name == null || sym == null){
            throw new NullPointerException();
        }

        if(symTable.get(0).containsKey(name)){
            throw new DuplicateSymException();
        }
        
        // Add the key value pair if there are no errors
        symTable.getFirst().put(name, sym);
    }

    /**
     * Adds a new, empty HashMap to the front of the List
     */
    public void addScope(){
        symTable.addFirst(new HashMap<String, Sym>());
    }

    /**
     * If the name exists in the first HashMap, return the value. 
     * Otherwise return null or return EmptySymTableException if the 
     * list is null
     * @param name is the key to look for in the SymTable's first HashMap
     * @return the Sym value if the key exists in the first HashMap
     * @throws EmptySymTableException if the symTable's list is empty
     */
    public Sym lookupLocal(String name) throws EmptySymTableException{
        if(symTable.isEmpty()){
            throw new EmptySymTableException();
        }

        if(symTable.getFirst().containsKey(name)){
            return symTable.getFirst().get(name);
        }
        else{
            return null;
        }
    }

    /**
     * Searches through the entire SymTable for a key and returns the value in the first HashMap
     * where a key match is found.
     * @param name is the key to look for in the SymTable
     * @return the Sym value if a match is found for the name key
     * @throws EmptySymTableException if the SymTable is empty
     */
    public Sym lookupGlobal(String name) throws EmptySymTableException{
        if(symTable.isEmpty()){
            throw new EmptySymTableException();
        }

        //Goes through the linkedList looking for a key match
        for(int i = 0; i < symTable.size(); i++){
            if(symTable.get(i).containsKey(name)){
                return symTable.get(i).get(name);
            }
        }

        //If no match found then return null
        return null;
    }

    /**
     * Removes the HashMap at the front of the list
     * @throws EmptySymTableException if the symTable is empty before attempting to remove
     */
    public void removeScope() throws EmptySymTableException{
        if(symTable.isEmpty()){
            throw new EmptySymTableException();
        }

        symTable.removeFirst();
    }

    /**
     * Method used for debugging, prints all the HashMaps in the List
     */
    public void print(){
        System.out.print("\nSym Table\n");
        for(int i = 0; i < symTable.size(); i++){
            System.out.println(symTable.get(i).toString());
        }
        //TODO: Might not need this last newline?
        System.out.println();
    }
}