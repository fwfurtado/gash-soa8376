package br.com.caelum.gash.booking.shared.configuration;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableHystrix
class CircuitBreakerConfiguration {

}
