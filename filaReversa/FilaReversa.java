public interface FilaReversa {
    public abstract void enqueue(Object o);
    public abstract Object dequeue();
    public abstract void reverse();
    public abstract int size();
    public abstract boolean isEmpty();
}