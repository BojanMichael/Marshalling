package xmlTools;

import gui.Launcher;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import language.LanguageHandler;
import org.xml.sax.SAXException;
import unit.MyUnit;
import unit.MyUnits;

public class MyUnitsMarshaller 
{
	public static MyUnits unmarshal(String filename) 
	{
		MyUnits lengthUnits = null;
		try 
		{
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(new File(Launcher.SCHEMA_LOC+Launcher.SCHEMA1_NAME));
			lengthUnits = (MyUnits)Factory.loadInstance(new FileInputStream(Launcher.OBJECTS_LOC+filename), schema, MyUnits.class);
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
	}

	public static void marshal(String filename) 
	{
		// Length Unit
		MyUnits lengthUnits = new MyUnits();		
		lengthUnits.add(new MyUnit("km", 1000, false, new LanguageHandler[]{new LanguageHandler("de", "Kilometer", "Es sind Kilometer"), new LanguageHandler("en", "kilometer", "1000 times a meter")}));
		lengthUnits.add(new MyUnit("m", 1, true,  new LanguageHandler[]{new LanguageHandler("de", "Meter", "Ein Meter ist knapp die Hälfte einer Körperkrösse"), new LanguageHandler("en", "meter", "Meters are not Inches")}));

		FileOutputStream fOS = null;
		try 
		{
			fOS = new FileOutputStream(Launcher.OBJECTS_LOC+filename);
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
			System.out.println("Name in " + Launcher.DEF_LANG + "\t\t" + unit.getUnitName(Launcher.DEF_LANG));
			System.out.println("Description in " + Launcher.DEF_LANG + "\t" + unit.getDescription(Launcher.DEF_LANG));
			System.out.println("--------------------------------------------------------------------------");
		}
	}

	public static void saveSchema()
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
