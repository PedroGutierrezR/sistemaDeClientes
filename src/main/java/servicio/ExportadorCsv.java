package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.Cliente;

public class ExportadorCsv extends Exportador{

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		
		File archivo = new File(fileName + ".csv");
		
		if(!archivo.exists()) {
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
			}
			System.out.println("Datos de clientes exportados correctamente en formato csv.");
			bw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

	
	
}
