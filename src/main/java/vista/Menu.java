package vista;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import datos.Datos;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;

public class Menu {

	private ClienteServicio clienteServicio;
	private ArchivoServicio archivoServicio;
	private String fileName; // para exportar el archivo
	private String fileName1; // para importar el archivo
	private int opcion;
	private Scanner scanner;

	public Menu() {
		super();
		this.clienteServicio = new ClienteServicio();
		this.archivoServicio = new ArchivoServicio();
		this.fileName = "Clientes";
		this.fileName1 = "DBClientes.csv";
		this.scanner = new Scanner(System.in);
	}

	public void iniciarMenu() {

		do {
			System.out.println("1. Listar Clientes\n" + "2. Agregar Cliente\n" + "3. Editar Cliente\n"
					+ "4. Cargar Datos\n" + "5. Exportar Datos\n" + "6. Salir\n" + "Ingrese una opción:");
			opcion = scanner.nextInt();

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
				terminarPrograma();
				break;
			default:
				System.out.println("opción inválida. Intente de nuevo");
				break;
			}

		} while (opcion != 6);

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
			scanner.close();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
