package servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import modelo.Cliente;

public class ClienteServicioTest {

	private static Logger logger = Logger.getLogger("cl.desafaiolatam.servicio.ClienteServicio");

	@Test
	public void testAgregarCliente() {
		
		ClienteServicio clienteServicio = new ClienteServicio();	
		logger.info("Test agregar cliente");
		List<Cliente> listaClientes = clienteServicio.agregarCliente();
	
		assertEquals("3", listaClientes.get(0).getAniosCliente());

	}

	@Test
	public void agregarClienteNullTest() {

		ClienteServicio clienteServicio = new ClienteServicio();
		logger.info("Test agregar cliente nulo");
		List<Cliente> listaClientes = clienteServicio.agregarCliente();

		assertEquals("null", listaClientes.get(1).getApellidoCliente());
	}

	@AfterAll
	static void done() {
		logger.info("Fin de la clase de prueba");
	}

}
