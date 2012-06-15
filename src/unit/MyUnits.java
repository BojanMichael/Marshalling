package unit;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement(namespace = "http://ch.fbi.xml.beispielEins")
@XmlAccessorType(XmlAccessType.FIELD)
public class MyUnits extends ArrayList<MyUnit>
{	
	@Override
	public boolean add(MyUnit myUnit)
	{
		try
		{
			super.add((MyUnit)myUnit);
			return true;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return false;
		}		
	}
}
