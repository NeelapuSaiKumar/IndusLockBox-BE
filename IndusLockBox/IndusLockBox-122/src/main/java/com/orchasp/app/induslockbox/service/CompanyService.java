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

import com.orchasp.app.induslockbox.dto.CompanyDTO;
import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	public final String uploadDirectory = System.getProperty("user.dir") + "/src/main/companylogos";

	public List<Company> findAll() {
		return companyRepository.findAll();
	}

	public Optional<Company> findById(Long id) {
		return companyRepository.findById(id);
	}

	public Company save(CompanyDTO company, MultipartFile file) throws IOException {
		Company c = new Company();
		String ofn = file.getOriginalFilename();
		Path filenameandpath = Paths.get(uploadDirectory, ofn);
		Files.write(filenameandpath, file.getBytes());
		c.setLogoName(ofn);
		c.setActive(true);
		c.setAddress(company.getAddress());
		c.setCin(company.getCin());
		c.setCity(company.getCity());
		c.setCompanyCode(company.getCompanyCode());
		c.setCompanyname(company.getCompanyname());
		c.setContactNo(company.getContactNo());
		c.setCreatedBy(company.getCreatedBy());
		c.setCreatedDate(LocalDateTime.now());
		c.setDateOfIncorporation(company.getDateOfIncorporation());
		c.setEmail(company.getEmail());
		c.setFaxNo(company.getFaxNo());
		c.setPincode(company.getPincode());
		c.setRegisterNo(company.getRegisterNo());
		c.setState(company.getState());
		c.setTelephone(company.getTelephone());
		c.setUpdatedBy(company.getUpdatedBy());
		c.setUpdatedDate(company.getUpdatedDate());
		c.setWebsite(company.getWebsite());
		return companyRepository.save(c);
	}

	public Company updateCompany(Long id, Company updatedCompany) {
		Optional<Company> existingCompanyOpt = companyRepository.findById(id);
		if (existingCompanyOpt.isPresent()) {
			Company existingCompany = existingCompanyOpt.get();
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

			return companyRepository.save(existingCompany);
		} else {
			throw new RuntimeException("Company not found with id " + id);
		}
	}

	public void deleteById(Long id) {
		Optional<Company> companyOpt = companyRepository.findById(id);
		if (companyOpt.isPresent()) {
			Company company = companyOpt.get();
			company.setActive(false);
			companyRepository.save(company);
		} else {
			throw new RuntimeException("Company not found with id " + id);
		}
	}

	public Company updateImage(Long id, MultipartFile file) throws IOException {
		Optional<Company> existingCompanyOpt = companyRepository.findById(id);
		if (existingCompanyOpt.isPresent()) {
			Company existingCompany = existingCompanyOpt.get();
			
			if (existingCompany.getLogoName() != null) {
				Path oldImagePath = Paths.get(uploadDirectory, existingCompany.getLogoName());
				Files.deleteIfExists(oldImagePath);
			}

			String originalFilename = file.getOriginalFilename();
			Path newImagePath = Paths.get(uploadDirectory, originalFilename);
			Files.write(newImagePath, file.getBytes());

			existingCompany.setLogoName(originalFilename);
			existingCompany.setUpdatedDate(LocalDateTime.now());

			return companyRepository.save(existingCompany);
		} else {
			throw new RuntimeException("Company not found with id " + id);
		}
	}

	public void activateById(Long id) {
		Optional<Company> companyOpt = companyRepository.findById(id);
		if (companyOpt.isPresent()) {
			Company company = companyOpt.get();
			company.setActive(true);
			companyRepository.save(company);
		} else {
			throw new RuntimeException("Company not found with id " + id);
		}
	}
}
