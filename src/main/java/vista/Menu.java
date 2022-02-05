package vista;

import java.util.InputMismatchException;
import java.util.concurrent.TimeUnit;

import datos.Datos;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import utilidades.OurScanner;
import utilidades.Utilidad;

public class Menu {

	private ClienteServicio clienteServicio;
	private ArchivoServicio archivoServicio;
	private String fileName; // para exportar el archivo
	private String fileName1; // para importar el archivo
	private int opcion;
	private OurScanner ourScanner;

	public Menu() {
		super();
		this.clienteServicio = new ClienteServicio();
		this.archivoServicio = new ArchivoServicio();
		this.fileName = "Clientes";
		this.fileName1 = "DBClientes.csv";
		this.ourScanner = new OurScanner();
	}

	public void iniciarMenu() {
		try {
			do {

				int opcion = ourScanner.imprimirMenuPrincipal();

				switch (opcion) {
				case 1:
					listarClientes();
					break;
				case 2:
					agregarCliente();
					break;
				case 3:
					editarCliente();
					break;
				case 4:
					importarDatos();
					break;
				case 5:
					exportarDatos();
					break;
				case 6:
					Utilidad.clearConsole();
					break;
				case 7:
					terminarPrograma();
					break;
				default:
					System.out.println("opción inválida. Intente de nuevo");
					break;
				}
			} while (opcion != 7);

		} catch (InputMismatchException e) {
			System.out.println("Opción incorrecta... se detuvo el programa");
		}

	}

	private void listarClientes() {
		clienteServicio.listarClientes();
	}

	private void agregarCliente() {
		clienteServicio.agregarCliente();
	}

	private void editarCliente() {
		clienteServicio.editarCliente();
	}

	private void importarDatos() {
		archivoServicio.cargarDatos(fileName1);
	}

	private void exportarDatos() {

		Datos listaDatos = Datos.getInstancia();
		archivoServicio.exportar(fileName, listaDatos.getListaClientes());

	}

	private void terminarPrograma() {
		System.out.println("saliendo del sistema de clientes...");
		try {
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Programa terminado");
			System.exit(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
