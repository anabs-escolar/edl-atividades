
public class ListaLigada{

    public class No{
        private No next, prev;
        private Object value;

        public No(Object value){
            this.value = value;
            this.next =  null;
            this.prev = null;
        }

        public Object getValue(){
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
        public No getPrev(){
            return prev;
        }
        public void setPrev(No o){
            prev = o;
        }
    }

    private int size;
    private No first, last;

    public ListaLigada(){
        this.size = 0;
        this.first = null;
        this.last = null;
    }

    
    public void replaceElements(No n, Object o){
        n.setValue(o);
    }
    public void swapElements(No n, No q){
        Object temp = n.getValue();
        n.setValue(q.getValue());
        q.setValue(temp);
    }
    public No insertAfter(No n, Object o){
        if (n == last){
            return insertLast(o);
        }
        No new_n = new No(o);
        new_n.setPrev(n);
        new_n.setNext(n.getNext());

        n.setNext(new_n);
        new_n.getNext().setPrev(new_n);
        size++;
        return new_n;
}
    public No insertBefore(No n, Object o){
        if (n == first){
            return insertFirst(o);
        }
        No new_n = new No(o);
        new_n.setNext(n);
        new_n.setPrev(n.getPrev());

        n.setPrev(new_n);
        new_n.getPrev().setNext(new_n);
        size++;
        return new_n;
    }
    public No insertFirst(Object o){
        No new_n = new No(o);
        if (isEmpty()){
            first = new_n;
            last = new_n;
        } else{
            new_n.setNext(first);
            first.setPrev(new_n);
            first = new_n;
        }
        size++;
        return new_n;
    }
    public No insertLast(Object o){
        No new_n = new No(o);
        if (isEmpty()){
            last = new_n;
            first = new_n;
        } else{
            new_n.setPrev(last);
            last.setNext(new_n);
            last = new_n;
        }
        size++;
        return new_n;
    }
    public Object remove(No p){
        Object old = p.getValue();
        if (size == 1) {
            first = null;
            last = null;
        } else if (p == first){
            first = first.getNext();
            first.setPrev(null);
        } else if (p == last){
            last = last.getPrev();
            last.setNext(null);
        } else{
            p.getPrev().setNext(p.getNext());
            p.getNext().setPrev(p.getPrev());

        }
        size--;
        return old;
    }
    public boolean isFirst(No p){
        return first == p;
    }
    public boolean isLast(No p){
        return last == p;
    }
    public No before(No p){
        return p.getPrev();
    }
    public No after(No p){
        return p.getNext();
    }
    public No last(){
        return this.last;
    }
    public No first(){
        return this.first;
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

}