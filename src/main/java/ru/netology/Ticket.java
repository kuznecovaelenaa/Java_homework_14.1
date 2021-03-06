package ru.netology;

import java.util.Objects;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private float cost;
    private String fromAirport;
    private String toAirport;
    private int travelTimeMinutes;

    public Ticket(int id, float cost, String fromAirport, String toAirport, int travelTimeMinutes) {
        this.id = id;
        this.cost = cost;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.travelTimeMinutes = travelTimeMinutes;
    }

    public int getId() {
        return id;
    }

    public float getCost() {
        return cost;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public String getToAirport() {
        return toAirport;
    }

    public int getTravelTimeMinutes() {
        return travelTimeMinutes;
    }

    @Override
    public int compareTo(Ticket otherTicket) {
        if (cost < otherTicket.cost) {
            return -1;
        }
        if (cost > otherTicket.cost) {
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return id == ticket.id && Float.compare(ticket.cost, cost) == 0 && travelTimeMinutes == ticket.travelTimeMinutes && Objects.equals(fromAirport, ticket.fromAirport) && Objects.equals(toAirport, ticket.toAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cost, fromAirport, toAirport, travelTimeMinutes);
    }
}
