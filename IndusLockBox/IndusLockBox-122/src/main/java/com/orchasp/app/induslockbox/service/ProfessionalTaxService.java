package com.orchasp.app.induslockbox.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.entity.ProfessionalTax;
import com.orchasp.app.induslockbox.repository.CompanyRepository;
import com.orchasp.app.induslockbox.repository.ProfessionalTaxRepository;

@Service
public class ProfessionalTaxService {

	@Autowired
	private ProfessionalTaxRepository ptRepository;

	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private PasswordService passwordService;

	public List<ProfessionalTax> findAll() {
		return ptRepository.findAll();
	}

	public List<ProfessionalTax> findByCompany_id(Long company_id) {
		return ptRepository.findByCompany_id(company_id);
	}

	public Optional<ProfessionalTax> findById(Long id) {
		return ptRepository.findById(id);
	}

	public ProfessionalTax updateProfessionalTax(Long id, ProfessionalTax updatedProfessionalTax) {
		Optional<ProfessionalTax> existingProfessionalTaxOpt = ptRepository.findById(id);
		if (existingProfessionalTaxOpt.isPresent()) {
			ProfessionalTax existingProfessionalTax = existingProfessionalTaxOpt.get();

			 if(updatedProfessionalTax.getPtinCom()!=null) {
			existingProfessionalTax.setPtinCom(updatedProfessionalTax.getPtinCom());
			 }
			 if(updatedProfessionalTax.getPtinSal()!=null) {
			existingProfessionalTax.setPtinSal(updatedProfessionalTax.getPtinSal());
			 }
			 if(updatedProfessionalTax.getTaxDivision()!=null) {
			existingProfessionalTax.setTaxDivision(updatedProfessionalTax.getTaxDivision());
			 }
			 if(updatedProfessionalTax.getEmail()!=null) {
			existingProfessionalTax.setEmail(updatedProfessionalTax.getEmail());
			 }
			 if(updatedProfessionalTax.getTaxCircle()!=null) {
			existingProfessionalTax.setTaxCircle(updatedProfessionalTax.getTaxCircle());
			 }
			 if(updatedProfessionalTax.getMobileNo()!=null) {
			existingProfessionalTax.setMobileNo(updatedProfessionalTax.getMobileNo());
			 }
			 if(updatedProfessionalTax.getDateOfEnrollment()!=null) {
			existingProfessionalTax.setDateOfEnrollment(updatedProfessionalTax.getDateOfEnrollment());
			 }
			 if(updatedProfessionalTax.getUserid()!=null) {
			existingProfessionalTax.setUserid(updatedProfessionalTax.getUserid());
			 }
			if(updatedProfessionalTax.getPassword().equals(existingProfessionalTax.getPassword())) {
			existingProfessionalTax.setPassword(updatedProfessionalTax.getPassword());
			}
			else {
				existingProfessionalTax.setPassword(passwordService.encrypt(updatedProfessionalTax.getPassword()));
			}
			if(updatedProfessionalTax.getCreatedBy()!=null) {
			existingProfessionalTax.setCreatedBy(updatedProfessionalTax.getCreatedBy());
			}
			if(updatedProfessionalTax.getCreatedDate()!=null) {
			existingProfessionalTax.setCreatedDate(updatedProfessionalTax.getCreatedDate());
			}
			if(updatedProfessionalTax.getUpdatedBy()!=null) {
			existingProfessionalTax.setUpdatedBy(updatedProfessionalTax.getUpdatedBy());
			}
			existingProfessionalTax.setUpdatedDate(LocalDateTime.now());
			existingProfessionalTax.setActive(updatedProfessionalTax.isActive());
			
			Company updatedCompany = updatedProfessionalTax.getCompany();
			if (updatedCompany != null) {
				Company existingCompany = existingProfessionalTax.getCompany();
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
					existingProfessionalTax.setCompany(updatedCompany);
				}
			}

			return ptRepository.save(existingProfessionalTax);
		} else {
			throw new RuntimeException("Bank not found with id " + id);
		}
	}

	public ProfessionalTax save(ProfessionalTax pt) {
		Long companyId = pt.getCompany().getCompanyid();
        Optional<Company> company = companyRepository.findById(companyId);
        Company c=company.get();
        pt.setCompany(c);
        pt.setActive(true);
        pt.setCreatedDate(LocalDateTime.now());
		pt.setPassword(passwordService.encrypt(pt.getPassword()));
		return ptRepository.save(pt);
	}

	public void deleteById(Long id) {
		Optional<ProfessionalTax> ptOpt = ptRepository.findById(id);
		if (ptOpt.isPresent()) {
			ProfessionalTax pt = ptOpt.get();
			pt.setActive(false);
			ptRepository.save(pt);
		}
//        bankRepository.deleteById(id);
	}

	public void activateById(Long id) {
		Optional<ProfessionalTax> ptOpt = ptRepository.findById(id);
		if (ptOpt.isPresent()) {
			ProfessionalTax pt = ptOpt.get();
			pt.setActive(true);
			ptRepository.save(pt);
		}
	}
	
	public String GetDecryptPassword(Long id) {
		Optional<ProfessionalTax> pt=ptRepository.findById(id);
		if(pt.isPresent()) {
			ProfessionalTax ptl=pt.get();
			return passwordService.decrypt(ptl.getPassword());
		}
		return null;
	}
	
}
