import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SistemaGestion {
    private static Scanner scanner = new Scanner(System.in);
    private static ContenedorElementos contenedorPrincipal = new ContenedorElementos(1);

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            try {
                System.out.println("1. Agregar Elemento");
                System.out.println("2. Eliminar Elemento");
                System.out.println("3. Mostrar Elementos");
                System.out.println("4. Mostrar Precio Total del Kit");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Consumir el salto de línea pendiente
                switch (opcion) {
                    case 1:
                        agregarElemento();
                        break;
                    case 2:
                        eliminarElemento();
                        break;
                    case 3:
                        mostrarElementos();
                        break;
                    case 4:
                        mostrarPrecioTotal();
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida, por favor intente de nuevo.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Entrada inválida. Por favor ingrese números solamente.");
                scanner.nextLine(); // Clear buffer
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Clear buffer if needed
            }
        }
    }

    private static void agregarElemento() {
        try {
            System.out.print("Ingrese código del nuevo elemento: ");
            int codigo = scanner.nextInt();
            System.out.print("Ingrese precio del nuevo elemento: ");
            double precio = scanner.nextDouble();
            if (precio < 0) {
                throw new IllegalArgumentException("El precio no puede ser negativo.");
            }
            ElementoConcreto nuevoElemento = new ElementoConcreto(codigo, precio);
            contenedorPrincipal.agregarElemento(nuevoElemento);
            System.out.println("Elemento agregado exitosamente.");
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Se esperaba un número. Intente de nuevo.");
        } catch (IllegalStateException e) {
            throw new IllegalStateException("Ya existe un elemento con este código.");
        }
    }

    private static void eliminarElemento() {
        try {
            System.out.print("Ingrese código del elemento a eliminar: ");
            int codigo = scanner.nextInt();
            Elemento elementoAEliminar = contenedorPrincipal.getElementos().stream()
                    .filter(e -> e.getCodigo() == codigo)
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("Elemento no encontrado."));
            contenedorPrincipal.eliminarElemento(elementoAEliminar);
            System.out.println("Elemento eliminado exitosamente.");
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("No se encontró el elemento con el código proporcionado.");
        }
    }

    private static void mostrarElementos() {
        if (contenedorPrincipal.getElementos().isEmpty()) {
            System.out.println("No hay elementos en el kit.");
        } else {
            System.out.println("Elementos en el kit:");
            contenedorPrincipal.getElementos().forEach(e ->
                    System.out.println("Código: " + e.getCodigo() + ", Precio: " + e.getPrecio()));
        }
    }

    private static void mostrarPrecioTotal() {
        System.out.println("Precio total del kit con descuento: " + contenedorPrincipal.getPrecio());
    }
}
