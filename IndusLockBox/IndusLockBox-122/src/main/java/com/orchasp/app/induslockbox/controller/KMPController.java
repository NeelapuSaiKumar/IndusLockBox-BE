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

import com.orchasp.app.induslockbox.dto.KMPDTO;
import com.orchasp.app.induslockbox.entity.KMP;
import com.orchasp.app.induslockbox.service.KMPService;

@RestController
@RequestMapping("/api/admin/kmp")
@CrossOrigin(origins = "http://localhost:4200")
public class KMPController {

    @Autowired
    private KMPService kmpService;
    
    public final String uploadDirectory1 = System.getProperty("user.dir") + "/src/main/kmpphotos";
	public final String uploadDirectory2 = System.getProperty("user.dir") + "/src/main/resumedb";

    @GetMapping("/fetchall")
    public List<KMP> getAllKMPs() {
        return kmpService.findAll();
    }

    @GetMapping("/fetchbyid/{id}")
    public ResponseEntity<KMP> getKMPById(@PathVariable Long id) {
        Optional<KMP> KMP = kmpService.findById(id);
        return KMP.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/images/{id}")
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws Exception {
		Optional<KMP> imageOpt = kmpService.findById(id);
		if (imageOpt.isPresent()) {
			KMP k = imageOpt.get();
			Path path = Paths.get(uploadDirectory1, k.getPhotoName());
			byte[] imageBytes = Files.readAllBytes(path);
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + k.getPhotoName() + "\"");
			headers.add(HttpHeaders.CONTENT_TYPE, Files.probeContentType(path));

			return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
    
    @GetMapping("/company/{company_id}")
    public ResponseEntity<List<KMP>> getKMPByCompanyId(@PathVariable Long company_id) {
        List<KMP> KMPDetails = kmpService.findByCompany_id(company_id);
        return ResponseEntity.ok(KMPDetails);
    }

    @PostMapping("/save")
    public KMP createKMP(@ModelAttribute KMPDTO kmpDto,@RequestParam("photo") MultipartFile photo,@RequestParam("resume") MultipartFile resume) throws Exception{
       return kmpService.save( kmpDto,photo,resume);
           
    }

    @PutMapping("/update/{id}")
    public KMP updateKMP(@PathVariable Long id, @RequestBody KMP kmp){
       return kmpService.updateKMP(id, kmp);
    }    
    @PutMapping("/updateImage/{id}")
	public ResponseEntity<KMP> updateKmpImage(@PathVariable Long id, @RequestParam("photo") MultipartFile photo) 
			throws Exception {

		KMP updatedKmp= kmpService.updateImage(id, photo);
		if (updatedKmp != null) {
			return ResponseEntity.ok(updatedKmp);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
    
    @PutMapping("/updateResume/{id}")
 	public ResponseEntity<KMP> updateKmpResume(@PathVariable Long id, @RequestParam("resume") MultipartFile resume) 
 			throws Exception {

 		KMP resumeKmp= kmpService.updateResume(id, resume);
 		if (resumeKmp != null) {
 			return ResponseEntity.ok(resumeKmp);
 		} else {
 			return ResponseEntity.notFound().build();
 		}

 	}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteKMP(@PathVariable Long id) {
        kmpService.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    @PatchMapping("/activate/{id}")
    public void activateKMP(@PathVariable Long id) {
        kmpService.activateById(id);
    }
}