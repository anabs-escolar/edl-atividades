
public class InvalidNoException extends RuntimeException{
    public InvalidNoException(){
        super("NO_SUCH_KEY");
    }
}

public class HashTable {
    private Object[] arr;
    private int N;

    public HashTable(int tam){
        this.arr = new Object[tam];
        this.N = tam;
    }

    public class Item{
        public int chave;
        public Object element; 
        
        public Item(int k, Object o){
            this.chave = k;
            this.element = o;
        } 
    }

    private int hash(int x){
        return x % N;
    }
    
    public Object find(int k){
        int i = hash(k);
        int p = 0; // posicao

        while (p < N){
            Item c = arr[i];
            if (c == null)
                throw new InvalidNoException("NO_SUCH_KEY");
            else if (c.key == k)
                return c.element;
            else 
                i = hash(i+1);
                p++;
        }

        throw new InvalidNoException("NO_SUCH_KEY");
    }

    public void insert(int k, Object o){
        int i = hash(k);
        int p = 0;

        while (p < N){
            if (arr[i] == null){
                arr[i] = new Item(k, o);
                return;
            }

            i = hash(++i);
            p++;
        }

        throw new InvalidNoException("Cheio");
    }

    public Object remove(int k){
        int i = hash(k);
        int p = 0;

        while(p< N){
            Item c = arr[i];
            if (c == null)
                throw new InvalidNoException("NO_SUCH_KEY");
            else if (c.key == k){
                old = c.element();
                c = null;
                return old;
            }
            else 
                i = hash(i+1);
                p++;
            
        }
    }
    
}