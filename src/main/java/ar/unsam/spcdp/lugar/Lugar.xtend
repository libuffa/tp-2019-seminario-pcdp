package ar.unsam.spcdp.lugar

import ar.unsam.spcdp.transicion.Transicion
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Lugar {

	int marcas
	Integer input
	Transicion output

	def transicionar() {
		output.transicionar(this)
	}

	def recibirTransicion() {
		if(input !== null) marcas += input
	}

	def restarMarcas() {
		marcas -= output.marcaHabilitada
	}

}
