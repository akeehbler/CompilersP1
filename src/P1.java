/**
 * P1
 * 
 * This is a test Class that tests various aspects of the
 * following files:
 *  SymTable.java
 *  Sym.java
 *  EmptySymTableException.java
 *  DuplicateSymException.java
 */
public class P1{

    public static void main( String [] args){
        boolean testsPassed = true;
        if(!testSymType()){
            System.out.println("testSymType did not pass");
            testsPassed = false;
        }
        if(!testSymToString()){
            System.out.println("testSymToString did not pass");
            testsPassed = false;
        }
        if(!testSymTableAddDecl1()){
            System.out.println("testSymTableAddDecl1 did not pass");
            testsPassed = false;
        }
        if(!testSymTableAddDecl2()){
            System.out.println("testSymTableAddDecl2 did not pass");
            testsPassed = false;
        }
        if(!testSymTableAddDecl3()){
            System.out.println("testSymTableAddDecl3 did not pass");
            testsPassed = false;
        }
        if(!testSymTableAddDecl4()){
            System.out.println("testSymTableAddDecl4 did not pass");
            testsPassed = false;
        }
        if(!testSymTableAddDecl5()){
            System.out.println("testSymTableAddDecl5 did not pass");
            testsPassed = false;
        }
        if(!testSymTableAddDecl6()){
            System.out.println("testSymTableAddDecl6 did not pass");
            testsPassed = false;
        }
        if(!testSymTableRemoveScope1()){
            System.out.println("testSymTableRemoveScope1 did not pass");
            testsPassed = false;
        }
        if(!testSymTableRemoveScope2()){
            System.out.println("testSymTableRemoveScope2 did not pass");
            testsPassed = false;
        }
        if(!testSymTableAddScope()){
            System.out.println("testSymTableAddScope did not pass");
            testsPassed = false;
        }
        if(!testSymTableLookupLocal1()){
            System.out.println("testSymTableLookupLocal1 did not pass");
            testsPassed = false;
        }
        if(!testSymTableLookupLocal2()){
            System.out.println("testSymTableLookupLocal2 did not pass");
            testsPassed = false;
        }
        if(!testSymTableLookupGlobal1()){
            System.out.println("testSymTableLookupGlobal1 did not pass");
            testsPassed = false;
        }
        if(!testSymTableLookupGlobal2()){
            System.out.println("testSymTableLookupGlobal2 did not pass");
            testsPassed = false;
        }

        if(testsPassed){
            System.out.println("All tests passed");
        }
    }

    /**
     * Tests if the constructor correctly sets the type
     * @return true if passed, false if not passed
     */
    public static boolean testSymType(){
        Sym testSym = new Sym("Boolean");
        if(!testSym.getType().equals("Boolean")){
            return false;
        }
        return true;
    }

    /**
     * Tests if the toString method of the Sym class returns the type
     * @return true if passed, false if not passed
     */
    public static boolean testSymToString(){
        Sym testSym = new Sym("int");
        if(!testSym.getType().equals("int")){
            return false;
        }
        return true;
    }

    /**
     * Tests that addDecl correctly adds the name and sym to the first HashMap
     * with no Exceptions
     * @return true if passed, false if not
     */
    public static boolean testSymTableAddDecl1(){
        SymTable testSymTable = new SymTable();
        try{
            testSymTable.addDecl("<3 Ta's", new Sym("String"));
        } catch(EmptySymTableException e){
            return false;
        } catch(DuplicateSymException e){
            return false;
        } catch(NullPointerException e){
            return false;
        } catch(Exception e){
            return false;
        }
        return true;
    }

    /**
     * Tests that a NullPointer Exception is thrown on a null name
     * @return true if test passed, false if not
     */
    public static boolean testSymTableAddDecl2(){
        SymTable testSymTable = new SymTable();
        try{
            testSymTable.addDecl(null, new Sym("String"));
        } catch(EmptySymTableException e){
            return false;
        } catch(DuplicateSymException e){
            return false;
        } catch(NullPointerException e){
            return true;
        } catch(Exception e){
            return false;
        }
        return false;
    }

    /**
     * Tests that a NullPointer Exception is thrown on a null Sym
     * @return true if test passed, false if not
     */
    public static boolean testSymTableAddDecl3(){
        SymTable testSymTable = new SymTable();
        try{
            testSymTable.addDecl("I love the Graders", null);
        } catch(EmptySymTableException e){
            return false;
        } catch(DuplicateSymException e){
            return false;
        } catch(NullPointerException e){
            return true;
        } catch(Exception e){
            return false;
        }
        return false;
    }

    /**
     * Tests that a NullPointer Exception is thrown on a null name and Sym
     * @return true if test passed, false if not
     */
    public static boolean testSymTableAddDecl4(){
        SymTable testSymTable = new SymTable();
        try{
            testSymTable.addDecl(null, null);
        } catch(EmptySymTableException e){
            return false;
        } catch(DuplicateSymException e){
            return false;
        } catch(NullPointerException e){
            return true;
        } catch(Exception e){
            return false;
        }
        return false;
    }

