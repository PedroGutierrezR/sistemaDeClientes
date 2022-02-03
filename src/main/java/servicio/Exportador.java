package servicio;

import java.util.List;

import modelo.Cliente;

/*
Hint: Los pasos 8, 9 y 10 buscan tener una clase abstracta (Exportador), con un solo
método exportar, cuyas clases ExportadorCsv y ExportadorTxt extienden de esta
clase e implementan su método. Por lo tanto, los métodos declarados serán
pertenecientes a cada Exportador bajo el concepto de herencia. Al utilizarlo, se
instancia alguno de los exportadores en la clase menu ocupando polimorfismo
 */

public abstract class Exportador {

	abstract void exportar(String fileName, List<Cliente> listaClientes);

}
