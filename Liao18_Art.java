// needed for doing graphics
import java.awt.*;
import javax.swing.*;

/**
 * Class Art 
 * 
 * @author Jonathan Liao
 * @version 2.3.2015
 * 
 * --------------------------
 * CS203
 * Starter Code Last Updated:  Spring 2015
 * --------------------------
 */
public class Art extends JPanel
{

    // instance variables
    // 
    // Define your variables here if you want to assign them in the init()
    // method and use them in paint() method
    // 
    int numTrees = 3;  //example instance variable
    String colorMonster = "";
     /**
      * This method is called exactly once when your program is first started.
      * It asks the user for information used to customize the final drawing.
      */
    public void init() 
    {
        // Example of message window:
        JOptionPane.showMessageDialog(null, 
                                    "Welcome to the Movie Poster Maker.\nCreate a poster for the horror movie \"Cabin in the Woods!\"");

        // Example of dialog window:  prompt user for number of trees and then
        // convert the users input string into an integer
        String question = 
            "How many trees do you want in the picture? (Enter 0-3)";
        String numTreesString = JOptionPane.showInputDialog(question);
        
        try //because "null" cannot be parsed into a string, this catch statement will prevent an error from happening and default to 0
        {
            if(numTreesString != null)
            numTrees = Integer.parseInt(numTreesString);
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, 
                                    "That is not a valid number. 0 will be selected by default."); 
                                    numTrees = 0;
        }
        
        if (numTrees != 0 && numTrees != 1 && numTrees != 2 && numTrees != 3) {
            JOptionPane.showMessageDialog(null, 
                                    "That is not a valid number. 0 will be selected by default."); 
                                    numTrees = 0;
        }
        
        
        String question2 = 
            "What color do you want the monster to be? (Enter red, purple, or orange";
        String colorMonsterString = JOptionPane.showInputDialog(question2);
        colorMonster = colorMonsterString;

        if (!colorMonster.equalsIgnoreCase("red") && !colorMonster.equalsIgnoreCase("purple") && !colorMonster.equalsIgnoreCase("orange")) {
            JOptionPane.showMessageDialog(null, 
                                    "That is not a valid color. Red will be selected by default."); 
                                    colorMonster = "red";
        }

        
    }//init
    
     
    public void drawTree(Graphics canvas, int x, int y)
    {

        Color wood = new Color(150, 111, 51);
        canvas.setColor(wood);
        
        canvas.fillRect(x+75,y+120,20,50); //trunk
        canvas.setColor(Color.green.darker().darker()); 
        
        int xpoints[] = {x+ 40, x+ 85, x+ 130};
        int ypoints[] = {y+ 125, y+ 5, y+ 125};
        int npoints = 3;

        canvas.fillPolygon(xpoints, ypoints, npoints);

    }//drawTree
    
    public void drawMonster(Graphics g) {
        

        g.fillOval(40, 220, 55, 40); //body
        
        g.setColor(Color.green.darker().darker().darker().darker()); //stem
        int xpoints[] = {55, 70, 80};
        int ypoints[] = {220, 180, 220};
        int npoints = 3;
        
        g.fillPolygon(xpoints, ypoints, npoints);
        
        g.setColor(Color.black);
        g.fillOval(58, 245, 20, 10); //mouth
        
        g.setColor(Color.black); //nose 
        int x1points[] = {64, 69, 74};
        int y1points[] = {242, 237, 242};
        int n1points = 3;
        g.fillPolygon(x1points, y1points, n1points);
        
        g.setColor(Color.black);
        g.fillRect(52, 230, 10, 10); //right eye
        
        g.setColor(Color.black);
        g.fillRect(75, 230, 10, 10); //left eye
        
        g.setColor(Color.red);
        g.fillRect(54, 232, 5, 5); //right pupil
        
        g.setColor(Color.red);
        g.fillRect(77, 232, 5, 5); //left pupil
        
    
    
    }
    
    /**
     * This program uses the data that the init() method placed in the program's
     * instance variables to draw artwork on the window.  
     * 
     * This method will be called many times.  Each time the window is moved,
     * resized, covered or uncovered, the painting must be redrawn.
     * 
     * @param  canvas   the Graphics object for this applet
     */
    public void paint(Graphics canvas) 
    {
        //leave this mysterious line of code here.  Otherwise your
        //background color won't be painted
        super.paint(canvas);
        setBackground(Color.black);
        
        //draw the house
        
        canvas.setColor(Color.green.darker()); 
        canvas.fillRect(0, 250, 10000, 10000); //grass
        
        Color lightwood = new Color(170, 131, 71);
        canvas.setColor(lightwood); 
        canvas.fillRect(150, 150, 200, 150); //house body
        
        Color wood = new Color(150, 111, 51);
        canvas.setColor(wood); //house roof 
        int xpoints[] = {120, 250, 380};
        int ypoints[] = {150, 70, 150};
        int npoints = 3;
        
        canvas.fillPolygon(xpoints, ypoints, npoints);
        
        canvas.setColor(Color.lightGray);
        canvas.fillRect(200, 230, 50, 70); //door
        
        canvas.setColor(Color.black);
        canvas.fillRect(275, 200, 30, 30); //window
        
        canvas.setColor(Color.white);
        canvas.fillOval(30, 40, 40, 40); //moon

        
        // check to see if we need to draw a second tree
        if(colorMonster.equalsIgnoreCase("red"))
        {
            canvas.setColor(Color.red.darker()); 
            drawMonster(canvas);
        }
        else if(colorMonster.equalsIgnoreCase("purple")){
            canvas.setColor(Color.blue.darker()); 
            drawMonster(canvas);
            
        }

        else if(colorMonster.equalsIgnoreCase("orange")) {
            canvas.setColor(Color.orange); 
            drawMonster(canvas);
        }

        
        
        
        if(numTrees == 1)
        {
            drawTree(canvas, 300, 225);
        }
        else if(numTrees == 2){
            drawTree(canvas, 40, 185);
            drawTree(canvas, 230, 300);
        }

        else if(numTrees == 3) {
            drawTree(canvas, 40, 185);
            drawTree(canvas, 150, 300);
            drawTree(canvas, 300, 225);
        }
        else{
            //no trees drawn!
        }
        
        
        
        
        canvas.setColor(Color.red);
        canvas.drawString("The Cabin in the Woods".toUpperCase(), 170, 140);
    }//paint


    /**
     * The program begins by creating a window frame and putting a drawing canvas
     * into it.  CS203 Students can safely ignore this method though you may wish
     * to change the size of the window from the 500x500 specified below.
     */
    public static void main(String[] args)
    {
        //Create a window frame
        JFrame myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(500,500);

        // put the picture in the frame
        Art studentArt = new Art();
        studentArt.init();
        myFrame.add(studentArt);

        //show the user
        myFrame.setVisible(true);
    }    
}//class Art
