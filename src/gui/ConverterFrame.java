package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;

import unit.MyUnit;
import xmlTools.MyUnitsMarshaller;

public class ConverterFrame extends JFrame 
{
	private static final long serialVersionUID = 1970743664009863658L;
	private JComboBoxUnit firstUnit,secondUnit;
	private JTextField inputField,outputField,infoField;
	private double input;

	public ConverterFrame()
	{
		input = 0;
		this.setLayout(new BorderLayout());
		JPanel layoutPanel = new JPanel();
		layoutPanel.setLayout(new GridLayout());

		Launcher.unitList = MyUnitsMarshaller.unmarshal(Launcher.OBJECTS_LOC+Launcher.OBJECT_NAME);

		firstUnit = new JComboBoxUnit();
		secondUnit = new JComboBoxUnit();

		inputField = new JTextField("input a number");

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
					if(u.getUnitLabel() == firstUnit.getKey())
					{
						unit1 = u;
					}
					if(u.getUnitLabel() == secondUnit.getKey()) //.getSelectedItem().toString()
					{
						unit2 = u;
					}
				}
				
				try 
				{
					input = Double.parseDouble(inputField.getText());
				}
				catch(NumberFormatException ex)
				{
					System.out.println(ex.getMessage()+" "+ ex.getCause());
					input = 0;
				}
				outputField.setText(String.valueOf(Math.round(unit1.getFactorTo(unit2)*input*10000.0)/10000.0));
			}
		});

		layoutPanel.add(firstUnit);
		layoutPanel.add(inputField);
		layoutPanel.add(secondUnit);
		layoutPanel.add(outputField);
		layoutPanel.add(submit);


		infoField = new JTextField("Welcome to "+Launcher.APP_NAME);

		this.add(layoutPanel,BorderLayout.NORTH);
		this.add(infoField, BorderLayout.CENTER);

		setJMenuBar(new MenuView(firstUnit, secondUnit, this));
	}

	public JTextField getInfoField()
	{
		return infoField;
	}
}
