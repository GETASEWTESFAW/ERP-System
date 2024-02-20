package com.bingetgroup.ERP.services;

import com.bingetgroup.ERP.exception.RecordNotFoundException;
import com.bingetgroup.ERP.models.EducationBackgrounds;
import com.bingetgroup.ERP.models.Employees;
import com.bingetgroup.ERP.repositories.EducationBackgroundRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EducationBackgroundService {
    private final EducationBackgroundRepository educationBackgroundRepository;
    public EducationBackgrounds getEducationBackgroundById(long id){
    return this.educationBackgroundRepository.findById(id).orElseThrow(()->new RecordNotFoundException("Employee Education Background is not found."));
    }
    public List<EducationBackgrounds> getAllEducationBackground(int page, int size, String column){
        Sort sort=Sort.by(column).ascending();
        Pageable pageable= PageRequest.of(page,size,sort);
        return this.educationBackgroundRepository.findAll(pageable).getContent();
    }
    public EducationBackgrounds getEducationBackgroundByEmployee(Employees employees){
        return this.educationBackgroundRepository.findByEmployee(employees).orElseThrow(()->new RecordNotFoundException("Education background is not found for the given Employee"));
    }
    public String add(EducationBackgrounds educationBackground){
        this.educationBackgroundRepository.save(educationBackground);
        return "Employee education background is recorded successfully";
    }
    public String addAll(List<EducationBackgrounds> educationBackground){
        this.educationBackgroundRepository.saveAll(educationBackground);
        return "Employee education background is recorded successfully";
    }
    public String update(EducationBackgrounds educationBackground){
       EducationBackgrounds educationBackground1= getEducationBackgroundById(educationBackground.getId());
       educationBackground1.setEducationCertificate(educationBackground.getEducationCertificate());
       educationBackground1.setEducationDuration(educationBackground.getEducationDuration());
       educationBackground1.setInstitution(educationBackground.getInstitution());
       educationBackground1.setFieldOfStudy(educationBackground.getFieldOfStudy());
       educationBackground1.setStartedDate(educationBackground.getStartedDate());
       educationBackground1.setEndDate(educationBackground.getEndDate());
       this.educationBackgroundRepository.save(educationBackground1);
        return "Employee education background is updated successfully";
    }
    public String updateAll(List<EducationBackgrounds> educationBackgrounds){
        educationBackgrounds.stream().map((educationBackground)->update(educationBackground)).collect(Collectors.toList());
        return "Employee education backgrounds are updated successfully";
    }
    public String delete(EducationBackgrounds educationBackground){
          this.educationBackgroundRepository.delete(educationBackground);
        return "Employee education background is updated successfully";
    }
    public String deleteAll(List<EducationBackgrounds> educationBackgrounds){
        this.educationBackgroundRepository.deleteAll(educationBackgrounds);
        return "Employee education background is updated successfully";
    }
}
