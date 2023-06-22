package TDAColaCP;

import java.util.Comparator;

import auxiliares.Entrada;
import auxiliares.Entry;
import excepciones.EmptyPriorityQueueException;
import excepciones.InvalidKeyException;


/**
 * Clase que  se encarga de definir una colección de elementos que soporta:
 *  – Inserción de elementos arbitraria
 *   – Eliminación de elementos en orden de prioridad
 * @author Lucas Solmoni y Victoria Legakis
 *
 * @param <K>-Tipo de las prioridades
 * @param <V>-Tipo de los valores
 */

public class HeapPQueue<K, V> implements PriorityQueue<K, V> {
	// Atributos de instancia
	protected Entrada<K, V>[] element;
	protected Comparator<K> comp;
	protected int size;

/**
 * Constructor de la cola con prioridad
 * @param maxelement- Determina el tamaño del arreglo
 * @param comp- Compara
 */
	public HeapPQueue(int maxelement, Comparator<K> comp) {
		

		element = (Entrada<K, V>[]) new Entrada[maxelement];
		this.comp = comp; 
		size = 0; 
	}
	public HeapPQueue(Comparator<K>comp) {
		this(200,comp);
	}

	@Override
	public int size() {
		return size; 
	}

	@Override
	public boolean isEmpty() {
		return size == 0; 
	}

	@Override
	public Entry<K, V> min() throws EmptyPriorityQueueException {
		if (isEmpty())
			throw new EmptyPriorityQueueException("Cola vacía");
		return element[1];
		
	}

	@Override
	public Entry<K, V> insert(K key, V value) throws InvalidKeyException {
		checkKey(key);
		Entrada<K, V> entrada = new Entrada<K, V>(key, value); 
		if(size==element.length-1)
			reArray();
		element[++size] = entrada; 
		
		int i = size; 
		boolean seguir = true; 
		while (i > 1 && seguir) {
			Entrada<K, V> elemActual = element[i]; 
			Entrada<K, V> elemPadre = element[i / 2]; 
			if (comp.compare(elemActual.getKey(), elemPadre.getKey()) < 0) {
				Entrada<K, V> aux = element[i];
				element[i] = element[i / 2];
				element[i / 2] = aux;
				i /= 2; 
			} else 
				seguir = false;
		} 
		return entrada;
	}

	@Override
	 public Entry<K,V> removeMin()throws EmptyPriorityQueueException{
  	  Entry<K,V>min=min();
  	  int m=1;// En m voy a computar la posicion del min imo de los hijos de i
  	  if(isEmpty())throw new EmptyPriorityQueueException("Cola vacía");
  	  if(size==1) {
  		  element[1]=null;
  		  size=0;
  		  return min;
  	  }
  	  else {
  		  
  		  element[1]=element[size]; element[size]=null;
  		  size--;
  		  int i=1; // Me ubico en la raiz
  		  boolean seguir=true;

  		  while(seguir) { 
	    			 
	    			  int hi=i*2;
	    			  int hd= i*2 +1;
	    			
	    			  boolean existeHI= hi<=size();
	    			  boolean existeHD=hd<=size();
	    			  
	    			  if(!existeHI) seguir=false; 
	    			  else {
	    				  if(existeHD) {
	    					  if(comp.compare(element[hi].getKey(),element[hd].getKey() ) <0)  {
	    						  m=hi;
	    					  }
	    					  else 
	    						  m=hd;
	    				  }
	    				  else m=hi;
	    			  }
	    			 if(comp.compare(element[i].getKey(),element[m].getKey())>0) {
	    			      Entrada<K,V> aux=element[i];
	    			      element[i]=element[m];
	    			      element[m]=aux;
	    			      i=m; 
	    			 }else seguir=false;
  			  
  		  }
  		  return min;
  		  
  		  
  	  }
  	  
    }
	private void checkKey(K key)throws InvalidKeyException{
		if(key==null)throw new InvalidKeyException("Clave nula");
	}
	 public void reArray() {
   	  Entrada <K,V> [] ax= (Entrada<K,V> [] )new Entrada[element.length*2];
   	  for (int i = 1; i <= size; i++)
 			ax[i] = element[i];
   	  element=ax;
   	  
     }
}