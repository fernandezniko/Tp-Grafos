package tpGrafos;

import segundaParte.GrafoNDNP;

public class GeneradoraPorProbabilidad extends Generador {
	
	/*ivate int cantNodos ;
	private int gradoMax ;
	private int gradoMin ;
	private int cantidadDeAristas ;
	*/
	
	private int cantNodos;
	private double probaParaArista;
	
	public GeneradoraPorProbabilidad(int cantNodos , double probaParaArista){
		
		super(cantNodos);
		this.cantNodos=cantNodos;
		this.probaParaArista=probaParaArista;
		//is.cantNodos = CantNodos ;
	}
	public void generar() {
		int cantAristas = 0;
		for(int i=0;i<cantNodos-1;i++) {
			
			for(int j=i+1;j<cantNodos;j++) {
				
				if(Math.random() < probaParaArista) {
					matriz.set(i, j, 1);
					cantAristas++ ;
				}
			}
		}
		int cantTotAristas = (cantNodos * (cantNodos-1))/2;
		MaxMinCa();
		double adyacenciaReal = Math.rint((cantAristas * 100) / cantTotAristas) ;
		GrafoNDNP grafo = new GrafoNDNP(matriz,cantNodos,cantidadDeAristas,gradoMax,gradoMin,adyacenciaReal);
		grafo.grabar();
	}
	
	

}