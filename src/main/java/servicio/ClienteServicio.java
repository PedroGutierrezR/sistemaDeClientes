package servicio;

import java.util.List;
import java.util.Scanner;

import datos.Datos;
import modelo.CategoríaEnum;
import modelo.Cliente;

public class ClienteServicio {

	private Scanner scanner;
	private Datos listaDatos = Datos.getInstancia();

	public ClienteServicio() {
		super();
		this.scanner = new Scanner(System.in);
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

	public Cliente agregarCliente() {

		System.out.println("Ingrese RUN del cliente: ");
		String runCliente = scanner.next();

		System.out.println("Ingrese nombre del cliente: ");
		String nombreCliente = scanner.next();

		System.out.println("Ingrese apellido del cliente: ");
		String apellidoCliente = scanner.next();

		System.out.println("Ingrese años como cliente: ");
		String aniosCliente = scanner.next();

		Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente);

		setListaClientes(cliente);

		return cliente;
	}

	public void editarCliente() {

		int opcion;

		System.out.println("-------------Editar Cliente-------------\n");
		System.out.println("Seleccione qué desea hacer: \n" + "1.-Cambiar el estado del Cliente \n"
				+ "2.-Editar los datos ingresados del Cliente \n" + "Ingrese opcion: ");
		System.out.println("----------------------------------------");

		try {

			opcion = scanner.nextInt();

			if (opcion == 1) {

				Cliente cliente = buscarRun();

				if (cliente == null) {

					System.out.println("Cliente no existe");

				} else {

					System.out.println(" -----Actualizando estado del Cliente----\n");
					System.out.println("El estado actual es: " + cliente.getNombreCategoria());
					System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo\n"
							+ "2.-Si desea mantener el estado del cliente Activo\n " + "Ingrese opcion:");
					System.out.println("----------------------------------------");

					opcion = scanner.nextInt();

					switch (opcion) {
					case 1:
						cliente.setNombreCategoria(CategoríaEnum.INACTIVO);
						System.out.println("Nuevo estado: " + cliente.getNombreCategoria());
						break;
					case 2:
						System.out.println("Nuevo estado: " + cliente.getNombreCategoria());
						cliente.setNombreCategoria(CategoríaEnum.ACTIVO);
						break;
					default:
						System.out.println("Opción inválida... vuelva a intentarlo.");
						break;
					}

				}

			} else if (opcion == 2) {

				Cliente cliente = buscarRun();

				if (cliente == null) {
					System.out.println("Cliente no existe");
				} else {
					System.out.println("----Actualizando datos del Cliente-----");
					System.out.println("1.-El RUN del Cliente es: " + cliente.getRunCliente());
					System.out.println("2.-El Nombre del Cliente es: " + cliente.getNombreCliente());
					System.out.println("3.-El Apellido del Cliente es: " + cliente.getApellidoCliente());
					System.out.println("4.-Los años como Cliente son: " + cliente.getAniosCliente());
					System.out.println("Ingrese opcion a editar de los datos del cliente: ");
					System.out.println("----------------------------------------");

					opcion = scanner.nextInt();

					switch (opcion) {
					case 1:
						System.out.println("1.-Ingrese nuevo RUN del cliente: ");
						String nuevoRut = scanner.next();
						cliente.setRunCliente(nuevoRut);
						System.out.println("Datos cambiados con éxito");
						break;
					case 2:
						System.out.println("1.-Ingrese nuevo nombre del cliente: ");
						String nuevoNombre = scanner.next();
						cliente.setNombreCliente(nuevoNombre);
						System.out.println("Datos cambiados con éxito");
						break;
					case 3:
						System.out.println("1.-Ingrese nuevo apellido del cliente: ");
						String nuevoApellido = scanner.next();
						cliente.setApellidoCliente(nuevoApellido);
						System.out.println("Datos cambiados con éxito");
						break;
					case 4:
						System.out.println("1.-Ingrese nuevo año como cliente: ");
						String nuevoAño = scanner.next();
						cliente.setAniosCliente(nuevoAño);
						System.out.println("Datos cambiados con éxito");
						break;
					default:
						System.out.println("Opción ingresada inválida");
						break;
					}
				}
			} else {
				System.out.println("Opción ingresada inválida");
			}

		} catch (Exception e) {
			e.getMessage();
		}

	}

	private Cliente buscarRun() {

		System.out.println("Ingrese RUN del Cliente a editar: ");
		String runCliente = scanner.next();

		for (int i = 0; i < listaDatos.getListaClientes().size(); i++) {

			if (listaDatos.getListaClientes().get(i).getRunCliente().equals(runCliente)) {

				return listaDatos.getListaClientes().get(i);

			}
		}

		return null;
	}

	public List<Cliente> getListaClientes() {
		return listaDatos.getListaClientes();
	}

	public void setListaClientes(Cliente cliente) {

		listaDatos.agregarClientesSingleton(cliente);
		System.out.println("Datos cargados correctamente en la lista");

	}

}
