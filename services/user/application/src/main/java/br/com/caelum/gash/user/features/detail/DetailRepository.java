package br.com.caelum.gash.user.features.detail;

import br.com.caelum.gash.user.domain.User;
import java.util.Optional;
import org.springframework.data.repository.Repository;

interface DetailRepository extends Repository<User, Long> {
    Optional<UserView> findBySlug(String slug);
}
