package br.com.caelum.gash.user.features.detail;

import static org.springframework.http.ResponseEntity.notFound;

import br.com.caelum.gash.user.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class DetailExceptionHandler {

    private static Logger LOG = LoggerFactory.getLogger(DetailExceptionHandler.class);

    @ExceptionHandler
    ResponseEntity<?> handle(UserNotFoundException e) {
        LOG.error("[DETAIL][NOT_FOUND] {}", e.getMessage());

        return notFound().build();
    }
}
