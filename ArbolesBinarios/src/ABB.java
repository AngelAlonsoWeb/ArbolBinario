public class ABB{   		//Java Beans
    private Nodo raiz;  //null

    ABB(){
        this.raiz = null;
    }

    public boolean esVacio(){
        return (this.raiz == null);
    }

    public Nodo regresaRaiz(){   //getRaiz  -- getter de atributo raiz
        return this.raiz;
    }

    public void insertarValor(int valor){
        if (this.raiz == null){
            System.out.println("Insertando raiz: " + valor);
            this.raiz = new Nodo();
            this.raiz.dato = valor;
            this.raiz.izquierdo = null;
            this.raiz.derecho = null;
        }
        else insertarNodo(valor, this.raiz);
    }

    public void insertarNodo(int valor, Nodo nodoRef){
        if (valor <= nodoRef.dato) {
            if (nodoRef.izquierdo == null){
                System.out.println("Insertando hijo izquierdo de: "  + nodoRef.dato + ": " + valor);
                nodoRef.izquierdo =  new Nodo();
                nodoRef.izquierdo.dato = valor;
                nodoRef.izquierdo.izquierdo = null;
                nodoRef.izquierdo.derecho = null;
            }
            else {
                insertarNodo(valor, nodoRef.izquierdo);
            }
        }
        else {
            if (valor > nodoRef.dato) {
                if (nodoRef.derecho == null){
                    System.out.println("Insertando hijo derecho de: " + nodoRef.dato + ": " + valor);
                    nodoRef.derecho =  new Nodo();
                    nodoRef.derecho.dato = valor;
                    nodoRef.derecho.izquierdo = null;
                    nodoRef.derecho.derecho = null;
                }
                else {
                    insertarNodo(valor, nodoRef.derecho);
                }
            }
        }
    }


    public void muestraAcostado(int nivel, Nodo nodoRef){
        if (nodoRef == null){
            return;
        }
        else {
            muestraAcostado(nivel + 1, nodoRef.derecho);

            for (int i=0; i < nivel; i++){
                System.out.print("   ");
            }

            System.out.println(nodoRef.dato);
            muestraAcostado(nivel + 1, nodoRef.izquierdo);
        }
    }

    public void imprimirHorizontal() {
        imprimirHorizontalRec(raiz, 0);
    }

    private void imprimirHorizontalRec(Nodo nodo, int nivel) {
        if (nodo != null) {
            imprimirHorizontalRec(nodo.derecho, nivel + 1);

            for (int i = 0; i < nivel; i++)
                System.out.print("   ");

            System.out.println(nodo.dato);

            imprimirHorizontalRec(nodo.izquierdo, nivel + 1);
        }
    }public Nodo buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private Nodo buscarRec(Nodo nodo, int valor) {
        if (nodo == null || nodo.dato == valor)
            return nodo;

        if (valor < nodo.dato)
            return buscarRec(nodo.izquierdo, valor);

        return buscarRec(nodo.derecho, valor);
    }

    public void preorden() {
        preordenRec(raiz);
        System.out.println();
    }

    private void preordenRec(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            preordenRec(nodo.izquierdo);
            preordenRec(nodo.derecho);
        }
    }

    public void inorden() {
        inordenRec(raiz);
        System.out.println();
    }

    private void inordenRec(Nodo nodo) {
        if (nodo != null) {
            inordenRec(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            inordenRec(nodo.derecho);
        }
    }

    public void postorden() {
        postordenRec(raiz);
        System.out.println();
    }

    private void postordenRec(Nodo nodo) {
        if (nodo != null) {
            postordenRec(nodo.izquierdo);
            postordenRec(nodo.derecho);
            System.out.print(nodo.dato + " ");
        }
    }

    public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private Nodo eliminarRec(Nodo nodo, int valor) {
        if (nodo == null) {
            return nodo;
        }

        if (valor < nodo.dato) {
            nodo.izquierdo = eliminarRec(nodo.izquierdo, valor);
        } else if (valor > nodo.dato) {
            nodo.derecho = eliminarRec(nodo.derecho, valor);
        } else {
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            } else if (nodo.derecho == null) {
                return nodo.izquierdo;
            }

            nodo.dato = encontrarMenorValor(nodo.derecho);

            nodo.derecho = eliminarRec(nodo.derecho, nodo.dato);
        }

        return nodo;
    }

    private int encontrarMenorValor(Nodo nodo) {
        int minValor = nodo.dato;
        while (nodo.izquierdo != null) {
            minValor = nodo.izquierdo.dato;
            nodo = nodo.izquierdo;
        }
        return minValor;
    }
}










