package br.com.caelum.gash.booking.features.payment;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookings")
class PaymentController {

    private final PaymentService service;

    PaymentController(PaymentService service) {
        this.service = service;
    }

    @PutMapping("{id}/pay")
    ResponseEntity<?> payBy(@PathVariable Long id) {
        PaymentView payment = service.payBookingBy(id);

        return ok(payment);
    }

}
