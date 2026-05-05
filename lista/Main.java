public class Main {

    public static void main(String[] args) {

        ListaArray lista = new ListaArray(2);

        System.out.println("=== Inserções ===");
        lista.insertFirst("A");   // [A]
        lista.insertLast("B");    // [A, B]
        lista.insertLast("C");    // resize → [A, B, C]
        print(lista);

        System.out.println("\n=== Inserção no meio ===");
        lista.insertBefore(1, "X"); // [A, X, B, C]
        print(lista);

        lista.insertAfter(2, "Y");  // [A, X, B, Y, C]
        print(lista);

        System.out.println("\n=== Acesso ===");
        System.out.println("first: " + lista.first());
        System.out.println("last: " + lista.last());
        System.out.println("before(2): " + lista.before(2));
        System.out.println("after(2): " + lista.after(2));

        System.out.println("\n=== Replace e Swap ===");
        lista.replaceElements(2, "Z"); // substitui B → Z
        print(lista);

        lista.swapElements(1, 3); // troca X e Y
        print(lista);

        System.out.println("\n=== Remoções ===");
        lista.remove(0); // remove A
        print(lista);

        lista.remove(lista.size() - 1); // remove último
        print(lista);

        lista.remove(1); // remove do meio
        print(lista);

        System.out.println("size: " + lista.size());
        System.out.println("isEmpty: " + lista.isEmpty());

        lista.remove(0);
        print(lista);
        lista.remove(0);
        print(lista);


        System.out.println("isEmpty: " + lista.isEmpty());

    }

    // utilitário
    public static void print(ListaArray lista) {
        System.out.print("[");
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(lista.before(i+1)); // alternativa: acessar direto se tiver método
            if (i < lista.size() - 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }
}