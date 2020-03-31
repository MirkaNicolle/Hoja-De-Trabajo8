/**
 * Mirka Monzon 18139
 * HDT 8
 * Sistema de colas con prioridad para atender pacientes en la emergencia de un hospital.
 *
 * Priority Queue Heap
 * Obtenido de: Java Structures Chapter 13 Priority Queues
 */

import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {

    //Atributo
    protected Vector<E> data;

    //constructor
    public VectorHeap() {data = new Vector<E>();}

    public VectorHeap(Vector<E> v) {
        int i;
        data = new Vector<E>(v.size());
        for (i = 0; i < v.size(); i++) { //Agrega un elemento al heap
            add(v.get(i));
        }
    }

    //Devuelve nodo padre
    protected static int parent(int i) {return (i-1)/2;}

    //Devuelve nodo hijo derecho
    protected static int left(int i) {return 2*i+1;}

    //Devuelve nodo hijo izquierdo
    protected static int right(int i) {return (2*i+1) + 1;}

    //Mueve el nodo (hacia arriba)
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 &&
                (value.compareTo(data.get(parent)) < 0))
        {
            data.set(leaf,data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf,value);
    }

    //Agrega elemento al vector
    public void add(E value){
        data.add(value);
        percolateUp(data.size()-1);
    }

    //Mueve el nodo (hacia abajo)
    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize)
            {
                if ((right(root) < heapSize) &&
                        ((data.get(childpos+1)).compareTo
                                (data.get(childpos)) < 0))
                {
                    childpos++;
                }
                if ((data.get(childpos)).compareTo
                        (value) < 0)
                {
                    data.set(root,data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root,value);
                    return;
                }
            } else {
                data.set(root,value);
                return;
            }
        }
    }

    //Retorna el primer elemento
    public E getFirst() {return data.firstElement();}

    //Tamaño del heap
    public int size() {return data.size();}

    //Devuelve y remueve el valor minimo del priority Queue
    public E remove() {
        E minVal = getFirst();
        data.set(0,data.get(data.size()-1));
        data.setSize(data.size()-1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }
}
