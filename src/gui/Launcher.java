package gui;

import javax.swing.JFrame;

public class Launcher 
{
	private static final int WIDTH = 500, HEIGHT = 500;
	
	public static void main(String[] args) 
	{
		ConverterFrame cF = new ConverterFrame();
		cF.setSize(WIDTH, HEIGHT);
		cF.setTitle("Converter");
		cF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cF.setVisible(true);
	}
}