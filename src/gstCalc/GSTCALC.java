package gstCalc;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GSTCALC implements ActionListener{
    
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[25];
    JButton[] functionButton = new JButton[30];
    JButton addButton, subButton, mulButton, divButton,negButton,gstAddButton,gstSubButton,dollarButton;
    JButton decButton,equButton,delButton, clrButton;
    JPanel panel;
    JComboBox comboBox;
    
    Font myFont = new Font("Ink Free",Font.BOLD,50);
    
    double num1=0,num2=0,result=0;
    char operator;
    private static final double EXCHANGE_RATE = 0.012;
    
    
    GSTCALC(){
        
        frame = new JFrame("GSTCALC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,900);
        frame.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(50,30,800,100);
        textField.setFont(myFont);
        textField.setEditable(false);
        
        
        
        
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("CLR");
        negButton = new JButton("(-)");
        gstAddButton = new JButton("GST/+");
        gstSubButton = new JButton("GST/-");
        dollarButton = new JButton("$");
        
        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = decButton;
        functionButton[4] = equButton;
        functionButton[5] = delButton;
        functionButton[6] = clrButton;
        functionButton[7] = divButton;
        functionButton[8] = negButton;
        functionButton[9] = gstAddButton;
        functionButton[10] = gstSubButton;
        functionButton[11] = dollarButton;
        
        
        comboBox = new JComboBox();
        comboBox.addActionListener(this);
        comboBox.setFont(myFont);
        comboBox.setFocusable(false);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"5", "10", "15", "20", "25", "30", "35", "40", "45", "50"}));
        
        
        for(int i =0;i<12;i++) {
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
            
        }
        
        for (int i=0;i<10;i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            
        }
        
        negButton.setBounds(20,630,145,100);
        delButton.setBounds(200,630,145,100);
        clrButton.setBounds(400,630,145,100);
        gstAddButton.setBounds(20,740,200,100);
        
        int gap = 10; // Adjust the gap value as needed
        int xPosition = gstAddButton.getX() + gstAddButton.getWidth() + gap;
        gstSubButton.setBounds(xPosition,740,200,100);
        
        comboBox.setBounds(500, 740, 100, 40);
        
        int buttonGap = 600;
        int buttonWidth = 100;
        int dollarButtonX = addButton.getX() + addButton.getWidth() + buttonGap;
        
        
        dollarButton.addActionListener(this);
        dollarButton.setFont(myFont);
        dollarButton.setFocusable(false);
        dollarButton.setBounds(600,200,100,100);
        
        
        panel = new JPanel();
        panel.setBounds(10,200,500,400);
        panel.setLayout(new GridLayout(4,5,60,60));
        
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
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
        frame.add(gstAddButton);
        frame.add(gstSubButton);
        frame.add(comboBox);
        frame.add(dollarButton);
        

        frame.add(textField);
        frame.setVisible(true);
        
        
    }
    
    public static void main(String[] args) {
        
        GSTCALC gstcalc = new GSTCALC();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
        for (int i=0;i<10;i++) {
            if(e.getSource()==numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton) {
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton) {
            num1=Double.parseDouble(textField.getText());
            operator= '+';
            textField.setText("");
        }
        if(e.getSource() == subButton) {
            num1=Double.parseDouble(textField.getText());
            operator= '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton) {
            num1=Double.parseDouble(textField.getText());
            operator= '*';
            textField.setText("");
        }
        if(e.getSource() == divButton) {
            num1=Double.parseDouble(textField.getText());
            operator= '/';
            textField.setText("");
        }
        if(e.getSource()== equButton) {
            num2=Double.parseDouble(textField.getText());
            
            switch(operator) {
            case '+':
                result=num1+num2;
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
            
            
            }
            
            textField.setText(String.valueOf(result));
            num1=result;
		
		}
		if(e.getSource() == clrButton) {
			textField.setText("");
		}
		if(e.getSource() == delButton) {
			String s = textField.getText();
			textField.setText("");
			for(int i=0;i<s.length()-1;i++) {
				textField.setText(textField.getText()+s.charAt(i));
			}
		}
		if(e.getSource()== negButton) {
			double temp = Double.parseDouble(textField.getText());
			temp*=-1;
			textField.setText(String.valueOf(temp));
			
		}
		if(e.getSource()==gstAddButton) {
			String s1 = textField.getText();
			double originalAmount = Double.parseDouble(s1);
			double gstRate = Double.parseDouble((String) comboBox.getSelectedItem()) / 100;
		    double gstAmount = originalAmount * gstRate;
		    double totalAmount = originalAmount + gstAmount;
		    textField.setText(String.valueOf(totalAmount));
		}
		
		if(e.getSource()==gstSubButton) {
			String s2 = textField.getText();
			double originalAmount = Double.parseDouble(s2);
			double gstRate = Double.parseDouble((String) comboBox.getSelectedItem()) / 100;
		    double gstAmount = originalAmount * gstRate;
		    double totalAmount = originalAmount - gstAmount;
		    textField.setText(String.valueOf(totalAmount));
		}
		if(e.getSource() == dollarButton) {
			String s3 = textField.getText();
			double INRAmount = Double.parseDouble(s3); 
			double dollorAmount = INRAmount * EXCHANGE_RATE;
			textField.setText(String.valueOf(dollorAmount));
			
		}
		
		
	}

}
