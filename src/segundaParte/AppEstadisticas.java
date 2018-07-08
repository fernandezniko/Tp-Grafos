package segundaParte;

public class AppEstadisticas {

	public static void main(String[] args) {
		/*
		//GRAF0 AL 40% DE ADYACENCIA
		GrafoNDNP grafo = new GrafoNDNP("Generados\\Por Adyacencia\\grafoAleatorioAl40.in") ;
		//SECUENCIAL ALEATORIO
		grafo.ejecutarCaso("Estadisticas\\Secuencial Aleatorio\\grafoAleatorioAl40.out", 1);
		//WELSH-POWELL
		grafo.ejecutarCaso("Estadisticas\\Welsh-Powel\\grafoAleatorioAl40.out", 2);
		//MATULA
		grafo.ejecutarCaso("Estadisticas\\Matula\\grafoAleatorioAl40.out", 3);
		
		//GRAF0 AL 60% DE ADYACENCIA
		GrafoNDNP grafo2 = new GrafoNDNP("Generados\\Por Adyacencia\\grafoAleatorioAl60.in") ;
		//SECUENCIAL ALEATORIO
		grafo2.ejecutarCaso("Estadisticas\\Secuencial Aleatorio\\grafoAleatorioAl60.out", 1);
		//WELSH-POWELL
		grafo2.ejecutarCaso("Estadisticas\\Welsh-Powel\\grafoAleatorioAl60.out", 2);
		//MATULA
		grafo2.ejecutarCaso("Estadisticas\\Matula\\grafoAleatorioAl60.out", 3);
		*/
		//GRAF0 AL 90% DE ADYACENCIA
		GrafoNDNP grafo3 = new GrafoNDNP("Generados\\Por Adyacencia\\grafoAleatorioAl90.in") ;
		//SECUENCIAL ALEATORIO
		grafo3.ejecutarCaso("Estadisticas\\Secuencial Aleatorio\\grafoAleatorioAl90.out", 1);
		//WELSH-POWELL
		grafo3.ejecutarCaso("Estadisticas\\Welsh-Powel\\grafoAleatorioAl90.out", 2);
		//MATULA
		grafo3.ejecutarCaso("Estadisticas\\Matula\\grafoAleatorioAl90.out", 3);
		
	}
}
