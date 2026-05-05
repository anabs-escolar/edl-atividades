
public class ListaArray {
    private int size, cap;
    private Object[] arr;

    public ListaArray(int c){
        this.size = 0;
        this.cap = c;
        this.arr = new Object[c];
    }

    public void replaceElements(int n, Object o){
        if (isEmpty())
            throw new RuntimeException("A Lista está vazia.");
        arr[n] = o;
    }
    public void swapElements(int n, int q){
        if (isEmpty())
            throw new RuntimeException("A Lista está vazia.");
        Object temp = arr[n];
        arr[n] = arr[q];
        arr[q] = temp;
    }
    public void insertBefore(int n, Object o){
        if (size == cap){
            int new_cap = cap*2;
            Object[] new_a = new Object[new_cap];
            for (int i=0; i<size; i++)
                new_a[i] = arr[i];
            arr = new_a;
            cap = new_cap;
        }

        for (int i=size; i>n; i--){
            arr[i] = arr[i-1];
        }

        arr[n] = o;
        size++;
    }
    public void insertAfter(int n, Object o){
        insertBefore(n+1, o);
    }
    public void insertFirst(Object o){
        insertBefore(0, o); 
    }
    public void insertLast(Object o){
        insertBefore(size, o);
    }
    public Object remove(int n){
        if (isEmpty())
            throw new RuntimeException("A Lista está vazia.");
        Object old = arr[n];
        for (int i=n; i<size-1; i++)
            arr[i] = arr[i+1];
        size--;
        return old;
    }
    public boolean isFirst(Object n){
        return arr[0] == n;
    }
    public boolean isLast(Object n){
        return arr[size-1] == n;
    }
    public Object before(int p){
        return arr[p-1];
    }
    public Object after(int p){
        return arr[p+1];
    }
    public Object first(){
        return arr[0];
    }
    public Object last(){
        return arr[size-1];
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
}