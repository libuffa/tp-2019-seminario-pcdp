package ar.unsam.spcdp.lugar;

import ar.unsam.spcdp.transicion.Transicion;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class Lugar {
  private int id;
  
  private int marcas;
  
  private Integer input = Integer.valueOf(1);
  
  private Transicion output;
  
  public int transicionar() {
    int _xifexpression = (int) 0;
    boolean _transicionHabilitada = this.transicionHabilitada();
    if (_transicionHabilitada) {
      int _xblockexpression = (int) 0;
      {
        this.output.transicionar();
        _xblockexpression = this.restarMarcas();
      }
      _xifexpression = _xblockexpression;
    }
    return _xifexpression;
  }
  
  public int recibirTransicion() {
    int _xifexpression = (int) 0;
    if ((this.input != null)) {
      int _marcas = this.marcas;
      _xifexpression = this.marcas = (_marcas + (this.input).intValue());
    }
    return _xifexpression;
  }
  
  public int restarMarcas() {
    int _marcas = this.marcas;
    int _marcaHabilitada = this.output.getMarcaHabilitada();
    return this.marcas = (_marcas - _marcaHabilitada);
  }
  
  public boolean transicionHabilitada() {
    boolean _xifexpression = false;
    if ((this.output != null)) {
      int _marcaHabilitada = this.output.getMarcaHabilitada();
      _xifexpression = (this.marcas >= _marcaHabilitada);
    } else {
      _xifexpression = false;
    }
    return _xifexpression;
  }
  
  @Pure
  public int getId() {
    return this.id;
  }
  
  public void setId(final int id) {
    this.id = id;
  }
  
  @Pure
  public int getMarcas() {
    return this.marcas;
  }
  
  public void setMarcas(final int marcas) {
    this.marcas = marcas;
  }
  
  @Pure
  public Integer getInput() {
    return this.input;
  }
  
  public void setInput(final Integer input) {
    this.input = input;
  }
  
  @Pure
  public Transicion getOutput() {
    return this.output;
  }
  
  public void setOutput(final Transicion output) {
    this.output = output;
  }
}
