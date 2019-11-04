package ar.unsam.spcdp.app;

import ar.unsam.spcdp.lugar.Lugar;
import ar.unsam.spcdp.transicion.Transicion;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class App {
  private List<Lugar> lugares = CollectionLiterals.<Lugar>newArrayList();
  
  private int marcaMaxima;
  
  public boolean redHabilitada() {
    final Function1<Lugar, Boolean> _function = new Function1<Lugar, Boolean>() {
      public Boolean apply(final Lugar lugar) {
        return Boolean.valueOf(lugar.transicionHabilitada());
      }
    };
    return IterableExtensions.<Lugar>exists(this.lugares, _function);
  }
  
  public static void main(final String[] args) {
    App app = new App();
    Lugar _lugar = new Lugar();
    final Procedure1<Lugar> _function = new Procedure1<Lugar>() {
      public void apply(final Lugar it) {
        it.setId(1);
        it.setInput(Integer.valueOf(1));
        it.setMarcas(3);
      }
    };
    Lugar p1 = ObjectExtensions.<Lugar>operator_doubleArrow(_lugar, _function);
    Lugar _lugar_1 = new Lugar();
    final Procedure1<Lugar> _function_1 = new Procedure1<Lugar>() {
      public void apply(final Lugar it) {
        it.setId(2);
        it.setInput(Integer.valueOf(1));
        it.setMarcas(2);
      }
    };
    Lugar p2 = ObjectExtensions.<Lugar>operator_doubleArrow(_lugar_1, _function_1);
    Lugar _lugar_2 = new Lugar();
    final Procedure1<Lugar> _function_2 = new Procedure1<Lugar>() {
      public void apply(final Lugar it) {
        it.setId(3);
        it.setInput(Integer.valueOf(1));
        it.setMarcas(3);
      }
    };
    Lugar p3 = ObjectExtensions.<Lugar>operator_doubleArrow(_lugar_2, _function_2);
    Transicion _transicion = new Transicion();
    final Procedure1<Transicion> _function_3 = new Procedure1<Transicion>() {
      public void apply(final Transicion it) {
        it.setId(1);
        it.setMarcaHabilitada(1);
      }
    };
    Transicion t1 = ObjectExtensions.<Transicion>operator_doubleArrow(_transicion, _function_3);
    t1.getLugares().add(p2);
    Transicion _transicion_1 = new Transicion();
    final Procedure1<Transicion> _function_4 = new Procedure1<Transicion>() {
      public void apply(final Transicion it) {
        it.setId(2);
        it.setMarcaHabilitada(1);
      }
    };
    Transicion t2 = ObjectExtensions.<Transicion>operator_doubleArrow(_transicion_1, _function_4);
    t2.getLugares().add(p3);
    p1.setOutput(t1);
    p2.setOutput(t2);
    app.lugares = Collections.<Lugar>unmodifiableList(CollectionLiterals.<Lugar>newArrayList(p1, p2, p3));
    while (app.redHabilitada()) {
      {
        int _nextInt = new Random().nextInt(3);
        final int random = (_nextInt + 1);
        final Function1<Lugar, Boolean> _function_5 = new Function1<Lugar, Boolean>() {
          public Boolean apply(final Lugar lugar) {
            int _id = lugar.getId();
            return Boolean.valueOf((_id == random));
          }
        };
        Lugar lugar = IterableExtensions.<Lugar>findFirst(app.lugares, _function_5);
        lugar.transicionar();
        final Consumer<Lugar> _function_6 = new Consumer<Lugar>() {
          public void accept(final Lugar _lugar) {
            int _id = _lugar.getId();
            String _plus = ("Lugar: P" + Integer.valueOf(_id));
            String _plus_1 = (_plus + " - Marcas: ");
            int _marcas = _lugar.getMarcas();
            String _plus_2 = (_plus_1 + Integer.valueOf(_marcas));
            InputOutput.<String>println(_plus_2);
          }
        };
        app.lugares.forEach(_function_6);
        final Function1<Lugar, Integer> _function_7 = new Function1<Lugar, Integer>() {
          public Integer apply(final Lugar _lugar) {
            return Integer.valueOf(_lugar.getMarcas());
          }
        };
        int marcaMaxima = IterableExtensions.<Lugar, Integer>maxBy(app.lugares, _function_7).getMarcas();
        if ((marcaMaxima > app.marcaMaxima)) {
          app.marcaMaxima = marcaMaxima;
        }
        InputOutput.<String>println("");
      }
    }
    InputOutput.<String>println("Fin del programa: ");
    InputOutput.<String>println("");
    final Consumer<Lugar> _function_5 = new Consumer<Lugar>() {
      public void accept(final Lugar lugar) {
        int _id = lugar.getId();
        String _plus = ("Lugar: P" + Integer.valueOf(_id));
        String _plus_1 = (_plus + " - Marcas: ");
        int _marcas = lugar.getMarcas();
        String _plus_2 = (_plus_1 + Integer.valueOf(_marcas));
        InputOutput.<String>println(_plus_2);
      }
    };
    app.lugares.forEach(_function_5);
    InputOutput.<String>println((("La red de petri es " + Integer.valueOf(app.marcaMaxima)) + "-acoplada"));
  }
}
