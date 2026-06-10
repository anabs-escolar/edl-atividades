
# Árvore Simples Implementação

## `InvalidNoException`

```java
public class InvalidNoException extends RuntimeException{
    public InvalidNoException(){
        super("Nó Invalido");
    }
}
```

## `ArvoreSimples`

```java
import java.util.Iterator;
import java.util.ArrayList;


public class ArvoreSimples {

    // Atributos da árvore
    private No raiz;
    private int tam;

    // Construtor
    public ArvoreSimples(Object o) {
        raiz = new No(null, o);
        tam = 1;
    }

    /** Retorna a raiz da árvore */
    public No root() {
        return raiz;
    }

    /** Retorna o nó pai de um nó */
    public No parent(No v) {
        return v.parent();
    }

    /** Retorna os filhos de um nó */
    public Iterator children(No v) {
        return v.children();
    }

    /** Testa se um nó é interno */
    public boolean isInternal(No v) {
        return v.childrenNumber() > 0;
    }

    /** Testa se um nó é externo */
    public boolean isExternal(No v) {
        return v.childrenNumber() == 0;
    }

    /** Testa se um nó é a raiz */
    public boolean isRoot(No v) {
        return v == raiz;
    }

    /** Adiciona um filho a um nó */
    public void addChild(No v, Object o) {
        No novo = new No(v, o);
        v.addChild(novo);
        tam++;
    }

    /**
     * Remove um nó.
     * Só pode remover nós externos que possuam pai
     * (ou seja, que não sejam a raiz).
     */
    public Object remove(No v) throws InvalidNoException {
        No pai = v.parent();

        if (pai != null && isExternal(v)) {
            pai.removeChild(v);
        } else {
            throw new InvalidNoException();
        }

        Object o = v.element();
        tam--;

        return o;
    }

    /**
     * Troca os elementos armazenados em dois nós.
     */
    public void swapElements(No v, No w) {
        Object temp = v.element();
        v.setElement(w.element());
        w.setElement(temp);
    }
    
    /** Retorna a profundidade de um nó */
    public int depth(No v) {
        return profundidade(v);
    }

    private int profundidade(No v) {
        if (v == raiz) {
            return 0;
        } else {
            return 1 + profundidade(v.parent());
        }
    }

    /** Retorna a altura da árvore */
    public int height() {
        int altura = 0;
        Iterator it = Nos();

        while(it.hasNext()){
            No no = (No) it.next();
            int profundidade = depth(no);
            if (profundidade > altura)
                altura = profundidade;
        }

        return altura;
    }

    /** Retorna um Iterator com os elementos armazenados na árvore */
    public Iterator elements() {
        ArrayList els = new ArrayList();
        Iterator it = Nos();
        while(it.hasNext()){
            No no = (No) it.next();
            els.add(no.element());
        }
        return els.iterator();
    }

    /** Retorna um Iterator com os nós da árvore */
    public Iterator Nos() {
        ArrayList nos = new ArrayList();
        addNos(root(), nos);
        return nos.iterator();
    }

    private void addNos(No n, ArrayList a){
        a.add(n);
        Iterator it = n.children();
        while(it.hasNext()){
            No filho = (No) it.next(); // converte Obj para No
            addNos(filho, a);
        }
    }

    /** Retorna o número de nós da árvore */
    public int size() {
        return this.tam;
    }

    /**
     * Retorna se a árvore está vazia.
     * Sempre será falso, pois não permitimos remover a raiz.
     */
    public boolean isEmpty() {
        return false;
    }

    /** Substitui o elemento armazenado em um nó */
    public Object replace(No v, Object o) {
        Object old = v.element();
        v.setElement(o);
        return old;
    }

    public class No {
        private Object o;
        private No pai;
        private ArrayList filhos = new ArrayList();

        public No(No pai, Object o) {
            this.pai = pai;
            this.o = o;
        }

        public Object element() {
            return o;
        }

        public No parent() {
            return pai;
        }

        public void setElement(Object o) {
            this.o = o;
        }

        public void addChild(No o) {
            filhos.add(o);
        }

        public void removeChild(No o) {
            filhos.remove(o);
        }

        public int childrenNumber() {
            return filhos.size();
        }

        public Iterator children() {
            return filhos.iterator();
        }
    }
}
```

## `Main`

```java
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
```