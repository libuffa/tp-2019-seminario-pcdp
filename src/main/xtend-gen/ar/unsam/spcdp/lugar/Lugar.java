package ar.unsam.spcdp.lugar;

import ar.unsam.spcdp.transicion.Transicion;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class Lugar {
  private int marcas;
  
  private List<Transicion> transiciones = CollectionLiterals.<Transicion>newArrayList();
}
