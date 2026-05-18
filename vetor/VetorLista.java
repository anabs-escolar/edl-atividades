
public class VetorLista implements Vetor {

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

    private int n, size;
    private No first, last;

    public VetorLista(int n){
        this.first = null;
        this.last = null;
        this.n = n;
        this.size = 0;
    }

    public Object elemAtRank(int r){
        if (isEmpty())
            throw new Excecao("Vetor vazio.");
        if (r >= size || r < 0)
            throw new Excecao("Índice não existe.");

        return getNode(r).getValue();
    }

    public Object replaceAtRank(int r, Object o){
        if (isEmpty())
            throw new Excecao("Vetor vazio.");
        if (r >= size || r < 0)
            throw new Excecao("Índice não existe.");

        Object old = getNode(r).getValue();
        getNode(r).setValue(o);
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
            No cur = getNode(r);
            No prev = cur.getPrev();

            no.setPrev(prev);
            no.setNext(cur);

            prev.setNext(no);
            cur.setPrev(no);
        }
        size++;
    }

    public Object removeAtRank(int r){
        No old_no = getNode(r);

        if (size == 1){
            first = last;
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

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public No getNode(int r){
        No cur = first;
        int i = 0;
        while (cur != null){
            if (i == r)
                return cur;
            cur = cur.getNext();
            i++;
        }
        return null;
    }

}