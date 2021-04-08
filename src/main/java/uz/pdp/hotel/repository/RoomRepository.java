package uz.pdp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hotel.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
