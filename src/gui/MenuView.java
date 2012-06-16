package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuView extends JMenu
{	
	public MenuView()
	{
		addMenuItems();
	}
	
	private void addMenuItems()
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu file;
		JMenuItem open, exit;
		
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
		file = new JMenu("File");
		file.setMnemonic('F');
		file.add(open);
		file.add(exit);
				
		
		//add JMenus to the menu bar
		menuBar.add(file);
		
	}
}
