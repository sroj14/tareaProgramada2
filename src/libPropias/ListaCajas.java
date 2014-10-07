public class ListaCajas{
	public Caja primerCaja;
	public Caja ultimaCaja;
	public Caja actual;
	public int size;

public class Caja{
	private Caja siguiente;
	private String estado;
	private String nombre;


	public Caja(String estado, String nombre){
        this.siguiente = null;
        this.estado = estado;
        this.nombre = nombre;

	}

	public String obtenerEstado(){
		return this.estado;
	}

	public void establecerEstado(String estado){
		this.estado = estado;
	}

	public void establecerSiguiente(Caja siguiente){
		this.siguiente = siguiente;
	}

 
    public Caja obtenerSiguiente(){
            return this.siguiente;
     }

    public String obtenerNombre(){
    	return this.nombre;
    }

    }

    public void establecerActual(){
    	this.actual = this.primerCaja;
    }

    public Caja obtenerActual(){
    	return this.actual;
    }

    public void establecerActualSig(){
        this.actual = this.actual.obtenerSiguiente();
    }


public int obtenerTamaño(){
     return this.size;
}

public ListaCajas(){
    this.primerCaja = null;
    this.ultimaCaja = null;
    this.actual = null;
	
}

public void  insertar(String estado,String nombre){
     Caja caja = new Caja(estado,nombre);

	if(primerCaja == null){
		this.primerCaja = caja;
		this.ultimaCaja = caja;
		this.actual = caja;
	}
	else{
		this.ultimaCaja.establecerSiguiente(caja);
		this.ultimaCaja = caja;
		this.actual = caja;
	}
	size++;

}

}
//           cajas.establecerActual();
//           while(clienteRegular.obtenerTamaño() != 0){
 //           for(int i = 0; i <cajas.obtenerTamaño();i++){
//            if(cajas.obtenerActual().obtenerEstado() == "Desocupada"){
 //             clienteRegular.asignarCaja();
  //            listClientes.addElement(cajas.obtenerActual().obtenerNombre()+ "atendido pobres");
   //           cajas.obtenerActual().establecerEstado("Ocupada");
    //          cajas.establecerActualSig();
     //         break;
      //      }
       //     else{
      //        cajas.establecerActualSig();
       //     }
       //   }
        //  }      