package tpGrafos;

public class App {

	public static void main(String[] args) {
		/*
		Generador proba = new GeneradoraPorProbabilidad(10, 0.5) ;
		proba.generar();
		
		Generador nP = new GeneradoraNpartito(10, 2) ;
		nP.generar();
		*/
		
		
		
		Generador g1 = new GeneradorPorPorcentajeDeAdyacencia(600, 0.4) ;
		g1.generar();
		
		Generador g2 = new GeneradorPorPorcentajeDeAdyacencia(600, 0.6) ;
		g2.generar();
		
		Generador g3 = new GeneradorPorPorcentajeDeAdyacencia(600, 0.9) ;
		g3.generar();
		
		
	}
}
