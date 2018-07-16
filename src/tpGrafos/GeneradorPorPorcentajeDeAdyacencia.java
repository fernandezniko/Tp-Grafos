package tpGrafos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import segundaParte.GrafoNDNP;
import tpGrafos.Arista;
import tpGrafos.Generador;

public class GeneradorPorPorcentajeDeAdyacencia extends Generador {
	List<Arista> list;
	double porcAd;
	private int cantidadDeAristasMaxima=this.cantNodos*(this.cantNodos-1)/2;
	
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
		double adyacenciaReal = Math.rint((cantidadDeAristas * 100) / cantidadDeAristasMaxima) ;
		MaxMinCa();
		
		GrafoNDNP grafo = new GrafoNDNP(this.getMatriz(), cantNodos, cantidadDeAristas, gradoMax, gradoMin, adyacenciaReal);
		String nombreArch = "grafoAleatorioAl"+ (int)(porcAd*100)+".in" ;
		grafo.grabar("Generados\\Por Adyacencia\\"+nombreArch); ;
		
	}

}
