package dev.rahul.BMS.service;

import dev.rahul.BMS.exception.TheatreNotFoundException;
import dev.rahul.BMS.model.Theatre;
import dev.rahul.BMS.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;

    public Theatre createTheatre(Theatre theatre) {
        return theatreRepository.save(theatre);
    }

    public Theatre getTheatreById(int id) {
        return theatreRepository.findById(id).orElseThrow(
                () -> new TheatreNotFoundException("Theatre with id " + id + " not found")
        );
    }

    public List<Theatre> getAllTheatresByCityId(int id) {
        return theatreRepository.findAllByCity_Id(id);
    }

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public void deleteTheatreById(int id) {
        theatreRepository.deleteById(id);
    }
}