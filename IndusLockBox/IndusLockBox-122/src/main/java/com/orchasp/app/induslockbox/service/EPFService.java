package com.orchasp.app.induslockbox.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.entity.EPF;
import com.orchasp.app.induslockbox.repository.CompanyRepository;
import com.orchasp.app.induslockbox.repository.EPFRepository;

@Service
public class EPFService {

	@Autowired
	private EPFRepository epfRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private PasswordService passwordService;

	public List<EPF> findAll() {
		return epfRepository.findAll();
	}

	public Optional<EPF> findById(Long id) {
		return epfRepository.findById(id);
	}

	public EPF updateEPF(Long id, EPF updatedEPF) {
		Optional<EPF> existingEPFOpt = epfRepository.findById(id);
		if (existingEPFOpt.isPresent()) {
			EPF existingEPF = existingEPFOpt.get();
			if(updatedEPF.getEstid()!=null) {
			existingEPF.setEstid(updatedEPF.getEstid());
			}
			if(updatedEPF.getLin()!=null) {
			existingEPF.setLin(updatedEPF.getLin());
			}
			if(updatedEPF.getNiccode()!=null) {
			existingEPF.setNiccode(updatedEPF.getNiccode());
			}
			if(updatedEPF.getPanno()!=null) {
			existingEPF.setPanno(updatedEPF.getPanno());
			}
			if(updatedEPF.getEmailId()!=null) {
			existingEPF.setEmailId(updatedEPF.getEmailId());
			}
			if(updatedEPF.getMobileNo()!=null) {
			existingEPF.setMobileNo(updatedEPF.getMobileNo());
			}
			if(updatedEPF.getUserid()!=null) {
			existingEPF.setUserid(updatedEPF.getUserid());
			}
			if (updatedEPF.getPassword().equals(existingEPF.getPassword())) {
				existingEPF.setPassword(updatedEPF.getPassword());
			} else {
				existingEPF.setPassword(passwordService.encrypt(updatedEPF.getPassword()));
			}
			if(updatedEPF.getPfOfficeAddress()!=null) {
			existingEPF.setPfOfficeAddress(updatedEPF.getPfOfficeAddress());
			}
			if(updatedEPF.getSignatory()!=null) {
			existingEPF.setSignatory(updatedEPF.getSignatory());
			}
			if(updatedEPF.getCreatedBy()!=null) {
			existingEPF.setCreatedBy(updatedEPF.getCreatedBy());
			}
			if(updatedEPF.getCreatedDate()!=null) {
			existingEPF.setCreatedDate(updatedEPF.getCreatedDate());
			}
			if(updatedEPF.getUpdatedBy()!=null) {
			existingEPF.setUpdatedBy(updatedEPF.getUpdatedBy());
			}
			existingEPF.setUpdatedDate(LocalDateTime.now());
			existingEPF.setActive(updatedEPF.isActive());

			Company updatedCompany = updatedEPF.getCompany();
			if (updatedCompany != null) {
				Company existingCompany = existingEPF.getCompany();
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
					existingEPF.setCompany(updatedCompany);
				}
			}
			return epfRepository.save(existingEPF);
		} else {
			throw new RuntimeException("Director not found with id " + id);
		}
	}

	public EPF save(EPF epf) {
		Long companyId = Optional.ofNullable(epf.getCompany()).map(Company::getCompanyid)
				.orElseThrow(() -> new RuntimeException("Company information is missing"));
		Company company = companyRepository.findById(companyId)
				.orElseThrow(() -> new RuntimeException("Company not found with id " + companyId));
		epf.setCompany(company);
		epf.setActive(true);
		epf.setPassword(passwordService.encrypt(epf.getPassword()));
		epf.setCreatedDate(LocalDateTime.now());
		return epfRepository.save(epf);
	}

	public void deleteById(Long id) {
		Optional<EPF> epfOpt = epfRepository.findById(id);
		if (epfOpt.isPresent()) {
			EPF epf = epfOpt.get();
			epf.setActive(false);
			epfRepository.save(epf);
		} else {
			throw new RuntimeException("EPF not found with id " + id);
		}
	}

	public List<EPF> findByCompany_id(Long company_id) {
		return epfRepository.findByCompany_id(company_id);
	}

	public void activateById(Long id) {
		Optional<EPF> epfOpt = epfRepository.findById(id);
		if (epfOpt.isPresent()) {
			EPF epf = epfOpt.get();
			epf.setActive(true);
			epfRepository.save(epf);
		} else {
			throw new RuntimeException("EPF not found with id " + id);
		}
	}

	public String GetDecryptPassword(Long id) {
		Optional<EPF> epfOpt = epfRepository.findById(id);
		if (epfOpt.isPresent()) {
			EPF epf = epfOpt.get();
			return passwordService.decrypt(epf.getPassword());
		} else {
			throw new RuntimeException("EPF not found with id " + id);
		}

	}

}
