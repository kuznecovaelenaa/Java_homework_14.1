package ru.netology;

import java.time.Year;

public class TicketRepository {

    public Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public void removeById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }

    public void removeAll() {
        Ticket[] tmp = new Ticket[0];
        tickets = tmp;
    }

    public Ticket[] findById(int id) {
        Ticket[] tmp = new Ticket[1];
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                tmp[0] = ticket;
            }
        }
        tickets = tmp;
        return tmp;
    }
}
