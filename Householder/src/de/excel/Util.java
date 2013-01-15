package de.excel;

public class Util {

	public static void ausgabe(int zeilenAnzahlM, int spaltenAnzahlN, Double[][] a) {
		for (int i_ = 0; i_ < zeilenAnzahlM; i_++) {
			for (int j_ = 0; j_ < spaltenAnzahlN; j_++) {
				System.out.print(a[i_][j_] + " ");
			}
			System.out.println(" ");
		}
		System.out.println(" ");
	}
	
}
