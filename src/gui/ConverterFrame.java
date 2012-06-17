package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;

import unit.MyUnit;

public class ConverterFrame extends JFrame 
{
	private JComboBox<String> firstUnit,secondUnit;
	private JTextField inputField,outputField,infoField;
	private double input;

	public ConverterFrame()
	{
		input = 0;
		this.setLayout(new BorderLayout());
		JPanel layoutPanel = new JPanel();
		layoutPanel.setLayout(new GridLayout());

		firstUnit = new JComboBox<String>();
		secondUnit = new JComboBox<String>();

		inputField = new JTextField("input a number");
		inputField.addKeyListener(new KeyListener() 
		{
			@Override
			public void keyTyped(KeyEvent arg0) 
			{	
				try 
				{
					input = Double.parseDouble(inputField.getText());
				}
				catch(NumberFormatException e)
				{
					System.out.println(e.getMessage()+" "+ e.getCause());
					input = 0;
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyPressed(KeyEvent arg0) {}
		});

		outputField = new JTextField("output");
		outputField.setEditable(false);

		JButton submit = new JButton("Calculate");
		submit.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				MyUnit unit1 = null, unit2 = null;
				for(MyUnit u : Launcher.unitList.getUnitList())
				{
					if(u.getUnitLabel() == firstUnit.getSelectedItem().toString())
					{
						unit1 = u;
					}
					if(u.getUnitLabel() == secondUnit.getSelectedItem().toString())
					{
						unit2 = u;
					}
				}
				input = Double.parseDouble(inputField.getText());
				outputField.setText(String.valueOf((unit1.getFactorTo(unit2)*input)));
			}
		});

		layoutPanel.add(firstUnit);
		layoutPanel.add(inputField);
		layoutPanel.add(secondUnit);
		layoutPanel.add(outputField);
		layoutPanel.add(submit);
		
		
		infoField = new JTextField("Welcome");

		this.add(layoutPanel,BorderLayout.NORTH);
		this.add(infoField, BorderLayout.CENTER);
		
		frontViewerFrame();
	}

	private void frontViewerFrame()
	{
		setJMenuBar(new MenuView(firstUnit,secondUnit,this));
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
	
	public JTextField getInfoField()
	{
		return infoField;
	}
}
