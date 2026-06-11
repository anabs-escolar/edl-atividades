public class Main {

    public static void main(String[] args) {

        FilaPrioridadeHeap heap = new FilaPrioridadeHeap();

        System.out.println("Vazia? " + heap.isEmpty());

        heap.insert("A", 20);
        heap.insert("B", 5);
        heap.insert("C", 15);
        heap.insert("D", 3);
        heap.insert("E", 10);
        heap.insert("F", 1);

        System.out.println("Tamanho: " + heap.size());
        System.out.println("Minimo: " + heap.min());

        System.out.println("\nRemovendo em ordem:");

        while (!heap.isEmpty()) {
            System.out.println(heap.removeMin());
        }

        System.out.println("\nTamanho final: " + heap.size());
        System.out.println("Vazia? " + heap.isEmpty());
    }
}