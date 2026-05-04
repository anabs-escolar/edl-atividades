
public class VetorArray implements Vetor {
    private Object[] v; // array
    private int n; // capacidade
    private int size; // tamanho
    
    public VetorArray(int n) {
        this.n = n;
        this.v = new Object[n];
        this.size = 0;
    }

    public Object elemAtRank(int r) {
        if (isEmpty())
            throw new Excecao("O Vetor está vazio.");
        if (r >= n || r < 0)
            throw new Excecao("Índice não existe.");

        return v[r];
    }

    public Object replaceAtRank(int r, Object o) {
        if (isEmpty())
            throw new Excecao("O Vetor está vazio.");
        if (r >= n || r < 0)
            throw new Excecao("Índice não existe.");

        Object old = v[r];
        v[r] = o;
        return old;
    }

    public void insertAtRank(int r, Object o) {
        if (size == n){
            int new_n = n*2;
            Object[] new_v = new Object[new_n];
            for (int i=0; i<size; i++)
                new_v[i] = v[i];
            v = new_v;
            n = new_n;
        }

        for (int i=size; i>r; i--){
            v[i] = v[i-1];
        }

        v[r] = o;
        size++;
    }

    public Object removeAtRank(int r){
        if (isEmpty())
            throw new Excecao("O Vetor está vazio.");

        Object old = v[r];
        for (int i=r; i<size-1; i++)
            v[i] = v[i+1];
        size--;
        return old;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


}