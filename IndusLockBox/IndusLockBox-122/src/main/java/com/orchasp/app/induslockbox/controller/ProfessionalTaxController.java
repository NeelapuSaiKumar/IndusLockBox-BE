package com.orchasp.app.induslockbox.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.orchasp.app.induslockbox.entity.ProfessionalTax;
import com.orchasp.app.induslockbox.service.ProfessionalTaxService;

@RestController
@RequestMapping("/api/pt")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfessionalTaxController {
	  @Autowired
	    private ProfessionalTaxService ptService;

	    @GetMapping("/fetchall")
	    public List<ProfessionalTax> getAllProfessionalTaxs() {
	        return ptService.findAll();
	    }

	    @GetMapping("/fetchbyid/{id}")
	    public ResponseEntity<ProfessionalTax> getProfessionalTaxById(@PathVariable Long id) {
	        Optional<ProfessionalTax> ProfessionalTax = ptService.findById(id);
	        return ProfessionalTax.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound().build());
	    }
	    
	    @GetMapping("/company/{company_id}")
	    public ResponseEntity<List<ProfessionalTax>> getProfessionalTaxByCompanyId(@PathVariable Long company_id) {
	        List<ProfessionalTax> ProfessionalTaxDetails = ptService.findByCompany_id(company_id);
	        return ResponseEntity.ok(ProfessionalTaxDetails);
	    }

	    @PostMapping("/save")
	    public ProfessionalTax createProfessionalTax(@RequestBody ProfessionalTax ProfessionalTax) {
	        return ptService.save(ProfessionalTax);
	    }

	    @PutMapping("/update/{id}")
	    public ProfessionalTax updateProfessionalTax(@PathVariable Long id, @RequestBody ProfessionalTax updatedProfessionalTax) {
	        return ptService.updateProfessionalTax(id, updatedProfessionalTax);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteProfessionalTax(@PathVariable Long id) {
	    	ptService.deleteById(id);
	        return ResponseEntity.ok().build();
	    }
	    
	    @PatchMapping("/activate/{id}")
	    public void activateProfessionalTax(@PathVariable Long id) {
	    	ptService.activateById(id);
	    }
	    
	    @GetMapping("/decrypt/{id}")
	    public String getDecryptPassword(@PathVariable Long id) {
	    	return ptService.GetDecryptPassword(id);
	    }
}