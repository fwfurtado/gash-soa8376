package br.com.caelum.gash.garage.features.creation;

import static org.springframework.http.ResponseEntity.created;

import java.net.URI;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("garages")
class CreationController {

    private final CreationService service;

    CreationController(CreationService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<?> createBy(Long userId, @Valid @RequestBody GarageForm form, UriComponentsBuilder uriBuilder) {
        form.setUserId(userId);

        Long garageId = service.saveBy(form);

        URI uri = uriBuilder.path("users/{userId}/garages/{garageId}").build(userId, garageId);

        return created(uri).build();
    }
}
