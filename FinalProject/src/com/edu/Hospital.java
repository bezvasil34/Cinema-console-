package com.edu;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Hospital extends JFrame {

	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11;

	eHandler handler= new eHandler();

	public Hospital(String s) {
		super(s);
		setLayout(new FlowLayout());
		b1 = new JButton("Додати відділення");
		b2 = new JButton("Видалити відд");
		b3 = new JButton("Показати всі відд");
		b4 = new JButton("Додати лікаря до відд");
		b5 = new JButton("Додати лікаря");
		b6 = new JButton("Видалити лікаря");
		b7 = new JButton("Показати всіх лікарів");
		b8 = new JButton("Додати пацієнта");
		b9 = new JButton("Видалити пацієнта");
		b10 = new JButton("Показати всіх пацієнтів");
		b11 = new JButton("Записати пацієнтів у файл");
		b1.setPreferredSize(new Dimension(180, 50));
		b2.setPreferredSize(new Dimension(180, 50));
		b3.setPreferredSize(new Dimension(180, 50));
		b4.setPreferredSize(new Dimension(180, 50));
		b5.setPreferredSize(new Dimension(180, 50));
		b6.setPreferredSize(new Dimension(180, 50));
		b7.setPreferredSize(new Dimension(180, 50));
		b8.setPreferredSize(new Dimension(180, 50));
		b9.setPreferredSize(new Dimension(180, 50));
		b10.setPreferredSize(new Dimension(180, 50));
		b11.setPreferredSize(new Dimension(180, 50));
		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);
		add(b8);
		add(b9);
		add(b10);
		add(b11);
		b1.addActionListener(handler);
		b2.addActionListener(handler);
		b3.addActionListener(handler);
		b4.addActionListener(handler);
		b5.addActionListener(handler);
		b6.addActionListener(handler);
		b7.addActionListener(handler);
		b8.addActionListener(handler);
		b9.addActionListener(handler);
		b10.addActionListener(handler);
		b11.addActionListener(handler);
		
		

	}

	public class eHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==b1) {
				Department.addDep();
			}if (e.getSource()==b2) {
				Department.delDep();
			}if (e.getSource()==b3) {
				Department.allDep();
			}if (e.getSource()==b4) {
				Department.addDocToDep();
			}if (e.getSource()==b5) {
				Doctor.addDoctor();
			}if (e.getSource()==b6) {
				Doctor.delDoctor();
			}if (e.getSource()==b7) {
				Doctor.allDoctors();
			}if (e.getSource()==b8) {
				Pacient.addPacient();
			}if (e.getSource()==b9) {
				Pacient.delPacient();
			}if (e.getSource()==b10) {
				Pacient.allPacients();
			}if (e.getSource()==b11) {
				try {
					Pacient.writeToDoc();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
			
		}
		
	}
}
