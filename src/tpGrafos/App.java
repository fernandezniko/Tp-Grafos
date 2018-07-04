package tpGrafos;

public class App {

	public static void main(String[] args) {
		
		/*MatrizSimetrica m = new MatrizSimetrica(5) ;
		
		m.setFc(1, 0, 1);
		m.setFc(2, 0, 1);
		m.setFc(3, 1, 1);
		m.setFc(3, 2, 1);
		m.setFc(4, 3, 1);
		
		m.recorrerVector();
		
		*/
		Generador g1 = new GeneradoraPorProbabilidad(100, 0.5) ;
		//Generador g1 = new GeneradorPorPorcentajeDeAdyacencia(5, 0.5) ;
		
		g1.generar();
		g1.recorrerG() ;
		//g1.MaxMinCa();
	}
}
