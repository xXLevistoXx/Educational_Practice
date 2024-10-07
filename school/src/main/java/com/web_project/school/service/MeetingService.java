package com.web_project.school.service;

import com.web_project.school.model.MeetingModel;

import java.util.List;
import java.util.UUID;

public interface MeetingService {
    public List<MeetingModel> findAllMeetings();

    public MeetingModel findMeetingById(UUID id);

    public MeetingModel addMeeting(MeetingModel meeting);

    public MeetingModel updateMeeting(MeetingModel meeting);

    public void deleteMeeting(UUID id);
}
