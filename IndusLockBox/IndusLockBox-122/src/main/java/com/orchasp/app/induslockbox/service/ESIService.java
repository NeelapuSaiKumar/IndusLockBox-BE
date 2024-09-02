package com.orchasp.app.induslockbox.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.entity.ESI;
import com.orchasp.app.induslockbox.repository.CompanyRepository;
import com.orchasp.app.induslockbox.repository.ESIRepository;

@Service
public class ESIService {

	@Autowired
	private ESIRepository esiRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private PasswordService passwordService; // Injecting PasswordService

	public List<ESI> findAll() {
		return esiRepository.findAll();
	}

	public List<ESI> findByCompany_id(Long company_id) {
		return esiRepository.findByCompany_id(company_id);
	}

	public Optional<ESI> findById(Long id) {
		return esiRepository.findById(id);
	}

	public ESI updateESI(Long id, ESI updatedESI) {
		Optional<ESI> existingESIOpt = esiRepository.findById(id);
		if (existingESIOpt.isPresent()) {
			ESI existingESI = existingESIOpt.get();
			if (updatedESI.getEmployerCodeNo() != null) {
				existingESI.setEmployerCodeNo(updatedESI.getEmployerCodeNo());
			}
			if (updatedESI.getEmployerName() != null) {
				existingESI.setEmployerName(updatedESI.getEmployerName());
			}
			if (updatedESI.getEmailId() != null) {
				existingESI.setEmailId(updatedESI.getEmailId());
			}
			if (updatedESI.getMobileNo() != null) {
				existingESI.setMobileNo(updatedESI.getMobileNo());
			}
			if (updatedESI.getUserid() != null) {
				existingESI.setUserid(updatedESI.getUserid());
			}
			if (updatedESI.getPassword().equals(existingESI.getPassword())) {
				existingESI.setPassword(updatedESI.getPassword());
			} else {
				existingESI.setPassword(passwordService.encrypt(updatedESI.getPassword()));
			}
			if (updatedESI.getSignatory() != null) {
				existingESI.setSignatory(updatedESI.getSignatory());
			}
			if (updatedESI.getRo() != null) {
				existingESI.setRo(updatedESI.getRo());
			}
			if (updatedESI.getLin() != null) {
				existingESI.setLin(updatedESI.getLin());
			}
			if (updatedESI.getCreatedBy() != null) {
				existingESI.setCreatedBy(updatedESI.getCreatedBy());
			}
			if (updatedESI.getCreatedDate() != null) {
				existingESI.setCreatedDate(updatedESI.getCreatedDate());
			}
			if (updatedESI.getUpdatedBy() != null) {
				existingESI.setUpdatedBy(updatedESI.getUpdatedBy());
			}
			existingESI.setUpdatedDate(LocalDateTime.now());
			existingESI.setActive(updatedESI.isActive());

			Company updatedCompany = updatedESI.getCompany();
			if (updatedCompany != null) {
				Company existingCompany = existingESI.getCompany();
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
					existingESI.setCompany(updatedCompany);
				}
			}

			return esiRepository.save(existingESI);
		} else {
			throw new RuntimeException("ESI not found with id " + id);
		}
	}

	public ESI save(ESI esi) {
		Long companyId = esi.getCompany().getCompanyid();
		Optional<Company> company = companyRepository.findById(companyId);
//		company.ifPresent(ESI::setCompany);
		Company c = company.get();
		esi.setCompany(c);
		esi.setCreatedDate(LocalDateTime.now());
		esi.setActive(true);
		esi.setPassword(passwordService.encrypt(esi.getPassword()));
		return esiRepository.save(esi);
	}

	public void deleteById(Long id) {
		Optional<ESI> ESIOpt = esiRepository.findById(id);
		ESIOpt.ifPresent(esi -> {
			esi.setActive(false);
			esiRepository.save(esi);
		});
	}

	public void activateById(Long id) {
		Optional<ESI> ESIOpt = esiRepository.findById(id);
		ESIOpt.ifPresent(esi -> {
			esi.setActive(true);
			esiRepository.save(esi);
		});
	}

	public String GetDecryptPassword(Long id) {
		Optional<ESI> ESIOpt = esiRepository.findById(id);
		if (ESIOpt.isPresent()) {
			ESI esi = ESIOpt.get();
			return passwordService.decrypt(esi.getPassword());
		} else {
			throw new RuntimeException("ESI not found with id " + id);
		}
	}
}
