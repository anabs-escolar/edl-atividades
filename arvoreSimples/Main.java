import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        ArvoreSimples arvore = new ArvoreSimples("A");

        ArvoreSimples.No raiz = arvore.root();

        arvore.addChild(raiz, "B");
        arvore.addChild(raiz, "C");

        Iterator it = arvore.children(raiz);

        ArvoreSimples.No b = (ArvoreSimples.No) it.next();
        ArvoreSimples.No c = (ArvoreSimples.No) it.next();

        arvore.addChild(b, "D");
        arvore.addChild(b, "E");

        arvore.addChild(c, "F");

        System.out.println("Tamanho: " + arvore.size());

        System.out.println("Altura: " + arvore.height());

        System.out.println("Profundidade da raiz: "
                + arvore.depth(raiz));

        System.out.println("Profundidade de B: "
                + arvore.depth(b));

        System.out.println("Profundidade de C: "
                + arvore.depth(c));

        System.out.println();

        System.out.println("Elementos:");

        Iterator elementos = arvore.elements();

        while (elementos.hasNext()) {
            System.out.println(elementos.next());
        }

        System.out.println();

        System.out.println("Nós:");

        Iterator nos = arvore.Nos();

        while (nos.hasNext()) {
            ArvoreSimples.No no =
                    (ArvoreSimples.No) nos.next();

            System.out.println(
                    no.element() +
                    " (profundidade = " +
                    arvore.depth(no) + ")"
            );
        }

        System.out.println();

        System.out.println("Troca B e C");

        arvore.swapElements(b, c);

        elementos = arvore.elements();

        while (elementos.hasNext()) {
            System.out.println(elementos.next());
        }
    }
}