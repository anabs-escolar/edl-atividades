public class MainLigada {

    public static void main(String[] args) {

        ListaLigada lista = new ListaLigada();

        System.out.println("=== Inserções ===");
        lista.insertFirst("A"); // [A]
        lista.insertLast("B");  // [A, B]
        lista.insertLast("C");  // [A, B, C]
        print(lista);

        System.out.println("\n=== Inserção no meio ===");
        ListaLigada.No n = lista.first().getNext(); // nó B
        lista.insertBefore(n, "X"); // [A, X, B, C]
        print(lista);

        lista.insertAfter(n, "Y");  // [A, X, B, Y, C]
        print(lista);

        System.out.println("\n=== Acesso ===");
        System.out.println("first: " + lista.first().getValue());
        System.out.println("last: " + lista.last().getValue());
        System.out.println("before(B): " + lista.before(n).getValue());
        System.out.println("after(B): " + lista.after(n).getValue());

        System.out.println("\n=== Replace e Swap ===");
        lista.replaceElements(n, "Z"); // B → Z
        print(lista);

        ListaLigada.No n1 = lista.first().getNext(); // X
        ListaLigada.No n2 = lista.last().getPrev();  // Y
        lista.swapElements(n1, n2);
        print(lista);

        System.out.println("\n=== Remoções ===");
        lista.remove(lista.first()); // remove A
        print(lista);

        lista.remove(lista.last()); // remove último
        print(lista);

        lista.remove(n); // remove Z
        print(lista);

        System.out.println("\n=== Removendo tudo ===");
        while (!lista.isEmpty()) {
            System.out.println("removendo: " + lista.first().getValue());
            lista.remove(lista.first());
            print(lista);
        }

        System.out.println("\n=== Estado final ===");
        System.out.println("size: " + lista.size());
        System.out.println("isEmpty: " + lista.isEmpty());
    }

    // percorre a lista
    public static void print(ListaLigada lista) {
        System.out.print("[");

        ListaLigada.No cur = lista.first();
        while (cur != null) {
            System.out.print(cur.getValue());
            if (cur.getNext() != null)
                System.out.print(", ");
            cur = cur.getNext();
        }

        System.out.println("]");
    }
}