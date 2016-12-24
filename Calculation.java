/*  Name: Roopa Chandra and Priya Gupta
 *  PennKey: roopac and guppriya
 *  Recitation: 210 and 221
 *
 *  Execution: N/A
 *
 *  Generates a Calculation object that contains the first operand, the operator 
 *  and the second operand 
 *
 */


public class Calculation {
    private double first; //the first number in the calculation
    private String operator; //the operatator for the calculation 
    private double second; //the second number in the calculation 
    
    /**
     * create and initialize a calculation with given a expression
     * @param first is the first number in the calculation
     * @param operator is the operator in the calculation
     * @param second is the second number in the calculation
     */
    public Calculation(double first, String operator, double second)  {
        this.first = first;
        this.operator = operator;
        this.second = second;
        
    }
    
    //returns the first number in the calculation
    public String getFirst() {
        return "" + first;    
    }
    
    //returns the second number in the calculation 
    public String getSecond() {
        return "" + second;     
        
    }
    
    //returns a string representation of the result of the expression
    public String getResult() {
        return "" + result();
        
        
    }
    
    //computing the result of the operation 
    public double result() {
        if (operator.equals("+")) {
            //    System.out.println("INSDIE RESULT FUNCTION");
            return first + second;
        }
        
        if (operator.equals("-")) {
            return first - second;
            
        }
        
        if (operator.equals("/")) {
            return first / second; 
            
        }
        
        if (operator.equals("x")) {
            return first * second;
            
            
        }
        
        if (operator.equals("!")) {
            return factorial(first);
            
            
        }
        
        if (operator.equals("=")) {
            return result();
            
        }
        
        throw new RuntimeException("ERROR: You didn't input an operator");
        
    }
    
    
    //computing the factorial of a integer num
    public double factorial(double num) {
        if (num == 1) {
            return 1;
        }
        
        return num * factorial(num - 1);
        
    }
    
    //returning a string representation of the operation 
    public String toString() {
        String operation = "" + first + " " + operator + " " + second + " " +
            "=" + " " + result();
        return operation;
    }
    
    
    public static void main(String[] args) {
        Calculation calc = new Calculation(5, "/", 2);
        //System.out.println(calc.toString());
        
    }
    
}