package com.example.management.service;

import com.example.management.model.Certificate;
import com.example.management.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateService {
    @Autowired
    private CertificateRepository certificateRepository;

    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    public Optional<Certificate> getCertificateById(Long id) {
        return certificateRepository.findById(id);
    }

    public Certificate createCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    public Certificate updateCertificate(Long id, Certificate certificateDetails) {
        Certificate certificate = certificateRepository.findById(id).orElseThrow();
        certificate.setStatus(certificateDetails.getStatus());
        certificate.setStudent(certificateDetails.getStudent());
        certificate.setCourse(certificateDetails.getCourse());
        return certificateRepository.save(certificate);
    }
    
    public void deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
    }
}