package com.stayease.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.stayease.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {}
