package com.orchasp.app.induslockbox.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.orchasp.app.induslockbox.dto.CompanyDTO;
import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.service.CompanyService;

@RestController
@RequestMapping("/api/admin/companies")
@CrossOrigin(origins = "http://localhost:4200")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	public final String uploadDirectory = System.getProperty("user.dir") + "/src/main/companylogos";

	@GetMapping("/fetchall")
	public List<Company> getAllOrganisations() {
		return companyService.findAll();
	}

	@GetMapping("/fetchbyid/{id}")
	public ResponseEntity<Company> getOrganisationById(@PathVariable Long id) {
		Optional<Company> company = companyService.findById(id);
		return company.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/images/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws Exception {
		Optional<Company> imageOpt = companyService.findById(id);
		if (imageOpt.isPresent()) {
			Company c = imageOpt.get();
			Path path = Paths.get(uploadDirectory, c.getLogoName());
			byte[] imageBytes = Files.readAllBytes(path);
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + c.getLogoName() + "\"");
			headers.add(HttpHeaders.CONTENT_TYPE, Files.probeContentType(path));

			return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/save")
	public Company createOrganisation(@ModelAttribute CompanyDTO organisation, @RequestParam("file") MultipartFile file)
			throws Exception {
		return companyService.save(organisation, file);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Company> updateOrganisation(@PathVariable Long id, @RequestBody Company organisationDetails) {
		try {
			Company updatedOrganisation = companyService.updateCompany(id, organisationDetails);
			return ResponseEntity.ok(updatedOrganisation);
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/updateImage/{id}")
	public ResponseEntity<Company> updateCompanyImage(@PathVariable Long id, @RequestParam("file") MultipartFile file)
			throws Exception {

		Company updatedCompany = companyService.updateImage(id, file);
		if (updatedCompany != null) {
			return ResponseEntity.ok(updatedCompany);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteOrganisation(@PathVariable Long id) {
		companyService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PatchMapping("/activate/{id}")
	public void activateCompany(@PathVariable Long id) {
		companyService.activateById(id);
	}
}