package br.com.caelum.gash.booking.shared.domain;

public enum Status {
    WAITING_PAYMENT,
    PAYED,
    CANCELLED;

    public boolean isPayed() {
        return this == PAYED;
    }

    public boolean canBePay() {
        return this == WAITING_PAYMENT;
    }
}
