package com.stayease.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.stayease.model.Booking;
import com.stayease.model.User;
import com.stayease.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/hotels/{hotelId}/book")
    @PreAuthorize("hasRole('CUSTOMER')")
    public ResponseEntity<Booking> bookRoom(@PathVariable Long hotelId, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(bookingService.bookRoom(hotelId, user.getId()));
    }

    @DeleteMapping("/{bookingId}")
    @PreAuthorize("hasRole('HOTEL_MANAGER')")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
        return ResponseEntity.ok().build();
    }
}
