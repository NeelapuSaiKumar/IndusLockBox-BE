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

import com.orchasp.app.induslockbox.dto.DirectorForm;
import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.entity.Director;
import com.orchasp.app.induslockbox.repository.CompanyRepository;
import com.orchasp.app.induslockbox.repository.DirectorRepository;

@Service
public class DirectorService {

	@Autowired
	private DirectorRepository directorRepository;
	@Autowired
	private CompanyRepository companyRepository;
	
	public final String uploadDirectory = System.getProperty("user.dir") + "/src/main/directorphotos";

	public List<Director> findAll() {
		return directorRepository.findAll();
	}

	public Optional<Director> findById(Long id) {
		return directorRepository.findById(id);
	}

	public Director updateDirector(Long id, Director updatedDirector) {
		Optional<Director> existingDirectorOpt = directorRepository.findById(id);
		if (existingDirectorOpt.isPresent()) {
			Director existingDirector = existingDirectorOpt.get();
			if(updatedDirector.getName()!=null) {
			existingDirector.setName(updatedDirector.getName());
			}
			if(updatedDirector.getEmail()!=null) {
			existingDirector.setEmail(updatedDirector.getEmail());
			}
			if(updatedDirector.getDinNo()!=null) {
			existingDirector.setDinNo(updatedDirector.getDinNo());
			}
			if(updatedDirector.getAddress()!=null) {
			existingDirector.setAddress(updatedDirector.getAddress());
			}
			if(updatedDirector.getDateOfAppointment()!=null) {
			existingDirector.setDateOfAppointment(updatedDirector.getDateOfAppointment());
			}
			if(updatedDirector.getDateOfExit()!=null) {
			existingDirector.setDateOfExit(updatedDirector.getDateOfExit());
			}
			if(updatedDirector.getPanNo()!=null) {
			existingDirector.setPanNo(updatedDirector.getPanNo());
			}
			if(updatedDirector.getPassportNo()!=null) {
			existingDirector.setPassportNo(updatedDirector.getPassportNo());
			}
			if(updatedDirector.getDesignation()!=null) {
			existingDirector.setDesignation(updatedDirector.getDesignation());
			}
			if(updatedDirector.getAadharNo()!=null) {
			existingDirector.setAadharNo(updatedDirector.getAadharNo());
			}
			if(updatedDirector.getCreatedBy()!=null) {
			existingDirector.setCreatedBy(updatedDirector.getCreatedBy());
			}
			if(updatedDirector.getCreatedDate()!=null) {
			existingDirector.setCreatedDate(updatedDirector.getCreatedDate());
			}
			if(updatedDirector.getUpdatedBy()!=null) {
			existingDirector.setUpdatedBy(updatedDirector.getUpdatedBy());
			}
			if(updatedDirector.getImageName()!=null)
			{
				existingDirector.setImageName(updatedDirector.getImageName());
			}
			existingDirector.setUpdatedDate(LocalDateTime.now());
			existingDirector.setActive(updatedDirector.isActive());

			Company updatedCompany = updatedDirector.getCompany();
			if (updatedCompany != null) {
				Company existingCompany = existingDirector.getCompany();
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
					if(updatedCompany.getLogoName()!=null)
					{
						existingCompany.setLogoName(updatedCompany.getLogoName());
					}
					existingCompany.setUpdatedDate(LocalDateTime.now());
					existingCompany.setActive(updatedCompany.isActive());
					companyRepository.save(existingCompany);
				} else {
					companyRepository.save(updatedCompany);
					existingDirector.setCompany(updatedCompany);
				}
			}

			// Save and return the updated director
			return directorRepository.save(existingDirector);
		} else {
			throw new RuntimeException("Director not found with id " + id);
		}
	}

	public Director updateImage(Long id, MultipartFile file) throws IOException {
		Optional<Director> existingDirectorOpt = directorRepository.findById(id);
		if (existingDirectorOpt.isPresent()) {
			Director existingDirector = existingDirectorOpt.get();
			
			if (existingDirector.getImageName() != null) {
				Path oldImagePath = Paths.get(uploadDirectory, existingDirector.getImageName());
				Files.deleteIfExists(oldImagePath);
			}

			String originalFilename = file.getOriginalFilename();
			Path newImagePath = Paths.get(uploadDirectory, originalFilename);
			Files.write(newImagePath, file.getBytes());

			existingDirector.setImageName(originalFilename);
			existingDirector.setUpdatedDate(LocalDateTime.now());

			return directorRepository.save(existingDirector);
		} else {
			throw new RuntimeException("Company not found with id " + id);
		}
	}
	
	public Director save(DirectorForm director,MultipartFile file) throws Exception {
		Long companyId = director.getCompanyid();
		Director d = new Director();
		Optional<Company> companyOpt = companyRepository.findById(companyId);
		if (companyOpt.isPresent()) {
			Company company = companyOpt.get();
			 String ofn = file.getOriginalFilename();
	        Path filenameandpath = Paths.get(uploadDirectory, ofn);
	        Files.write(filenameandpath, file.getBytes());
	        d.setImageName(ofn);
			d.setCompany(company);
			d.setName(director.getName());
			d.setAadharNo(director.getAadharNo());
			d.setAddress(director.getAddress());
			d.setDateOfAppointment(director.getDateOfAppointment());
			d.setCreatedDate(LocalDateTime.now());
			d.setDesignation(director.getDesignation());
			d.setDinNo(director.getDinNo());
			d.setEmail(director.getEmail());
			d.setMobileNo(director.getMobileNo());
			d.setPanNo(director.getPanNo());
			d.setPassportNo(director.getPassportNo());
			d.setUpdatedBy(director.getUpdatedBy());
			d.setActive(true);
			d.setCreatedBy(director.getName());
			return directorRepository.save(d);
		} else {
			throw new RuntimeException("Company not found with id " + companyId);
		}
	}

	public List<Director> findByCompany_id(Long company_id) {
		return directorRepository.findByCompany_id(company_id);
	}

	public void deleteById(Long id) {
		Optional<Director> d = directorRepository.findById(id);
		if (d.isPresent()) {
			Director director = d.get();
			director.setActive(false);
			directorRepository.save(director);
		}
	}

	public void activateById(Long id) {
		Optional<Director> DirectorOpt = directorRepository.findById(id);
		if (DirectorOpt.isPresent()) {
			Director director = DirectorOpt.get();
			director.setActive(true);
			directorRepository.save(director);
		}
	}
}