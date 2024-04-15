import java.util.ArrayList;
import java.util.List;

class ContenedorElementos implements Elemento {
    private List<Elemento> elementos;
    private int codigo;

    public ContenedorElementos(int codigo) {
        this.codigo = codigo;
        this.elementos = new ArrayList<>();
    }

    public void agregarElemento(Elemento elemento) {
        elementos.add(elemento);
    }

    public void eliminarElemento(Elemento elemento) {
        elementos.remove(elemento);
    }

    @Override
    public double getPrecio() {
        return elementos.stream().mapToDouble(Elemento::getPrecio).sum() * 0.9; // Aplica un descuento del 10%
    }

    @Override
    public int getCodigo() {
        return codigo;
    }
}