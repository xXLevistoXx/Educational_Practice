package com.web_project.school.service;

import com.web_project.school.model.PositionModel;
import com.web_project.school.repository.PassportRepository;
import com.web_project.school.repository.PositionRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryPositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    public InMemoryPositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<PositionModel> findAllPositions() {
        return positionRepository.findAll(Sort.by("id"));
    }

    @Override
    public PositionModel findPositionById(UUID id) {
        return positionRepository.findById(id).orElse(null);
    }

    @Override
    public PositionModel addPosition(PositionModel position) {
        return positionRepository.save(position);
    }

    @Override
    public PositionModel updatePosition(PositionModel position) {
        if (positionRepository.existsById(position.getId())) {
            return positionRepository.save(position);
        }
        return null;
    }

    @Override
    public void deletePosition(UUID id) {
        if (positionRepository.existsById(id)) {
            positionRepository.deleteById(id);
        }
    }
}
