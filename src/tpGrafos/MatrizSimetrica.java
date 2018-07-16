package tpGrafos;

public class MatrizSimetrica {

	private int tam;
	private int orden ;
	private int [] vec ;
	
	public int getValor(int i) {
		return vec[i];
	}
	
	public void setValor(int i, int val) {
		vec[i] = val;
	}
	public int getTam() {
		return this.tam;
	}
	
	public MatrizSimetrica(int grado){
		
		this.orden = grado ;
		this.tam = (grado*(grado-1))/2 ;
		vec = new int [this.tam] ;
		
	}
	
	public void set(int f , int c , int dato){
		
		if(f > c){
			vec[ c*orden + f - ( c*c + 3 * c + 2)/2] = dato ;
		}
		else if(f < c)
			vec[ f*orden + c - (( f*f + 3 * f + 2) / 2)] = dato ;
		
	}
	
	public void recorrerVector(){
		
		for(int i=0 ; i<tam ; i++){
			System.out.print(vec[i]+" ");
		}
	}
	
	
	public int get(int f, int c){
		
		if(f > c){
			return vec[ c*orden + f - ( c*c + 3 * c + 2)/2] ;
		}
		else if(f < c)
			return vec[ f*orden + c - (( f*f + 3 * f + 2) / 2)] ;
		else
			return 0 ;
	}
	
}
