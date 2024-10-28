package dev.rahul.BMS.repository;

import dev.rahul.BMS.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
    List<Theatre> findAllByCity_Id(int cityId);
}
