package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import unit.MyUnit;
import xmlTools.MyUnitsMarshaller;

@SuppressWarnings("serial")
public class MenuView extends JMenuBar
{
	private JComboBoxUnit firstUnit,secondUnit;
	private ConverterFrame parent;
	public MenuView(JComboBoxUnit firstUnit, JComboBoxUnit secondUnit, ConverterFrame parent)
	{
		this.firstUnit = firstUnit;
		this.secondUnit = secondUnit;
		this.parent = parent;
		addMenuItems();
	}
	
	private void addMenuItems()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenuItem open, exit, exportXmlFile, exportSchema, importXmlFile;
		
		//add JMenus to the menu bar
		menuBar.add(file);
		menuBar.add(edit);
		
		//add default menu items
		open = new JMenuItem("Open");		
		
		exit = new JMenuItem("Exit");
		exit.setMnemonic('E');
		exit.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
		exit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}			
		});		
		
		//add default menu items to the file menu
		file.setMnemonic('F');
		file.add(open);
		file.addSeparator();
		file.add(exit);
		
		
		// prepare edit links
		exportSchema = new JMenuItem("Export a XML - Schema");
		exportSchema.setMnemonic('S');
		exportSchema.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		exportSchema.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				MyUnitsMarshaller.saveSchema();
				parent.getInfoField().setText("exported schema to "+Launcher.SCHEMA_LOC+Launcher.SCHEMA_NAME);
			}			
		});
		
		exportXmlFile = new JMenuItem("Export a XML - File");
		exportXmlFile.setMnemonic('X');
		exportXmlFile.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
		exportXmlFile.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				JFileChooser jFileChooser = new JFileChooser(new File(""));

				// Show save dialog
				int fileInt = jFileChooser.showOpenDialog(parent);
				File selFile = jFileChooser.getSelectedFile();
				
				MyUnitsMarshaller.marshal(selFile.toString());
				parent.getInfoField().setText("exported list to "+selFile.toString());
			}	
		});
		
		importXmlFile = new JMenuItem("Import a XML - File");
		importXmlFile.setMnemonic('I');
		importXmlFile.setAccelerator(KeyStroke.getKeyStroke("ctrl I"));
		importXmlFile.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				JFileChooser jFileChooser = new JFileChooser(new File(""));

				// Show save dialog
				int fileInt = jFileChooser.showOpenDialog(parent);
				File selFile = jFileChooser.getSelectedFile();

				Launcher.unitList = MyUnitsMarshaller.unmarshal(selFile.toString());
				
				firstUnit.restructure(Launcher.unitList);
				secondUnit.restructure(Launcher.unitList);
				
				parent.getInfoField().setText("importet from "+selFile.toString());
			}	
		});
		
		// add links to edit
		edit.add(exportXmlFile);
		edit.add(exportSchema);
		edit.addSeparator();
		edit.add(importXmlFile);
		
		add(menuBar);
	}
}
