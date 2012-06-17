package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
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
		
		MenuView menu = new MenuView();
		
		JComboBox<String> firstUnit = new JComboBox<String>();
		firstUnit.addItem("Metttter");
		firstUnit.addItem("MiliMettter");
		firstUnit.addItem("Ellenlänge");
//		firstUnit.setEditable(false);
//		firstUnit.addActionListener(listener);
		

		JComboBox<String> secondUnit = new JComboBox<String>();
		secondUnit.addItem("Metttter");
		secondUnit.addItem("MiliMettter");
		secondUnit.addItem("Ellenlänge");
//		secondUnit.setEditable(true);
//		secondUnit.addActionListener(listener);
		
		JTextField inputField = new JTextField("input a number");
		
		JTextField outputField = new JTextField("output");
		outputField.setEditable(false);
		//outputField.setC // Set read only

		layoutPanel.add(firstUnit);
		layoutPanel.add(inputField);
		layoutPanel.add(secondUnit);
		layoutPanel.add(outputField);
		
		this.add(menu,BorderLayout.NORTH);
		this.add(layoutPanel,BorderLayout.CENTER);
	}
}
