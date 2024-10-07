package com.web_project.school.service;

import com.web_project.school.model.MeetingModel;
import com.web_project.school.repository.MeetingRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemoryMeetingServiceImpl implements MeetingService{
    private final MeetingRepository meetingRepository;

    public InMemoryMeetingServiceImpl(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }
    @Override
    public List<MeetingModel> findAllMeetings() {
        return meetingRepository.findAll(Sort.by("id"));
    }

    @Override
    public MeetingModel findMeetingById(UUID id) {
        return meetingRepository.findById(id).orElse(null);
    }

    @Override
    public MeetingModel addMeeting(MeetingModel meeting) {
        return meetingRepository.save(meeting);
    }

    @Override
    public MeetingModel updateMeeting(MeetingModel meeting) {
        if (meetingRepository.existsById(meeting.getId())) {
            return meetingRepository.save(meeting);
        }
        return null;
    }

    @Override
    public void deleteMeeting(UUID id) {
        if (meetingRepository.existsById(id)) {
            meetingRepository.deleteById(id);
        }
    }
}
