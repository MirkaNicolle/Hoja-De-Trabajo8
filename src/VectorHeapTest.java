/**
 * Mirka Monzon 18139
 * HDT 8
 * Sistema de colas con prioridad para atender pacientes en la emergencia de un hospital.
 *
 * Unity test
 */

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class VectorHeapTest {

    @org.junit.jupiter.api.Test
    void add() {
        PriorityQueue<Paciente> pacientes = new VectorHeap<>();

        Paciente paciente1 = new Paciente("Juan", "Dolor en el estomago", "E");
        Paciente paciente2 = new Paciente("Maria", "Dolores de parto", "A");
        Paciente paciente3 = new Paciente("Pablo", "Herido de bala", "A");

        pacientes.add(paciente1);
        pacientes.add(paciente2);
        pacientes.add(paciente3);

        Vector<Paciente> pacientes2 = new Vector<>();
        pacientes2.add(paciente1);
        pacientes2.add(paciente2);
        pacientes2.add(paciente3);

        PriorityQueue<Paciente> expected = new VectorHeap<>(pacientes2);

        assertEquals(expected, pacientes);
    }

    @org.junit.jupiter.api.Test
    void remove() {
        PriorityQueue<Paciente> pacientes = new VectorHeap<>();
        Paciente paciente1 = new Paciente("Juan", "Dolor en el estomago", "E");
        Paciente paciente2 = new Paciente("Maria", "Dolores de parto", "A");
        Paciente paciente3 = new Paciente("Pablo", "Herido de bala", "A");

        pacientes.add(paciente1);
        pacientes.add(paciente2);
        pacientes.add(paciente3);

        assertEquals(paciente2, pacientes.remove());
    }
}