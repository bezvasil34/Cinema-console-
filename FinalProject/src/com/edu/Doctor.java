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

public class Doctor extends Person implements Serializable {

	private String position;

	private static final long serialVersionUID = -5332983594682872319L;

	public Doctor(String surname, String name) {
		super(surname, name);

	}

	public Doctor(String surname, String name, String position) {
		super(surname, name);
		this.position = position;

	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((position == null) ? 0 : position.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Лікар: Прізвище: " + surname + ", імя: " + name + ", посада" + position + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		return true;
	}

	static List<Doctor> doctors = new ArrayList<Doctor>();

	public static void addDoctor() {

		String n = JOptionPane.showInputDialog("Введіть імя лікаря: ");
		String s = JOptionPane.showInputDialog("Введіть прізвище лікаря: ");
		String p = JOptionPane.showInputDialog("Введіть посаду лікаря: ");
		doctors.add(new Doctor(s, n, p));

		String fileName = "doctor.out";
		FileOutputStream fos;
		ObjectOutputStream oos;

		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(doctors);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void delDoctor() {

		FileInputStream fis;
		ObjectInputStream oin;

		try {
			fis = new FileInputStream("doctor.out");

			oin = new ObjectInputStream(fis);

			doctors = (ArrayList<Doctor>) oin.readObject();

			Iterator<Doctor> iterator = doctors.iterator();
			String s = JOptionPane.showInputDialog("Введіть прізвище лікаря для видалення: ");
			String n = JOptionPane.showInputDialog("Введіть імя лікаря для видалення: ");
			while (iterator.hasNext()) {
				Doctor doctor = iterator.next();
				if ((doctor.surname.equals(s)) && (doctor.name.equals(n))) {

					iterator.remove();

					JOptionPane.showMessageDialog(null, "Лікаря видалено з бази");
					break;
				} else if (!(doctor.surname.equals(s)) && (doctor.name.equals(n))) {

					JOptionPane.showMessageDialog(null, "Немає такого лікаря");

				}
			}
			String fileName = "doctor.out";
			FileOutputStream fos;
			ObjectOutputStream oos;

			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(doctors);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void allDoctors() {

		FileInputStream fis;
		ObjectInputStream oin;

		try {
			fis = new FileInputStream("doctor.out");

			oin = new ObjectInputStream(fis);

			doctors = (ArrayList<Doctor>) oin.readObject();

			JOptionPane.showMessageDialog(null, doctors);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
