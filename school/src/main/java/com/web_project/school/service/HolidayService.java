package com.web_project.school.service;

import com.web_project.school.model.HolidayModel;

import java.util.List;
import java.util.UUID;

public interface HolidayService {
    public List<HolidayModel> findAllHolidays();

    public HolidayModel findHolidayById(UUID id);

    public HolidayModel addHoliday(HolidayModel holiday);

    public HolidayModel updateHoliday(HolidayModel holiday);

    public void deleteHoliday(UUID id);
}

