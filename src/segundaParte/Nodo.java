package segundaParte;

public class Nodo {
	
	int numero;
	int color;
	int grado;
	
	public Nodo(int indice, int color, int grado )
	{
		this.numero= indice;
		this.color= color;
		this.grado= grado;
	}

	public Nodo( Nodo nodo )
	{
		this( nodo.numero, nodo.color, nodo.grado);
	}

	public void copiarValores( Nodo nodo){
		numero= nodo.numero;
		color= nodo.color;
		grado= nodo.grado;
	}
	
	public void intercambiar( Nodo ady)
	{
		Nodo aux = new Nodo(this);
		this.copiarValores(ady);
		ady.copiarValores(aux);
	}
	
	public int campararGrados(Nodo ady)
	{
		if(this.grado > ady.grado)
			return 1;
		else if(this.grado<ady.grado)
			return -1;
		else return 0;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}
	
}

