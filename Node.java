/*  Name: Roopa Chandra and Priya Gupta
 *  PennKey: roopac and guppriya
 *  Recitation: 210 and 221
 *
 *  Execution: N/A
 *
 *  Creates a node data structure 
 *
 */

public class Node {
    private Node next; //the next node in the linked list 
    private Calculation calc; //the value of the node
    
    /**
     * create and initialize a node with a given calculation 
     * @param calc is the calculation
     */
    public Node(Calculation calc) {
        this.calc = calc;
        next = null;
        
    }
    /**
     * create and initialize a node with a given calculation 
     * @param next is the next node in the list
     * @param calc is the calculation
     */   
    public Node(Node next, Calculation calc) {
        this.next = next;
        this.calc = calc;
    }
    
    /**
     * create and initialize a node with a given calculation 
     * @param calc is the calculation
     * @param next is the next node in the linked list
     */
    public Node(Calculation calc, Node next) {
        this.calc = calc;
        this.next = next;
        
        
    }
    /**
     * returns the value, the calculation, of a node
     */
    public Calculation getCalculation() {
        
        return calc;
        
    }
    /**
     * sets the next node equal to node next
     */ 
    public void setNext(Node next) {
        this.next = next;
        
    }
    
    /**
     * returns the next node in the linked list
     */
    public Node getNext() {
        return next;   
    }
    
    
    public static void main(String[] args) {
        Calculation calc1 = new Calculation(5, "+", 2);
        Node calc1Node = new Node(calc1);
        System.out.println(calc1Node.getCalculation().getResult());
    }
}