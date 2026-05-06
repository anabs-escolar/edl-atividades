public class Main {

    public static void main(String[] args) {

        Sequencia seq = new Sequencia();

        System.out.println("=== Inserções iniciais ===");
        seq.insertAtRank(0, "A"); // [A]
        seq.insertAtRank(1, "B"); // [A, B]
        seq.insertAtRank(2, "C"); // [A, B, C]
        print(seq);

        System.out.println("\n=== Insert no meio ===");
        seq.insertAtRank(1, "X"); // [A, X, B, C]
        print(seq);

        System.out.println("\n=== atRank / elemAtRank ===");
        System.out.println("rank 0: " + seq.elemAtRank(0));
        System.out.println("rank 2: " + seq.elemAtRank(2));

        System.out.println("\n=== replaceAtRank ===");
        seq.replaceAtRank(2, "Z"); // B -> Z
        print(seq);

        System.out.println("\n=== Navegação por nó ===");
        Sequencia.No n = seq.atRank(2); // nó Z
        System.out.println("valor: " + n.getValue());
        System.out.println("before: " + seq.before(n).getValue());
        System.out.println("after: " + seq.after(n).getValue());

        System.out.println("\n=== rankOf ===");
        System.out.println("rank do nó Z: " + seq.rankOf(n));

        System.out.println("\n=== insertAfter / insertBefore ===");
        seq.insertAfter(n, "Y"); // depois de Z
        print(seq);

        seq.insertBefore(n, "W"); // antes de Z
        print(seq);

        System.out.println("\n=== swapElements ===");
        Sequencia.No n1 = seq.first();
        Sequencia.No n2 = seq.last();
        seq.swapElements(n1, n2);
        print(seq);

        System.out.println("\n=== replaceElements ===");
        seq.replaceElements(n, "K");
        print(seq);

        System.out.println("\n=== removeAtRank ===");
        seq.removeAtRank(0); // remove primeiro
        print(seq);

        seq.removeAtRank(seq.size() - 1); // remove último
        print(seq);

        seq.removeAtRank(1); // remove meio
        print(seq);

        System.out.println("\n=== remove(No) ===");
        Sequencia.No alvo = seq.atRank(1);
        System.out.println("removendo: " + alvo.getValue());
        seq.remove(alvo);
        print(seq);

        System.out.println("\n=== Removendo tudo ===");
        while (!seq.isEmpty()) {
            System.out.println("removendo: " + seq.first().getValue());
            seq.remove(seq.first());
            print(seq);
        }

        System.out.println("\n=== Estado final ===");
        System.out.println("size: " + seq.size());
        System.out.println("isEmpty: " + seq.isEmpty());
    }

    // utilitário de impressão
    public static void print(Sequencia seq) {
        System.out.print("[");
        Sequencia.No cur = seq.first();

        while (cur != null) {
            System.out.print(cur.getValue());
            if (cur.getNext() != null)
                System.out.print(", ");
            cur = cur.getNext();
        }

        System.out.println("]");
    }
}