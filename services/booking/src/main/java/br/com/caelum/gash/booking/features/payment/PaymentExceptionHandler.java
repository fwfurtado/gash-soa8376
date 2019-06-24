package br.com.caelum.gash.booking.features.payment;

import static org.springframework.http.ResponseEntity.accepted;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.status;

import br.com.caelum.gash.booking.shared.exception.BookingAlreadyPayedException;
import br.com.caelum.gash.booking.shared.exception.BookingCannotBePayedException;
import br.com.caelum.gash.booking.shared.exception.BookingNotFoundException;
import br.com.caelum.gash.booking.shared.exception.PaymentFallbackException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class PaymentExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentExceptionHandler.class);

    @ExceptionHandler(BookingNotFoundException.class)
    ResponseEntity<?> handle(BookingNotFoundException e) {
        LOG.info(e.getMessage());

        return notFound().build();
    }

    @ExceptionHandler(BookingAlreadyPayedException.class)
    ResponseEntity<?> handle(BookingAlreadyPayedException e) {
        LOG.warn(e.getMessage());
        return status(HttpStatus.GONE).build();
    }

    @ExceptionHandler(BookingCannotBePayedException.class)
    ResponseEntity<?> handle(BookingCannotBePayedException e) {
        LOG.error(e.getMessage());

        return badRequest().build();
    }

    @ExceptionHandler(PaymentFallbackException.class)
    ResponseEntity<?> handle(PaymentFallbackException e) {
        LOG.warn(e.getMessage());

        return accepted().build();
    }

}
