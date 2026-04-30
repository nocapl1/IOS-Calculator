import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Calculator {

    // Window dimension
    int windowWidth = 360;
    int windowHeight = 540;

    Color customLightGray = new Color(212, 212, 210);
    Color customDarkGray = new Color(80, 80, 80);
    Color customBlack = new Color(28, 28, 28);
    Color customOrange = new Color(255, 149, 0);

    // Arrays for calculator's button values
    // used to iterate through and make a button for each
    String[] buttonValues = {
            "AC", "+/-", "%", "÷",
            "7", "8", "9", "×", // note: x is multiplication symbol
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "0", ".", "√", "="
    };

    String[] rightSymbols = { "÷", "×", "-", "+", "=" };
    String[] topSymbols = { "AC", "+/-", "%" };

    JFrame frame = new JFrame("Calculator");
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    //Variables to keep track
    //A+B, A-B, A*B, A/B
    String A = "0";
    String operator = null;
    String B = null;

    // Constructor
    Calculator() {

        frame.setVisible(true);
        frame.setSize(windowWidth, windowHeight);
        frame.setLocationRelativeTo(null); // center window frame
        frame.setResizable(false); // avoids dragging
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        displayLabel.setBackground(customBlack);
        displayLabel.setForeground(Color.WHITE);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 80));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT); // Displays text to the right
        displayLabel.setText("0"); // default
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel, BorderLayout.NORTH); // Displays panel only to top portion of calculator

        // 5 rows, 4 columns according to array
        buttonsPanel.setLayout(new GridLayout(5, 4));
        buttonsPanel.setBackground(customBlack);
        frame.add(buttonsPanel);

        // Adding buttons, iteration loop
        for (int i = 0; i < buttonValues.length; i++) {
            JButton button = new JButton();
            String buttonValue = buttonValues[i];
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setText(buttonValue);
            button.setFocusable(false); // Buttons won't have rectangle box when cursor hovers & click
            button.setBorder(new LineBorder(customBlack));

            // Color distinction

            // If buttonValue array contains the symbol in topSymbols array
            if (Arrays.asList(topSymbols).contains(buttonValue)) {
                button.setBackground(customLightGray);
                button.setForeground(customBlack);

            }

            // If in rightSymbols
            else if (Arrays.asList(rightSymbols).contains(buttonValue)) {
                button.setBackground(customOrange);
                button.setForeground(Color.white);

            }

            // 0 to 9 or decimal or root sign
            else {
                button.setBackground(customDarkGray);
                button.setForeground(Color.white);
            }

            buttonsPanel.add(button);

            //Let button work
            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    JButton button = (JButton) e.getSource(); //get the source of the event

                    //Identify which button text was clicked & displayed
                    String buttonValue = button.getText();

                    if(Arrays.asList(rightSymbols).contains(buttonValue)){

                        if(buttonValue == "="){

                            //If we have value for A stored
                            if(A != null){
                                B = displayLabel.getText();
                                double numA = Double.parseDouble(A);
                                double numB = Double.parseDouble(B);

                                if(operator == "+"){
                                    displayLabel.setText(removeZeroDecimal(numA + numB));
                                }
                                else if(operator == "-"){
                                    displayLabel.setText(removeZeroDecimal(numA - numB));
                                }
                                else if(operator == "×"){
                                    displayLabel.setText(removeZeroDecimal(numA * numB));
                                }
                                else if(operator == "÷"){
                                    displayLabel.setText(removeZeroDecimal(numA / numB));
                                }
                                clearAll();

                            }
                        }

                        else if("+-×÷".contains(buttonValue)){

                            //Avoids clicking operator twice
                            if(operator == null){
                                A = displayLabel.getText();
                                displayLabel.setText("0");
                                B = "0";
                            }

                            //If not null, change the operator value
                            operator = buttonValue;
                        }
                    }
                    else if(Arrays.asList(topSymbols).contains(buttonValue)){

                        if(buttonValue == "AC"){
                            clearAll();
                            displayLabel.setText("0");
                        }

                        else if (buttonValue == "+/-"){

                            //Convert text into double
                            double numDisplay = Double.parseDouble(displayLabel.getText());
                            numDisplay *= -1; //turn into negative
                            displayLabel.setText(removeZeroDecimal(numDisplay));
                        }
                        else if (buttonValue == "%"){

                            double numDisplay = Double.parseDouble(displayLabel.getText());
                            numDisplay /= 100; 
                            displayLabel.setText(removeZeroDecimal(numDisplay));

                        }
                    }

                    //digits or .
                    else{

                        if(buttonValue == "."){
                            //If current display label doesn't have a '.'
                            if(!displayLabel.getText().contains(buttonValue)){
                                displayLabel.setText(displayLabel.getText() + buttonValue);

                            }
                        }
                        else if("0123456789".contains(buttonValue)){

                            //Overlap -- replace zero
                            if(displayLabel.getText() == "0"){
                                displayLabel.setText(buttonValue);
                            }

                            //if not 0, can add digit to ends
                            else{
                                displayLabel.setText(displayLabel.getText() + buttonValue);
                            }
                        }
                    }
                }
            });

        }
    }

    //Sets everything back to default
    void clearAll(){
        A = "0";
        operator = null;
        B = null;
    }

    String removeZeroDecimal(double numDisplay){

        //Whole number
        if(numDisplay % 1 == 0){
            return Integer.toString((int) numDisplay);
        }

        //Otherwise not whole
        return Double.toString(numDisplay);
    }
}
