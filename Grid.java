import java.util.Arrays;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * This is a template for making a Game with a top text panel, middle grid game,
 * and bottom text panel.
 *
 */
public class Grid extends JFrame implements ActionListener {

  public int[] identity = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8}; 
  public int[] shuffledValues = shuffleArray(identity);
  Random rand = new Random();
    public static void main(String[] args) {
        new Grid();
    } // end main method 
       public static int[] shuffleArray(int[] array) {
        Random random = new Random();
        int[] shuffledArray = array.clone();
        
        for (int i = shuffledArray.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            
            int temp = shuffledArray[i];
            shuffledArray[i] = shuffledArray[j];
            shuffledArray[j] = temp;
        }
        
        return shuffledArray;
    }

    private JPanel topPanel, gamePanel, bottomPanel;
    private JLabel bottomLabel, topLabel;
    private JButton[] board;
    private Font f = new Font("SansSerif", Font.BOLD, 12);

    public Grid() {
        setSize(800, 400);

        //Panel to hold text, images, buttons etc. at top of window
        topPanel = new JPanel();
        topLabel = new JLabel("Top text");
        topLabel.setFont(f);
        topPanel.add(topLabel);
        this.add(topPanel, BorderLayout.NORTH); //add to frame, at "North" meaning top
        
        //Panel to hold the main game in the middle of the window
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(4, 4)); //To hold 4 by 4 buttons
        this.add(gamePanel, BorderLayout.CENTER);

        //Buttons to go on the middle panel
        board = new JButton[16]; //array of 9 buttons
        for (int i = 0; i < 16; i++) { //loop through all 16 buttons
            board[i] = new JButton(""); //make a new button with empty string
            board[i].addActionListener(this); //listen for button to be pressed
            board[i].setFont(f); //Font f is initialized above the constructor
            board[i].setBackground(Color.PINK); 
            gamePanel.add(board[i]); //add button to the board
          //add counter to this loop
          // add timer object so that the code knows that the user cannot flip more than two cards at a time
          //once the two cards are flipped, if(card1.parseInt)
        }

        //Bottom Panel to hold text, images, buttons, etc
        bottomPanel = new JPanel();
        bottomLabel = new JLabel("Put text here: "); //Label with text
        bottomLabel.setFont(f);
        bottomPanel.add(bottomLabel);
        this.add(bottomPanel, BorderLayout.WEST); //add to window at bottom

        setVisible(true); //make the window visible
        setDefaultCloseOperation(EXIT_ON_CLOSE); //close window when X is pressed
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 16; i++) {
            if (e.getSource() == board[i]) { //if button i is pressed
                board[i].setText("" + shuffledValues[i]);
              //use this method to store the last two numbers that have been clicked
              //if the two cards !=, then hide cards and store next two clicks
            }
        }
    }

}
//use counter variable to 
//if card1 and card2 have the same value
//both cards change into a different colour
//a score counter increases by 20
//the score is then add to a highscore.txt file