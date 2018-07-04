package tpGrafos;

import java.util.ArrayList;
import java.util.Collections;

import segundaParte.GrafoNDNP;
import tpGrafos.Arista;
import tpGrafos.Generador;

public class GeneradorPorPorcentajeDeAdyacencia extends Generador {
	ArrayList<Arista> list;
	double porcAd;
	private int cantidadDeAristasAristas;
	public GeneradorPorPorcentajeDeAdyacencia(int n,double porcAd) {
		super(n);
		list= new ArrayList<Arista>();
		this.porcAd= porcAd;
	}

	@Override
	public void generar() {
		cantidadDeAristas=0;
		for (int i = 0; i < super.getCantidadDeNodos()-1; i++) {
			for (int j =i+ 1; j < super.getCantidadDeNodos(); j++) {
				list.add(new Arista(i,j));
			}
		}
		Collections.sort(list);
		for (int i = 0; i < (list.size()*porcAd); i++) {
			this.set(list.get(i).getNodoOrigen(), list.get(i).getNodoDestino(), 1);
			cantidadDeAristas++;
		}
		list.clear();
		double adyacenciaReal = Math.rint((cantidadDeAristas * 100) / cantidadDeAristasAristas) ;
		MaxMinCa();
		GrafoNDNP grafo = new GrafoNDNP(this.getMatriz(), cantNodos, cantidadDeAristas, gradoMax, gradoMin, adyacenciaReal);
		grafo.grabar();
	}

}
