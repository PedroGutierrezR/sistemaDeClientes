package servicio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import datos.Datos;
import modelo.Cliente;

public class ExportadorCsv extends Exportador {

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {

		File archivo = new File(fileName + ".csv");

		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
				System.out.println("Archivo creado");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

//		List<Cliente> listaFiltradaDeClientes =	leerAntesDeExportar(fileName);

		try {
			FileWriter fw = new FileWriter(archivo, true);
			BufferedWriter bw = new BufferedWriter(fw);

			for (Cliente cliente : listaClientes) {
				bw.append(cliente.getRunCliente() + ",");
				bw.append(cliente.getNombreCliente() + ",");
				bw.append(cliente.getApellidoCliente() + ",");
				bw.append(cliente.getAniosCliente() + ";");
				bw.append(cliente.getNombreCategoriaString());
				bw.append("\n");
			}
			System.out.println("Datos de clientes exportados correctamente en formato csv.");
			bw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public List<Cliente> leerAntesDeExportar(String fileName) {

		List<Cliente> listaFiltradaClientes = new ArrayList<Cliente>();
		File leerArchivo = new File(fileName + ".csv");
		
		try {
			FileReader fr = new FileReader(leerArchivo);
			BufferedReader br = new BufferedReader(fr);

			String lineas;

			while ((lineas = br.readLine()) != null) {

				String[] datosClientes = lineas.split(",");
				String run = datosClientes[0];
				boolean confirmacion = false;
				List<Cliente> lista = Datos.getInstancia().getListaClientes();

				for (int i = 0; i < lista.size(); i++) {

					String verificacion = lista.get(i).getRunCliente();

					if (verificacion.equals(run)) {
						confirmacion = true;
					}

				}

				if (confirmacion == false) {
					Cliente cliente = new Cliente(datosClientes[0], datosClientes[1], datosClientes[2],
							datosClientes[3]);
					listaFiltradaClientes.add(cliente);
				}
			}

			br.close();

		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
		return listaFiltradaClientes;
	}
}
