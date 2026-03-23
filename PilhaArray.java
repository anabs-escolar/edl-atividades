public class PilhaArray implements Pilha
    // Atributos
    private int capacidade;
    private Object[] a;
    private int t;
    private fc;
    // Construtor
    public PilhaArray(int capacidade, int crescimento){
        this.capacidade = capacidade;
        t = -1;
        fc =  crescimento;
        if (crescimento <= 0) fc = 0;
        a = new Object[capacidade];

    public void push(Object o){
        if (t >= capacidade-1){
            if (fc == 0 ) capacidade*=2;
            else capacidade+=fc;
            Object b[] = new Object[capacidade];
            for (int f = 0; f < a.legth; f++)
                b[f] = a[f];
            a = b;
        }
        a[++t] = o;
    }

    public Object pop() throws PilhaVaziaExcecao{
        if(isEmpty())
            throw new PilhaVaziaExcecao("Pilha está vazia");
        Object r = a[t--];
        return r;
    }

    public Object top() throws PilhaVaziaExcecao{
        if(isEmpty())
            throw new PilhaVaziaExcecao("Pilha está vazia")
        return a[t];
    }

    public boolean isEmpty(){
        return t == -1;
    }

    public int size(){
        return t+1;
    }

}