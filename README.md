# patronesDeEstructuracion_SoniaTejeroRecio


_**Antes de empezar, me gustaría decir que he realizado esta entrega centrándome en los principios SOLID y teniendo muy en cuenta en principio de responsabilidad única.**_




_**Además, he utilizado patrones de diseño estructurales, para ser más exactos "Composite".**_




_**Gracias a ello he logrado realizar un programa con la mayor abstracción posible.**_


## ¿Cómo he estructurado el proyecto?
He realizado el ejercicio propuesto además he realizado un JAVADOC y un diagrama de clases. 


## Comenzamos 🚀


Es importante recalcar que todos los bloques de código se han realizado utilizando el lenguaje de programación **Java**.


### Indice 📋
_Cómo he estructurado y desarrollado la tarea:_


```
📌Ejercicio 1
PSEUDOCÓDIGO:
INTERFAZ Elemento
    FUNCIÓN getPrecio() RETORNA real
    FUNCIÓN getCodigo() RETORNA entero

CLASE ElementoConcreto IMPLEMENTA Elemento
    PRIVADO entero codigo
    PRIVADO real precio

    CONSTRUCTOR ElementoConcreto(codigo: entero, precio: real)
        ASIGNAR codigo A this.codigo
        ASIGNAR precio A this.precio

    FUNCIÓN getPrecio() RETORNA precio
    FUNCIÓN getCodigo() RETORNA codigo

CLASE ContenedorElementos IMPLEMENTA Elemento
    PRIVADO LISTA DE Elemento elementos
    PRIVADO entero codigo

    CONSTRUCTOR ContenedorElementos(codigo: entero)
        ASIGNAR codigo A this.codigo
        INICIALIZAR elementos COMO nueva lista vacía

    FUNCIÓN agregarElemento(elemento: Elemento)
        AÑADIR elemento A elementos

    FUNCIÓN eliminarElemento(elemento: Elemento)
        REMOVER elemento DE elementos

    FUNCIÓN getPrecio() RETORNA 90% del sumatorio de getPrecio() de todos los elementos en la lista
    FUNCIÓN getCodigo() RETORNA codigo

    FUNCIÓN getElementos() RETORNA copia nueva de elementos

CLASE SistemaGestion
    PRIVADO static Scanner scanner = nuevo Scanner
    PRIVADO static ContenedorElementos contenedorPrincipal = nuevo ContenedorElementos(1)

    FUNCIÓN PRINCIPAL(args: arreglo de Cadena)
        VARIABLE salir = falso

        MIENTRAS NO salir
            IMPRIMIR "1. Agregar Elemento"
            IMPRIMIR "2. Eliminar Elemento"
            IMPRIMIR "3. Mostrar Elementos"
            IMPRIMIR "4. Mostrar Precio Total del Kit"
            IMPRIMIR "5. Salir"
            IMPRIMIR "Seleccione una opción: "
            LEER opción de scanner

            SEGÚN opción
                CASO 1:
                    LLAMAR agregarElemento()
                CASO 2:
                    LLAMAR eliminarElemento()
                CASO 3:
                    LLAMAR mostrarElementos()
                CASO 4:
                    LLAMAR mostrarPrecioTotal()
                CASO 5:
                    ASIGNAR verdadero A salir
                DEFECTO:
                    IMPRIMIR "Opción inválida, por favor intente de nuevo."

    FUNCIÓN agregarElemento()
        IMPRIMIR "Ingrese código del nuevo elemento: "
        LEER codigo de scanner
        IMPRIMIR "Ingrese precio del nuevo elemento: "
        LEER precio de scanner
        CREAR nuevoElemento = nuevo ElementoConcreto(codigo, precio)
        AGREGAR nuevoElemento A contenedorPrincipal
        IMPRIMIR "Elemento agregado exitosamente."

    FUNCIÓN eliminarElemento()
        IMPRIMIR "Ingrese código del elemento a eliminar: "
        LEER codigo de scanner
        BUSCAR elementoAEliminar en contenedorPrincipal donde getCodigo() es igual a codigo
        SI elementoAEliminar no es nulo
            ELIMINAR elementoAEliminar de contenedorPrincipal
            IMPRIMIR "Elemento eliminado exitosamente."
        SI NO
            IMPRIMIR "Elemento no encontrado."

    FUNCIÓN mostrarElementos()
        SI contenedorPrincipal.getElementos() está vacío
            IMPRIMIR "No hay elementos en el kit."
        SI NO
            IMPRIMIR "Elementos en el kit:"
            PARA CADA elemento en contenedorPrincipal.getElementos()
                IMPRIMIR "Código: " + getCodigo() de elemento + ", Precio: " + getPrecio() de elemento

    FUNCIÓN mostrarPrecioTotal()
        IMPRIMIR "Precio total del kit con descuento: " + getPrecio() de contenedorPrincipal


📌Javadoc 


📌Recursos necesarios para la corrección


📌Autor
```




## Ejercicio 1📄
Para la realización de este ejrcicio, la parte visual para el usuario, he realizado un menú siguiendo las operaciones CRUD (Crear, Leer, Actualizar, Borrar) operaciones que son propias para los sistemas de gestión de información con sus consiguinetes excepciones. 

Para cumplir con este requisito he realizado un menú que responde a las operaciones CRUD, en este menú el usuario podrña elegir entre las distintas opciones:
```
1. Agregar Elemento
2. Eliminar Elemento
3. Mostrar Elementos
4. Mostrar Precio Total del Kit
5. Salir
```

**Para la elaboración de este programa he utilizado el patrón de diseño: COMPOSITE**

En la carpeta del ejercicio encontrará el código, test unitarios además de un diagrama de clases para una mejor visualización del mismo.

## Corrección 🖇️
_Link a codespace:_ [codespace_de_Sonia](https://codespaces.new/SoniaTejeroRecio/patronesDeEstructuracion)




_Link a repositorio de github:_ [repositorio](https://github.com/SoniaTejeroRecio/patronesDeEstructuracion.git)




## Autores ✒️
* **Sonia Tejero Recio** - *Trabajo completo*
