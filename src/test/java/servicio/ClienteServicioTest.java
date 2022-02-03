package servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import modelo.Cliente;

@DisplayName("Test clase ClienteServicio")
public class ClienteServicioTest {
	
	private static Logger logger = Logger.getLogger("ClienteServicioTest");
	private static ClienteServicio clienteServicio;
	private static Cliente cliente;

	@BeforeAll
	public static void setup() {
		clienteServicio = new ClienteServicio();
	}
	
	@Test
	public void agregarClienteTest() {
		
		logger.info("Información de agregarClienteNullTest");
		cliente = new Cliente();
		cliente = clienteServicio.agregarCliente();	
		assertEquals("3", cliente.getAniosCliente());
	}

	@Test
	public void agregarClienteNullTest() {
		
		logger.info("Información de agregarClienteNullTest");
		cliente = new Cliente();
		cliente = clienteServicio.agregarCliente();	
		assertEquals(null, cliente);
	}
	
	@AfterAll
	static void done() {
		logger.info("Fin clase de prueba");
	}

}
