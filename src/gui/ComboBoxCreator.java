package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JComboBox;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;
import unit.MyUnit;
import unit.MyUnits;

@SuppressWarnings("serial")
public class ComboBoxCreator extends JComboBox<String> //should be an object with a string and a key --> string: Kilometer and the key: km for searching the correct reference
{
	public ComboBoxCreator()
	{
		createComoBox();
	}
	
	private void createComoBox()
	{		
		for(MyUnit unit : getXmlUnitList().getUnitList())
			addItem(unit.getUnitLabel());
		
//		addItem("Metttter");
//		addItem("MiliMettter");
//		addItem("Ellenlänge");
		setEnabled(true);
	}
	
	private MyUnits getXmlUnitList()
	{
		MyUnits lengthUnits = null;
		try 
		{
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(new File(Launcher.SCHEMA_LOC+Launcher.SCHEMA1_NAME));
			lengthUnits = (MyUnits)Factory.loadInstance(new FileInputStream(Launcher.OBJECTS_LOC+Launcher.OBJECT_NAME), schema, MyUnits.class);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("! File not found ! "+e.getMessage());
		} 
		catch (JAXBException e) 
		{
			System.out.println(e.getCause());
			System.out.println("! JAXB Exception ! "+e.getMessage());
		} 
		catch (SAXException e) 
		{
			System.out.println("! SAX Exception ! "+e.getMessage());
		}

		
		return lengthUnits;
		
//		if(lengthUnits != null)
//		{
//			for(MyUnit el : lengthUnits.getUnitList())
//			{
//				System.out.println("--------------------------------------------------------------------------");
//				System.out.println(Launcher.DEF_LANG+": ["+el.getUnitLabel()+"] "+el.getUnitName(Launcher.DEF_LANG)+" - "+el.getDescription(Launcher.DEF_LANG));
//				System.out.println("--------------------------------------------------------------------------");
//			}
//		}
	}
}