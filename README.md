

Name: Roopa Chandra 



/**********************************************************************
 *  Put your description of your project below.
 **********************************************************************/

For this project, I have decided to create a basic, working calculator that
    will respond to user interaction. The calculator will have functional operators,
    allow users to store a value to be accessed later, cycle through past calculations,
    and have a clear button to reset the input. My goal is to create a working calculator
    that allows the user to compute mathematical values.  For this project, I will be
    using a combination of Penn Draw functions, objects, recursion, and Linked Lists.  
    
To begin with, I will be creating the interface for the calculator through Penn Draw.
    I am planning on drawing squares with numbers and operators inside of them and then
    leaving a blank rectangle at the top of the calculator to print the number the user
    just inputted. I have decided to output each number clicked as the user selects the
    numbers and then to output the result when the user clicks equal or goes on to click
    another operator. For example, if the user clicks 5, the plus, the 10, the divide, then
    the 5; it will take the 5 and 10, add them together and output the result. It will then,
    take the result (15) and divide by 5 and output 3. This behavior is similar to the
    calculator found on mac laptops which provides an intuitive interface. The calculator
    also accepts multi-digit numbers but will only display one number at a time. For example
    when entering 555, it will show 5 three times. 
        
When creating the calculator, I will create a while true loop that will monitor the mouse
    clicks and determine what button was clicked by using the x-coordinate and y-coordinate
    of the position of the mouse click. One the button is identified, if it is a number it
    will store it and if it is an operator it will store it until two arguments are entered
    and then the operation will be performed on the two values. In addition, I will store the
    past calculations in a linked list. Each calculation will create a new object called calculation
    that stores the two variables and the operator so when the user goes to access the calculation,
    all the information is stores.  
        
This calculator will have an addition, subtraction, division, multiplication, and a factorial operator. 
    When the factorial button is pressed, the factorial function will be called which will calculate
    he factorial recursively with 1 as the base case.  




/**********************************************************************
 *  Describe how to run your project. Ideally, it should be as simple
 *  as loading your project source files into Dr. Java. However, if 
 *  you use any external libraries, list them here.
 **********************************************************************/
   
To run the project, run Draw.java by calling java Draw. The program works as follows: 
        In order to use addition, subtraction, multiplication, and division, type in a number, the operator,
        the second number, and the = button. The program will then output the 
        correct answer. In order to complete a second calculation, you have to repeat the process: type in one number,
        the operator, and the second operator. For factorial, you have to type in a number and the factorial button (!).
Our calculator requires that once you enter a number operator number = and get the result, you start a new calculation in
        the same format number operator number equal. You cannot take the result and immediately click a new operator. If           you wish to use the result later, you can enter it and then hit store mem to save it for later. 
I also have added four additional functions: store memory (store mem button), get memory (get mem button), and look at past         calculations (^ button), and clear  (C). To use the store memory and get memory function, type in a number, and then         click store mem. In order to use that number, click get mem, which will output the number to the screen, and then           click an operator and another number. You will only be able to access the number you stored in store mem once. In           order to store a new number, repeat the process: type in a number and then click store mem. In order to look at past         calculations, click the ^ button. This will cycle through all your past calculations. In order to use a past                 calculation, you will have to type in the number again. Lastly, the clear button clears your current calculation.           So, if you click a number, lets say 5, and realize you wanted to click a different number, click the C button in             order to clear 5. 

In order to prevent user error from crashing the program, I threw RunTime errors everytime the user 
        inputs a wrong calculation (ie. 5 ++,  2+=, 3=). Thus, in order to use the calculator again, one must 
        run the program again.
    

/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/

I found it hard to figure out what button on the 
        calculator the user clicked with getting just the x and y location
        of the mouse. I also ran into a problem with mousePressed as I found
        it returns true normally about three times for every user click, thus causing
        our calculator to think the buton had been clicked three times. However, I was able to overcome both
        these problems by using a 2D array to store the
        buttons and then calculating the indicies given the mouse location to get the string
        represenation of the button clicked. To solve the second problem, I decided to monitor
        when mousePressed changes from false to true instead of just using the value returned. 


/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **********************************************************************/

I found this project really enjoyable and informative. I learned a lot 
        about linked lists and objects.


