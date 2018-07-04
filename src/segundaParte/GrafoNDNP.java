package segundaParte;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import tpGrafos.MatrizSimetrica;

public class GrafoNDNP {

	MatrizSimetrica matrizAdyacencia ;
	int cantNodos;
	int cantAristas;
	int grMin ;
	int grMax ;
	double adyacencia;
	Nodo[] nodo;
	int cantColores;
	
	public GrafoNDNP(MatrizSimetrica matriz, int cantNodos, int cantAristas, int gMin, int gMax, double adyacencia) {
		this.matrizAdyacencia=matriz;
		this.cantNodos=cantNodos;
		this.cantAristas=cantAristas;
		this.grMin = gMin;
		this.grMax = gMax;
		this.adyacencia = adyacencia;
	}
	
	public void leerArchivo(String path) {
		
		    FileReader fr = null;
		    BufferedReader br = null;
		    try {	        
		         fr = new FileReader (path);
		         br = new BufferedReader(fr);
		       
		         String[] datos = br.readLine().split(" "); 	
		         cantNodos = Integer.parseInt( datos[0] );
		         cantAristas = Integer.parseInt( datos[1] );
		         
		         nodo = new Nodo[cantNodos+1];
	    		 for(int i=1; i<=cantNodos;i++)
	    			 nodo[i]= new Nodo(i,0,0); //Inicializo cada nodo enumerandolo, colocandole color 0 y grado 0.
	    		 
		         matrizAdyacencia = new MatrizSimetrica(cantNodos+1);  	
	        	 //Lleno la matriz
		         int f, c;
		         for(int i=0; i<cantAristas; i++)
	        	 {
	        		 datos = br.readLine().split(" ");         
	        		 f= Integer.parseInt(datos[0]);
	        		 c= Integer.parseInt(datos[1]);
	        		 matrizAdyacencia.set(f, c, 1);
	        		 
	        		 nodo[f].grado++; //Incremento el grado, tras realizar la adyacencia
	        		 nodo[c].grado++;
	             }  
	        	 
		    }
		    catch(Exception e){
			         e.printStackTrace();
			  }finally{
			         try{                    
			            if( null != fr ){   
			               fr.close();     
			            }                  
			         }catch (Exception e2){ 
			            e2.printStackTrace();
			         }
			      }		
		}
	
	public void colorearSecuencialAlternativo() {
		int i, color;
		cantColores = 0;
		for(i=1; i<=cantNodos; i++) {
			color = 1;
			while(!sePuedeColorear(i, color))
				color++;
			nodo[i].color = color;
			if(color > cantColores)
				cantColores = color;
		}
	}
	
	public void colorearPowell(){
		ordenarGradoDescente(nodo,1,nodo.length-1);
		colorearSecuencialAlternativo();
	}
	

	public void colorearMatula(){
		
		ordenarGradoAscendente(nodo,1,nodo.length-1);
		colorearSecuencialAlternativo();
	}
	
	private boolean esAdyacente(Nodo nodo1, Nodo nodo2) {
		return matrizAdyacencia.get(nodo1.getNumero(), nodo2.getNumero()) == 1;
	}
	
	private boolean sePuedeColorear(int n, int color) {
		int i=1; 
		if(nodo[n].color != 0) //si el nodo fue coloreado 
			return false;      //no puedo colorear
		while(i <= cantNodos) {
			if(nodo[i].color == color) {  //si el nodo a colorear es adyacente a un nodo ya pintado de ese
				if(esAdyacente(nodo[i],nodo[n]))  //color, no lo podré colorear
					return false;
			}
			i++;
		}
		return true;
	}
	
	private void ordenarGradoAscendente(Nodo nodo[],int izq,int der)
	{
		Nodo pivote = new Nodo( nodo[(izq+der)/2] );  	        
		int i=izq, d=der;	        
		do	        
		{	            
			while((nodo[i].campararGrados(pivote)<0)) 
				i++; 	            
			while((nodo[d].campararGrados(pivote)>0)) 
				d--;	            
			if(i<=d)	            
			{	                
				nodo[i].intercambiar(nodo[d]);	            	
				i++;	            	
				d--;	            
			}	        
		}while (i<=d); 	            
		if(izq<d) ordenarGradoAscendente(nodo,izq,d);	            
		if(i<der) ordenarGradoAscendente(nodo,i,der);	        
	}
	
