package gui;

import java.io.File;
import java.util.Locale;

import javax.swing.JFrame;

import unit.MyUnits;

public class Launcher 
{
	private static final int WIDTH = 500, HEIGHT = 100;
	
	//Unix+Linux
	public static final String SCHEMA_LOC = "."+File.separator+"schemas"+File.separator;
	public static final String OBJECTS_LOC = "."+File.separator+"objects"+File.separator;
	//Windows
//	public static final String SCHEMA_LOC = "";
//	public static final String OBJECTS_LOC = "";
	
	public static final String OBJECT_NAME = "out.xml";
	public static final String SCHEMA_NAME = "schema";
	public static final String SCHEMA1_NAME = SCHEMA_NAME+"1.xsd";
	public static final String SCHEMA2_NAME = SCHEMA_NAME+"2.xsd";
	
	public static final String DEF_LANG = Locale.getDefault().getLanguage();
	
	public static MyUnits unitList;
	
	public static void main(String[] args)
	{
		unitList = new MyUnits();
		
		//first read file(xml) unmarshal and fill the arraylist with units ;)
		
		ConverterFrame cF = new ConverterFrame();
		cF.setSize(WIDTH, HEIGHT);
		cF.setTitle("Converter");
		cF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cF.setVisible(true);
	}
}