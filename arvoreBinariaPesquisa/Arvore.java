import java.util.Iterator;
import java.util.ArrayList;


public class Arvore {

    // Atributos da árvore
    private No raiz;
    private int tam;

    // Construtor
    public Arvore(Object o, int k) {
        this.raiz = new No(null, o, k);
        this.tam = 1;
    }

     public No leftChild(No v){
        return v.left();
    }

    public No RightChild(No v){
        return v.right();
    }
    
    public boolean hasLeft(No v){
        return v.left() != null;
    }

    public boolean hasRight(No v){
        return v.right() != null;
    }

    public No find(int k, No v){
        if (isExternal(v))
            return v;
        
        if (k < v.key()){
            return find(k, v.left());

        } else if (k == v.key()) {
            return v;

        } else {
            return find(k, v.right());
        }     
    }

    public void insert(Object o, int key){
        No n;
        No cur = (No) root();

        while(true){

            if(key < cur.key()){

                if(!hasLeft(cur)){
                    n = new No(cur, o, key);
                    if(cur.childrenNumber() == 0)
                        cur.filhos.add(n);
                    else
                        cur.filhos.set(0, n);
                    tam++;
                    return;
                }

                cur = cur.left();
            } else {

                if(!hasRight(cur)){
                    n = new No(cur, o, key);
                    if(cur.childrenNumber() == 0)
                        cur.filhos.add(null);

                    if(cur.childrenNumber() == 1)
                        cur.filhos.add(n);
                    else
                        cur.filhos.set(1, n);
                    tam++;
                    return;
                }

                cur = cur.right();
            }
        }
    }
    public Object remove(No v){

        Object old = v.element();

        // caso 1: folha
        if(isExternal(v)){

            No pai = (No) v.parent();

            if(pai.left() == v)
                pai.filhos.set(0, null);
            else
                pai.filhos.set(1, null);
            tam--;
            return old;
        }

        // caso 2: dois filhos
        if(hasLeft(v) && hasRight(v)){

            No suc = min(v.right());

            v.setElement(suc.element());

            v.setKey(suc.key());

            remove(suc);
            tam--;
            return old;
        }

        // caso 3: um único filho
        No filho;

        if(hasLeft(v))
            filho = v.left();
        else
            filho = v.right();

        No pai = (No) v.parent();

        if (pai.left() == v)
            pai.filhos.set(0, filho);
        else
            pai.filhos.set(1, filho);
        tam--;
        return old;
    }

    private No min(No v){
        while(v.left() != null)
            v = v.left();

        return v;
    }

    // Métodos comuns de Arvore

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
    public void addChild(No v, Object o, int k) {
        No novo = new No(v, o, k);
        v.addChild(novo);
        tam++;
    }

    /**
     * Remove um nó.
     * Só pode remover nós externos que possuam pai
     * (ou seja, que não sejam a raiz).
     */
    // public Object remove(No v) throws InvalidNoException {
    //     No pai = v.parent();

    //     if (pai != null && isExternal(v)) {
    //         pai.removeChild(v);
    //     } else {
    //         throw new InvalidNoException();
    //     }

    //     Object o = v.element();
    //     tam--;

    //     return o;
    // }

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
        if(n == null)
            return;

        a.add(n);
        Iterator it = n.children();
        while(it.hasNext()){
            No filho = (No) it.next();
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

    public void mostrar() {
        mostrar(root(), 0);
    }

    private void mostrar(No n, int nivel) {

        int h = height();

        ArrayList<No> nivelNos = new ArrayList<>();
        nivelNos.add(root());

        for (int i = 0; i <= h; i++) {

            int espacos = (int)Math.pow(2, h - i);

            imprimirEspacos(espacos);

            ArrayList<No> prox = new ArrayList<>();

            for (No no : nivelNos) {

                if (no != null) {
                    System.out.print(no.key());

                    prox.add(no.left());
                    prox.add(no.right());
                } else {
                    System.out.print(" ");

                    prox.add(null);
                    prox.add(null);
                }

                imprimirEspacos(espacos * 2);
            }

            System.out.println();
            nivelNos = prox;
        }
    }

    private void imprimirEspacos(int n) {
        for (int i = 0; i < n; i++)
            System.out.print(" ");
    }

    public class No {
        private Object o;
        private int chave;
        private No pai;
        protected ArrayList filhos = new ArrayList();

        public No(No pai, Object o, int k) {
            this.pai = pai;
            this.o = o;
            this.chave = k;
        }

           public int key(){
            return chave;
        }

        public void setKey(int k){
            this.chave = k;
        }


        public No left() {
            if (childrenNumber() > 0)
                return (No) filhos.get(0);
            return null;
        }
        
        public No right() {
            if (childrenNumber() > 1)
                return (No) filhos.get(1);
            return null;
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