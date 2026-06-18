public class Main {

    public static void main(String[] args) {

        Arvore abb = new Arvore("6", 6);

        abb.insert("2", 2);
        abb.insert("9", 9);
        abb.insert("1", 1);
        abb.insert("4", 4);
        abb.insert("8", 8);
        abb.insert("3", 3);
        abb.insert("5", 5);

        System.out.println("Tamanho: " + abb.size());
        abb.mostrar();

        Arvore.No n = abb.find(4, abb.root());

        if (n != null)
            System.out.println("Encontrado: " + n.element());

        System.out.println("\nAntes da remoção:");

        imprimirEmOrdem(abb.root());
        System.out.println();
        abb.mostrar();
        
        Arvore.No remover = abb.find(2, abb.root());

        abb.remove(remover);

        System.out.println("\nDepois de remover 2:");

        imprimirEmOrdem(abb.root());

        System.out.println();
        abb.mostrar();
    }

    private static void imprimirEmOrdem(Arvore.No n) {

        if (n == null)
            return;

        imprimirEmOrdem(n.left());

        System.out.print(n.key() + " ");

        imprimirEmOrdem(n.right());
    }
}