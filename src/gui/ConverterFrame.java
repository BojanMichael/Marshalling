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

public class ConverterFrame extends JFrame 
{
	public ConverterFrame()
	{
		frontViewerFrame();
		
//		this.setLayout(new BorderLayout());
//		JPanel layoutPanel = new JPanel();
//		layoutPanel.setLayout(new FlowLayout());
//		
//		JComboBox<String> firstUnit = new JComboBox<String>();
//		firstUnit.addItem("Metttter");
//		firstUnit.addItem("MiliMettter");
//		firstUnit.addItem("Ellenlänge");
//		firstUnit.setEditable(true);
////		firstUnit.addActionListener(listener);
//		
//
//		JComboBox<String> secondUnit = new JComboBox<String>();
//		secondUnit.addItem("Metttter");
//		secondUnit.addItem("MiliMettter");
//		secondUnit.addItem("Ellenlänge");
//		secondUnit.setEditable(true);
////		secondUnit.addActionListener(listener);
//		
//		JTextField inputField = new JTextField();
//		
//		JTextField outputField = new JTextField();
//		//outputField.setC // Set read only
//
//		layoutPanel.add(firstUnit);
//		layoutPanel.add(inputField);
//		layoutPanel.add(secondUnit);
//		layoutPanel.add(outputField);
//		
//		this.add(layoutPanel,BorderLayout.CENTER);
	}
	
	private void frontViewerFrame()
	{
		setJMenuBar(new MenuView());
		setLayout(new FlowLayout());
		
		//muess no di richtige paramter mitgä
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
