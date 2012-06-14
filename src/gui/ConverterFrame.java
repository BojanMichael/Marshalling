package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ConverterFrame extends JFrame 
{
	public ConverterFrame()
	{
		this.setLayout(new BorderLayout());
		JPanel layoutPanel = new JPanel();
		layoutPanel.setLayout(new FlowLayout());
		
		JComboBox<String> firstUnit = new JComboBox<String>();
		firstUnit.addItem("Metttter");
		firstUnit.addItem("MiliMettter");
		firstUnit.addItem("Ellenlänge");
		firstUnit.setEditable(true);
//		firstUnit.addActionListener(listener);
		

		
		JComboBox<String> secondUnit = new JComboBox<String>();
		secondUnit.addItem("Metttter");
		secondUnit.addItem("MiliMettter");
		secondUnit.addItem("Ellenlänge");
		secondUnit.setEditable(true);
//		secondUnit.addActionListener(listener);
		
		JTextField inputField = new JTextField();
		
		JTextField outputField = new JTextField();

		layoutPanel.add(firstUnit);
		layoutPanel.add(inputField);
		layoutPanel.add(secondUnit);
		layoutPanel.add(outputField);
		
		Insests i = new Insets(10,10,10,10);

		this.add(new JSeparator(), BorderLayout.NORTH);
		this.add(layoutPanel,BorderLayout.CENTER);
		
		
	}
}
