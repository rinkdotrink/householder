package src.de.excel;

import java.util.Arrays;

public class Householder {

	public Double[][] a;
	public Double[] rho;
	double rhoK = 0.0;
	double s = 0.0;
	int zeilenAnzahlM;
	int spaltenAnzahlN;
	int iterationenAnzahlL;
	boolean bedingungRhoN;

	public Householder(Double[][] a) {
		zeilenAnzahlM = a.length;
		spaltenAnzahlN = a[0].length;
		this.rho = new Double[zeilenAnzahlM];
		this.a = a;
	}

	public void compute() {
		iterationenAnzahlL = Math.min(zeilenAnzahlM - 1, spaltenAnzahlN);
		bedingungRhoN = iterationenAnzahlL < spaltenAnzahlN;
		iterate();
		belegeR();
		
		Util.ausgabe(zeilenAnzahlM, spaltenAnzahlN, a);
	}


	public void iterate() {
		for (int iteration = 0; iteration < iterationenAnzahlL; iteration++) {
			
			int k = iteration;
			int j = 0;
			
			double beta = 0.0;
			for (int i = iteration; i < zeilenAnzahlM; i++) {
				beta += a[i][k] * a[i][k];
			}
			rhoK = Math.sqrt(beta);
			// 15
			if (a[k][k] > 0) {
				rhoK = -rhoK;
			}
			rho[iteration] = rhoK;
			// 4
			a[k][k] = 1 - (a[k][k] / rhoK);
			// 6
			for (int i = iteration + 1; i < zeilenAnzahlM; i++) {
				a[i][k] /= -rhoK;
			}
			// fï¿½r j = k + 1..n
			// s2
		//	j = k + 1;
			 for(j = k + 1; j < spaltenAnzahlN; j++){ // das kam hinzu
			s = 0.0;
			// 8
			summenProdukt(iteration, k, j);
			// 9
			s = s / a[k][k];
			// fï¿½r i = k..m
			// 11
			for (int i = iteration; i < zeilenAnzahlM; i++) {
				a[i][j] -= s * a[i][k];
			}
			// das entfällt in der letzten Iteration
		//	if (iteration < iterationenAnzahlL - 1) {
				if(j < spaltenAnzahlN-1){	
				
				s = 0.0;
				j++;
				summenProdukt(iteration, k, j);
				s = s / a[k][k]; // 1,5
				System.out.println("s3: " + s);
				for (int i = iteration; i < zeilenAnzahlM; i++) {
					a[i][j] -= s * a[i][k];
				}
			}
		}  // das kam hinzu
			Util.ausgabe(zeilenAnzahlM, spaltenAnzahlN, a);
		}
	}

	private void summenProdukt(int iteration, int k, int j) {
		for (int i = iteration; i < zeilenAnzahlM; i++) {
			s += a[i][k] * a[i][j];
		}
	}

	public void belegeR() {
		rho[iterationenAnzahlL] = a[zeilenAnzahlM - 1][spaltenAnzahlN - 1];
		System.out.println("Ausgabe");
		for (int i_ = 0; i_ < zeilenAnzahlM; i_++) {
			for (int j_ = 0; j_ < spaltenAnzahlN; j_++) {
				if (i_ == j_) {
					a[i_][j_] = rho[i_];
				}
				if (j_ > i_) {
					a[i_][j_] = a[i_][j_];
				}
				if (j_ < i_) {
					a[i_][j_] = 0.0;
				}
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(a);
		return result;

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Householder other = (Householder) obj;
		if(!myDeepEqual(a, other.a))
			return false;
		return true;
	}
	
	public boolean myDeepEqual(Double[][] d1, Double[][] d2) {
		boolean isEqual = true;
		for(int i = 0; i< d1.length;i++) {
			for (int j = 0; j < d1[0].length;j++) {
				isEqual = isEqual && Math.abs(d1[i][j] - d2[i][j]) < 0.1;
			}
		}
		return isEqual;
	}
}
