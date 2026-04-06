
public class FilaListaLigada implements Fila {
    
    private class No {
        private No next;
        private Object value;

        public No(Object value){
            this.value = value;
            this.next = null;
        }

        public Object getValue() {
            return value;
        }
        public void setValue(Object o){
            value = o;
        }
        public No getNext(){
            return next;
        }
        public void setNext(No o){
            next = o;
        }
    }

    private No first, last;
    private int size, capacity;

    public FilaListaLigada(int c) {
        this.first = null;
        this.last = null;
        this.size = 0;
        this.capacity = c;
    }


    public void enqueue(Object o) {
        if (capacity == size)
            capacity = capacity*2;
        
        No new_node = new No(o);
        if (first == null)
            first = new_node;
        else 
            last.setNext(new_node);
        last = new_node;
        size++;
    }

    public Object dequeue() {
        if (isEmpty())
            throw new FilaVaziaExececao("Fila vazia");

        Object remove = first.getValue();
        if (last == first)
            last = null;
        first = first.getNext();
        size--;
        return remove;
    }

    public int size(){ return size; }

    public boolean isEmpty(){ return size == 0; }

}
