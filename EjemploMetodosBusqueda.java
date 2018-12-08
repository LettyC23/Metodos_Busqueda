class MetodosBusqueda{
	
	public void BusquedaSecuencial (int []numeros){
        Scanner leer = new Scanner(System.in);
        boolean existe= false;
         
        System.out.println("ingrese el número a buscar!");
        int numBuscado = leer.nextInt();
         
        for(int b = 0; b < numeros.length; b++){
             
            if(numeros[b]==numBuscado){
                 
                System.out.println("el numero si existe, en la posicion "+(b+1));
                break;
            }else
            
                existe = true;
            
        }       
        
	    }
	
	
	
	public int busquedaBinaria(int[] numeros, int elemento) {
		int centro, primero, valorCentro, ultimo;
		primero = 0;
		ultimo=numeros.length-1;
		while(primero <= ultimo) {
			centro= (primero+ultimo)/2;
			valorCentro = numeros[centro];
			System.out.println("Comparando " + elemento + " con " + numeros[centro]); //opcional
		
			if(elemento == valorCentro) {
				return centro;
			}else if(elemento < valorCentro) {
				ultimo = centro-1; 
			}else {
				primero = centro + 1;
			}
		
			
		}
		
		return -1;
	}
	
}

class hashCero{
	String[] arreglo;
	//constructor
	int tamaño, contador;
	public hashCero(int tam) {
		tamaño = tam;
		arreglo= new String [tam];
		Arrays.fill(arreglo, "-1");
	}
	
	
	public void funcionalidadHash(String [] cadenaArreglo, String[] arreglo) {
		int i;
		
		for(i=0; i<cadenaArreglo.length; i++) {
			String elemento = cadenaArreglo[i];
			int indiceArreglo = Integer.parseInt(elemento)%7;
			System.out.println("El indice es: " + indiceArreglo + " para el elemento " + elemento);
					//tratando las colisiones
			
			while(arreglo[indiceArreglo] != "-") {
				indiceArreglo++;
				System.out.println("Oocurrio una colision para el indice " + (indiceArreglo-9) + 
						" cambiar el idice  " + indiceArreglo);
				indiceArreglo %= tamaño;
			}
			arreglo[indiceArreglo] = elemento;
		}
	}
	
	public String buscarClave(String elemento) {
		int indiceArreglo = Integer.parseInt(elemento)%7;
		int contador = 0;
		while(arreglo[indiceArreglo] != "-1") {
			if(arreglo[indiceArreglo] == elemento) {
				System.out.println(" El elemento " + elemento + " fue encontrado en la posicion " + indiceArreglo);
				return arreglo[indiceArreglo];
			}
			indiceArreglo++;
			indiceArreglo %= tamaño;
contador++;
	if(contador>7) {
		break;
	}
		}
		return null;
	}
  }
  
  public class EjemplosMetodosBusqueda {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		byte op=0;
		while(op!=4) {
		MetodosBusqueda mb = new MetodosBusqueda();
		int numeros[];
		numeros= new int [100];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = new Random().nextInt(100);
		}
		System.out.println("1) Busqueda secuencial \n2) Busqueda binaria \n3)Hash");
		 op = entrada.nextByte();
		if(op==1) {
			mb.BusquedaSecuencial(numeros);
		}else if(op==2) {
			int numero[];
			numero = new int [100];
			for (int i = 0; i < numero.length; i++) {
				numero[i] = i;
			}
			System.out.println("Ingrese el elemento a buscar");
			int elementoBuscado = entrada.nextInt();
			int indice = mb.busquedaBinaria(numero, elementoBuscado);
			if (indice != -1) {
				System.out.println("Elemento " + elementoBuscado + " se encuentra en el indice: " + indice );
			}else {
				System.out.println("Elemento NO encontrado!!!!");}
		}else if(op==3) {
			hashCero hash = new hashCero(8);
			String [] elementos = {"28","33", "21","10","12", "14","56","100"};
			hash.funcionalidadHash(elementos, hash.arreglo);
			String buscado = hash.buscarClave("33");
			if (buscado==null) {
				System.out.println(" El elemento 33 no se encuentra!");
			}
		}else {
			System.out.println("Opcion incorrecta!!!!!");
		}
		}
		
	}

}
