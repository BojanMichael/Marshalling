package gui;

import javax.swing.JComboBox;

import unit.MyUnit;
import unit.MyUnits;

@SuppressWarnings("serial")
public class ComboBoxCreator extends JComboBox<String> //should be an object with a string and a key --> string: Kilometer and the key: km for searching the correct reference
{
	public ComboBoxCreator(MyUnits unitsList)
	{
		createComoBox(unitsList);
	}
	
	private void createComoBox(MyUnits unitsList)
	{		
		for(MyUnit unit : unitsList.getUnitList())
			addItem(unit.getUnitLabel());
		
//		addItem("Metttter");
//		addItem("MiliMettter");
//		addItem("Ellenlänge");
		setEnabled(true);
	}
}