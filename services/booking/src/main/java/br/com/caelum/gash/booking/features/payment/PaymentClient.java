package br.com.caelum.gash.booking.features.payment;

import br.com.caelum.gash.booking.shared.exception.PaymentException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
class PaymentClient {

    private final RestTemplate rest;
    private final String paymentURL;

    PaymentClient(RestTemplate rest, @Value("${gash.urls.payment}") String paymentURL) {
        this.rest = rest;
        this.paymentURL = paymentURL;
    }


    @HystrixCommand(fallbackMethod = "payBookingFallback", ignoreExceptions = PaymentException.class)
    Optional<PaymentView> payBooking(PaymentRequest request) {

        ResponseEntity<PaymentView> response = rest.postForEntity(paymentURL, request, PaymentView.class);

        if (response.getStatusCode().is2xxSuccessful()){
            PaymentView body = response.getBody();

            return Optional.ofNullable(body);
        }

        throw new PaymentException(response.getStatusCode());
    }

    Optional<PaymentView> payBookingFallback(PaymentRequest request) {
        return Optional.empty();
    }
}
