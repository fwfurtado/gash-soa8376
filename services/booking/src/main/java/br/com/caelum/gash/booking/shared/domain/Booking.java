package br.com.caelum.gash.booking.shared.domain;

import java.time.ZonedDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User customer;

    @ManyToOne
    private Garage garage;

    private ZonedDateTime start;

    private ZonedDateTime end;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Deprecated
    private Booking() {
    }

    public Booking(ZonedDateTime start, ZonedDateTime end) {
        this.start = start;
        this.end = end;
        this.status = Status.WAITING_PAYMENT;
    }

    public Long getId() {
        return id;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public ZonedDateTime getStart() {
        return start;
    }

    public ZonedDateTime getEnd() {
        return end;
    }

    public boolean alreadyPayed() {
        return status.isPayed();
    }

    public boolean canBePay() {
        return status.canBePay();
    }

    public Status getStatus() {
        return status;
    }

    public void pay() {
        status = Status.PAYED;
    }
}
