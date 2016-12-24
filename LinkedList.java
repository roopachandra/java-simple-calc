/*  Name: Roopa Chandra and Priya Gupta
 *  PennKey: roopac and guppriya
 *  Recitation: 210 and 221
 *
 *  Execution: N/A
 *
 *  Creates a linked list data structure
 *
 */
public class LinkedList {
    private Node head; //the first node in the linked list
    
    /**
     * create and initialize a linked list
     */
    public LinkedList() {
        head = null;
    }
    
    /**
     * return the head of the list
     */
    public Node getHead() {
        return head;
        
        
    }
    
    /**
     * check if head is empty, return true if it is 
     */
    
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        
        return false;
        
        
    }
    
    /**
     * add a new node, nextCalc, to the start of the list
     */
    public void add(Node nextCalc) {
        if (head == null) {
            head = nextCalc;
            head.setNext(null);
            
        }
        else {
            Node oldHead = head;
            head = nextCalc;
            nextCalc.setNext(oldHead);
        }
        
    }
    
    
    /**
     * returns a string verison of the list
     */ 
    public String toString() {
        Node temp = head;
        String printing = "";
        if (temp == null) {
            printing = "blank";
            
        }
        while (temp != null) {
            
            printing += temp.getCalculation() + "        ";
            temp = temp.getNext();
            
        }
        
        
        return printing;
        
    }
    
    
    public static void main(String[] args) { 
        Calculation calc1 = new Calculation(5, "-", 2);
        Calculation calc2 = new Calculation(4, "+", 3);
        Calculation calc3 = new Calculation(3, "-", 2);
        
        Node calc1node = new Node(calc1);
        Node calc2node = new Node(calc2);
        Node calc3node = new Node(calc3);
        
        
        LinkedList list = new LinkedList();
        list.add(calc1node);
        list.add(calc2node);
        list.add(calc3node);
        
        
        //System.out.println(list);
        
        
    }
    
    
    
    
    
}