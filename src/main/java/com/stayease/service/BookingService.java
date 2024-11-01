package com.stayease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stayease.model.Booking;
import com.stayease.model.Hotel;
import com.stayease.model.User;
import com.stayease.repository.BookingRepository;
import com.stayease.repository.HotelRepository;
import com.stayease.repository.UserRepository;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private UserRepository userRepository;

    public Booking bookRoom(Long hotelId, Long userId) {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();
        Booking booking = new Booking();
        booking.setHotel(hotel);
        booking.setUser(user);
        return bookingRepository.save(booking);
    }

    public void cancelBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
