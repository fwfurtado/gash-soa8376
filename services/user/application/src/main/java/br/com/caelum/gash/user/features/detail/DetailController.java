package br.com.caelum.gash.user.features.detail;

import static org.springframework.http.ResponseEntity.ok;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("users")
class DetailController {
    private static final Logger LOG = LoggerFactory.getLogger(DetailController.class);

    private final DetailService service;

    DetailController(DetailService service) {
        this.service = service;
    }

    @GetMapping("{slug}")
    ResponseEntity<?> detailing(@PathVariable String slug) {
        LOG.info("Trying to show details of user by slug {}", slug);

        UserView user = service.showBy(slug);

        return ok(user);
    }
}
