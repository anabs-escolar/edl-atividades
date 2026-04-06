
public class FilaListaLigada implements Fila {
    
    public class No {
        private No next;
        private Object value;

        public Object getValue() {
            return value
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
    private int n;

    public FilaListaLigada(int n) {
        this->first = 0;
        this->last = 0;
        this->n = n;
    }

    public void enqueue(Object o) {
        if (size() == n-1){
            // encheu coleguinha
        }
        No new_node = new No;
        new_node->value = o;
        new_node->next = 0;
        if (this->first == 0)
            this->first == new_node;
        else 
            this->last->next = new_node;
        this->last = new_node;
    }

    public void dequeue() {
        if (this->first == 0) return;
        No remove = this->first;
        if (this->last == this->first)
            this->last = 0;
        this->first = this->first->next;
    }
}