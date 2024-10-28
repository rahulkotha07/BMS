package dev.rahul.BMS.repository;

import dev.rahul.BMS.model.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Integer> {
    List<Auditorium> findAllByTheatre_Id(int theatreId);
}
