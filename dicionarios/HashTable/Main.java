
public class Main {

    public static void main(String[] args) {

        HashTable tabela = new HashTable(7);

        System.out.println("=== INSERCOES ===");

        tabela.insert(10, "Ana");
        tabela.insert(20, "Bruno");
        tabela.insert(30, "Carlos");

        System.out.println("10 -> " + tabela.find(10));
        System.out.println("20 -> " + tabela.find(20));
        System.out.println("30 -> " + tabela.find(30));
        tabela.mostrar();

        System.out.println("\n=== TESTE DE COLISAO ===");

        /*
         * hash = chave % 7
         *
         * 1 % 7 = 1
         * 8 % 7 = 1
         * 15 % 7 = 1
         *
         * Todos colidem.
         */

        tabela.insert(1, "A");
        tabela.insert(8, "B");
        tabela.insert(15, "C");

        System.out.println("1  -> " + tabela.find(1));
        System.out.println("8  -> " + tabela.find(8));
        System.out.println("15 -> " + tabela.find(15));
        tabela.mostrar();

        System.out.println("\n=== REMOCAO ===");

        System.out.println("Removido: " + tabela.remove(20));

        try {
            System.out.println(tabela.find(20));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        tabela.mostrar();

        System.out.println("\n=== CHAVE INEXISTENTE ===");

        try {
            System.out.println(tabela.find(999));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        tabela.mostrar();

        System.out.println("\n=== TABELA CHEIA ===");

        try {
            tabela.insert(100, "X");
            tabela.insert(101, "Y");

            // deve estourar quando não houver espaço
            tabela.insert(102, "Z");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        tabela.mostrar();

        System.out.println("=== REMOVENDO E BUSCANDO ===");
        HashTable h = new HashTable(7);

        h.insert(1, "A");
        h.insert(8, "B");
        h.insert(15, "C");

        h.mostrar();

        System.out.println("Removendo 1...");
        h.remove(1);

        h.mostrar();

        System.out.println("Buscando 15...");
        System.out.println(h.find(15));

        System.out.println("=== REMOVENDO E INSERINDO ===");
        HashTable n = new HashTable(7);
        n.insert(1, "A");
        n.insert(8, "B");
        n.insert(15, "C");

        n.remove(1);

        n.mostrar();

        n.insert(22, "D");

        n.mostrar();
    }
}