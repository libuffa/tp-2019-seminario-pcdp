package ar.unsam.spcdp.transicion

import ar.unsam.spcdp.lugar.Lugar
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Transicion {

	int id
	List<Lugar> lugares = newArrayList
	int marcaHabilitada = 1

	def transicionar() {
		lugares.forEach[_lugar|_lugar.recibirTransicion]
	}

}
