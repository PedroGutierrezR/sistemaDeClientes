package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Cliente;

public class ArchivoServicio extends Exportador {

	private Scanner scanner = new Scanner(System.in);
	private ExportadorCsv exportadorCsv = new ExportadorCsv();
	private ExportadorTxt exportadorTxt = new ExportadorTxt();
	private ClienteServicio clienteServicio = new ClienteServicio();
	private List<Cliente> lista = new ArrayList<Cliente>();
	private Cliente cliente;
	
	public void cargarDatos(String fileName1) {
		
		System.out.println("---------Cargar Datos---------------");
		System.out.println("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
		
		String ruta = scanner.next();

		try {
			File archivo = new File(ruta + "/" + fileName1);
			BufferedReader br = new BufferedReader(new FileReader(archivo));

			String lineas;
			
			while ((lineas = br.readLine()) != null) {

				String[] datosClientes = lineas.split(",");
				String run = datosClientes[0];
				Boolean confirmacion = false;				
				lista = clienteServicio.getListaClientes();
				
				for(int i = 0; i < lista.size(); i++) {
					
					String verificacion = lista.get(i).getRunCliente();
					
					if(verificacion == run) {
						confirmacion = true;
					}
					
				}
				
				if (confirmacion) {
					System.out.println("Cliente ya existe");
				} else {
					cliente = new Cliente(datosClientes[0], datosClientes[1], datosClientes[2],
							datosClientes[3]);
					clienteServicio.setListaClientes(cliente);
				}
			}
	
			br.close();
			
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}

	}

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		
		System.out.println("---------Exportar Datos-----------");
		System.out.println("Seleccione el formato a exportar:\n"
				+ "1.-Formato csv\n"
				+ "2.-Formato txt");
		System.out.println("Ingrese una opción para exportar: ");
		int opcion = scanner.nextInt();
		if(opcion == 1) {
			exportadorCsv.exportar(fileName, listaClientes);
		} else if (opcion == 2) {
			exportadorTxt.exportar(fileName, listaClientes);
		}
		
	}

}
