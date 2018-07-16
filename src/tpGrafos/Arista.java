package tpGrafos;

public class Arista implements Comparable<Object> {

	public int getNodoOrigen() {
		return nodoOrigen;
	}

	public int getNodoDestino() {
		return nodoDestino;
	}

	private int nodoOrigen;
	private int nodoDestino;
	private double random;

	public Arista(int nodoOrigen, int nodoDestino) {
		this.nodoOrigen = nodoOrigen;
		this.nodoDestino = nodoDestino;
		this.random = Math.random() * 10000;
	}

	public int compareTo(Object o) {
		return (int) (this.random - ((Arista) o).random);
	}

}
