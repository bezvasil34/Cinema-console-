package com.edu;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws IOException {

		Hospital h= new Hospital("Форма для реєстратури");
		h.setVisible(true);
		h.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		h.setSize(400,400);
		h.setResizable(false);
		h.setLocationRelativeTo(null);
		
	
		

		
	
	}

}

