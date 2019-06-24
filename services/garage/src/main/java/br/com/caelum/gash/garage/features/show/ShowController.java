package br.com.caelum.gash.garage.features.show;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("garages")
class ShowController {

    private final ShowService service;

    ShowController(ShowService service) {
        this.service = service;
    }

    @GetMapping("{garageId}")
    ResponseEntity<?> showBy(@PathVariable Long garageId) {
        GarageView garage = service.showGarageBy(garageId);

        return ok(garage);
    }
}
