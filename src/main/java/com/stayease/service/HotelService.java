package com.stayease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stayease.model.Hotel;
import com.stayease.repository.HotelRepository;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> findAllHotels() {
        return hotelRepository.findAll();
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }
}
