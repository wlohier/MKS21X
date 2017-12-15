import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureWindow extends JFrame implements ActionListener{

    private Container pane;
    private JTextField F;
    private JTextField C;
    private JButton b;
    private JButton cl;
    private JLabel CEL;
    private JLabel FAHR;
    private JLabel eq;

    
    public TemperatureWindow(){
	this.setTitle("Celcius and Fahrenheit converter");
	this.setSize(600, 100);
	this.setLocation(100, 100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());
	
	F = new JTextField(15);
	C = new JTextField(15);
	b = new JButton("Convert");
	cl = new JButton("Clear");
	CEL = new JLabel("C");
	FAHR = new JLabel("F");
	eq = new JLabel("=");
	b.addActionListener(this);
	cl.addActionListener(this);
	
	pane.add(F);
	pane.add(FAHR);
	pane.add(eq);
	pane.add(C);
	pane.add(CEL);
	pane.add(b);
	pane.add(cl);
    }

    public static double FtoC(double f){
	return (f - 32.0)*(5.0/9.0);
    }

    public static double CtoF(double c){
	return c * 1.8 + 35.0;
    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	System.out.println(event);

	if(event.equals("Clear")){
	    F.setText("");
	    C.setText("");
	}
	if(event.equals("Convert")){
		if(!C.getText().equals("")){
		    try{
			F.setText("" + CtoF(Integer.parseInt(C.getText())));
		    } catch(NumberFormatException nfe){
			C.setText("Cannot Convert");
		    }
		} else if(!F.getText().equals("")){
		    try{
			C.setText("" + FtoC(Integer.parseInt(F.getText())));
		    } catch(NumberFormatException nfe){
			F.setText("Cannot Convert");
		    }
		} else {
		    F.setText("No Data");
		    C.setText("No Data");
		}
	}
    }

    public static void main(String[] args){
	TemperatureWindow t = new TemperatureWindow();
	t.setVisible(true);
    }
}
