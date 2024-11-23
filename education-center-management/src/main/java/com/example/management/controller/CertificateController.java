package com.example.management.controller;

import com.example.management.model.Certificate;
import com.example.management.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certificates")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CertificateController {
    @Autowired
    private CertificateService certificateService;

    @GetMapping
    public List<Certificate> getAllCertificates() {
        return certificateService.getAllCertificates();
    }

    @GetMapping("/{id}")
    public Certificate getCertificateById(@PathVariable Long id) {
        return certificateService.getCertificateById(id).orElseThrow();
    }

    @PostMapping
    public Certificate createCertificate(@RequestBody Certificate certificate) {
        return certificateService.createCertificate(certificate);
    }

    @PutMapping("/{id}")
    public Certificate updateCertificate(@PathVariable Long id, @RequestBody Certificate certificateDetails) {
        return certificateService.updateCertificate(id, certificateDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCertificate(@PathVariable Long id) {
        certificateService.deleteCertificate(id);
    }
}