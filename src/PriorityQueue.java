/**
 * Mirka Monzon 18139
 * HDT 8
 * Sistema de colas con prioridad para atender pacientes en la emergencia de un hospital.
 *
 * Priority Queue interface
 * Obtenido de: Java Structures Chapter 13 Priority Queues
 */

public interface PriorityQueue<E extends Comparable<E>> {

    //Devuelve el minimo valor en el priority Queue
    public E getFirst();

    //Devuelve y remueve el minimo valor en el priority Queue
    public E remove();

    //Agrega un valor al priority Queue
    public void add(E value);

    //Devuelve el numero de elementos en el priority Queue
    public int size();
}
