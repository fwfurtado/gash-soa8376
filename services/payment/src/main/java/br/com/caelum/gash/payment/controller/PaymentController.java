package br.com.caelum.gash.payment.controller;

import java.time.ZonedDateTime;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
class PaymentController {

    @PostMapping
    PaymentView payBy(@Valid @RequestBody PaymentForm form) {

        UUID id = UUID.randomUUID();
        ZonedDateTime time = ZonedDateTime.now();

        return new PaymentView(id, time);
    }

}
