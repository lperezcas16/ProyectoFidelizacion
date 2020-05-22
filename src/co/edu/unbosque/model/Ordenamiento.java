package co.edu.unbosque.model;

import java.util.ArrayList;

public class Ordenamiento {

	public void usuarioAsc(ArrayList<Usuario> array) {

		Usuario aux;
		int k;
		for (int i = 1; i < array.size(); i++) {
			aux = array.get(i);
			k = i - 1;
			while (k > -1 && aux.getUsuario().compareToIgnoreCase(array.get(k).getUsuario()) < 0) {

				array.remove(k + 1);
				array.add(k + 1, array.get(k));
				k = k - 1;
			}

			array.remove(k + 1);
			array.add(k + 1, aux);
			
		}
	}
	
	
	
	
	
	
	public void nombreAsc(ArrayList<Usuario> array) {

		Usuario aux;
		int k;
		for (int i = 1; i < array.size(); i++) {
			aux = array.get(i);
			k = i - 1;
			while (k > -1 && aux.getNombre().compareToIgnoreCase(array.get(k).getNombre()) < 0) {

				array.remove(k + 1);
				array.add(k + 1, array.get(k));
				k = k - 1;
			}

			array.remove(k + 1);
			array.add(k + 1, aux);
			
		}
	}
	
	
	
	
	
	
}
