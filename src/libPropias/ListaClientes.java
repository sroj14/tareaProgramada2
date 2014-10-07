import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListaClientes{
	public Cliente primerCliente;
	public Cliente ultimoCliente;
	public int size;

public class Cliente{
	private String nombre;
	private String correo;
	private String fecha;
	private String hora;
	private String calificacion;
	private Cliente siguiente;


	public Cliente(String calificacion, String nombre, String correo){

	this.nombre = nombre;
	this.correo = correo;
	this.calificacion = calificacion;
        Date date = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        this.hora = hourFormat.format(date);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.fecha = dateFormat.format(date);
        this.siguiente = null;
	}

	public String obtenerFecha(){
		return this.fecha;
	}
	public String obtenerHora(){
		return this.hora;
	}
	public String obtenerCorreo(){
		return this.correo;
	}
	public String obtenerNombre(){
		return this.nombre;
	}
	public String obtenerCalificacion(){
		return this.calificacion;
	}
	public void establecerSiguiente(Cliente siguiente){
		this.siguiente = siguiente;
	}
        public Cliente obtenerSiguiente(){
            return this.siguiente;
        }

}
public int obtenerTamaño(){
     return this.size;
}

public ListaClientes(){
    this.primerCliente = null;
    this.ultimoCliente = null;
	
}

public void  insertar(String cal, String nombre, String correo){
        Cliente usuario = new Cliente(cal,nombre,correo);

	if(primerCliente == null){
		this.primerCliente = usuario;
		this.ultimoCliente = usuario;
	}
	else{
		this.ultimoCliente.establecerSiguiente(usuario);
		this.ultimoCliente = usuario;
	}
	size++;

}
public Cliente asignarCaja(){
	if(this.primerCliente == null){
            System.out.println("lista vacia");
        }
        Cliente usuario = this.primerCliente;
        if(this.obtenerTamaño() ==1){
            this.primerCliente = null;
            this.ultimoCliente = null;
        }
        else{
            Cliente temp = this.primerCliente;
            this.primerCliente = this.primerCliente.obtenerSiguiente();
            temp.establecerSiguiente(null);
        }
        size--;
        return usuario;
}
}