import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/* Homework 8 applet calculator
 * Mariem Haj Belgacem
 */
public class calc extends JApplet implements ActionListener {
	
	//Variables
	public static final int WIDTH = 900;
	public static final int HEIGHT = 500;
	public static final int NUMBER_OF_DIGITS = 30;
	
	private JTextField disp;
	private JTextField dispResult;
	Font reset = new Font("Serif", Font.BOLD, 12);
	Font clear = new Font("Serif", Font.BOLD, 12);
	String operand = "";
	String result = "";
	String checkEqual="";
	double oprd;
	double rslt;
	double answ;
	public static final double min = -0.00004539992;
	public static final double max = 0.00004539992;
	
	public void init() {	

		//Container
		Container contentP = getContentPane();
		contentP.setLayout(new BorderLayout());

		//Calculator's JPanel for operand and result
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout());
		disp = new JTextField("", NUMBER_OF_DIGITS);
		disp.setBackground(Color.WHITE);
		textPanel.add(disp);
		contentP.add(textPanel, BorderLayout.NORTH);
		textPanel.setLayout(new GridLayout());
		dispResult = new JTextField("0", NUMBER_OF_DIGITS);
		dispResult.setBackground(Color.WHITE);
		textPanel.add(dispResult);
		contentP.add(textPanel, BorderLayout.NORTH);
		
		//create a button pannel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setLayout(new GridLayout(5, 3, 8, 8));
        //calc buttons
		JButton divButton = new JButton("/");
		divButton.addActionListener(this);
		buttonPanel.add(divButton);
		
		JButton nineButton = new JButton("9");
		nineButton.addActionListener(this);
		buttonPanel.add(nineButton);
		
		JButton eightButton = new JButton("8");
		eightButton.addActionListener(this);
		buttonPanel.add(eightButton);
		
		JButton sevenButton = new JButton("7");
		sevenButton.addActionListener(this);
		buttonPanel.add(sevenButton);
		
		JButton multButton = new JButton("*");
		multButton.addActionListener(this);
		buttonPanel.add(multButton);
		
		JButton sixButton = new JButton("6");
		sixButton.addActionListener(this);
		buttonPanel.add(sixButton);
		
		JButton fiveButton = new JButton("5");
		fiveButton.addActionListener(this);
		buttonPanel.add(fiveButton);
		
		JButton fourButton = new JButton("4");
		fourButton.addActionListener(this);
		buttonPanel.add(fourButton);
		
		JButton subtractButton = new JButton("-");
		subtractButton.addActionListener(this);
		buttonPanel.add(subtractButton);

		JButton threeButton = new JButton("3");
		threeButton.addActionListener(this);
		buttonPanel.add(threeButton);
		
		JButton twoButton = new JButton("2");
		twoButton.addActionListener(this);
		buttonPanel.add(twoButton);
		
		JButton oneButton = new JButton("1");
		oneButton.addActionListener(this);
		buttonPanel.add(oneButton);
		
		JButton addButton = new JButton("+");
		addButton.addActionListener(this);
		buttonPanel.add(addButton);
		
		JButton decButton = new JButton(".");
		decButton.addActionListener(this);
		buttonPanel.add(decButton);
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		buttonPanel.add(clearButton);	
		clearButton.setFont(clear);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(this);
		buttonPanel.add(resetButton);	
		resetButton.setFont(reset);
		
		JButton zeroButton = new JButton("0");
		zeroButton.addActionListener(this);
		buttonPanel.add(zeroButton);
		
	
		
		contentP.add(buttonPanel, BorderLayout.CENTER);
	
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			assumingCorrectNumberFormats(e);
		} catch (NullPointerException e2) {
			disp.setText("Error: Reenter Number.");
		}
	}

	
	//set operand value
	public void assumingCorrectNumberFormats(ActionEvent e) throws NumberFormatException {
		String actionCommand = e.getActionCommand();
		
		if(actionCommand.equals("0")) {
			operand = operand + 0;
			disp.setText(operand);
		}else if(actionCommand.equals("1")) {
			operand = operand + 1;
			disp.setText(operand);
		}else if(actionCommand.equals("2")) {
			operand = operand + 2;
			disp.setText(operand);
		}else if(actionCommand.equals("3")) {
			operand = operand + 3;
			disp.setText(operand);
		}else if(actionCommand.equals("4")) {
			operand = operand + 4;
			disp.setText(operand);
		}else if(actionCommand.equals("5")) {
			operand = operand + 5;
			disp.setText(operand);
		}else if(actionCommand.equals("6")) {
			operand = operand +  6;
			disp.setText(operand);
		}else if(actionCommand.equals("7")) {
			operand = operand + 7;
			disp.setText(operand);
		}else if(actionCommand.equals("8")) {
			operand = operand + 8;
			disp.setText(operand);
		}else if(actionCommand.equals("9")) {
			operand = operand + 9;
			disp.setText(operand);
		}else if(actionCommand.equals(".")) {
			operand = operand + ".";
			disp.setText(operand);
		}else if (actionCommand.equals("+")) {	//addition
			checkEqual="+";
			oprd = Double.parseDouble(disp.getText());
			rslt = Double.parseDouble(dispResult.getText());
			answ =  oprd + rslt;
			dispResult.setText(Double.toString(answ));
			operand = "";
			disp.setText("");
		}else if (actionCommand.equals("-")) {	//subtraction
			checkEqual="-";
			oprd = Double.parseDouble(disp.getText());
			rslt = Double.parseDouble(dispResult.getText());
			answ = oprd - rslt;
			dispResult.setText(Double.toString(answ));
			operand = "";
			disp.setText("");			
		}else if (actionCommand.equals("*")) {	//multiplication
			checkEqual="*";
			oprd = Double.parseDouble(disp.getText());
			rslt = Double.parseDouble(dispResult.getText());
			answ = oprd * rslt;
			dispResult.setText(Double.toString(answ));
			operand = "";
			disp.setText("");
		}else if (actionCommand.equals("/")) {	//division 
			checkEqual="/";
			try {
				if(rslt >= min || rslt <= max){
					oprd = Double.parseDouble(disp.getText());
					rslt = Double.parseDouble(dispResult.getText());
					rslt = oprd / rslt;
					dispResult.setText(Double.toString(answ));
					operand = "";
					disp.setText("");
				}else if (rslt <= min || rslt >= max)
					throw new DivisionByZeroException();
			}catch(DivisionByZeroException e3) {	// divide by zero exception
				disp.setText("Can't divide by zero.");
			}
		}
		else if (actionCommand.equals("Clear")) {	//clear 
			operand = "";
			disp.setText(operand);
		}else if (actionCommand.equals("Reset")) {	//reset
			dispResult.setText("0.0");
			
		
			
		}else
			disp.setText("Unexpected error.");	//throws NumberFormatException 
	}

	
	// Throws NumberFormatException.
	private static double stringToDouble(String stringObject) {
		return Double.parseDouble(stringObject.trim());
	}

}

