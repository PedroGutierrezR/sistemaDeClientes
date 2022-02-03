package modelo;

public class Cliente {

	private String runCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String aniosCliente;
	private CategoríaEnum nombreCategoria;

	public Cliente(String runCliente, String nombreCliente, String apellidoCliente, String aniosCliente) {
		super();
		this.runCliente = runCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.aniosCliente = aniosCliente;
		this.nombreCategoria = CategoríaEnum.ACTIVO;
	}
	
	public Cliente() {
		super();
		
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

	public String getAniosCliente() {
		return aniosCliente;
	}

	public void setAniosCliente(String aniosCliente) {
		this.aniosCliente = aniosCliente;
	}

	public CategoríaEnum getNombreCategoria() {
		return nombreCategoria;
	}
	
	public String getNombreCategoriaString() {
		
		String nombreCategoriaString = nombreCategoria.toString();
		
		return nombreCategoriaString;
	}

	public void setNombreCategoria(CategoríaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	@Override
	public String toString() {
		return "RUN del Cliente: " + runCliente + "\nNombre del Cliente: " + nombreCliente + "\nApellido del Cliente: "
				+ apellidoCliente + "\nAños como Cliente: " + aniosCliente + "\nCategoría del Cliente: " + nombreCategoria;
	}

}
