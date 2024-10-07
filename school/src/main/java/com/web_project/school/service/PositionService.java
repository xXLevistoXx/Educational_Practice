package com.web_project.school.service;

import com.web_project.school.model.PositionModel;

import java.util.List;
import java.util.UUID;

public interface PositionService {
    public List<PositionModel> findAllPositions();

    public PositionModel findPositionById(UUID id);

    public PositionModel addPosition(PositionModel position);

    public PositionModel updatePosition(PositionModel position);

    public void deletePosition(UUID id);
}
