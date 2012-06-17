package gui;

import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.event.ListDataListener;

import unit.MyUnit;
import unit.MyUnits;

@SuppressWarnings("serial")
public class JComboBoxUnit extends JComboBox<ComboBoxElements> //should be an object with a string and a key --> string: Kilometer and the key: km for searching the correct reference
{
	public JComboBoxUnit(MyUnits unitList)
	{
		createComboBox(unitList.getUnitList());
	}
	
	public JComboBoxUnit()
	{
		
	}
	
	private boolean createComboBox(ArrayList<MyUnit> unitList)
	{
		try
		{
			for(MyUnit unit : unitList)
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
		return createComboBox(unitList.getUnitList());
	}
	
	@Override
	public Object getSelectedItem()
	{
		ComboBoxElements element = (ComboBoxElements) super.getSelectedItem();
		
		if(element != null)
			return element.getElement();
		else
			return null;
	}
	
	@Override
	public String getName() 
	{
		ComboBoxElements element = (ComboBoxElements) super.getSelectedItem();
		
		if(element != null)
			return element.getElement();
		else
			return null;
	}
	
}