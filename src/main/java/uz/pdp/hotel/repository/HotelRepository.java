package uz.pdp.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.hotel.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {
}
