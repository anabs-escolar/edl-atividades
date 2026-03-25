public class PilhaArrayRubroNegra implements PilhaRubroNegra {
    // Atributos
    private int capacidade;
    private Object[] arr;
    private int topRubro;
    private int topNegro;

    // Construtor
    public PilhaArrayRubroNegra(int capacidade){
        this.capacidade = capacidade;
        topRubro = -1;
        topNegro = capacidade;
        arr = new Object[capacidade];
    }
    // Métodos

    public void pushR(Object o){ // Adiciona um elemento no final do array rubro
        if (topRubro +1 == topNegro){
            grow();
        }
        arr[++topRubro] = o;
        if ((double) size()/capacidade <= 0.3) shrink();

    }

    public void pushN(Object o){ // Adiciona um elemento no final do array negro
        if (topRubro+1 == topNegro){
            grow();
        }
        arr[--topNegro] = o;
        if ((double) size()/capacidade <= 0.3) shrink();

    }

    public Object popR() throws PilhaVaziaExcecao{ // Remove e retorna o ultimo elemento do array rubro
        if(topRubro == -1)
            throw new PilhaVaziaExcecao("Pilha está vazia");
        Object r = arr[topRubro--];
        if ((double) size()/capacidade <= 0.3) shrink();
        return r;
    }

    public Object popN() throws PilhaVaziaExcecao{ // Remove e retorna o ultimo elemento do array negro
        if(topNegro == capacidade)
            throw new PilhaVaziaExcecao("Pilha está vazia");
        Object r = arr[topNegro++];
        if ((double) size()/capacidade <= 0.3) shrink();
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

    public void shrink() { // Diminui o array geral pela metade, mantendo o array negro mais a direita
        int n_cap = capacidade/2;
        if(n_cap < size()) return;

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

    public Object topR() throws PilhaVaziaExcecao{ // Retorna o ultimo elemento do array rubro
        if(topRubro == -1)
            throw new PilhaVaziaExcecao("Pilha está vazia");
        return  arr[topRubro];
    }
    
    public Object topN() throws PilhaVaziaExcecao{ // Retorna o ultimo elemento do array negro
        if(topNegro == capacidade)
            throw new PilhaVaziaExcecao("Pilha está vazia");
        return  arr[topNegro];
    }

    public boolean isEmpty(){ // Retorna `true` se o array geral está vazio, caso contrário `false`
        return topRubro == -1 && topNegro == capacidade;
    }

    public int size(){ // Retorna a quantidade de elementos do array geral
        return (topRubro+1)+(capacidade - topNegro);
    }
}