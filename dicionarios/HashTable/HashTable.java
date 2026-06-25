
public class HashTable {
    private Item[] arr;
    private int N;

    public HashTable(int tam){
        this.arr = new Item[tam];
        this.N = tam;
    }

    public class Item{
        public int key;
        public Object element; 
        
        public Item(int k, Object o){
            this.key = k;
            this.element = o;
        } 
    }
    
    private final Item AVAILABLE = new Item(-1, null);

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
            i = hash(i+1);
            p++;
            
        }

        throw new InvalidNoException("NO_SUCH_KEY");
    }

    public void insert(int k, Object o){
        int i = hash(k);
        int p = 0;

        while (p < N){
            if (arr[i] == null || arr[i] == AVAILABLE){
                arr[i] = new Item(k, o);
                return;
            }

            i = hash(i+1);
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
                Object old = c.element;
                arr[i] = AVAILABLE;
                return old;
            }
            else {
                i = hash(i+1);
                p++;
            }
            
        };
        throw new InvalidNoException("NO_SUCH_KEY");
    }
    
    public void mostrar() {
        System.out.println("\nEstado da tabela:");
        for (int i = 0; i < N; i++) {
            System.out.print("[" + i + "] ");

            if (arr[i] == null) {
                System.out.println("null");
            } else if (arr[i] == AVAILABLE) {
                System.out.println("AVAILABLE");
            } else {
                Item item = arr[i];
                System.out.println(
                    "key=" + item.key +
                    ", valor=" + item.element
                );
            }
        }
    }
}