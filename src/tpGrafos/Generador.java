package tpGrafos;

public abstract class Generador {

	//private int Nodos ;
	MatrizSimetrica matriz ;
	
	protected int cantNodos ;
	protected int gradoMax ;
	protected int gradoMin ;
	protected int cantidadDeAristas ;
	
	public Generador(int n){
		System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
		this.cantNodos = n ;
		matriz = new MatrizSimetrica(n) ;
	}
	
	public MatrizSimetrica getMatriz() {
		return this.matriz;
	}
	
	
	public abstract void generar();
	
	public int getCantidadDeNodos() {
		return cantNodos;

	}
	
	

	public void set(int fila, int columna, int valor) {
		matriz.set(fila, columna, valor);
	}

	public int get(int fila, int columna) {

		return matriz.get(fila, columna);
	}
	
	
	public void recorrerG(){

		for(int i=0;i<cantNodos;i++) {
			
			for(int j=0;j<cantNodos;j++) {
				System.out.print(matriz.get(i,j)+" ");
			}
			System.out.println();
		}
	}
	
	public void MaxMinCa(){
		
		int [] vec = new int [cantNodos] ;
		
		for(int i=0 ; i<this.cantNodos ; i++){
			
			for(int j=0 ; j<this.cantNodos ; j++){
				
				if(matriz.get(i, j) == 1){
					vec[i] ++ ;
				}
			}
		}
		
		//for(int i=0 ; i<cantNodos ; i++) {
		//	System.out.print(vec[i]);
		//}
		
		int grMaxAnt , grMinAnt ,aristas=0;
		grMaxAnt = vec[0] ;
		grMinAnt = vec[0] ;	
		
		for(int k = 0 ; k<this.cantNodos ; k++){
			
			//System.out.println(vec[k]);
			if(grMaxAnt < vec[k]){
				grMaxAnt = vec[k] ;
			}
			if(grMinAnt > vec[k]){
				grMinAnt = vec[k] ;
			}
			aristas+= vec[k] ;
		}
		
		this.cantidadDeAristas = aristas/2 ;
		this.gradoMax = grMaxAnt ;
		this.gradoMin = grMinAnt ; 
		
		System.out.println("Aristas: " + this.cantidadDeAristas);
		System.out.println("Grado Maximo: " + this.gradoMax);
		System.out.println("Grado Minimo: " + this.gradoMin);
	}
	
	
}

