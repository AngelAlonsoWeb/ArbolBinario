public class Main {
    public static void main(String[] args) {
        ABB arbol = new ABB();

        Nodo raizArbolABB = arbol.regresaRaiz();

        //25, 8, 29, 38, 27
        arbol.insertarValor(25);
        arbol.insertarValor(8);
        arbol.insertarValor(29);
        arbol.insertarValor(38);
        arbol.insertarValor(27);

        System.out.println("Nodo raiz: " + arbol.regresaRaiz().dato);
        arbol.muestraAcostado(0, arbol.regresaRaiz());
        // Imprimir el árbol de forma horizontal
        System.out.println("Árbol de forma horizontal:");
        arbol.imprimirHorizontal();

        // Buscar un nodo
        int valorBuscado = 29;
        Nodo nodoBuscado = arbol.buscar(valorBuscado);
        if (nodoBuscado != null) {
            System.out.println("Nodo encontrado: " + nodoBuscado.dato);
        } else {
            System.out.println("Nodo no encontrado.");
        }

        // Recorrer el árbol en preorden
        System.out.println("Recorrido en preorden:");
        arbol.preorden();

        // Recorrer el árbol en inorden
        System.out.println("Recorrido en inorden:");
        arbol.inorden();

        // Recorrer el árbol en postorden
        System.out.println("Recorrido en postorden:");
        arbol.postorden();

        // Eliminar un nodo
        int valorAEliminar = 29;
        arbol.eliminar(valorAEliminar);
        System.out.println("Árbol después de eliminar el nodo con valor " + valorAEliminar + ":");
        arbol.imprimirHorizontal();
    }
}