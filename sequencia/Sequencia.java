

public class Sequencia {

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

    public Sequencia(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public No atRank(int rank){
        if (isEmpty())
            throw new RuntimeException("Sequencia vazia.");
        No no;
        if (rank <= size/2){
            no = first;
            for (int i=0; i<rank; i++)
                no = no.getNext();
        } else {
            no = last;
            for(int i=0; i < size-rank-1; i++)
                no = no.getPrev();
        }
        return no;
    }

    public int rankOf(No no){
        No n = first;
        int r = 0;
        while (n != no && n != null){
            n = n.getNext();
            r++;
        }
        return r;
    } 

    public Object elemAtRank(int r){
        if (isEmpty())
            throw new RuntimeException("Sequencia vazia.");
        No n = atRank(r);
        return n.getValue();
    }

    public Object replaceAtRank(int r, Object o){
        if (isEmpty())
            throw new RuntimeException("Sequencia vazia.");
        No n = atRank(r);
        Object old = n.getValue();
        n.setValue(o);
        return old;
    }

    public void insertAtRank(int r, Object o){
        No no = new No(o);

        if (size == 0){
            first = no;
            last = no;
        } else if (r == 0){
            no.setNext(first);
            first.setPrev(no);
            first = no;
        } else if (r == size){
            no.setPrev(last);
            last.setNext(no);
            last = no;
        } else {
            No cur = atRank(r);
            No prev = cur.getPrev();
            no.setPrev(prev);
            no.setNext(cur);
            prev.setNext(no);
            cur.setPrev(no);
        }
        size++;
    }

    public Object removeAtRank(int r){
        No old_no = atRank(r);

        if (size == 1){
            first = null;
            last = null;
        } else if (old_no == last){
            No prev = last.getPrev();
            last = prev;
            last.setNext(null);
        } else if (old_no == first){
            No next = first.getNext();
            first = next;
            first.setPrev(null);
        } else {
            No prev = old_no.getPrev();
            No next = old_no.getNext();
            prev.setNext(next);
            next.setPrev(prev);
        };
        size--;
        return old_no.getValue();
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