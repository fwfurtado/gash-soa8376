package br.com.caelum.gash.user.features.register;

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
@RequestMapping("users")
class RegisterController {

    private final RegisterService service;

    RegisterController(RegisterService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<?> register(@RequestBody @Valid UserForm form, UriComponentsBuilder uriBuilder) {
        String slug = service.saveBy(form);

        URI uri = uriBuilder.path("/users/{id}").build(slug);

        return created(uri).build();
    }

}
