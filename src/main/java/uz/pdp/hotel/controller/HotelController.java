package uz.pdp.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.hotel.entity.Hotel;
import uz.pdp.hotel.repository.HotelRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("hotel")
public class HotelController {

    @Autowired
    HotelRepository repository;

    @GetMapping
    public List<Hotel> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public void add(@RequestBody Hotel hotel) {
        repository.save(hotel);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody Hotel hotel) {
        Optional<Hotel> hotelById = repository.findById(id);
        if (hotelById.isPresent()) {
            Hotel updateHotel = hotelById.get();
            repository.save(updateHotel);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        Optional<Hotel> hotelById = repository.findById(id);
        if (hotelById.isPresent()) {
            repository.deleteById(id);
        }
    }
}
