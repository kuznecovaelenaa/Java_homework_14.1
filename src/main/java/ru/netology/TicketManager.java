package ru.netology;

import java.util.Arrays;

public class TicketManager {

    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.save(ticket);
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public void removeAll() {
        repository.removeAll();
    }

    public void findById(int id) {
        repository.findById(id);
    }

    public Ticket[] findAll(String fromAirport, String toAirport) {
        Ticket[] ans = new Ticket[0];
        for (Ticket ticket : repository.tickets) {
            if (ticket.getToAirport() == toAirport && ticket.getFromAirport() == fromAirport) {
                Ticket[] tmp = new Ticket[ans.length + 1];
                for (int i = 0; i < ans.length; i++) {
                    tmp[i] = ans[i];
                }
                tmp[tmp.length - 1] = ticket;
                ans = tmp;
            }
        }
        Arrays.sort(ans);
        return ans;
    }
}
