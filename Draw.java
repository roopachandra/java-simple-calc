/*  Name: Roopa Chandra and Priya Gupta
 *  PennKey: roopac and guppriya
 *  Recitation: 210 and 221
 *
 *  Execution: Java Draw
 *
 *  MAIN CLASS-- program generates the calculator and allows for user interaction
 *
 */

public class Draw {
    
    //initializes global variables so they can be cleared throughout the class
    //holds the numbers of the first number
    private static String firstString = "";
    //int representation of the first number
    private static double first = 0;
    private static String operator = "";
    private static String secondString = "";
    private static double second = 0;
    private static boolean firstTime = true;
    private static boolean equalsPressed = false;
    //is this the first value for the second string
    private static boolean firstEntry = true;
    //was the operator entered
    private static boolean operatorEntered = false;
    //stores value by user
    private static double memNum = 0;
    
    //draws the actual calculator using Penn Draw
    public static void drawCalc() {
        PennDraw.clear();
        PennDraw.setPenColor(PennDraw.BLACK);
        
        //draws the vertical lines of the calculator
        for (double x = 0; x <= 1; x = x + .25) {
            //System.out.println(" X values: " + x);
            PennDraw.line(x, 0, x, .833);
        }
        
        //draws the horizontal lines of the calculator
        for (double y = 0; y <= .84; y = y + .167) {
            //System.out.println(" Y values: " + y);
            PennDraw.line(0, y, 1, y);
        }
        
        //an array of all the values to be added to the calcualtor
        String[] arr = {"get mem", "1", "4", "7", "C", "0", "2",
            "5", "8", "^", "!", "3", "6", "9", "store mem", "=",
            "+", "-", "x", "/"};
        int k = 0;
        
        //adds the symbols to the boxes of the calculator
        for (double i = .125; i < 1; i = i + .25) {
            for (double j = .08; j < .84; j = j + .167) {
                PennDraw.text(i, j, arr[k]);
                k++;
            }  
        }  
    }
    
    //clears variables so user can enter new calculation
    public static void clear() {
        firstString = "";
        first = 0;
        operator = "";
        secondString = "";
        second = 0;
        firstTime = true;
        //is this the first value for the second string
        firstEntry = true;
        //was the operator entered
        operatorEntered = false;
        //stores past calculators
        equalsPressed = false;
        drawCalc();
        
    }
    
