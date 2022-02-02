package modelo;

public class Cliente {

	/*
	 * 
	 * ● Generar el constructor con parámetros ● Generar los getter y setter
	 * correspondientes ● Generar el toString para los parámetros
	 */

	private String runCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private int aniosCliente;
	private CategoríaEnum nombreCategoria;

	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, int aniosCliente,
			CategoríaEnum nombreCategoria) {
		super();
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente = aniosCliente;
		this.nombreCategoria = nombreCategoria;
	}

	public String getRunCliente() {
		return runCliente;
	}

	public void setRunCliente(String runCliente) {
		this.runCliente = runCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public int getAniosCliente() {
		return aniosCliente;
	}

	public void setAniosCliente(int aniosCliente) {
		this.aniosCliente = aniosCliente;
	}

	public CategoríaEnum getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(CategoríaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	@Override
	public String toString() {
		return "Cliente [runCliente=" + runCliente + ", nombreCliente=" + nombreCliente + ", apellidoCliente="
				+ apellidoCliente + ", aniosCliente=" + aniosCliente + ", nombreCategoria=" + nombreCategoria + "]";
	}

}
