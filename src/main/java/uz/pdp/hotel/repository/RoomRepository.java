package uz.pdp.hotel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hotel.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

    Page<Room> getAllByHotelId(Long hotel_id, Pageable pageable);
}
