package com.orchasp.app.induslockbox.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.orchasp.app.induslockbox.dto.KMPDTO;
import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.entity.KMP;
import com.orchasp.app.induslockbox.repository.CompanyRepository;
import com.orchasp.app.induslockbox.repository.KMPRepository;

@Service
public class KMPService {

	@Autowired
	private KMPRepository kmpRepository;

	@Autowired
	private CompanyRepository companyRepository;

	public final String uploadDirectory1 = System.getProperty("user.dir") + "/src/main/kmpphotos";
	public final String uploadDirectory2 = System.getProperty("user.dir") + "/src/main/resumedb";

	public List<KMP> findAll() {
		return kmpRepository.findAll();
	}

	public List<KMP> findByCompany_id(Long company_id) {
		return kmpRepository.findByCompany_id(company_id);
	}

	public Optional<KMP> findById(Long id) {
		return kmpRepository.findById(id);
	}

	public KMP updateKMP(Long id, KMP updatedKMP) {
		Optional<KMP> existingKMPOpt = kmpRepository.findById(id);
		if (existingKMPOpt.isPresent()) {
			KMP existingKMP = existingKMPOpt.get();
			if (updatedKMP.getEmail() != null) {
				existingKMP.setEmail(updatedKMP.getEmail());
			}
			if (updatedKMP.getName() != null) {
				existingKMP.setName(updatedKMP.getName());
			}
			if (updatedKMP.getDesignation() != null) {
				existingKMP.setDesignation(updatedKMP.getDesignation());
			}
			if (updatedKMP.getMobileNo() != null) {
				existingKMP.setMobileNo(updatedKMP.getMobileNo());
			}
			if (updatedKMP.getAddress() != null) {
				existingKMP.setAddress(updatedKMP.getAddress());
			}
			if (updatedKMP.getState() != null) {
				existingKMP.setState(updatedKMP.getState());
			}
			if (updatedKMP.getAadharNo() != null) {
				existingKMP.setAadharNo(updatedKMP.getAadharNo());
			}
			if (updatedKMP.getPassportNo() != null) {
				existingKMP.setPassportNo(updatedKMP.getPassportNo());
			}
			if (updatedKMP.getPanNo() != null) {
				existingKMP.setPanNo(updatedKMP.getPanNo());
			}
			if (updatedKMP.getCreatedBy() != null) {
				existingKMP.setCreatedBy(updatedKMP.getCreatedBy());
			}
			if (updatedKMP.getCreatedDate() != null) {
				existingKMP.setCreatedDate(updatedKMP.getCreatedDate());
			}
			if (updatedKMP.getUpdatedBy() != null) {
				existingKMP.setUpdatedBy(updatedKMP.getUpdatedBy());
			}
			if (updatedKMP.getPhotoName() != null) {
				existingKMP.setPhotoName(updatedKMP.getPhotoName());
			}
			if (updatedKMP.getResumeName() != null) {
				existingKMP.setPhotoName(updatedKMP.getResumeName());
			}
			existingKMP.setUpdatedDate(LocalDateTime.now());
			existingKMP.setActive(updatedKMP.isActive());

			Company updatedCompany = updatedKMP.getCompany();
			if (updatedCompany != null) {
				Company existingCompany = existingKMP.getCompany();
				if (existingCompany != null) {
					if (updatedCompany.getCompanyCode() != null) {
						existingCompany.setCompanyCode(updatedCompany.getCompanyCode());
					}
					if (updatedCompany.getCin() != null) {
						existingCompany.setCin(updatedCompany.getCin());
					}
					if (updatedCompany.getCompanyname() != null) {
						existingCompany.setCompanyname(updatedCompany.getCompanyname());
					}
					if (updatedCompany.getDateOfIncorporation() != null) {
						existingCompany.setDateOfIncorporation(updatedCompany.getDateOfIncorporation());
					}
					if (updatedCompany.getRegisterNo() != null) {
						existingCompany.setRegisterNo(updatedCompany.getRegisterNo());
					}
					if (updatedCompany.getTelephone() != null) {
						existingCompany.setTelephone(updatedCompany.getTelephone());
					}
					if (updatedCompany.getEmail() != null) {
						existingCompany.setEmail(updatedCompany.getEmail());
					}
					if (updatedCompany.getAddress() != null) {
						existingCompany.setAddress(updatedCompany.getAddress());
					}
					if (updatedCompany.getWebsite() != null) {
						existingCompany.setWebsite(updatedCompany.getWebsite());
					}
					if (updatedCompany.getContactNo() != null) {
						existingCompany.setContactNo(updatedCompany.getContactNo());
					}
					if (updatedCompany.getFaxNo() != null) {
						existingCompany.setFaxNo(updatedCompany.getFaxNo());
					}
					if (updatedCompany.getCity() != null) {
						existingCompany.setCity(updatedCompany.getCity());
					}
					if (updatedCompany.getState() != null) {
						existingCompany.setState(updatedCompany.getState());
					}
					if (updatedCompany.getPincode() != null) {
						existingCompany.setPincode(updatedCompany.getPincode());
					}
					if (updatedCompany.getUpdatedBy() != null) {
						existingCompany.setUpdatedBy(updatedCompany.getUpdatedBy());
					}
					if (updatedCompany.getLogoName() != null) {
						existingCompany.setLogoName(updatedCompany.getLogoName());
					}
					existingCompany.setUpdatedDate(LocalDateTime.now());
					existingCompany.setActive(updatedCompany.isActive());
					companyRepository.save(existingCompany);
				} else {
					companyRepository.save(updatedCompany);
					existingKMP.setCompany(updatedCompany);
				}
			}

			return kmpRepository.save(existingKMP);
		} else {
			throw new RuntimeException("KMP not found with id " + id);
		}
	}

