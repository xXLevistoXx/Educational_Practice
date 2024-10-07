package com.web_project.school.service;

import com.web_project.school.model.SubjectModel;
import com.web_project.school.repository.SubjectRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InMemorySubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    public InMemorySubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public List<SubjectModel> findAllSubjects() {
        return subjectRepository.findAll(Sort.by("id"));
    }

    @Override
    public SubjectModel findSubjectById(UUID id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @Override
    public SubjectModel addSubject(SubjectModel subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public SubjectModel updateSubject(SubjectModel subject) {
        if (subjectRepository.existsById(subject.getId())) {
            return subjectRepository.save(subject);
        }
        return null;
    }

    @Override
    public void deleteSubject(UUID id) {
        if (subjectRepository.existsById(id)) {
            subjectRepository.deleteById(id);
        }
    }
}
