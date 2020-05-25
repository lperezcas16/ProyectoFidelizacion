package co.edu.unbosque.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Estadisticas {
	
	public int numInscritos(ArrayList<Usuario> usuario, String filtro){
		int numIns= 0;
		for(int i=0; i<usuario.size(); i++){
			if(usuario.get(i).getNombre().equals(filtro)){
				numIns++;
			}else if(filtro.equals("TOTAL")){
									numIns++;
								}else{
																		
								}
						}
					
				return numIns;
	}
 @SuppressWarnings("unused")
 
public List <Integer > calcularModa(int[] numeros) {

    int c = 0;
    int veces = 0;
    int conteoMayor = 0;
    List < Integer > acumulado = new ArrayList < > ();

    for (int j = 0; j <= 9; j++) {
      c = 0;
      for (int k = 0; k < numeros.length; k++) {

        if (j == numeros[k]) {
          c++;
        }
      }

      if (veces <= c) {
        veces = c;
        if (c > 1 && c < numeros.length) {
          if (acumulado.size() == 0 || (conteoMayor > 0 && conteoMayor == c)) {
            conteoMayor = c;
            acumulado.add(j);
          } else if (conteoMayor < c) {
            conteoMayor = c;
            acumulado.clear();
            acumulado.add(j);
          }
        }
      }
    }

    return acumulado;
  }

  public  String calcularMedia(int[] numeros) {
    double valor = 0;
    String result = "(";
    for (int numero: numeros) {
      valor += (numero * 1.0);
      result += numero + " + ";
    }
    result = result.substring(0, result.length() - 2);
    result += ")/" + numeros.length + " = " + valor / numeros.length;

    return result;
  }

  public  String calcularMediana(int[] numeros) {

    // Ordenamos los numeros de menor a mayor
    Arrays.sort(numeros);

    String result;

    if (numeros.length % 2 == 0) {
      int pos = (numeros.length - 2) / 2;
      result = "" + (((numeros[pos] * 1.0) + numeros[pos + 1]) / 2);
    } else {
      int pos = (numeros.length - 1) / 2;
      result = "" + numeros[pos];
    }

    return result;
  }	
  
	/**/
	public double[] porcentajeRango(ArrayList<Usuario> usuarios, String filtro){
		double porRan[]= new double[6];
		double aux= 0;
		double aux2= 0;
		double aux3= 0;
		double aux4= 0;
		double aux5= 0;
		double aux6= 0;
		for(int i=0; i<usuarios.size(); i++){
			if(usuarios.get(i).getNombre().equals(filtro)){
				if(usuarios.get(i).getEdad()>=18 && usuarios.get(i).getEdad()<=25){
					aux++;
				}
				if(usuarios.get(i).getEdad()>=26 && usuarios.get(i).getEdad()<=29){
					aux2++;	
				}
				if(usuarios.get(i).getEdad()>=30 && usuarios.get(i).getEdad()<=37){
					aux3++;
				}
				if(usuarios.get(i).getEdad()>=38 && usuarios.get(i).getEdad()<=49){
					aux4++;
				}
				if(usuarios.get(i).getEdad()>=50 && usuarios.get(i).getEdad()<=66){
					aux5++;
				}
				if(usuarios.get(i).getEdad()>=67){
					aux6++;
				}
			}else{
					if(filtro.equals("TOTAL")){
									if(usuarios.get(i).getEdad()>=18 && usuarios.get(i).getEdad()<=25){
										aux++;
									}
									if(usuarios.get(i).getEdad()>=26 && usuarios.get(i).getEdad()<=29){
										aux2++;	
									}
									if(usuarios.get(i).getEdad()>=30 && usuarios.get(i).getEdad()<=37){
										aux3++;
									}
									if(usuarios.get(i).getEdad()>=38 && usuarios.get(i).getEdad()<=49){
										aux4++;
									}
									if(usuarios.get(i).getEdad()>=50 && usuarios.get(i).getEdad()<=66){
										aux5++;
									}
									if(usuarios.get(i).getEdad()>=67){
										aux6++;
									}
								}else{
									
						
					
					
				}
			}
		}
		porRan[0]= (aux/usuarios.size())*100;
		porRan[1]= (aux2/usuarios.size())*100;
		porRan[2]= (aux3/usuarios.size())*100;
		porRan[3]= (aux4/usuarios.size())*100;
		porRan[4]= (aux5/usuarios.size())*100;
		porRan[5]= (aux6/usuarios.size())*100;
		return porRan;
	}
  
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

