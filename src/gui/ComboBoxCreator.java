package gui;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class ComboBoxCreator extends JComboBox<String> //should be an object with a string and a key --> string: Kilometer and the key: km for searching the correct reference
{
	public ComboBoxCreator()
	{
		createComoBox();
	}
	
	private void createComoBox()
	{
		
		addItem("Metttter");
		addItem("MiliMettter");
		addItem("Ellenlänge");
		setEnabled(true);
	}
}