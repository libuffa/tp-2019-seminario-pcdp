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
  private List<Lugar> lugares = CollectionLiterals.<Lugar>newArrayList();
  
  private int marcaHabilitada;
  
  public int transicionar(final Lugar lugar) {
    int _xifexpression = (int) 0;
    int _marcas = lugar.getMarcas();
    boolean _greaterEqualsThan = (_marcas >= this.marcaHabilitada);
    if (_greaterEqualsThan) {
      int _xblockexpression = (int) 0;
      {
        final Consumer<Lugar> _function = new Consumer<Lugar>() {
          public void accept(final Lugar _lugar) {
            _lugar.recibirTransicion();
          }
        };
        this.lugares.forEach(_function);
        _xblockexpression = lugar.restarMarcas();
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
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
