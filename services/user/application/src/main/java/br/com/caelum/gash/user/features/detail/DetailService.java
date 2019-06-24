package br.com.caelum.gash.user.features.detail;

import br.com.caelum.gash.user.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
class DetailService {

    private final DetailRepository repository;

    DetailService(DetailRepository repository) {
        this.repository = repository;
    }

    UserView showBy(String slug) {
       return repository
                .findBySlug(slug)
                    .orElseThrow(() -> new UserNotFoundException(String.format("Cannot find user with slug '%s'", slug)));
    }
}
