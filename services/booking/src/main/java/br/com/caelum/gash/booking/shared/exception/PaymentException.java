package br.com.caelum.gash.booking.shared.exception;

import org.springframework.http.HttpStatus;

public class PaymentException extends RuntimeException {

    public PaymentException(HttpStatus status) {
        super(String.format("Payment service returns %s status", status));
    }
}
