package gui;

import javax.swing.JComboBox;
import unit.MyUnit;
import unit.MyUnits;

@SuppressWarnings("serial")
public class JComboBoxUnit extends JComboBox<ComboBoxElements> //should be an object with a string and a key --> string: Kilometer and the key: km for searching the correct reference
{
	public JComboBoxUnit(MyUnits unitList)
	{
		createComboBox(unitList);
	}
	
	public JComboBoxUnit()
	{
		// default file laden
	}
	
	private boolean createComboBox(MyUnits unitList)
	{
		try
		{
			for(MyUnit unit : unitList.getUnitList())
				addItem(new ComboBoxElements(unit.getUnitLabel(), unit.getUnitName(Launcher.DEF_LANG), true));
			
			setEnabled(true);
			return true;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
		
		setEnabled(false);
		return false;		
	}
	
	public boolean restructure(MyUnits unitList)
	{
		removeAllItems();		
		return createComboBox(unitList);
	}
	
	@Override
	public Object getSelectedItem()
	{
		ComboBoxElements element = (ComboBoxElements) super.getSelectedItem();
		
		if(element != null)
			return element.getElement();
		
		return "";		
	}
	
}