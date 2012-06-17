package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import unit.MyUnits;

public class ConverterFrame extends JFrame 
{
	private JComboBox<String> firstUnit,secondUnit;
	
	public ConverterFrame()
	{
		this.setLayout(new BorderLayout());
		JPanel layoutPanel = new JPanel();
		layoutPanel.setLayout(new FlowLayout());
		
		firstUnit = new JComboBox<String>();
		firstUnit.addItem("Metttter");
		firstUnit.addItem("MiliMettter");
		firstUnit.addItem("Ellenlänge");
//		firstUnit.setEditable(true);
//		firstUnit.addActionListener(listener);
		

		secondUnit = new JComboBox<String>();
		secondUnit.addItem("Metttter");
		secondUnit.addItem("MiliMettter");
		secondUnit.addItem("Ellenlänge");
//		secondUnit.setEditable(true);
//		secondUnit.addActionListener(listener);
		
		JTextField inputField = new JTextField("input a number");
		
		JTextField outputField = new JTextField("output");
		outputField.setEditable(false);
		
		layoutPanel.add(firstUnit);
		layoutPanel.add(inputField);
		layoutPanel.add(secondUnit);
		layoutPanel.add(outputField);
		
		this.add(layoutPanel,BorderLayout.CENTER);
		
		frontViewerFrame();
	}
	
	private void frontViewerFrame()
	{
		setJMenuBar(new MenuView(firstUnit,secondUnit));
//		setLayout(new FlowLayout());
		
		//muess no di richtige paramter mitg�
		//add(new ComboBoxCreator());
		
		
//		setLayout(new FlowLayout());
//		//main panel
//		JPanel jPanelMain = new JPanel(new BorderLayout());
//		
//		//menupanel
//		jPanelMain.add(new MenuView().getComponent(), BorderLayout.NORTH);
//		jPanelMain.add(new JLabel("Testchen"), BorderLayout.CENTER);
//		
//		//add main panel to the gui
//		add(jPanelMain);
	}
}