	public void grabar() {
		try {
			FileWriter fw= new FileWriter(new File("grafo.in"));
			PrintWriter pw= new PrintWriter(fw);
			
			pw.println(cantNodos+" "+ cantAristas+ " "+ adyacencia + " "+ grMax+" "+ grMin);
			for(int i=0;i< cantNodos;i++) {
				for(int j=i+1;j<cantNodos;j++) {
					if(matrizAdyacencia.get(i, j)!=0) {
						pw.println(i+" "+j);
					}
				}
			}
			
			
			
			pw.close();
		}catch(IOException e) {
			System.out.println("Error");
			
		}
	}
	
	private void ordenarGradoDescente (Nodo nodo[],int izq,int der)
	{
		Nodo pivote = new Nodo( nodo[(izq+der)/2] );  	        
		int i=izq, d=der;	        
		do	        
		{	            
			while((nodo[i].campararGrados(pivote)>0)) 
				i++; 	            
			while((nodo[d].campararGrados(pivote)<0)) 
				d--;	            
			if(i<=d)	            
			{	                
				nodo[i].intercambiar(nodo[d]);	            	
				i++;	            	
				d--;	            
			}	        
		}while (i<=d); 	            
		if(izq<d) ordenarGradoDescente(nodo,izq,d);	            
		if(i<der) ordenarGradoDescente(nodo,i,der);	        
	}
	
	public void mostrarNodosColoreados(){
		System.out.println("Cantidad de colores: " + cantColores );
		for(int i=1; i<=cantNodos; i++)
			System.out.println( nodo[i].toString() );
	}
	
	public void alterarOrdenNodos()
	{
		cantColores=0;  //vuelvo a setearlo en 0 por si se ejecuta varias veces el coloreo
		Nodo vectorAux[]= new Nodo[cantNodos+1];  //creo vector auxiliar donde voy a alterar posiciones 
	    int[] numeros= new int[cantNodos+1];
	    Random rnd=new Random();
	    int aux=cantNodos, pos;
	    
	    //se rellena una matriz ordenada del 1 al..n
	    for(int i=1; i<=cantNodos; i++) 
	    	numeros[i]=i;
	   
	    for(int i=1; i<=cantNodos; i++)
	    {
	        pos= rnd.nextInt(aux);  
	        vectorAux[ numeros[pos]+1 ] = 
				new Nodo( nodo[i].numero,0,nodo[i].grado ); //cambio la pos del nodo, en un vector de nodos aux
	        numeros[pos]=numeros[aux-1]; aux--; 
	    }
		nodo = vectorAux;
		vectorAux=null;
	}
	

	public void colorear(int codAlgoritmo)
	{
		if(codAlgoritmo == 1) colorearSecuencialAlternativo(); 
		if(codAlgoritmo == 2) colorearPowell(); 		
		if(codAlgoritmo == 3) colorearMatula(); 
		
	}
	
	public int gradoMayor(){
		int g_mayor = 0;
		for (int i = 1; i < nodo.length; i++) {
			if(nodo[i].grado>g_mayor){
				g_mayor = nodo[i].grado;
			}
		}
		return g_mayor;
	}
	
	public void grabarResumenCaso(String path, int cod_algoritmo, int[]cantColor, int nroCromatico)
	{
		//String pathOUT = "Lote de prueba/"+cod_algoritmo + "_" + pathCaso + "_resumen.txt";
		FileWriter fw = null;
		PrintWriter pw= null;
		try {
			fw = new FileWriter(path);
			pw = new PrintWriter(fw);
			pw.println("Algoritmo: " + cod_algoritmo);
			pw.println("NRO CROMATICO: " + nroCromatico);
			pw.println("CantColores  CantRepeticiones");
			for(int i=0; i<cantColor.length; i++)
			{
				if(cantColor[i]>0)
					pw.println(i + " " + cantColor[i]);
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
				try {
					if(fw!=null)
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			} 
	}
	
	public void grabarGrafoColoreado (String pathCaso, int cod_algoritmo, Nodo[] grafoColoreado, int nroCromatico)
	{
		String pathOUT = "Lote de prueba/OUT/" + pathCaso + ".out";
		FileWriter fw = null;
		PrintWriter pw= null;
		try {
			fw = new FileWriter(pathOUT);
			pw = new PrintWriter(fw);
			pw.println(cantNodos + " "+ nroCromatico +" " + gradoMayor());
			
			for(int i=1; i<=cantNodos; i++)
				pw.println(grafoColoreado[i].numero + " " + grafoColoreado[i].color);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
				try {
					if(fw!=null)
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			} 
	}

}
