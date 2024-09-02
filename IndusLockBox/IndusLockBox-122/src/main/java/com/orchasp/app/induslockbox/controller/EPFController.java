package com.orchasp.app.induslockbox.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orchasp.app.induslockbox.entity.EPF;
import com.orchasp.app.induslockbox.service.EPFService;

@RestController
@RequestMapping("/api/admin/epf")
@CrossOrigin(origins = "http://localhost:4200")
public class EPFController {

    private final EPFService epfService;

 
    public EPFController(EPFService epfService) {
        this.epfService = epfService;
    }

    @GetMapping("/fetchall")
    public List<EPF> getAllEPFs() {
        return epfService.findAll();
    }

    @GetMapping("/fetchbyid/{id}")
    public ResponseEntity<EPF> getEPFById(@PathVariable Long id) {
        Optional<EPF> epf = epfService.findById(id);
        return epf.map(ResponseEntity::ok)
                  .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public EPF createEPF(@RequestBody EPF epf) {
        return epfService.save(epf);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EPF> updateEPF(@PathVariable Long id, @RequestBody EPF epfDetails) {
        try {
            EPF updatedEPF = epfService.updateEPF(id, epfDetails);
            return ResponseEntity.ok(updatedEPF);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEPF(@PathVariable Long id) {
        epfService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/activate/{id}")
    public void activateEPF(@PathVariable Long id) {
        epfService.activateById(id);
    }

    @GetMapping("/company/{company_id}")
    public ResponseEntity<List<EPF>> getEPFByCompanyId(@PathVariable Long company_id) {
        List<EPF> epfDetails = epfService.findByCompany_id(company_id);
        return ResponseEntity.ok(epfDetails);
    }

    @GetMapping("/decrypt/{id}")
    public String getDecryptPassword(@PathVariable Long id) {
        return epfService.GetDecryptPassword(id);
    }
}
