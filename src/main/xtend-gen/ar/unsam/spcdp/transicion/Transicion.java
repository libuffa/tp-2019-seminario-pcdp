package ar.unsam.spcdp.transicion;

import ar.unsam.spcdp.lugar.Lugar;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Transicion {
  private int id;
  
  private List<Lugar> lugares = CollectionLiterals.<Lugar>newArrayList();
  
  private int marcaHabilitada = 1;
  
  public void transicionar() {
    final Consumer<Lugar> _function = new Consumer<Lugar>() {
      public void accept(final Lugar _lugar) {
        _lugar.recibirTransicion();
      }
    };
    this.lugares.forEach(_function);
  }
  
  @Pure
  public int getId() {
    return this.id;
  }
  
  public void setId(final int id) {
    this.id = id;
  }
  
  @Pure
  public List<Lugar> getLugares() {
    return this.lugares;
  }
  
  public void setLugares(final List<Lugar> lugares) {
    this.lugares = lugares;
  }
  
  @Pure
  public int getMarcaHabilitada() {
    return this.marcaHabilitada;
  }
  
  public void setMarcaHabilitada(final int marcaHabilitada) {
    this.marcaHabilitada = marcaHabilitada;
  }
}
