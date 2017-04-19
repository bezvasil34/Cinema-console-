package com.edu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

public class Department implements  Serializable{

	private String nameOfDepartment;
	private List<Doctor> doctors;

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(String nameOfDepartment) {
		super();
		this.nameOfDepartment = nameOfDepartment;

	}

	public String getNameOfDepartment() {
		return nameOfDepartment;
	}

	public void setNameOfDepartment(String nameOfDepartment) {
		this.nameOfDepartment = nameOfDepartment;
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}

	@Override
	public String toString() {
		return "Відділення:" + nameOfDepartment + ", Лікарі: " + doctors + "]";
	}

	static List<Department> departments = new ArrayList<Department>();


	public static void addDep(){

		String n =JOptionPane.showInputDialog("Введіть назву відділення:");
		departments.add(new Department(n));
		
		String fileName = "department.out";
		FileOutputStream fos;
		ObjectOutputStream oos;

		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(departments);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void delDep() {
		FileInputStream fis;
		ObjectInputStream oin;

		try {
			fis = new FileInputStream("department.out");

			oin = new ObjectInputStream(fis);

			departments = (ArrayList<Department>) oin.readObject();

		
		Iterator<Department> iterator = departments.iterator();
		String n =JOptionPane.showInputDialog("Введіть назву відділення для видалення:");
		while (iterator.hasNext()) {
			Department department = iterator.next();
		
			
			if (department.getNameOfDepartment().equals(n)) {
				iterator.remove();
				JOptionPane.showMessageDialog(null, "Відділення видалено");
				break;
			}else if (!department.getNameOfDepartment().equals(n)) {
				JOptionPane.showMessageDialog(null, "Немає такого відділення");
			}
		}
		String fileName = "department.out";
		FileOutputStream fos;
		ObjectOutputStream oos;

		fos = new FileOutputStream(fileName);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(departments);

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public static void allDep() {
		
		String fileName = "department.out";
		FileOutputStream fos;
		ObjectOutputStream oos;
try{
		fos = new FileOutputStream(fileName);
		oos = new ObjectOutputStream(fos);
		oos.writeObject(departments);
		JOptionPane.showMessageDialog(null, departments);
}catch(Exception e){
	
}

	}

	static List<Doctor> doctors2 = new ArrayList<Doctor>();
	public static void addDocToDep() {
	String d= JOptionPane.showInputDialog("В яке відділення добавити лікаря");
	for (Department department : departments) {
		if (department.nameOfDepartment.equalsIgnoreCase(d)) {
		
			String n = JOptionPane.showInputDialog("Введіть імя лікаря: ");
			String s = JOptionPane.showInputDialog("Введіть прізвище лікаря: ");
			String p = JOptionPane.showInputDialog("Введіть посаду лікаря: ");
			doctors2.add(new Doctor(s, n, p));
			department.setDoctors(doctors2);
		
			
		}
	}
	}
	}


