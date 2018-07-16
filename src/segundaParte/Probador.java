package segundaParte;

import java.io.*;

public class Probador {
	
	private int matrizAdyacencia[][];
	private int nodosColoreados[];
	private int cantNodos;
	private int cantAristas;
	private int cantNodosColoreo;
	private int cantAristasColoreo;
	private int cantColores;
	
	public Probador(String pathGrafo, String pathColoreo) {
		FileReader fr = null;
		try {
			File archivo = new File(pathGrafo);
			fr = new FileReader(archivo);
			BufferedReader br = new BufferedReader(fr);
			
			// Lectura archivo nodos adyacentes
			String linea = br.readLine();
			String datos[] = linea.split(" ");
			cantNodos = Integer.parseInt(datos[0]);
			cantAristas = Integer.parseInt(datos[1]);
			matrizAdyacencia = new int[cantNodos+1][cantNodos+1];
			int i;
			for(i=0; i<cantAristas; i++) {
				linea = br.readLine();
				datos = linea.split(" ");				
				matrizAdyacencia[Integer.parseInt(datos[0])][Integer.parseInt(datos[1])] = 1;
			}
			
			// Lectura archivo nodos con colores 
			archivo = new File(pathColoreo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			linea = br.readLine();
			datos = linea.split(" ");
			cantNodosColoreo = Integer.parseInt(datos[0]);
			cantColores = Integer.parseInt(datos[1]);
			cantAristasColoreo = Integer.parseInt(datos[2]);
			
			nodosColoreados = new int[cantNodosColoreo+1];
			for(i=0; i<cantNodosColoreo; i++) {
				linea = br.readLine();
				datos = linea.split(" ");
				nodosColoreados[Integer.parseInt(datos[0])] = Integer.parseInt(datos[1]); 
			}
			br.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(fr != null)
					fr.close();
			}
			catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public boolean verifica() {
		int i,j;
		
		if(nodosColoreados.length != matrizAdyacencia[1].length || cantNodos != cantNodosColoreo || cantAristas != cantAristasColoreo)
			return false;
		
		cantNodos = nodosColoreados.length;
		int color;
		for(i=0; i<cantNodos; i++) {
			 color = nodosColoreados[i];
			 for(j=i+1; j<cantNodos; j++)
				 if(matrizAdyacencia[i][j]==1 && color==nodosColoreados[j])
					 return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		Probador prueba = new Probador("Generados/coloreados/grafo.in","Generados/coloreados/grafo.out");
		if(prueba.verifica()== false)
			System.out.println("Grafo mal coloreado");
		else
			System.out.println("Grafo bien coloreado");
	}
}