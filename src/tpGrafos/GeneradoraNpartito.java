package tpGrafos;

import segundaParte.GrafoNDNP;

public class GeneradoraNpartito extends Generador {

	/*
	 * private int cantNodos ; private int gradoMax ; private int gradoMin ; private
	 * int cantidadDeAristas ;
	 */

	private int cantNodos;
	private int n;

	public GeneradoraNpartito(int cantNodos, int n) {

		super(cantNodos);
		this.cantNodos = cantNodos;
		this.n=n;
	}

	public void generar() {
		if (cantNodos % n != 0) {
			System.out.println("No se puede generar grafo n partito");
			return;
		}

		int aristasContiguas = (cantNodos / n) - 1;
		int aux = aristasContiguas;
		int cantAristas = 0;
		for (int i = 0; i < cantNodos; i++) {
			if (aux > 0) {
				matriz.set(i, i + 1, 1);
				cantAristas++;
				aux--;
			} else
				aux = aristasContiguas;
		}

		double porcAdyacencia = (2 * (double) cantAristas * 100) / ((cantNodos * (cantNodos - 1)) / 2);
		MaxMinCa();
		GrafoNDNP grafo = new GrafoNDNP(matriz, cantNodos, cantidadDeAristas, gradoMax, gradoMin, porcAdyacencia);
		String nombreArch = "grafo "+ n + " partito.in";
		grafo.grabar("Generados\\N-Partito\\"+nombreArch); ;
	}

}
