package tpGrafos;

public class App {

	public static void main(String[] args) {
		
		Generador proba = new GeneradoraPorProbabilidad(10, 0.5) ;
		proba.generar();
		
		Generador nP = new GeneradoraNpartito(10, 2) ;
		nP.generar();
		
		//Generador g1 = new GeneradorPorPorcentajeDeAdyacencia(600, 40.0) ;
		//g1.generar();
		
		/*
		Generador g1 = new GeneradorPorPorcentajeDeAdyacencia(600, 40.0) ;
		g1.generar();
		
		Generador g2 = new GeneradorPorPorcentajeDeAdyacencia(600, 60.0) ;
		g2.generar();
		
		Generador g3 = new GeneradorPorPorcentajeDeAdyacencia(600, 90.0) ;
		g3.generar();
		*/
	}
}
