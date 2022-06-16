package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {

    Ticket ticket1 = new Ticket(1,1299, "Moscow", "Kazan", 95);
    Ticket ticket2 = new Ticket(1,2199, "Moscow", "Kazan", 95);
    Ticket ticket3 = new Ticket(1,1899, "Moscow", "Kazan", 95);
    Ticket ticket4 = new Ticket(1,1999, "Moscow", "Kazan", 95);
    Ticket ticket5 = new Ticket(1,2299, "Moscow", "Kazan", 95);
    Ticket ticket6 = new Ticket(1,1299, "Kazan", "Moscow", 95);
    Ticket ticket7 = new Ticket(1,2199, "Kazan", "Moscow", 95);
    Ticket ticket8 = new Ticket(1,1899, "Kazan", "Moscow", 95);

    @Test
    public void firstTest() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.findAll("Moscow", "Kazan");
        Ticket[] expected = { ticket1, ticket3, ticket4, ticket2, ticket5 };

        assertArrayEquals(expected, actual);
    }
}
