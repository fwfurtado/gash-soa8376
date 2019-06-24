package br.com.caelum.gash.booking.features.register;

import static org.springframework.http.ResponseEntity.created;

import java.net.URI;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("bookings")
class RegisterController {

    private final RegisterService service;

    RegisterController(RegisterService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<?> register(@Valid @RequestBody BookingForm form, UriComponentsBuilder uriBuilder) {
        Long id = service.createBy(form);

        URI uri = uriBuilder.path("booking/{id}").build(id);

        return created(uri).build();
    }
}
