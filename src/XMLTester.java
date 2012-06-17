import gui.Launcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

import javax.swing.DefaultBoundedRangeModel;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import language.LanguageHandler;
import org.junit.Test;
import org.xml.sax.SAXException;
import unit.MyUnit;
import unit.MyUnits;


public class XMLTester 
{
	@Test
	public void unmarshal() 
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

		if(lengthUnits != null)
		{
			for(MyUnit el : lengthUnits.getUnitList())
			{
				System.out.println("--------------------------------------------------------------------------");
				System.out.println(Launcher.DEF_LANG+": ["+el.getUnitLabel()+"] "+el.getUnitName(Launcher.DEF_LANG)+" - "+el.getDescription(Launcher.DEF_LANG));
				System.out.println("--------------------------------------------------------------------------");
			}
		}
	}

//	@Test
	public void marshal() 
	{

		String lg = Locale.getDefault().getLanguage();

		// Length Unit
		MyUnits lengthUnits = new MyUnits();		
		lengthUnits.add(new MyUnit("km", 1000, false, new LanguageHandler[]{new LanguageHandler("de", "Kilometer", "Es sind Kilometer"), new LanguageHandler("en", "kilometer", "1000 times a meter")}));
		lengthUnits.add(new MyUnit("m", 1, true,  new LanguageHandler[]{new LanguageHandler("de", "Meter", "Ein Meter ist knapp die Hälfte einer Körperkrösse"), new LanguageHandler("en", "meter", "Meters are not Inches")}));

		FileOutputStream fOS = null;
		try 
		{
			fOS = new FileOutputStream(Launcher.OBJECTS_LOC+Launcher.OBJECT_NAME);
		}
		catch (FileNotFoundException e1) 
		{
			System.out.println(e1.getMessage());
			e1.printStackTrace();
		}

		try 
		{
			Factory.saveInstance(fOS, lengthUnits);
		} 
		catch (JAXBException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		// tests, if the length unit is working
		for(MyUnit unit : lengthUnits.getUnitList())
		{
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Name in " + lg + "\t\t" + unit.getUnitName(lg));
			System.out.println("Description in " + lg + "\t" + unit.getDescription(lg));
			System.out.println("--------------------------------------------------------------------------");
		}
	}

//	@Test
	public void saveSchema()
	{		
		File fOS = null;
		fOS = new File(Launcher.SCHEMA_LOC);

		try 
		{
			Factory.saveSchema(fOS, MyUnits.class);
		} 
		catch (JAXBException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
