
public class FilaReversaArray implements FilaReversa {
    private int inicio, fim;
    private int capacity, reverse;
    private Object[] fila;


    public FilaReversaArray(int c) {
        this.inicio = 0;
        this.fim = 0;
        this.capacity = c;
        this.fila = new Object[c];
        this.reverse = 0;
    }


    public void enqueue(Object o) {
        if (reverse==0){
            if (size() == capacity-1){
                int n_cap = capacity*2;

                Object[] n_fila = new Object[n_cap];
                int p = inicio;
                for (int i=0; i<size(); i++){
                    n_fila[i] = fila[p];
                    p = (p+1) % capacity;
                }
                fila = n_fila;
                capacity = n_cap;
                inicio = 0;
                fim = size();
            }
            fila[fim] = o;
            fim = ++fim % capacity;

            if (size() == capacity/3){
                int n_cap = capacity/2;
                
                Object[] n_fila = new Object[n_cap];
                int p = inicio;
                for (int i=0; i<size(); i++){
                    n_fila[i] = fila[p];
                    p = (p+1) % capacity;
                }
                fila = n_fila;
                capacity = n_cap;
                inicio = 0;
                fim = size();
            }
        } else {
            if(size() == capacity-1){
                int n_cap = capacity*2;

                Object[] n_fila = new Object[n_cap];
                int ult = fim;
                for (int i=0; i<size(); i++){
                    n_fila[i] = fila[ult];
                    ult = ++ult % capacity;
                }
                fila = n_fila;
                capacity = n_cap;
                inicio = size() -1;
                fim = capacity;
            }
            
            fila[fim] = o;
            fim = (fim-1+capacity)%capacity;

            if (size() == capacity/3){
                int n_cap = capacity/2;

                Object[] n_fila = new Object[n_cap];
                int ult = fim;
                for (int i=0; i<size(); i++){
                    n_fila[i] = fila[ult];
                    ult = (ult+1) % capacity;
                }
                fila = n_fila;
                capacity = n_cap;
                inicio = size() -1;
                fim = capacity;
            }

        }
    }

    public Object dequeue() throws FilaVaziaExececao {
        if(isEmpty()){
            throw new FilaVaziaExececao("A Fila está vazia.");
        }
        Object remove = fila[inicio];
        if (reverse==0){
            inicio = ++inicio%capacity;
            if (size()==capacity/3){
                int n_cap = capacity/2;
                
                Object[] n_fila = new Object[n_cap];
                int p = inicio;
                for (int i=0; i<size(); i++){
                    n_fila[i] = fila[p];
                    p = (p+1) % capacity;
                }
                fila = n_fila;
                capacity = n_cap;
                inicio = 0;
                fim = size();

            }
        } else {
            inicio = (inicio+capacity-1)%capacity;
            if (size()==capacity/3){
                int n_cap = capacity/2;

                Object[] n_fila = new Object[n_cap];
                int ult = fim;
                for (int i=0; i<size(); i++){
                    n_fila[i] = fila[ult];
                    ult = (ult+1) % capacity;
                }
                fila = n_fila;
                capacity = n_cap;
                inicio = size() -1;
                fim = capacity;
            }
        }

        return remove;
    }

    public void reverse(){
        reverse = ++reverse%2;
        int tmp = inicio;
        if (reverse==1){
            inicio = (fim-1+capacity)%capacity;
            fim = (tmp-1+capacity)%capacity;
        } else {
            inicio = (fim+1)%capacity;
            fim = (tmp+1)%capacity;
        }
    }

    public int size(){ 
        if (reverse == 0){
            return (capacity-inicio+fim)%capacity;
        }
        return (capacity+inicio-fim)%capacity;
     }

    public boolean isEmpty(){ return fim == inicio; }

}
