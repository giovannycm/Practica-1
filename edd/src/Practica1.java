package Clases;

import java.util.Iterator;

public class Practica1 {
    
    /**
     * AgregaOrdenado: Dada una lista ordenada y un elemento nuevo, se agrega dicho elemento de manera ordena
     * Tiempo O(n)
     * Es lineal ya que el while se hace recorriendo el tamaño de la lista
     * Espacio O(1) 
     *Cumple que el espacio sea constante ya que se trabaja sobre la misma lista.
     **/
    public static Lista<Integer> AgregaOrdenado(Lista<Integer> lista, int nuevo){
	    Iterator<Integer> iter = lista.iterator();	

	while(iter.hasNext()){
	    if(nuevo <= iter.next()){ 
		Integer posicion = iter.next();
		lista.insert(nuevo, posicion);
	    }else{
		iter.next();
	    }//Fin if-else	    
	}//Fin while
	return null;
	}
    
    /**
     * Unión: Regresa una lista que contiene los elementos de dos listas dadas, quita los duplicados
     *
     * Tiempo O(n*m)
     * Al momento de estar comparando entre las listas se genera el tiempo O(n*m)
     * Espacio O(n+m)
     * Es de este estilo ya que "pegamos" las listas y entonces se suma el espacio de la primera con el espacio de la segunda
     *
     * Como mejorarias el tiempo de union
     * Una forma de mejorar este algoritmo podria ser aplicar un ordenamiento para que el manejo de la lista sea mucho mas facil 
     * y asi poder cubrir una mayor cantidad de casos y evitar que el algoritmo sea fácil de "romper"
     **/
    public static void Union(Lista<Integer> lista1,Lista<Integer> lista2) {
	Iterator<Integer> iter = lista2.iterator();

	while(iter.hasNext()){
	    if(lista1.contains(iter.next())){
		Integer aux = iter.next();
		lista2.delete(aux);
		iter.next();
	    }else{
		Integer elemen = iter.next();
		lista1.add(elemen);
		iter.next();        
	    }//fin if-else
	}//Fin while
	return;
    }

    /**
     * Interseccion: Dadas dos listas de enteros nos devuelve los elementos que se encuentran en ambas listas
     *
     * Tiempo O(n*m)
     * Al momento de estar comparando entre las listas se genera el tiempo O(n*m)
     * Espacio O(n) siendo n mayor que m de otra forma sera O(m)
     * A la lista uno se le van quitando esos elementos y a la lista dos se le agregan
     *
     * b. Como mejorarias el tiempo de intersección
     * Implementando un algoritmo que nos permita al unir las listas hacerlo de manera ordenada, lo que haria mas facil hacer una comparacion
     * de los elementos al recorrerlo y de esta manera, poder notar que elementos no se encuentran repetidos, eliminarlos y después eliminar los duplicados.
     **/
    public static void Interseccion(Lista<Integer> lista,Lista<Integer> lista2){
	Iterator<Integer> iter = lista2.iterator();

	while(iter.hasNext()){
	    if(lista.contains(iter.next())){//Lo deja y pasa al siguiente
		iter.next();
	    }else{//Lo elimina y pasa al siguiente
		Integer elemen = iter.next();
		lista2.delete(elemen);
		iter.next();        
	    }//Fin if-else
	}//Fin while
	lista.empty();//Vaciamos lista1	
	return;
    }


    public static void main(String[] args) {
        Lista<Integer> primera = new Lista<Integer>();
        Lista<Integer> segunda = new Lista<Integer>();
        Lista<Integer> tercera = new Lista<Integer>();
        
        
        // Tests toString
        for (int i = 0; i <= 5; i++) {
            primera.add(i);
        }
        
        String test = "0 -> 1 -> 2 -> 3 -> 4 -> 5";
        if (!primera.toString().equals(test)) {
            System.out.println("1 El toString no funciona!");
        }
        primera = new Lista<Integer>();
        if (!primera.toString().equals("")) {
            System.out.println("2 El toString no funciona!");
        }
            
        // Tests Reverse
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();

        for (int i = 0; i <= 10; i++) {
            primera.add(i);
            segunda.agregaInicio(i);
        }
      
        primera.reverse();
        if (!primera.toString().equals(segunda.toString())) {
            System.out.println("1 El reverse no funciona!");    
        }
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        primera.reverse();
        if (!primera.toString().equals(segunda.toString())) {
            System.out.println("2 El reverse no funciona!");
        }

        // Tests Append
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        for (int i = 0; i <= 10; i++) {
            primera.add(i);
            segunda.add(i);
        }
        for (int i = 0; i <= 10; i++) {
            segunda.add(i);
        }
        primera.append(primera.clone());

        
        if (!primera.toString().equals(segunda.toString())) {
            System.out.println("1 El Append no funciona!");
        }

        // Tests IndexOf
        if (primera.indexOf(0) != 0) {
            System.out.println("1 El IndexOf no funciona!");
        }
        if (primera.indexOf(1) != 1) {
            System.out.println("2 El IndexOf no funciona!");
        }
        if (primera.indexOf(10) != 10) {
            System.out.println("3 El IndexOf no funciona!");
        }

        // Tests Insert
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        for (int i = 0; i <= 10; i++) {
            primera.add(i);
            
        }
        for (int i = 0; i <= 4; i++) {
            segunda.add(i);

        }
        segunda.add(6);
        for (int i = 5; i <= 10; i++) {
            segunda.add(i);

        }

        primera.insert(5, 6);
        if (!primera.toString().equals(segunda.toString())) {
            System.out.println("1 El insert no funciona!");
        }

        // Tests Mezcla Alternada
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        for (int i = 0; i <= 10; i++) {
            if (i % 2 == 0) {
                primera.add(i);
            }   
        }
        primera.add(11);
        for (int i = 0; i <= 10; i++) {
            if (i % 2 != 0) {
                segunda.add(i);
            }

        }
        for (int i = 0; i <= 11; i++) {
            
                tercera.add(i);

        }


        primera.mezclaAlternada(segunda);
        if (!primera.toString().equals(tercera.toString())) {
            System.out.println("1 la mezclaAlternada no funciona!");
        }


        // Tests Agrega Ordenado
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        for (int i = 0; i <= 10; i++) {
            primera.add(i);
        }
        for (int i = 0; i <= 9; i++) {
            segunda.add(i);
        }
        segunda.add(9);
        segunda.add(10);
        
        
        tercera = AgregaOrdenado(primera,9);
        if (!tercera.toString().equals(segunda.toString())) {
            System.out.println("1 el agregaOrdenado no funciona!");
        }
        
        // Tests Union
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        tercera = new Lista<Integer>();
        primera.add(1);
        primera.add(2);
        primera.add(3);
        segunda.add(2);
        Union(primera, segunda);

        if (!(primera.contains(1) && primera.contains(2) && primera.contains(3) && primera.size() == 3)) {
            System.out.println("1 La union no funciona!");
        }
        
        // Tests interseccion
        primera = new Lista<Integer>();
        segunda = new Lista<Integer>();
        tercera = new Lista<Integer>();
        primera.add(1);
        primera.add(2);
        primera.add(3);
        segunda.add(2);
        Interseccion(primera, segunda);

        if (!(primera.contains(2) && primera.size() == 1)) {
            System.out.println("1 La intersección no funciona!");
        }
        
        



    }   
   

    


}
