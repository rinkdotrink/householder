package de.excel;

import java.util.Arrays;

public class Householder {

	public Double[][] a;
	
	public Double[][] r;
	public Double[][] out;
	public Double[][] ak;
	public Double[] rho;
	double rhoK = 0.0;
	double s = 0.0;
	
	
	int zeilenAnzahlM;
	int spaltenAnzahlN;
	int iterationenAnzahlL;
	boolean bedingungRhoN;
	
	
	public Householder(Double[][] a){
		zeilenAnzahlM = a.length;
		spaltenAnzahlN = a[0].length;
		this.a = new Double[zeilenAnzahlM][spaltenAnzahlN];
		this.ak = new Double[zeilenAnzahlM][spaltenAnzahlN]; 
		this.out = new Double[zeilenAnzahlM][spaltenAnzahlN];
		this.rho = new Double[zeilenAnzahlM];
		this.r = new Double[zeilenAnzahlM][spaltenAnzahlN];
		this.a = a;
		
		
	}
	
	public Householder(Double[][] r_out, boolean out){
		r = new Double[zeilenAnzahlM][spaltenAnzahlN];
		r = r_out;
	}
	
	public void compute(){
		
		iterationenAnzahlL = Math.min(zeilenAnzahlM-1, spaltenAnzahlN);
		bedingungRhoN = iterationenAnzahlL < spaltenAnzahlN;
			
		iterate();
		belegeR();
						
		ausgabe();
	
	}
	
	
	private void ausgabe() {
		for(int i_ = 0; i_ < zeilenAnzahlM; i_++){
			for(int j_ = 0; j_ < spaltenAnzahlN; j_++){
				System.out.print(r[i_][j_] + " ");
			}
			System.out.println(" ");
			
		}
		
	}

	public void iterate(){
		for(int iteration = 0; iteration < iterationenAnzahlL; iteration++){
		
			double beta = 0.0;		
			int k = iteration;
			int j = 0;
		
				for(int i = iteration; i < zeilenAnzahlM; i++){
					beta += (a[i][k]*a[i][k]);
				}
			rhoK = Math.sqrt(beta);
		// 15				
			if(a[k][k] > 0){
				rhoK = rhoK * -1.0;
			}
			rho[iteration] = rhoK;  
		
		
		// 4
		   a[k][k] = 1 - (a[k][k] / rhoK);
			
		// 6
		   		for(int i = iteration + 1; i < zeilenAnzahlM; i++){
		   			a[i][k] = -(a[i][k] / rhoK);
		   		}
		
		// für j = k + 1..n
		//s2
		  
		   	s = 0.0;
		    j = k + 1;
		    
		    // 8
		
		   		for(int i = iteration; i < zeilenAnzahlM; i++){
		   			s += a[i][k] * a[i][j];
		   		}
		   	// 9
		   	s = s / a[k][k];  
		
		
		// für i = k..m
		   	// 11
				for(int i = iteration; i < zeilenAnzahlM; i++){
					a[i][j] = a[i][j] - (s * a[i][k]);
				
				}
		
		// das entfällt in der letzten Iteration
				
		
		if(iteration < iterationenAnzahlL -1){
			
					
						s = 0.0;
						j++;
						
						for(int i = iteration; i < zeilenAnzahlM; i++){
							s += a[i][k] * a[i][j];
						}
						
						s = s / a[k][k];  // 1,5
						System.out.println("s3: " + s);
						
						for(int i = iteration; i < zeilenAnzahlM; i++){
							a[i][j] = a[i][j] - (s * a[i][k]);
						}		
				
		}
		    	
		for(int i_ = 0; i_ < zeilenAnzahlM; i_++){
			for(int j_ = 0; j_ < spaltenAnzahlN; j_++){
					System.out.print(a[i_][j_] + " ");
					}
					System.out.println(" ");
					
				}
				
		System.out.println("");		
		
		
		}
		}
	
	public void belegeR(){
		
rho[iterationenAnzahlL] = a[zeilenAnzahlM-1][spaltenAnzahlN-1];
		
		System.out.println("Ende2");
		for(int i_ = 0; i_ < zeilenAnzahlM; i_++){
			for(int j_ = 0; j_ < spaltenAnzahlN; j_++){
				
				if(i_==j_){
					r[i_][j_] = rho[i_];
					
				}
				if(j_>i_){
					r[i_][j_] = a[i_][j_];
				}
				if(j_<i_){
					r[i_][j_] = 0.0;
				}
				
			}
			System.out.println(" ");
			
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(r);
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
		if (!Arrays.deepEquals(r, other.r))
			return false;
		return true;
	}
	


}
