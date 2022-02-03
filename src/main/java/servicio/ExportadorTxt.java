package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.Cliente;

public class ExportadorTxt extends Exportador {

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {

		File archivo = new File(fileName + ".txt");

		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
				System.out.println("Archivo creado");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

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
			System.out.println("Datos de clientes exportados correctamente en formato txt.");
			bw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

}
