
/**
 * DFAnimator
 * 
 * Using a DFA of my choice, this class facilitates the animation of a user inputted string
 * in this DFA.  It shows the current state and each step when the user presses a button.
 * ALso shows the result, and whether the string
 * is accepted or not.  Also has changing text to help user keep track of where they are
 * in their input and what their input was.  States change color when they accept (green)
 * and reject (red).
 * 
 * @author (Sean Gillespie)
 * @version (November 24, 2018)
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.regex.*;
public class DFAnimator implements ActionListener//for the button
{
    private static DFAnimator myAnim;//out animator object
    DFACanvas canvas;//DFACanvas we will draw on
    JTextArea ta;//last read text area
    JTextArea ta2;//input string text area
    JButton stepButton;//button to read through the input string and show next animation
    private String input;//input string to be read by DFA
    private int curr;//keeps track of current state of DFA
    private int nextToRead = 0;//used to iterate through input
    
    /*
     * main method
     * facilitates the animation of a DFA by asking for input
     * and checks to make sure user input is good
     */
    public static void main(String[] args)
    {
        myAnim = new DFAnimator();
        String newInput = JOptionPane.showInputDialog("Please enter a string of a's and b's for the DFA: ");
        myAnim.setInput(newInput);//asks for valid string of a and b in input dialog box
        while(!myAnim.inputValid(myAnim.getInput()))//if the string is not a's and b's
        {
            newInput = JOptionPane.showInputDialog("Please enter a string of a's and b's for the DFA: ");
            myAnim.setInput(newInput);//trying again to get good input in the dialog box
        }
    }
    
    /*
     * constructor for DFAnimator
     * 
     * sets up all the graphical objects used for the animation.
     */
    public DFAnimator()
    {
        //frame with all we see (canvas, button, two text areas are on this frame)
        JFrame newFrame = new JFrame();
        newFrame.setSize(1000,1000);
        newFrame.getContentPane().setBackground(Color.YELLOW); 
        newFrame.setLayout(new FlowLayout());
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.pack();
        newFrame.setLocationRelativeTo(null);
        newFrame.setVisible(true);

        //what is painted on each step
        canvas = new DFACanvas();
        canvas.setSize(800,800);
        canvas.setVisible(true);
        canvas.setBackground(Color.WHITE); 
        newFrame.add(canvas);
        
        //button for reading string
        stepButton = new JButton("Read Next Character");
        stepButton.addActionListener(this);
        stepButton.setVisible(true);
        newFrame.getContentPane().add(stepButton);

        //text area to tell the last char read so we know where we are in the string
       
        ta = new JTextArea("Last Read: ", 5, 10);
        ta.setFont(new Font("TimesRoman", Font.BOLD, 20)); 
        ta.setPreferredSize(new Dimension(100, 100));
        ta.setLineWrap(true);
        ta.setVisible(true);
        newFrame.add(ta);
        
        //text area to remind user what their input string was.
        ta2 = new JTextArea("Input: ", 5, 10);
        ta2.setFont(new Font("TimesRoman", Font.BOLD, 20)); 
        ta2.setPreferredSize(new Dimension(100, 100));
        ta2.setLineWrap(true);
        ta2.setVisible(true);
        newFrame.add(ta2);
    }

    /*
     * inputValid
     * 
     * checks user input to make sure it consists of the alphabet only (a's and b's) or the emptystring
     */
    public boolean inputValid(String str)
    {
        for(int i = 0; i < str.length(); i++)
        {
            if(!Pattern.matches("[ab]*", str))//using regex thats pretty NEATO!!!
            {
                return false;
            }
        }
        return true;
    }

    
    /*
     * actionPerformed (comes from actionListener interface, so we override it
     * 
     * each time the button is pressed, this method will call the repaint method to paint the
     * canvas in a certain way to show the animation.
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {
        try//we ahve to take the emptystring into account
        {
            myAnim.getInput().charAt(0);
        }
        catch(StringIndexOutOfBoundsException ex)
        {
            canvas.setState(curr);
            canvas.setDone(true);
            ta.setText("Last Read: emptystring");
            ta2.setText("Input: emptystring");
            canvas.repaint();
            JOptionPane.showMessageDialog(null, "This DFA rejected the emptystring, ends in state 0.");
            //will also turn red , but felt like it would be helpful to have a dialog as well.
        }
        ta2.setText("Input: " + input);//display input string in the textarea to remember it
        char c = input.charAt(nextToRead);//reading though each char in the string
        
        //switch statement for either a or b.  ALters Dispalys and calls repaint with updates for animation
        if(c == 'a')
        {
            switch (curr) {
                case 0:  curr = 1;//this is where we make the desired transition
                canvas.setState(curr);
                ta.setText("Last Read: " + c);//update last read field with last char read on last press
                canvas.repaint();//repaint to show animation
                nextToRead++;
                break;
                case 1:  curr = 2;
                canvas.setState(curr);
                ta.setText("Last Read: " + c);
                canvas.repaint();
                nextToRead++;
                break;
                case 2:  curr = 3;
                canvas.setState(curr);
                ta.setText("Last Read: " + c);
                canvas.repaint();
                nextToRead++;
                break;
                case 3:  curr = 4;
                canvas.setState(curr);
                ta.setText("Last Read: " + c);
                canvas.repaint();
                nextToRead++;
                break;
                case 4:  curr = 4;
                canvas.setState(curr);
                ta.setText("Last Read: " + c);
                canvas.repaint();
                nextToRead++;
                break;
            }
            if(nextToRead == input.length())//this is what happens when the string is done reading
            {
                if (curr == 3)//if we are in the accept states(only state 3)
                {
                    canvas.setState(curr);
                    canvas.setDone(true);//sets done to true wo color will change to green if accepted
                    canvas.repaint();
                    JOptionPane.showMessageDialog(null, "Accepting Configuration Found!!!");//tell user
                }
                else//if we are not in an accept state
                {
                    canvas.setState(curr);
                    canvas.setDone(true);//sets done to true so state turns red to show rejection
                    canvas.repaint();
                    JOptionPane.showMessageDialog(null, "This DFA rejected your input string.");//tell user
                }
            }
        }
        else if(c == 'b')//same as above, but for b in the input
        {
            switch (curr) {
                case 0:  curr = 4;//this is where we make the desired transitions happen
                canvas.setState(curr);
                ta.setText("Last Read: " + c);//update last read for user convenienice
                canvas.repaint();
                nextToRead++;
                break;
                case 1:  curr = 4;
                canvas.setState(curr);
                ta.setText("Last Read: " + c);
                canvas.repaint();
                nextToRead++;
                break;
                case 2:  curr = 1;
                canvas.setState(curr);
                ta.setText("Last Read: " + c);
                canvas.repaint();
                nextToRead++;
                break;
                case 3:  curr = 4;
                canvas.setState(curr);
                ta.setText("Last Read: " + c);
                canvas.repaint();
                nextToRead++;
                break;
                case 4:  curr = 4;
                canvas.setState(curr);
                ta.setText("Last Read: " + c);
                canvas.repaint();
                nextToRead++;
                break;
            }
            if(nextToRead == input.length())//once again what happens when string has been read
            {
                if (curr == 3)//if we are in accept state 3
                {
                    canvas.setState(curr);
                    canvas.setDone(true);//sets to 
                    canvas.repaint();
                    JOptionPane.showMessageDialog(null, "Accepting Configuration Found!!!");//tell user
                }
                else//if we are not in an accept state
                {
                    canvas.setState(curr);
                    canvas.setDone(true);
                    canvas.repaint();
                    JOptionPane.showMessageDialog(null, "This DFA rejected your input string.");//tell suer
                }
            }
        }
        return;
    }

    //accessor and mutator methods
    
    public void setCurr(int st)
    {
        this.curr = st; 
    }

    public int getCurr()
    {
        return curr;
    }

    public void setNextToRead(int st)
    {
        this.nextToRead = st; 
    }

    public int getNextToRead()
    {
        return nextToRead;
    }

    public void setInput(String str)
    {
        this.input = str; 
    }

    public String getInput()
    {
        return input;
    }

}
