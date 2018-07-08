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
	private int cantidadDeAristasAristas;
	
	public GeneradorPorPorcentajeDeAdyacencia(int n,double porcAd) {
		super(n);
		list= new ArrayList<Arista>();
		this.porcAd= porcAd;
	}

	@Override
	public void generar() {
		Random arista = new Random();
		//MatrizSimetrica matriz=new MatrizSimetrica(cantNodos);
		int maximoAristas = (cantNodos * (cantNodos -1))/2;
		int cantAristas = (int) (Math.rint((cantNodos * cantNodos - cantNodos)*0.5*(porcAd/100.0)));
		int aristasAplicadas = 0;
		double porcAdy = porcAd;
	
		while (aristasAplicadas!=cantAristas) {
			for (int i = 0; i < cantNodos; i++) {
				for (int j = i+1; j < cantNodos; j++) {
					if(matriz.get(i, j)==0) {
						if(arista.nextInt(2)==1) {
							matriz.set(i, j,1);
							aristasAplicadas++;
						}
					}
					if(aristasAplicadas==cantAristas)
						break;
				}
				if(aristasAplicadas==cantAristas)
					break;
			}
		}
		
		
		MaxMinCa();
		GrafoNDNP grafo = new GrafoNDNP(this.getMatriz(), cantNodos, cantAristas,gradoMax, gradoMin,porcAdy);
		String nombreArch = "grafoAleatorioAl"+ (int)porcAdy+".in" ;
		grafo.grabar("Generados\\Por Adyacencia\\"+nombreArch); ;
		
		/*
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
		String nombreArch = "grafoAleatorioAl"+ (int)porcAd+".in" ;
		grafo.grabar("Generados\\Por Adyacencia\\"+nombreArch); ;
		*/
	}

}
