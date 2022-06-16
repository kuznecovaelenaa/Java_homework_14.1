package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {

    Ticket ticket1 = new Ticket(1,1299, "Moscow", "Kazan", 95);
    Ticket ticket2 = new Ticket(2,2199, "Moscow", "Kazan", 95);
    Ticket ticket3 = new Ticket(3,1899, "Moscow", "Kazan", 95);
    Ticket ticket4 = new Ticket(4,1999, "Moscow", "Kazan", 95);
    Ticket ticket5 = new Ticket(5,2299, "Moscow", "Kazan", 95);
    Ticket ticket6 = new Ticket(6,1299, "Kazan", "Moscow", 95);
    Ticket ticket7 = new Ticket(7,2199, "Kazan", "Moscow", 95);
    Ticket ticket8 = new Ticket(8,1899, "Kazan", "Moscow", 95);

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

    @Test
    public void secondTest() {
        TicketRepository repository = new TicketRepository();
        TicketManager manager = new TicketManager(repository);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.removeAll();
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.removeById(4);


        Ticket[] actual = manager.findAll("Moscow", "Kazan");
        Ticket[] expected = { ticket3, ticket5 };

        assertArrayEquals(expected, actual);
    }

    @Test
    public void thirdTest() {
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

        Ticket[] actual = manager.findAll("SPB", "Kazan");
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void fourthTest() {
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
        manager.findById(8);

        Ticket[] actual = manager.findAll("Kazan", "Moscow");
        Ticket[] expected = { ticket8 };

        assertArrayEquals(expected, actual);
    }
}
