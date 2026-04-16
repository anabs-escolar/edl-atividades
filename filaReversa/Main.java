public class Main {
    public static void main(String[] args) {

        FilaReversaArray fila = new FilaReversaArray(4);

        fila.enqueue(1);
        fila.enqueue(2);
        fila.enqueue(3);

        System.out.println(fila.dequeue()); // 1

        fila.enqueue(4);
        fila.enqueue(5);

        fila.reverse();

        System.out.println(fila.dequeue()); // 5
        System.out.println(fila.dequeue()); // 4

        fila.enqueue(6);

        System.out.println(fila.dequeue()); // 6
        System.out.println(fila.dequeue()); // 3
        System.out.println(fila.dequeue()); // 2
    }
}