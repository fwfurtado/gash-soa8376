package br.com.caelum.gash.booking.features.payment;

import br.com.caelum.gash.booking.shared.domain.Booking;
import java.util.Optional;
import org.springframework.data.repository.Repository;

interface PaymentBookingRepository extends Repository<Booking, Long> {

    Optional<Booking> findById(Long id);

    void save(Booking booking);
}
