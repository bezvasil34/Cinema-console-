package com.edu;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

public class Pacient extends Person implements Serializable {

	private String dayOfBitrh;

	private static final long serialVersionUID = 5489035356292105533L;

	public Pacient() {
		// TODO Auto-generated constructor stub
	}

	public Pacient(String surname, String name, String dayOfBitrh) {
		super(surname, name);
		this.dayOfBitrh = dayOfBitrh;
	}

	public String getDayOfBitrh() {
		return dayOfBitrh;
	}

	public void setDayOfBitrh(String dayOfBitrh) {
		this.dayOfBitrh = dayOfBitrh;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dayOfBitrh == null) ? 0 : dayOfBitrh.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacient other = (Pacient) obj;
		if (dayOfBitrh == null) {
			if (other.dayOfBitrh != null)
				return false;
		} else if (!dayOfBitrh.equals(other.dayOfBitrh))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Пацієнт : Прізвище:" + surname + ", імя :" + name + ", дата народження:" + dayOfBitrh + "]";
	}

	static List<Pacient> pacients = new ArrayList<Pacient>();

	public static void addPacient() {

		String n = JOptionPane.showInputDialog("Введіть імя пацієнта: ");
		String s = JOptionPane.showInputDialog("Введіть прізвище пацієнта: ");
		String d = JOptionPane.showInputDialog("Введіть дату народження пацієнта: ");
		pacients.add(new Pacient(s, n, d));

		String fileName = "pacient.out";
		FileOutputStream fos;
		ObjectOutputStream oos;

		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(pacients);

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void delPacient() {
		FileInputStream fis;
		ObjectInputStream oin;

		try {
			fis = new FileInputStream("pacient.out");
			oin = new ObjectInputStream(fis);

			pacients = (ArrayList<Pacient>) oin.readObject();

			Iterator<Pacient> iterator = pacients.iterator();
			String s = JOptionPane.showInputDialog("Введіть прізвище пацієнта для видалення:");
			String n = JOptionPane.showInputDialog("Введіть імя пацієнта для видалення:");
			String d = JOptionPane.showInputDialog("Введіть дату народження пацієнта для видалення:");
			while (iterator.hasNext()) {
				Pacient pacient = iterator.next();
				if (pacient.surname.equals(s) && pacient.name.equals(n) && pacient.getDayOfBitrh().equals(d)) {
					iterator.remove();
				
					JOptionPane.showMessageDialog(null, "Пацієнта видалено з бази");
				
				} else if (!pacient.surname.equals(s) && pacient.name.equals(n) && pacient.getDayOfBitrh().equals(d)) {
				
					JOptionPane.showMessageDialog(null, "Немає такого пацієнта");
				}
			}

			String fileName = "pacient.out";
			FileOutputStream fos;
			ObjectOutputStream oos;

			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(pacients);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void allPacients() {
		FileInputStream fis;
		ObjectInputStream oin;

		try {
			fis = new FileInputStream("pacient.out");
			oin = new ObjectInputStream(fis);

			pacients = (ArrayList<Pacient>) oin.readObject();

			JOptionPane.showMessageDialog(null, pacients);
			// }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void writeToDoc() throws IOException {
		
		String fileName = "pacient.out";
		FileOutputStream fos;
		ObjectOutputStream oos;

		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(pacients);

	
		String fn = JOptionPane.showInputDialog("Введіть назву текстового файлу для запису пацієнтів");
		String flName = fn + ".txt";
		FileWriter fw = null;
		BufferedWriter bw = null;

		fw = new FileWriter(flName);
		bw = new BufferedWriter(fw);
		for (Pacient pacient : pacients) {
			bw.write(pacient.toString() + "\n");
		}
		bw.close();
		JOptionPane.showMessageDialog(null, "Записано в файл");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
