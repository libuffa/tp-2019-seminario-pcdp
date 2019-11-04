package ar.unsam.spcdp.transicion

import ar.unsam.spcdp.lugar.Lugar
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Transicion {

	List<Lugar> lugares = newArrayList
	int marcaHabilitada

	def transicionar(Lugar lugar) {
		if (lugar.marcas >= this.marcaHabilitada) {
			lugares.forEach[_lugar|_lugar.recibirTransicion]
			lugar.restarMarcas
		}
	}

}
