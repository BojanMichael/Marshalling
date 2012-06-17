package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuView extends JMenuBar
{	
	private JMenu jMenu = new JMenu();
	
	public MenuView()
	{
		addMenuItems();
	}
	
	private void addMenuItems()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenu edit = new JMenu("Edit");
		JMenuItem open, exit, exportXmlFile, exportSchema;
		
		//add JMenus to the menu bar
		menuBar.add(file);
		menuBar.add(edit);
		
		//add default menu items
		open = new JMenuItem("Open");		
		
		exit = new JMenuItem("Exit");
		exit.setMnemonic('E');
		exit.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
		exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				System.exit(0);
			}
			
		});		
		
		//add default menu items to the file menu
		file.setMnemonic('F');
		file.add(open);
		file.add(exit);
		
		
		// prepare edit links
		exportSchema = new JMenuItem("Export a XML - Schema");
		exportSchema.setMnemonic('S');
		exportSchema.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		exportSchema.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// implement the export method
			}
			
		});
		
		exportXmlFile = new JMenuItem("Export a XML - File");
		exportXmlFile.setMnemonic('X');
		exportXmlFile.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
		exportXmlFile.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// implement the export method
			}
			
		});
		
		
		// add links to edit
		edit.add(exportXmlFile);
		edit.add(exportSchema);
				
		
		
		
		add(menuBar);
	}
}
