public class Main {
    public static void main(String[] args) {
        FilaListaLigada fila = new FilaListaLigada(5);

        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);

        System.out.println(fila.dequeue()); // 10
        System.out.println(fila.dequeue()); // 20
    }
}