    //waits for user input and then performs the calculations
    public static void main(String[] args) {
        //initializes some objects and variables used when reading user input 
        double first = 0;
        
        LinkedList list = new LinkedList();
        boolean past = false;
        boolean firstUp = true;
        drawCalc();
        
        Node tempNode = null;
        
        //waits for user input
        while (true) {
            
            boolean present = PennDraw.mousePressed();
            
            //waits for false to change to true
            if (past != present) {
                //System.out.println(" Present: "  + present);
                if (present == true) {
                    past = true;
                    //System.out.println("Past: " + past);
                }
                else {
                    past = false;  
                }
                
                //runs if user clicks a button
                if (present == true) {
                    if (equalsPressed) {
                        clear(); 
                    }
                    drawCalc();
                    double xLocation = PennDraw.mouseX();
                    double yLocation = PennDraw.mouseY();
                    //figures out what row and column of the click
                    int column = (int) Math.ceil(xLocation / .25) - 1;
                    int row = (int) Math.ceil(yLocation / .167) - 1;
                    
                    String [][] buttons = new String[][] {
                        {"get mem", "0", "!", "="},
                        {"1", "2", "3", "+"},
                        {"4", "5", "6", "-"},
                        {"7", "8", "9", "x"},
                        {"C", "^", "store mem", "/"}  
                    };
                    
                    if (row > 4 || row < 0 || column < 0 || column > 5) {
                        throw new RuntimeException(
                                                   "ERROR: YOU FIRST HAVE TO" + 
                                                   "CLICK WITHIN THE" +
                                                   "CALCULATOR"); 
                    }
                    //prints out the button clicked by the user
                    PennDraw.textRight(1, .917, buttons[row][column]);
                    
                    //takes user input for the first number
                    if (!operatorEntered && !buttons[row][column].equals("C") &&
                        !buttons[row][column].equals("^")) {
                        //first input must be a number
                        if (firstTime) {
                            if (row == 4 || column == 3 ||
                                (row == 0 & column == 2)) {
                                throw new RuntimeException("ERROR: YOU NEED" +
                                                           "TO ENTER A" +
                                                           "NUMBER FIRST"); 
                            }
                            firstTime = false;
                        }
                        
                        if (row == 4 && column == 0) {
                            clear();
                            // System.out.println(firstString);
                        }
                        
                        else {
                            //if operator is entered, first number is entered
                            if (row == 4 || column == 3 || 
                                (row == 0 &  (column == 0 || column == 2))) {
                                
                                //if get mem button is clicked
                                if (buttons[row][column].equals("get mem")) {
                                    firstString = Integer.toString((int) memNum);
                                    //PennDraw.textRight(1, .917, firstString);
                                }
                                
                                //if store mem button is clicked
                                else if
                                    (buttons[row][column].equals("store mem")) {
                                    
                                    if (firstString.equals("")) {
                                        memNum = 0;
                                    }
                                    
                                    else {
                                        //System.out.println("Store mem");
                                        memNum = Integer.parseInt(firstString);
                                    }
                                    
                                    PennDraw.textRight(1, .917, firstString);
                                    clear();
                                }
                                
                                //checking to see if factorial is clicked
                                else if (row == 0 && column == 2) {
                                    first = Integer.parseInt(firstString); 
                                    second = 0;
                                    operator = "!";
                                    
                                    Calculation expression = 
                                        new Calculation(first, operator, second);
                                    Node newNode = new Node(expression);
                                    list.add(newNode);
                                    
                                    String result = expression.getResult();
                                    // System.out.println("RESULT:" + result);
                                    
                                    PennDraw.textRight(1, .917, result);
                                    equalsPressed = true;
                                    
                                }
                                
                                //converts string to int for calculations
                                else {
                                    first = Integer.parseInt(firstString); 
                                    //stores operator entered
                                    operator = buttons[row][column];
                                    operatorEntered = true;
                                }
                                
                            }
                            
                            //add new number to firstString
                            else firstString += buttons[row][column];
                            //System.out.println(" Num Entered: " + firstString);
                        }
                        
                    }
                    
//                else if (operatorEntered) {
//                    System.out.println("Inside Operator Loop");
//                }
                    
                    else {
                        if (firstEntry == true && 
                            !buttons[row][column].equals("C") &&
                            !buttons[row][column].equals("^") &&
                            !buttons[row][column].equals("store mem") &&
                            !buttons[row][column].equals("get mem")) {
                            
                            //if they enter an operator first
                            if (row == 4 || column == 3 || 
                                (row == 0 & (column == 0 || column == 2))) {
                                
                                throw new RuntimeException("ERROR: YOU NEED TO" +
                                                           "ENTER A NUMBER" +
                                                           "FIRST"); 
                            }
                            
                            firstEntry = false;
                        }  
                        
                        //if operator is entered, second number is fully entered
                        if (row == 4 || column == 3 || 
                            (row == 0 & (column == 0 || column == 2))) {
                            
                            //if they click get mem button
                            if (buttons[row][column].equals("get mem")) {
                                secondString = Integer.toString((int) memNum);
                                firstEntry = false;
                                //PennDraw.textRight(1, .917, secondString);
                                
                            }
                            
                            //if they click store mem button
                            if (buttons[row][column].equals("store mem")) {
                                throw new RuntimeException("ERROR:" +
                                                           "Cannot store" +
                                                           "calculation" +
                                                           "in here"); 
                                
                            }
                            
                            //if they click = buton
                            if (buttons[row][column].equals("=")) {
                                second = Integer.parseInt(secondString); 
                                
                                //add calculation to the list
                                Calculation expression = new
                                    Calculation(first, operator, second);
                                Node newNode = new Node(expression);
                                list.add(newNode);
                                //System.out.println("LIST " + list.toString());
                                
                                String result = expression.getResult();
                                // System.out.println("RESULT:" + result);
                                
                                PennDraw.textRight(1, .917, result);
                                equalsPressed = true;
                                
                                
                            }
                            //if they press C button 
                            else if (buttons[row][column].equals("C")) {
                                
                                clear();
                                firstUp = true;
                                tempNode = list.getHead();
                                
                                PennDraw.textRight(1, .917, "");
                                
                                
                            }
                            
                            //if they press ^ button
                            else if (buttons[row][column].equals("^")) { 
                                if (tempNode == null) {
                                    tempNode = list.getHead();
                                    
                                }
                                
                                if (tempNode == null) {
                                    throw new RuntimeException("ERROR:" +
                                                               "No" +
                                                               "calculations" +
                                                               "present");
                                    
                                    
                                    
                                }
                                
                                if (firstUp) {
                                    String result = 
                                        tempNode.getCalculation().getResult();
                                    PennDraw.textRight(1, .917, result);
                                    firstUp = false;
                                }
                                
                                else {                        
                                    String result = 
                                        tempNode.getCalculation().getResult();
                                    PennDraw.textRight(1, .917, result);
                                    tempNode = tempNode.getNext();
                                }   
                                
                            }
                            
                            //if they click store mem button
                            else if (buttons[row][column].equals("store mem")) {
                                second = Integer.parseInt(secondString); 
                                memNum = second;
                                
                            }
                            
                            //doesn't throw error if get mem is pressed
                            else if (buttons[row][column].equals("get mem")) {
                                PennDraw.textRight(1, .917, "get mem");
                            }
                            
                            //makes user hit enter before starting a new
                            //calculation
                            else {
                                throw new RuntimeException("ERROR: " + 
                                                           "YOU FIRST" +
                                                           "HAVE TO ENTER" + 
                                                           "EQUALS"); 
                            }
                            
                        }
                        //adds the number to string
                        else {
                            secondString += buttons[row][column];
                        }
                        
                    }
                    
                }
            }
        }
        
        
    }
}