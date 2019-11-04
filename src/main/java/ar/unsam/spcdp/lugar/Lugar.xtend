package ar.unsam.spcdp.lugar

import ar.unsam.spcdp.transicion.Transicion
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Lugar {

	int id
	int marcas
	Integer input = 1
	Transicion output

	def transicionar() {
		if(this.transicionHabilitada) {
			output.transicionar()
			this.restarMarcas
		}
	}

	def recibirTransicion() {
		if(input !== null) marcas += input
	}

	def restarMarcas() {
		marcas -= output.marcaHabilitada
	}
	
	def transicionHabilitada() {
		if(this.output !== null) {
			marcas >= this.output.marcaHabilitada
		} else {
			false
		}
	}

}