	public KMP updateImage(Long id, MultipartFile photo) throws IOException {
		Optional<KMP> existingKmpOpt = kmpRepository.findById(id);
		if (existingKmpOpt.isPresent()) {
			KMP existingKmp = existingKmpOpt.get();

			if (existingKmp.getPhotoName() != null) {
				Path oldImagePath = Paths.get(uploadDirectory1, existingKmp.getPhotoName());
				Files.deleteIfExists(oldImagePath);
			}

			String originalFilename = photo.getOriginalFilename();
			Path newImagePath = Paths.get(uploadDirectory1, originalFilename);
			Files.write(newImagePath, photo.getBytes());

			existingKmp.setPhotoName(originalFilename);
			existingKmp.setUpdatedDate(LocalDateTime.now());

			return kmpRepository.save(existingKmp);
		} else {
			throw new RuntimeException("Company not found with id " + id);
		}
	}
	
	public KMP updateResume(Long id, MultipartFile resume) throws IOException {
		Optional<KMP> existingKmpOpt = kmpRepository.findById(id);
		if (existingKmpOpt.isPresent()) {
			KMP existingKmp = existingKmpOpt.get();

			if (existingKmp.getResumeName() != null) {
				Path oldImagePath = Paths.get(uploadDirectory2, existingKmp.getResumeName());
				Files.deleteIfExists(oldImagePath);
			}

			String originalFilename = resume.getOriginalFilename();
			Path newImagePath = Paths.get(uploadDirectory2, originalFilename);
			Files.write(newImagePath, resume.getBytes());

			existingKmp.setResumeName(originalFilename);
			existingKmp.setUpdatedDate(LocalDateTime.now());

			return kmpRepository.save(existingKmp);
		} else {
			throw new RuntimeException("Company not found with id " + id);
		}
	}

	public KMP save(KMPDTO kmp, MultipartFile photo, MultipartFile resume) throws Exception {
		Long companyId = kmp.getCompanyid();
		KMP k = new KMP();
		Optional<Company> companyOpt = companyRepository.findById(companyId);
		if (companyOpt.isPresent()) {
			Company company = companyOpt.get();
			String ofn1 = photo.getOriginalFilename();
			String ofn2 = resume.getOriginalFilename();
			Path filenameandpath = Paths.get(uploadDirectory1, ofn1);
			Path filenameandpath1 = Paths.get(uploadDirectory2, ofn2);
			Files.write(filenameandpath, photo.getBytes());
			Files.write(filenameandpath1, resume.getBytes());
			k.setPhotoName(ofn1);
			k.setResumeName(ofn2);
			k.setCompany(company);
			k.setName(kmp.getName());
			k.setAadharNo(kmp.getAadharNo());
			k.setAddress(kmp.getAddress());
			k.setCreatedDate(LocalDateTime.now());
			k.setDesignation(kmp.getDesignation());
			k.setEmail(kmp.getEmail());
			k.setMobileNo(kmp.getMobileNo());
			k.setPanNo(kmp.getPanNo());
			k.setPassportNo(kmp.getPassportNo());
			k.setState(kmp.getState());
			k.setActive(true);
			k.setCreatedBy(kmp.getName());
			return kmpRepository.save(k);
		} else {
			throw new RuntimeException("Company not found with id " + companyId);
		}
	}

	public void deleteById(Long id) {
		Optional<KMP> KMPOpt = kmpRepository.findById(id);
		if (KMPOpt.isPresent()) {
			KMP k = KMPOpt.get();
			k.setActive(false);
			kmpRepository.save(k);
		}

	}

	public void activateById(Long id) {
		Optional<KMP> kmpOpt = kmpRepository.findById(id);
		if (kmpOpt.isPresent()) {
			KMP kmp = kmpOpt.get();
			kmp.setActive(true);
			kmpRepository.save(kmp);
		}
	}
}