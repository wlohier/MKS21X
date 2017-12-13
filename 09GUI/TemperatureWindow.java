import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureWindow extends JFrame, implements ActionListener{
    public TemperatureWindow(){
	this.setTitle("Celcius and Fahrenheit converter");
	this.setSize(600, 100);
	this.setLocation(100, 100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new SpringLayout());
	
	F = new JTextField(6);
	C = new JTextField(6);
	b = new JButton(
	pane.add(F);
	pane.add(C);
    }

    public static void main(String[] args){
	TemperatureWindow t = new TemperatureWindow();
	t.setVisible(true);
    }
}
