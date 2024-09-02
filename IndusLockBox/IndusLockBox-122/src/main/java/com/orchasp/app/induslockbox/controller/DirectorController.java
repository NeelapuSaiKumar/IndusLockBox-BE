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

import com.orchasp.app.induslockbox.dto.DirectorForm;
import com.orchasp.app.induslockbox.entity.Director;
import com.orchasp.app.induslockbox.service.DirectorService;

@RestController
@RequestMapping("/api/admin/directors")
@CrossOrigin(origins = "http://localhost:4200")
public class DirectorController {

	@Autowired
	private DirectorService directorService;
	
	public final String uploadDirectory = System.getProperty("user.dir") + "/src/main/directorphotos";

	@GetMapping("/fetchall")
	public List<Director> getAllBanks() {
		return directorService.findAll();
	}

	@GetMapping("/fetchbyid/{id}")
	public ResponseEntity<Director> getDirectorById(@PathVariable Long id) {
		Optional<Director> Director = directorService.findById(id);
		return Director.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping("/company/{company_id}")
	public ResponseEntity<List<Director>> getDirectorByCompanyId(@PathVariable Long company_id) {
		List<Director> DirectorDetails = directorService.findByCompany_id(company_id);
		return ResponseEntity.ok(DirectorDetails);
	}
	
	@GetMapping("/images/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws Exception {
		Optional<Director> imageOpt = directorService.findById(id);
		if (imageOpt.isPresent()) {
			Director d = imageOpt.get();
			Path path = Paths.get(uploadDirectory, d.getImageName());
			byte[] imageBytes = Files.readAllBytes(path);
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + d.getImageName() + "\"");
			headers.add(HttpHeaders.CONTENT_TYPE, Files.probeContentType(path));

			return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/save")
    public Director createDirector(@ModelAttribute DirectorForm director, @RequestParam("file") MultipartFile file) throws Exception {
		return directorService.save(director, file);
		
	}

	@PutMapping("/update/{id}")
	public Director updateDirector(@PathVariable Long id, @RequestBody Director directorDetails) {
		return directorService.updateDirector(id, directorDetails);
	}
	
	@PutMapping("/updateImage/{id}")
	public ResponseEntity<Director> updateDirectorImage(@PathVariable Long id, @RequestParam("file") MultipartFile file)
			throws Exception {

		Director updatedDirector = directorService.updateImage(id, file);
		if (updatedDirector != null) {
			return ResponseEntity.ok(updatedDirector);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteBank(@PathVariable Long id) {
		directorService.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PatchMapping("/activate/{id}")
	public void activateDirector(@PathVariable Long id) {
		directorService.activateById(id);
	}
}