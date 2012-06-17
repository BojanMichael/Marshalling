package gui;

import javax.swing.JComboBox;
import unit.MyUnit;
import unit.MyUnits;

@SuppressWarnings("serial")
public class JComboBoxUnit extends JComboBox<ComboBoxElements>
{
	public JComboBoxUnit()
	{
		restructure(Launcher.unitList);
	}

	private boolean createComboBox(MyUnits unitList)
	{
		try
		{
			for(MyUnit unit : unitList.getUnitList())
			{
				addItem(new ComboBoxElements(unit.getUnitLabel(), unit.getUnitName(Launcher.DEF_LANG), true));
			}

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

	public String getKey()
	{
		ComboBoxElements element = (ComboBoxElements)super.getSelectedItem();

		if(element != null)
			return element.getKey();

		return "";
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