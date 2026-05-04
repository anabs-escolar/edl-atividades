public class Main {

    public static void main(String[] args) {

        System.out.println("===== TESTES VetorArray =====");
        VetorArray va = new VetorArray(2);

        // Inserções
        va.insertAtRank(0, "A");
        va.insertAtRank(1, "B");
        va.insertAtRank(2, "C"); // testa resize
        printVetor(va);

        // Inserção no meio
        va.insertAtRank(1, "X");
        printVetor(va);

        // Acesso
        System.out.println("elemAtRank(2): " + va.elemAtRank(2));

        // Substituição
        System.out.println("replaceAtRank(2): " + va.replaceAtRank(2, "Y"));
        printVetor(va);

        // Remoção
        System.out.println("removeAtRank(0): " + va.removeAtRank(0));
        printVetor(va);

        System.out.println("removeAtRank(size-1): " + va.removeAtRank(va.size()-1));
        printVetor(va);

        // Erros
        testErro(() -> va.elemAtRank(100));
        testErro(() -> va.insertAtRank(-1, "Z"));
        testErro(() -> va.removeAtRank(100));


        System.out.println("\n===== TESTES VetorLista =====");
        VetorLista vl = new VetorLista(0);

        // Inserções
        vl.insertAtRank(0, "A");
        vl.insertAtRank(1, "B");
        vl.insertAtRank(2, "C");
        printVetor(vl);

        // Inserção no meio
        vl.insertAtRank(1, "X");
        printVetor(vl);

        // Inserção no início
        vl.insertAtRank(0, "START");
        printVetor(vl);

        // Inserção no fim
        vl.insertAtRank(vl.size(), "END");
        printVetor(vl);

        // Acesso
        System.out.println("elemAtRank(3): " + vl.elemAtRank(3));

        // Substituição
        System.out.println("replaceAtRank(3): " + vl.replaceAtRank(3, "Y"));
        printVetor(vl);

        // Remoções
        System.out.println("remove início: " + vl.removeAtRank(0));
        printVetor(vl);

        System.out.println("remove meio: " + vl.removeAtRank(2));
        printVetor(vl);

        System.out.println("remove fim: " + vl.removeAtRank(vl.size()-1));
        printVetor(vl);

        // Testar até esvaziar
        while (!vl.isEmpty()) {
            System.out.println("removendo: " + vl.removeAtRank(0));
            printVetor(vl);
        }

        // Erros
        testErro(() -> vl.elemAtRank(0));
        testErro(() -> vl.removeAtRank(0));
        testErro(() -> vl.insertAtRank(5, "Z"));
    }


    public static void printVetor(Vetor v) {
        System.out.print("[");

        for (int i = 0; i < v.size(); i++) {
            System.out.print(v.elemAtRank(i));
            if (i < v.size() - 1)
                System.out.print(", ");
        }

        System.out.println("]");
    }

    public static void testErro(Runnable r) {
        try {
            r.run();
        } catch (Exception e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }
    }
}