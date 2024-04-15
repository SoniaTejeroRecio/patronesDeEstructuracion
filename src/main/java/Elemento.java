interface Elemento {
    double getPrecio();
    int getCodigo();
}

class ElementoConcreto implements Elemento {
    private int codigo;
    private double precio;

    public ElementoConcreto(int codigo, double precio) {
        this.codigo = codigo;
        this.precio = precio;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public int getCodigo() {
        return codigo;
    }
}