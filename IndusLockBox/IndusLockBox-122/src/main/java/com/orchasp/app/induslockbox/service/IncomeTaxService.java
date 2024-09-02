			package com.orchasp.app.induslockbox.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.entity.IncomeTax;
import com.orchasp.app.induslockbox.repository.CompanyRepository;
import com.orchasp.app.induslockbox.repository.IncomeTaxRepository;

@Service
public class IncomeTaxService {

	@Autowired
	private IncomeTaxRepository itRepository;
	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private PasswordService passwordService;

	public List<IncomeTax> findAll() {
		return itRepository.findAll();
	}

	public Optional<IncomeTax> findById(Long id) {
		return itRepository.findById(id);
	}

	public IncomeTax updateIncomeTax(Long id, IncomeTax updatedIncomeTax) {
		Optional<IncomeTax> existingIncomeTaxOpt = itRepository.findById(id);
		if (existingIncomeTaxOpt.isPresent()) {
			IncomeTax existingIncomeTax = existingIncomeTaxOpt.get();
			if(updatedIncomeTax.getPanNumber()!=null) {
			existingIncomeTax.setPanNumber(updatedIncomeTax.getPanNumber());
			}
			if(updatedIncomeTax.getName()!=null) {
			existingIncomeTax.setName(updatedIncomeTax.getName());
			}
			if(updatedIncomeTax.getPanIssuedDate()!=null) {
			existingIncomeTax.setPanIssuedDate(updatedIncomeTax.getPanIssuedDate());
			}
			if(updatedIncomeTax.getIncorporationDate()!=null) {
			existingIncomeTax.setIncorporationDate(updatedIncomeTax.getIncorporationDate());
			}
			if(updatedIncomeTax.getPrimaryEmail()!=null) {
			existingIncomeTax.setPrimaryEmail(updatedIncomeTax.getPrimaryEmail());
			}
			if(updatedIncomeTax.getSecondaryEmail()!=null) {
			existingIncomeTax.setSecondaryEmail(updatedIncomeTax.getSecondaryEmail());
			}
			if(updatedIncomeTax.getPrimaryMobile()!=null) {
			existingIncomeTax.setPrimaryMobile(updatedIncomeTax.getPrimaryMobile());
			}
			if(updatedIncomeTax.getSecondaryMobile()!=null) {
			existingIncomeTax.setSecondaryMobile(updatedIncomeTax.getSecondaryMobile());
		}
			if(updatedIncomeTax.getUserid()!=null) {
			existingIncomeTax.setUserid(updatedIncomeTax.getUserid());
			}
			if (updatedIncomeTax.getPassword().equals(existingIncomeTax.getPassword())) {
				existingIncomeTax.setPassword(updatedIncomeTax.getPassword());
			} else {
				existingIncomeTax.setPassword(passwordService.encrypt(updatedIncomeTax.getPassword()));
			}
			if(updatedIncomeTax.getCreatedBy()!=null) {
			existingIncomeTax.setCreatedBy(updatedIncomeTax.getCreatedBy());
			}
			if(updatedIncomeTax.getCreatedDate()!=null) {
			existingIncomeTax.setCreatedDate(updatedIncomeTax.getCreatedDate());
			}
			if(updatedIncomeTax.getUpdatedBy()!=null) {
			existingIncomeTax.setUpdatedBy(updatedIncomeTax.getUpdatedBy());
			}
			existingIncomeTax.setActive(updatedIncomeTax.isActive());
			existingIncomeTax.setUpdatedDate(LocalDateTime.now());

			Company updatedCompany = updatedIncomeTax.getCompany();
			if (updatedCompany != null) {
				Company existingCompany = existingIncomeTax.getCompany();
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
					existingIncomeTax.setCompany(updatedCompany);
				}
			}

			return itRepository.save(existingIncomeTax);
		} else {
			throw new RuntimeException("IncomeTax not found with id " + id);
		}
	}

	public IncomeTax save(IncomeTax it) {
		Long companyId = it.getCompany().getCompanyid();
		Optional<Company> company = companyRepository.findById(companyId);
		Company c = company.get();
		it.setCompany(c);
		it.setPassword(passwordService.encrypt(it.getPassword()));
		it.setActive(true);
		it.setCreatedDate(LocalDateTime.now());
		return itRepository.save(it);
	}

	public void deleteById(Long id) {
		Optional<IncomeTax> itop = itRepository.findById(id);
		if (itop.isPresent()) {
			IncomeTax it = itop.get();
			it.setActive(false);
		}
		// itRepository.deleteById(id);
	}

	public void activateById(Long id) {
		Optional<IncomeTax> IncomeTaxOpt = itRepository.findById(id);
		if (IncomeTaxOpt.isPresent()) {
			IncomeTax it = IncomeTaxOpt.get();
			it.setActive(true);
			itRepository.save(it);
		}
	}

	public List<IncomeTax> findByCompany_id(Long company_id) {
		return itRepository.findByCompany_id(company_id);
	}

	public String GetDecryptPassword(Long id) {
		Optional<IncomeTax> IncomeTaxOpt = itRepository.findById(id);
		if (IncomeTaxOpt.isPresent()) {
			IncomeTax incometax = IncomeTaxOpt.get();
			return passwordService.decrypt(incometax.getPassword());
		} else {
			throw new RuntimeException("IncomeTax not found with id " + id);
		}

	}

}