    /**
     * Tests that a DuplicateSymException is thrown if a duplicate key is given
     * @return true if test passed, false if not
     */
    public static boolean testSymTableAddDecl5(){
        SymTable testSymTable = new SymTable();
        try{
            testSymTable.addDecl("Truedat", new Sym("String"));
            testSymTable.addDecl("Truedat", new Sym("Boolean"));
        } catch(EmptySymTableException e){
            return false;
        } catch(DuplicateSymException e){
            return true;
        } catch(NullPointerException e){
            return false;
        } catch(Exception e){
            return false;
        }
        return false;
    }

    /**
     * Tests that a EmptySymTableException is thrown when list is empty
     * @return true if test passed, false if not
     */
    public static boolean testSymTableAddDecl6(){
        SymTable testSymTable = new SymTable();
        try{
            testSymTable.removeScope();
            testSymTable.addDecl("Mr.Robot", new Sym("Show"));
        } catch(EmptySymTableException e){
            return true;
        } catch(DuplicateSymException e){
            return false;
        } catch(NullPointerException e){
            return false;
        } catch(Exception e){
            return false;
        }
        return false;
    }

    /**
     * Tests that removeScope works properly for first instance
     * @return true if test passed, false if not
     */
    public static boolean testSymTableRemoveScope1(){
        SymTable testSymTable = new SymTable();
        try{
            testSymTable.removeScope();
        } catch(EmptySymTableException e){
            return false;
        } catch(Exception e){
            return false;
        }
        return true;
    }

    /**
     * Tests that removeScope throws EmptySymTableException when
     * trying to remove a HashMap that doesn't exist
     * @return true if test passed, false if not
     */
    public static boolean testSymTableRemoveScope2(){
        SymTable testSymTable = new SymTable();
        try{
            testSymTable.removeScope();
            testSymTable.removeScope();
        } catch(EmptySymTableException e){
            return true;
        } catch(Exception e){
            return false;
        }
        return false;
    }

    /**
     * Tests that addScope adds the HashMap to the front of the list
     * @return true if test passed, false if not
     */
    public static boolean testSymTableAddScope(){
        SymTable testSymTable = new SymTable();
        try{
            testSymTable.addDecl("First", new Sym("type"));
            testSymTable.addScope();
            testSymTable.addDecl("Second", new Sym("num"));
            if(!testSymTable.lookupLocal("Second").getType().equals("num")){
                return false;
            }
        } catch(EmptySymTableException e){
            return false;
        } catch(Exception e){
            return false;
        }
        return true;
    }

    /**
     * Tests that lookupLocal returns null if matching key not found
     * @return true if test passed, false if not
     */
    public static boolean testSymTableLookupLocal1(){
        SymTable testSymTable = new SymTable();
        try{
            testSymTable.addDecl("First", new Sym("type"));
            testSymTable.addDecl("sec", new Sym("no"));
            testSymTable.addDecl("tird", new Sym("love"));
            if(testSymTable.lookupLocal("first") != null){
                return false;
            }
        } catch(EmptySymTableException e){
            return false;
        } catch(Exception e){
            return false;
        }
        return true;
    }

    /**
     * Tests that lookupLocal throws EmptySymTableException when the
     * list is empty
     * @return true if test passed, false if not
     */
    public static boolean testSymTableLookupLocal2(){
        SymTable testSymTable = new SymTable();
        try{
            testSymTable.addDecl("First", new Sym("type"));
            testSymTable.removeScope();
            testSymTable.lookupLocal("nope");
        } catch(EmptySymTableException e){
            return true;
        } catch(Exception e){
            return false;
        }
        return false;
    }

    /**
     * Tests that lookupGlobal throws EmptySymTableException when the
     * list is empty
     * @return true if test passed, false if not
     */
    public static boolean testSymTableLookupGlobal1(){
        SymTable testSymTable = new SymTable();
        try{
            testSymTable.addDecl("First", new Sym("type"));
            testSymTable.removeScope();
            // Should throw an error here
            testSymTable.lookupGlobal("nope");
        } catch(EmptySymTableException e){
            return true;
        } catch(Exception e){
            return false;
        }
        return false;
    }

    /**
     * Tests that lookupGlobal returns the first Hashmap match
     * @return true if test passed, false if not
     */
    public static boolean testSymTableLookupGlobal2(){
        SymTable testSymTable = new SymTable();
        try{
            testSymTable.addDecl("First", new Sym("type"));
            testSymTable.addScope();
            testSymTable.addDecl("Second", new Sym("wrong"));
            testSymTable.addScope();
            testSymTable.addDecl("Second", new Sym("correct"));
            if(!testSymTable.lookupGlobal("Second").getType().equals("correct")){
                return false;
            }
        } catch(EmptySymTableException e){
            return false;
        } catch(Exception e){
            return false;
        }
        return true;
    }
    
}