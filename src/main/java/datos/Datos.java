package datos;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;

public class Datos {

	private static Datos instanciaDatos;
	private List<Cliente> listaClientes = new ArrayList<Cliente>();
	
	private Datos() {
		
	}
	
	public static Datos getInstancia() {
		
		if(instanciaDatos == null) {
			instanciaDatos = new Datos();
		} 
		
		return instanciaDatos;
	}
	
	public void agregarClientesSingleton(Cliente cliente) {
		listaClientes.add(cliente);
	}
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	
}
