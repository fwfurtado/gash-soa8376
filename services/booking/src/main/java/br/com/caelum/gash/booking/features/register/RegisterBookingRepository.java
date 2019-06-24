package br.com.caelum.gash.booking.features.register;

import br.com.caelum.gash.booking.shared.domain.Booking;
import org.springframework.data.repository.Repository;

interface RegisterBookingRepository extends Repository<Booking, Long> {

    void save(Booking booking);
}
