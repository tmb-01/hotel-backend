package uz.pdp.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import uz.pdp.hotel.entity.Hotel;
import uz.pdp.hotel.entity.Room;
import uz.pdp.hotel.repository.HotelRepository;
import uz.pdp.hotel.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("room")
public class RoomController {

    @Autowired
    RoomRepository repository;

    @GetMapping
    public Page<Room> getAll(@RequestParam int page) {

        PageRequest pageRequest = PageRequest.of(page,10);
        return repository.findAll(pageRequest);
    }

    @PostMapping
    public void add(@RequestBody Room room) {
        repository.save(room);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody Room room) {
        Optional<Room> roomById = repository.findById(id);
        if (roomById.isPresent()) {
            Room updateRoom = roomById.get();
            updateRoom.setFloor(room.getFloor());
            updateRoom.setHotel(room.getHotel());
            updateRoom.setNumber(room.getNumber());
            updateRoom.setSize(room.getSize());

            repository.save(updateRoom);
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        Optional<Room> roomById = repository.findById(id);
        if (roomById.isPresent()) {
            repository.deleteById(id);
        }
    }

}
