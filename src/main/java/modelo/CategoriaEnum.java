package modelo;

public enum CategoriaEnum {

	ACTIVO("Activo"), INACTIVO("Inactivo");

	private String text;
	
	CategoriaEnum(String text) {
		this.text = text;
	}
	
	public String getText() {
        return this.text;
    }
	
	public static CategoriaEnum fromString(String text) {
        for (CategoriaEnum estado : CategoriaEnum.values()) {
            if (estado.text.equalsIgnoreCase(text)) {
                return estado;
            }
        }
        return null;
    }
}
