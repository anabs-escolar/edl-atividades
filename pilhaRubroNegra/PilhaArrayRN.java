public class PilhaArrayRN implements PilhaRubroNegra {
    // Atributos
    private int capacidade;
    private Object[] arr;
    private int topRubro;
    private int topNegro;
    // Construtor
    public PilhaArrayRN(int capacidade){
        this.capacidade = capacidade;
        topRubro = -1;
        topNegro = capacidade;
        arr = new Object[capacidade];
    }
    public void pushR(Object o){
        if (topRubro +1 == topNegro){
            grow();
        }
        arr[++topRubro] = o;
    }
    public void pushN(Object o){
        if (topRubro+1 == topNegro){
            grow();
        }
        arr[--topNegro] = o;
    }

    public Object popR() throws PilhaVaziaExcecao{
        if(isEmpty())
            throw new PilhaVaziaExcecao("Pilha está vazia");
        Object r = arr[topRubro--];
        return r;
    }
    public Object popN() throws PilhaVaziaExcecao{
        if(isEmpty())
            throw new PilhaVaziaExcecao("Pilha está vazia");
        Object r = arr[topNegro++];
        return r;
    }

    public void grow() {
        int n_cap = capacidade*2;
        Object n_arr[] = new Object[n_cap];

        for(int i=0; i <= topRubro; i++)
            n_arr[i] = arr[i];
        
        int tamNegro = capacidade - topNegro;
        int n_topNegro = n_cap - tamNegro;

        for(int i=0; i < tamNegro; i++)
            n_arr[n_topNegro + i] = arr[topNegro + i];

        topNegro = n_topNegro;
        capacidade = n_cap;
        arr = n_arr;
    }
    public Object top() throws PilhaVaziaExcecao{
        if(isEmpty())
            throw new PilhaVaziaExcecao("Pilha está vazia");
        return 0;
    }

    public boolean isEmpty(){
        return topRubro == -1 && topNegro == capacidade;;
    }

    public int size(){
        return (topRubro+1)+(capacidade - topNegro);
    }

}
