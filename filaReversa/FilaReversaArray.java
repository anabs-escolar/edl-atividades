
public class FilaReversaArray implements FilaReversa {
    private int inicio;
    private int capacity, reverse, size;
    private Object[] fila;


    public FilaReversaArray(int c) {
        this.inicio = 0;
        this.capacity = c;
        this.fila = new Object[c];
        this.reverse = 0;
        this.size = 0; 
    }


    public void enqueue(Object o) {
        if (size==capacity)
            resize(capacity*2);
        if (reverse==0){
            int posi = (inicio+size)%capacity;
            fila[posi] = o;
        }
        else {
            inicio = (inicio+capacity-1)%capacity;
            fila[inicio] = o;
        }

        size++;
    }

    public Object dequeue() throws FilaVaziaExececao {
        if(isEmpty()){
            throw new FilaVaziaExececao("A Fila está vazia.");
        }
        Object remove;
        if (reverse==0){
            remove = fila[inicio];
            inicio = (inicio+1)%capacity;
        } else {
            int pos = (inicio+size-1)%capacity;
            remove = fila[pos];
        }
        size--;
        if(capacity >1  && size <=capacity/3 )
            resize(capacity/2);

        return remove;
    }

    public void reverse(){
        if (reverse==0){
            reverse++;
        }else{
            reverse--;
        }
    }
    public void resize(int n_cap){
        Object[] n_fila = new Object[n_cap];
        for(int i=0; i<size; i++){
            int index = (inicio+i)%capacity;
            n_fila[i] = fila[index];
        }
        fila = n_fila;
        capacity = n_cap;
        inicio = 0;
    }
    public int size(){ return size; }

    public boolean isEmpty(){ return size==0; }

}
