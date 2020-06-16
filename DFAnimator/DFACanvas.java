/**
 * DFACanvas
 * 
 * Lays out the visual aspects of the DFAnimator class for the user to see and interact with.
 * Has a different case for each state the DFA could be in at any given time.
 * 
 * @author(Sean Gillespie)
 * @version(November 24,2018)
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Canvas;
import javax.swing.JFrame;

public class DFACanvas extends Canvas
{
    private final Color STATE = Color.BLUE;//color of normal state
    private final Color ON_STATE = Color.YELLOW;//color of current state
    private final Color START = Color.CYAN;//start arrow to indicate start state
    private final Color TRANSITION = Color.GRAY;//color of the transition arrows.
    private final Color LABELS = Color.BLACK;//color of all textual labels
    private final Color ACCEPT = Color.GREEN;//color the accept state turns when it accepts a string
    private final Color REJECT = Color.RED;//color state turns when input is rejected.
    private int state;//which state the DFA is in
    private boolean done = false;//whether the whole string has been read
    
    /*Paint
     * 
     * Draws everything the user will see in the animation.
     * Different case for each state the DFA could be in.
     */
    public void paint(Graphics g) 
    {
        switch (state) {
            case 0://case 0 is what is painted when the DFA is currently in state 0.
            super.paint(g);
            g.setColor(LABELS);
            g.setFont(new Font("TimesRoman", Font.BOLD, 16)); //here we are giving directions.
            g.drawString("Welcome to the DFAnimator. Input string into dialog box, then press the", 5, 15);
            g.drawString("read next character button to read your input string and see it being", 5, 28);
            g.drawString("decided by the DFA.  Yellow state indiciates current state, green means", 5, 41);
            g.drawString("it has accepted, red means it has rejected.  Track last read and remember", 5, 54);
            g.drawString("what your input string was by looking at the fields below the DFA. Enjoy!", 5, 67);
            g.drawString("NOTE: for testing purposes, the DFA langauge is a(ab)*aa", 5, 80);
            g.setColor(START);
            int xpoints0[] = {75, 100, 75};
            int ypoints0[] = {320, 340, 360};
            int npoints0 = 3;
            g.fillPolygon(xpoints0, ypoints0, npoints0);//start state indicator
            if(done == true)//for changing the state red to show rejection of string after fisnihed read
            {
                g.setColor(REJECT);
            }
            else//otherwise, use yellow to indicate we are on this state.
            {
                g.setColor(ON_STATE);
            }
            g.fillOval(100,300,80,80);//draws state 0 in yellow to undicate we are there
            g.setColor(STATE);
            g.fillOval(250,300,80,80);//draw the rest of the states default blue
            g.fillOval(400,300,80,80);
            g.fillOval(550,300,80,80);
            g.fillOval(250,500,80,80);
            g.setColor(LABELS);
            g.drawOval(560,310,60,60);//this is the circle that indiciates state 3 is a final state
            g.setFont(new Font("TimesRoman", Font.BOLD, 20));//change font for labels so we can see 
            g.drawString("0", 135, 350);//labeling all the states with corresponding number
            g.drawString("1", 285, 350);
            g.drawString("2", 435, 350);
            g.drawString("3", 585, 350);
            g.drawString("4", 285, 550);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 14));//shrink font
            g.drawString("a",360,310);//labaleing all the arrow transitions.
            g.drawString("a",200,330);
            g.drawString("a",510,330);
            g.drawString("b",360,377);
            g.drawString("a,b",480,440);
            g.drawString("a,b",280,640);
            g.drawString("b",200,470);
            g.drawString("b",296,450);
            g.setColor(TRANSITION);//here we draw all the arrows
            g.drawLine(180, 340, 250, 340);
            g.drawLine(480,340,550,340);
            g.drawLine(140,380,257,510);
            g.drawLine(557,365,320,515);
            g.drawLine(290,380,290,500);
            g.drawArc(330, 315, 70, 30, 0, 180);
            g.drawArc(330, 330, 70, 30, 180, 180);
            g.drawArc(270, 530, 35, 90, 180, 180);
            //making all the arrow tips
            int xpointsZeroA[] = {250, 240, 240};
            int ypointsZeroA[] = {340, 345, 335};
            int npointsZeroA = 3;
            g.fillPolygon(xpointsZeroA, ypointsZeroA, npointsZeroA);
            int xpointsZeroB[] = {260, 255, 247};
            int ypointsZeroB[] = {515, 500, 508};
            int npointsZeroB = 3;
            g.fillPolygon(xpointsZeroB, ypointsZeroB, npointsZeroB);
            int xpointsOneA[] = {402, 402, 392};
            int ypointsOneA[] = {330, 320, 330};
            int npointsOneA = 3;
            g.fillPolygon(xpointsOneA, ypointsOneA, npointsOneA);
            int xpointsOneB[] = {290, 285, 295};
            int ypointsOneB[] = {505, 490, 490};
            int npointsOneB = 3;
            g.fillPolygon(xpointsOneB, ypointsOneB, npointsOneB);
            int xpointsTwoA[] = {550, 537, 537};
            int ypointsTwoA[] = {340, 335, 345};
            int npointsTwoA = 3;
            g.fillPolygon(xpointsTwoA, ypointsTwoA, npointsTwoA);
            int xpointsTwoB[] = {330, 330, 340};
            int ypointsTwoB[] = {345, 355, 345};
            int npointsTwoB = 3;
            g.fillPolygon(xpointsTwoB, ypointsTwoB, npointsTwoB);
            int xpointsThree[] = {320, 330, 337};
            int ypointsThree[] = {515, 503, 510};
            int npointsThree = 3;
            g.fillPolygon(xpointsThree, ypointsThree, npointsThree);
            int xpointsFour[] = {270, 275, 265};
            int ypointsFour[] = {573, 587, 587};
            int npointsFour = 3;
            g.fillPolygon(xpointsFour, ypointsFour, npointsFour);

            break;
            
            case 1://case 1 is what is painted when DFA is in state 1

            super.paint(g);
            g.setColor(LABELS);
            g.setFont(new Font("TimesRoman", Font.BOLD, 16)); 
            g.drawString("Welcome to the DFAnimator. Input string into dialog box, then press the", 5, 15);
            g.drawString("read next character button to read your input string and see it being", 5, 28);
            g.drawString("decided by the DFA.  Yellow state indiciates current state, green means", 5, 41);
            g.drawString("it has accepted, red means it has rejected.  Track last read and remember", 5, 54);
            g.drawString("what your input string was by looking at the fields below the DFA. Enjoy!", 5, 67);
            g.drawString("NOTE: for testing purposes, the DFA langauge is a(ab)*aa", 5, 80);
            g.setColor(START);
            int xpoints1[] = {75, 100, 75};
            int ypoints1[] = {320, 340, 360};
            int npoints1 = 3;
            g.fillPolygon(xpoints1, ypoints1, npoints1);//start state indicator
            g.setColor(STATE);
            g.fillOval(100,300,80,80);
            if(done == true)//for changing the color of the state to red to show rejection of string 
            {
                g.setColor(REJECT);
            }
            else//jsut make it yellow
            {
                g.setColor(ON_STATE);
            }
            g.fillOval(250,300,80,80);
            g.setColor(STATE);
            g.fillOval(400,300,80,80);
            g.fillOval(550,300,80,80);
            g.fillOval(250,500,80,80);
            g.setColor(LABELS);
            g.drawOval(560,310,60,60);//state 3 final indication
            g.setFont(new Font("TimesRoman", Font.BOLD, 20)); 
            g.drawString("0", 135, 350);//labeling all the states
            g.drawString("1", 285, 350);
            g.drawString("2", 435, 350);
            g.drawString("3", 585, 350);
            g.drawString("4", 285, 550);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
            g.drawString("a",360,310);//labeling all the transitions
            g.drawString("a",200,330);
            g.drawString("a",510,330);
            g.drawString("b",360,377);
            g.drawString("a,b",480,440);
            g.drawString("a,b",280,640);
            g.drawString("b",200,470);
            g.drawString("b",296,450);
            g.setColor(TRANSITION);
            g.drawLine(180, 340, 250, 340);//drawing all the transitions
            g.drawLine(480,340,550,340);
            g.drawLine(140,380,257,510);
            g.drawLine(557,365,320,515);
            g.drawLine(290,380,290,500);
            g.drawArc(330, 315, 70, 30, 0, 180);
            g.drawArc(330, 330, 70, 30, 180, 180);
            g.drawArc(270, 530, 35, 90, 180, 180);
            //here is all the transition arrow tips
            int xpointsZeroA1[] = {250, 240, 240};
            int ypointsZeroA1[] = {340, 345, 335};
            int npointsZeroA1 = 3;
            g.fillPolygon(xpointsZeroA1, ypointsZeroA1, npointsZeroA1);
            int xpointsZeroB1[] = {260, 255, 247};
            int ypointsZeroB1[] = {515, 500, 508};
            int npointsZeroB1 = 3;
            g.fillPolygon(xpointsZeroB1, ypointsZeroB1, npointsZeroB1);
            int xpointsOneA1[] = {402, 402, 392};
            int ypointsOneA1[] = {330, 320, 330};
            int npointsOneA1 = 3;
            g.fillPolygon(xpointsOneA1, ypointsOneA1, npointsOneA1);
            int xpointsOneB1[] = {290, 285, 295};
            int ypointsOneB1[] = {505, 490, 490};
            int npointsOneB1 = 3;
            g.fillPolygon(xpointsOneB1, ypointsOneB1, npointsOneB1);
            int xpointsTwoA1[] = {550, 537, 537};
            int ypointsTwoA1[] = {340, 335, 345};
            int npointsTwoA1 = 3;
            g.fillPolygon(xpointsTwoA1, ypointsTwoA1, npointsTwoA1);
            int xpointsTwoB1[] = {330, 330, 340};
            int ypointsTwoB1[] = {345, 355, 345};
            int npointsTwoB1 = 3;
            g.fillPolygon(xpointsTwoB1, ypointsTwoB1, npointsTwoB1);
            int xpointsThree1[] = {320, 330, 337};
            int ypointsThree1[] = {515, 503, 510};
            int npointsThree1 = 3;
            g.fillPolygon(xpointsThree1, ypointsThree1, npointsThree1);
            int xpointsFour1[] = {270, 275, 265};
            int ypointsFour1[] = {573, 587, 587};
            int npointsFour1 = 3;
            g.fillPolygon(xpointsFour1, ypointsFour1, npointsFour1);

            break;
            
            case 2://case 2 is what is npainted when DFA is in state 2

            super.paint(g);
            g.setColor(LABELS);
            g.setFont(new Font("TimesRoman", Font.BOLD, 16)); //directions
            g.drawString("Welcome to the DFAnimator. Input string into dialog box, then press the", 5, 15);
            g.drawString("read next character button to read your input string and see it being", 5, 28);
            g.drawString("decided by the DFA.  Yellow state indiciates current state, green means", 5, 41);
            g.drawString("it has accepted, red means it has rejected.  Track last read and remember", 5, 54);
            g.drawString("what your input string was by looking at the fields below the DFA. Enjoy!", 5, 67);
            g.drawString("NOTE: for testing purposes, the DFA langauge is a(ab)*aa", 5, 80);
            g.setColor(START);
            int xpoints2[] = {75, 100, 75};
            int ypoints2[] = {320, 340, 360};
            int npoints2 = 3;
            g.fillPolygon(xpoints2, ypoints2, npoints2);//start state indicator
            g.setColor(STATE);
            g.fillOval(100,300,80,80);
            g.fillOval(250,300,80,80);
            if(done == true)//what we do when the string is rejected in state 2 (turns red)
            {
                g.setColor(REJECT);
            }
            else
            {
                g.setColor(ON_STATE);
            }
            g.fillOval(400,300,80,80);
            g.setColor(STATE);
            g.fillOval(550,300,80,80);
            g.fillOval(250,500,80,80);
            g.setColor(LABELS);
            g.drawOval(560,310,60,60);//final state indicator for state 3
            g.setFont(new Font("TimesRoman", Font.BOLD, 20)); 
            g.drawString("0", 135, 350);//labeling all the states
            g.drawString("1", 285, 350);
            g.drawString("2", 435, 350);
            g.drawString("3", 585, 350);
            g.drawString("4", 285, 550);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
            g.drawString("a",360,310);//labaling all the transitions
            g.drawString("a",200,330);
            g.drawString("a",510,330);
            g.drawString("b",360,377);
            g.drawString("a,b",480,440);
            g.drawString("a,b",280,640);
            g.drawString("b",200,470);
            g.drawString("b",296,450);
            g.setColor(TRANSITION);
            g.drawLine(180, 340, 250, 340);
            g.drawLine(480,340,550,340);//drawing all the transitions
            g.drawLine(140,380,257,510);
            g.drawLine(557,365,320,515);
            g.drawLine(290,380,290,500);
            g.drawArc(330, 315, 70, 30, 0, 180);
            g.drawArc(330, 330, 70, 30, 180, 180);
            g.drawArc(270, 530, 35, 90, 180, 180);
            //drawing all the arrow tips.
            int xpointsZeroA2[] = {250, 240, 240};
            int ypointsZeroA2[] = {340, 345, 335};
            int npointsZeroA2 = 3;
            g.fillPolygon(xpointsZeroA2, ypointsZeroA2, npointsZeroA2);
            int xpointsZeroB2[] = {260, 255, 247};
            int ypointsZeroB2[] = {515, 500, 508};
            int npointsZeroB2 = 3;
            g.fillPolygon(xpointsZeroB2, ypointsZeroB2, npointsZeroB2);
            int xpointsOneA2[] = {402, 402, 392};
            int ypointsOneA2[] = {330, 320, 330};
            int npointsOneA2 = 3;
            g.fillPolygon(xpointsOneA2, ypointsOneA2, npointsOneA2);
            int xpointsOneB2[] = {290, 285, 295};
            int ypointsOneB2[] = {505, 490, 490};
            int npointsOneB2 = 3;
            g.fillPolygon(xpointsOneB2, ypointsOneB2, npointsOneB2);
            int xpointsTwoA2[] = {550, 537, 537};
            int ypointsTwoA2[] = {340, 335, 345};
            int npointsTwoA2 = 3;
            g.fillPolygon(xpointsTwoA2, ypointsTwoA2, npointsTwoA2);
            int xpointsTwoB2[] = {330, 330, 340};
            int ypointsTwoB2[] = {345, 355, 345};
            int npointsTwoB2 = 3;
            g.fillPolygon(xpointsTwoB2, ypointsTwoB2, npointsTwoB2);
            int xpointsThree2[] = {320, 330, 337};
            int ypointsThree2[] = {515, 503, 510};
            int npointsThree2 = 3;
            g.fillPolygon(xpointsThree2, ypointsThree2, npointsThree2);
            int xpointsFour2[] = {270, 275, 265};
            int ypointsFour2[] = {573, 587, 587};
            int npointsFour2 = 3;
            g.fillPolygon(xpointsFour2, ypointsFour2, npointsFour2);

            break;
            
            case 3://case 3 is what is painted when DFA is in state 3 (accept state)
            
            super.paint(g);
            g.setColor(LABELS);
            g.setFont(new Font("TimesRoman", Font.BOLD, 16)); //directions
            g.drawString("Welcome to the DFAnimator. Input string into dialog box, then press the", 5, 15);
            g.drawString("read next character button to read your input string and see it being", 5, 28);
            g.drawString("decided by the DFA.  Yellow state indiciates current state, green means", 5, 41);
            g.drawString("it has accepted, red means it has rejected.  Track last read and remember", 5, 54);
            g.drawString("what your input string was by looking at the fields below the DFA. Enjoy!", 5, 67);
            g.drawString("NOTE: for testing purposes, the DFA langauge is a(ab)*aa", 5, 80);
            g.setColor(START);
            int xpoints3[] = {75, 100, 75};
            int ypoints3[] = {320, 340, 360};
            int npoints3 = 3;
            g.fillPolygon(xpoints3, ypoints3, npoints3);//start state indicator
            g.setColor(STATE);
            g.fillOval(100,300,80,80);
            g.fillOval(250,300,80,80);
            g.fillOval(400,300,80,80);
            if(done == true)//what happens when we end in state 3 and accept (turns green)
            {
                g.setColor(ACCEPT);
            }
            else//otherwise indicate we aare in this state
            {
                g.setColor(ON_STATE);
            }
            g.fillOval(550,300,80,80);
            g.setColor(STATE);
            g.fillOval(250,500,80,80);
            g.setColor(LABELS);
            g.drawOval(560,310,60,60);
            g.setFont(new Font("TimesRoman", Font.BOLD, 20)); 
            g.drawString("0", 135, 350);//label states of DFA
            g.drawString("1", 285, 350);
            g.drawString("2", 435, 350);
            g.drawString("3", 585, 350);
            g.drawString("4", 285, 550);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
            g.drawString("a",360,310);//label transisitons of DFA
            g.drawString("a",200,330);
            g.drawString("a",510,330);
            g.drawString("b",360,377);
            g.drawString("a,b",480,440);
            g.drawString("a,b",280,640);
            g.drawString("b",200,470);
            g.drawString("b",296,450);
            g.setColor(TRANSITION);
            g.drawLine(180, 340, 250, 340);
            g.drawLine(480,340,550,340);//draw transitions of DFA
            g.drawLine(140,380,257,510);
            g.drawLine(557,365,320,515);
            g.drawLine(290,380,290,500);
            g.drawArc(330, 315, 70, 30, 0, 180);
            g.drawArc(330, 330, 70, 30, 180, 180);
            g.drawArc(270, 530, 35, 90, 180, 180);
            //drawing the arrow tips.
            int xpointsZeroA3[] = {250, 240, 240};
            int ypointsZeroA3[] = {340, 345, 335};
            int npointsZeroA3 = 3;
            g.fillPolygon(xpointsZeroA3, ypointsZeroA3, npointsZeroA3);
            int xpointsZeroB3[] = {260, 255, 247};
            int ypointsZeroB3[] = {515, 500, 508};
            int npointsZeroB3 = 3;
            g.fillPolygon(xpointsZeroB3, ypointsZeroB3, npointsZeroB3);
            int xpointsOneA3[] = {402, 402, 392};
            int ypointsOneA3[] = {330, 320, 330};
            int npointsOneA3 = 3;
            g.fillPolygon(xpointsOneA3, ypointsOneA3, npointsOneA3);
            int xpointsOneB3[] = {290, 285, 295};
            int ypointsOneB3[] = {505, 490, 490};
            int npointsOneB3 = 3;
            g.fillPolygon(xpointsOneB3, ypointsOneB3, npointsOneB3);
            int xpointsTwoA3[] = {550, 537, 537};
            int ypointsTwoA3[] = {340, 335, 345};
            int npointsTwoA3 = 3;
            g.fillPolygon(xpointsTwoA3, ypointsTwoA3, npointsTwoA3);
            int xpointsTwoB3[] = {330, 330, 340};
            int ypointsTwoB3[] = {345, 355, 345};
            int npointsTwoB3 = 3;
            g.fillPolygon(xpointsTwoB3, ypointsTwoB3, npointsTwoB3);
            int xpointsThree3[] = {320, 330, 337};
            int ypointsThree3[] = {515, 503, 510};
            int npointsThree3 = 3;
            g.fillPolygon(xpointsThree3, ypointsThree3, npointsThree3);
            int xpointsFour3[] = {270, 275, 265};
            int ypointsFour3[] = {573, 587, 587};
            int npointsFour3 = 3;
            g.fillPolygon(xpointsFour3, ypointsFour3, npointsFour3);

            break;
            
            case 4: //case 4 is what is painted when DFA is in state 4.
            
            super.paint(g);
            g.setColor(START);
            g.setColor(LABELS);
            g.setFont(new Font("TimesRoman", Font.BOLD, 16)); //directions
            g.drawString("Welcome to the DFAnimator. Input string into dialog box, then press the", 5, 15);
            g.drawString("read next character button to read your input string and see it being", 5, 28);
            g.drawString("decided by the DFA.  Yellow state indiciates current state, green means", 5, 41);
            g.drawString("it has accepted, red means it has rejected.  Track last read and remember", 5, 54);
            g.drawString("what your input string was by looking at the fields below the DFA. Enjoy!", 5, 67);
            g.drawString("NOTE: for testing purposes, the DFA langauge is a(ab)*aa", 5, 80);
            int xpoints4[] = {75, 100, 75};
            int ypoints4[] = {320, 340, 360};
            int npoints4 = 3;
            g.fillPolygon(xpoints4, ypoints4, npoints4);//indicate start state
            g.setColor(STATE);
            g.fillOval(100,300,80,80);
            g.fillOval(250,300,80,80);
            g.fillOval(400,300,80,80);
            g.fillOval(550,300,80,80);
            if(done == true)//what happens when we end in state 4
            {
                g.setColor(REJECT);
            }
            else//turn yellow to indicate we are in this state during reading process
            {
                g.setColor(ON_STATE);
            }
            g.fillOval(250,500,80,80);
            g.setColor(LABELS);
            g.drawOval(560,310,60,60);
            g.setFont(new Font("TimesRoman", Font.BOLD, 20)); 
            g.drawString("0", 135, 350);//label states of DFA
            g.drawString("1", 285, 350);
            g.drawString("2", 435, 350);
            g.drawString("3", 585, 350);
            g.drawString("4", 285, 550);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
            g.drawString("a",360,310);//label transitons of DFA
            g.drawString("a",200,330);
            g.drawString("a",510,330);
            g.drawString("b",360,377);
            g.drawString("a,b",480,440);
            g.drawString("a,b",280,640);
            g.drawString("b",200,470);
            g.drawString("b",296,450);
            g.setColor(TRANSITION);
            g.drawLine(180, 340, 250, 340);//draw transitions of DFA
            g.drawLine(480,340,550,340);
            g.drawLine(140,380,257,510);
            g.drawLine(557,365,320,515);
            g.drawLine(290,380,290,500);
            g.drawArc(330, 315, 70, 30, 0, 180);
            g.drawArc(330, 330, 70, 30, 180, 180);
            g.drawArc(270, 530, 35, 90, 180, 180);
            //draw all the arrow tips
            int xpointsZeroA4[] = {250, 240, 240};
            int ypointsZeroA4[] = {340, 345, 335};
            int npointsZeroA4 = 3;
            g.fillPolygon(xpointsZeroA4, ypointsZeroA4, npointsZeroA4);
            int xpointsZeroB4[] = {260, 255, 247};
            int ypointsZeroB4[] = {515, 500, 508};
            int npointsZeroB4 = 3;
            g.fillPolygon(xpointsZeroB4, ypointsZeroB4, npointsZeroB4);
            int xpointsOneA4[] = {402, 402, 392};
            int ypointsOneA4[] = {330, 320, 330};
            int npointsOneA4 = 3;
            g.fillPolygon(xpointsOneA4, ypointsOneA4, npointsOneA4);
            int xpointsOneB4[] = {290, 285, 295};
            int ypointsOneB4[] = {505, 490, 490};
            int npointsOneB4 = 3;
            g.fillPolygon(xpointsOneB4, ypointsOneB4, npointsOneB4);
            int xpointsTwoA4[] = {550, 537, 537};
            int ypointsTwoA4[] = {340, 335, 345};
            int npointsTwoA4 = 3;
            g.fillPolygon(xpointsTwoA4, ypointsTwoA4, npointsTwoA4);
            int xpointsTwoB4[] = {330, 330, 340};
            int ypointsTwoB4[] = {345, 355, 345};
            int npointsTwoB4 = 3;
            g.fillPolygon(xpointsTwoB4, ypointsTwoB4, npointsTwoB4);
            int xpointsThree4[] = {320, 330, 337};
            int ypointsThree4[] = {515, 503, 510};
            int npointsThree4 = 3;
            g.fillPolygon(xpointsThree4, ypointsThree4, npointsThree4);
            int xpointsFour4[] = {270, 275, 265};
            int ypointsFour4[] = {573, 587, 587};
            int npointsFour4 = 3;
            g.fillPolygon(xpointsFour4, ypointsFour4, npointsFour4);

            break;
        }

    }

    //accessor and mutator methods
    
    public void setState(int st)
    {
        this.state = st; 
    }

    public int getState()
    {
        return state;
    }
    
    public void setDone(boolean d)
    {
        this.done = d; 
    }

    public boolean getDone()
    {
        return done;
    }
}

