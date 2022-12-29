import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener{

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10]; // for the number in the calculator
    JButton[] functionButtons = new JButton[9];

    // Let's create the buttons
    JButton addButton, subBotton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    //
    JPanel panel;
    Font myFont = new Font("Ink Free", Font.BOLD,30);

    double num1=0, num2=0, result=0;
    char operator;

    // Constructor
    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        // Function buttons
        addButton = new JButton("+");
        subBotton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        // Adding function buttons
        functionButtons[0] = addButton;
        functionButtons[1] = subBotton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        // Add action listener to each button
        for (int i =0; i<9; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        // Now let's work with the number buttons:
        for (int i =0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150, 430,100,50);
        clrButton.setBounds(250, 430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        // Adding buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subBotton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        Calculator calc = new Calculator();


    }

    // Adding functionality to our calculator
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i =0; i<10; i++){
            if (e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if (e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }

        if (e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText(""); // To clear
        }

        if (e.getSource() == subBotton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText(""); // To clear
        }

        if (e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText(""); // To clear
        }

        if (e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText(""); // To clear
        }

        if (e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());

            switch (operator){
                case '+':
                    result = num1+num2;
                    break;

                case '-':
                    result = num1-num2;
                    break;

                case '*':
                    result = num1*num2;
                    break;

                case '/':
                    result = num1/num2;
                    break;
            } // now let's update the value
            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clrButton){
            textField.setText(""); // this clears the screen
        }

        if (e.getSource() == delButton){
            String string = textField.getText();
            textField.setText("");

            for (int i=0; i<string.length()-1; i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }

        if (e.getSource() == negButton){
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }
}
