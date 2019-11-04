package ar.unsam.spcdp.app;

import ar.unsam.spcdp.lugar.Lugar;
import ar.unsam.spcdp.transicion.Transicion;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class App {
  private List<Lugar> lugares = CollectionLiterals.<Lugar>newArrayList();
  
  private List<Transicion> transiciones = CollectionLiterals.<Transicion>newArrayList();
  
  public static void main(final String[] args) {
    System.out.println("Hello World! hola");
  }
}
