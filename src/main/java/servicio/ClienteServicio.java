package servicio;

import java.util.List;
import datos.Datos;
import modelo.Cliente;
import utilidades.OurScanner;

public class ClienteServicio {

	private Datos listaDatos = Datos.getInstancia();
	private OurScanner ourScanner;

	public ClienteServicio() {
		super();
		ourScanner = new OurScanner();
	}

	public void listarClientes() {

		if (listaDatos.getListaClientes().isEmpty()) {
			System.out.println("\nNo existen clientes... intente con la opción dos.\n");
		} else {
			for (Cliente cliente : listaDatos.getListaClientes()) {
				System.out.println("-------------Datos del Cliente-------------\n");
				System.out.println(cliente.toString());
				System.out.println("-------------------------------------------");
			}
		}
	}

	public List<Cliente> agregarCliente() {

		Cliente cliente = ourScanner.escanearAgregarCliente();

		setListaClientes(cliente);

		List<Cliente> listaClientes = listaDatos.getListaClientes();

		return listaClientes;
	}

	public void editarCliente() {

		ourScanner.escanearEditarCliente();

	}

	public List<Cliente> getListaClientes() {
		return listaDatos.getListaClientes();
	}

	public void setListaClientes(Cliente cliente) {

		listaDatos.agregarClientesSingleton(cliente);
		System.out.println("Datos cargados correctamente en la lista");

	}
	
}
