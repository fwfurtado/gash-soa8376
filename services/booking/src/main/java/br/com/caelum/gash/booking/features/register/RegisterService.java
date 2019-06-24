package br.com.caelum.gash.booking.features.register;

import br.com.caelum.gash.booking.shared.domain.Booking;
import br.com.caelum.gash.booking.shared.domain.Garage;
import br.com.caelum.gash.booking.shared.domain.User;
import br.com.caelum.gash.booking.shared.exception.CustomerNotFoundException;
import br.com.caelum.gash.booking.shared.exception.GarageNotFoundException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
class RegisterService {

    private final FindUserRepository userRepository;
    private final FindGarageRepository garageRepository;
    private final RegisterBookingRepository bookingRepository;
    private final Converter<BookingForm, Booking> converter;

    RegisterService(FindUserRepository userRepository, FindGarageRepository garageRepository, RegisterBookingRepository bookingRepository, Converter<BookingForm, Booking> converter) {
        this.userRepository = userRepository;
        this.garageRepository = garageRepository;
        this.bookingRepository = bookingRepository;
        this.converter = converter;
    }

    Long createBy(BookingForm form) {
        Long customerId = form.getCustomerId();
        User customer = userRepository.findById(customerId)
                                .orElseThrow(() -> new CustomerNotFoundException(customerId));

        Long garageId = form.getGarageId();
        Garage garage = garageRepository.findById(garageId)
                                .orElseThrow(() -> new GarageNotFoundException(garageId));

        Booking booking = converter.convert(form);
        booking.setCustomer(customer);
        booking.setGarage(garage);

        bookingRepository.save(booking);

        return booking.getId();
    }
}
