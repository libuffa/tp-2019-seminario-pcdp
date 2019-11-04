package ar.unsam.spcdp.app

import ar.unsam.spcdp.lugar.Lugar
import ar.unsam.spcdp.transicion.Transicion
import java.util.List
import java.util.Random

class App {
	
	List<Lugar> lugares = newArrayList
	int marcaMaxima
	
	def redHabilitada() {
		this.lugares.exists[lugar | lugar.transicionHabilitada]
	}
	
	static def void main( String[] args ){
		var app = new App
		var p1 = new Lugar => [
			it.id = 1
			it.input = 1
			it.marcas = 3
		]
		var p2 = new Lugar => [
			it.id = 2
			it.input = 1
			it.marcas = 2
		]
		var p3 = new Lugar => [
			it.id = 3
			it.input = 1
			it.marcas = 3
		]
		var t1 = new Transicion => [
			it.id = 1
			it.marcaHabilitada = 1
		]
		t1.lugares.add(p2)
		var t2 = new Transicion => [
			it.id = 2
			it.marcaHabilitada = 1
		]
		t2.lugares.add(p3)
//		var t3 = new Transicion => [
//			it.id = 3
//			it.marcaHabilitada = 1
//		]
		p1.output = t1
		p2.output = t2
		
		app.lugares = #[p1, p2, p3]
        while(app.redHabilitada) {
        	val random = new Random().nextInt(3) + 1
        	var lugar = app.lugares.findFirst[lugar | lugar.id == random]
        	lugar.transicionar
        	app.lugares.forEach[_lugar | println("Lugar: P" + _lugar.id + " - Marcas: " + _lugar.marcas)]
        	var marcaMaxima = app.lugares.maxBy[_lugar | _lugar.marcas].marcas
        	if(marcaMaxima > app.marcaMaxima) {
        		app.marcaMaxima = marcaMaxima
        	}
        	println("")
        }
        println("Fin del programa: ")
        println("")
        app.lugares.forEach[lugar | println("Lugar: P" + lugar.id + " - Marcas: " + lugar.marcas)]
        println("La red de petri es " + app.marcaMaxima + "-acoplada")
    }
	
}