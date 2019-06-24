package br.com.caelum.gash.booking.shared.exception;

public class CustomerNotFoundException extends IllegalArgumentException {

    private final Long customerId;

    public CustomerNotFoundException(Long id) {
        super(String.format("Cannot find customer with id '%s'", id));
        this.customerId = id;
    }

    public Long getCustomerId() {
        return customerId;
    }
}
