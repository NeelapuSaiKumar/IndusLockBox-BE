package com.orchasp.app.induslockbox.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.entity.GST;
import com.orchasp.app.induslockbox.repository.CompanyRepository;
import com.orchasp.app.induslockbox.repository.GSTRepository;

@Service
public class GSTService {

	@Autowired
	private GSTRepository gstRepository;
	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private PasswordService passwordService;

	public List<GST> findAll() {
		return gstRepository.findAll();
	}

	public Optional<GST> findById(Long id) {
		return gstRepository.findById(id);
	}

	public GST updateGST(Long id, GST updatedGST) {
		Optional<GST> existingGSTOpt = gstRepository.findById(id);
		if (existingGSTOpt.isPresent()) {
			GST existingGST = existingGSTOpt.get();
			if(updatedGST.getGstNumber()!=null) {
			existingGST.setGstNumber(updatedGST.getGstNumber());
			}
			if(updatedGST.getUserid()!=null) {
			existingGST.setUserid(updatedGST.getUserid());
			}
			if (updatedGST.getPassword().equals(existingGST.getPassword())) {
				existingGST.setPassword(updatedGST.getPassword());
			} else {
				existingGST.setPassword(passwordService.encrypt(updatedGST.getPassword()));
			}
			if(updatedGST.getAddress()!=null) {
			existingGST.setAddress(updatedGST.getAddress());
			}
			if(updatedGST.getEmail()!=null) {
			existingGST.setEmail(updatedGST.getEmail());
			}
			if(updatedGST.getMobileno()!=null) {
			existingGST.setMobileno(updatedGST.getMobileno());
			}
			if(updatedGST.getState()!=null) {
			existingGST.setState(updatedGST.getState());
			}
			if(updatedGST.getCreatedBy()!=null) {
			existingGST.setCreatedBy(updatedGST.getCreatedBy());
			}
			if(updatedGST.getCreatedDate()!=null) {
			existingGST.setCreatedDate(updatedGST.getCreatedDate());
			}
			if(updatedGST.getUpdatedBy()!=null) {
			existingGST.setUpdatedBy(updatedGST.getUpdatedBy());
			}
			existingGST.setUpdatedDate(LocalDateTime.now());
			existingGST.setActive(updatedGST.isActive());

			Company updatedCompany = updatedGST.getCompany();
			if (updatedCompany != null) {
				Company existingCompany = existingGST.getCompany();
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
					existingGST.setCompany(updatedCompany);
				}
			}

			return gstRepository.save(existingGST);
		} else {
			throw new RuntimeException("GST not found with id " + id);
		}
	}

	public GST save(GST gst) {

		Long companyId = gst.getCompany().getCompanyid();
		Optional<Company> company = companyRepository.findById(companyId);
		Company c = company.get();
		gst.setCompany(c);
		gst.setCreatedDate(LocalDateTime.now());
		gst.setActive(true);
		gst.setPassword(passwordService.encrypt(gst.getPassword()));
		gst.setCreatedDate(LocalDateTime.now());

		return gstRepository.save(gst);
	}

	public void deleteById(Long id) {
		Optional<GST> gstop = gstRepository.findById(id);
		if (gstop.isPresent()) {
			GST gst = gstop.get();
			gst.setActive(false);
			gstRepository.save(gst);
		}
		// gstRepository.deleteById(id);
	}

	public void activateById(Long id) {
		Optional<GST> gstOpt = gstRepository.findById(id);
		if (gstOpt.isPresent()) {
			GST gst = gstOpt.get();
			gst.setActive(true);
			gstRepository.save(gst);
		}
	}

	public List<GST> findByCompany_id(Long company_id) {
		return gstRepository.findByCompany_id(company_id);
	}

	public String GetDecryptPassword(Long id) {
		Optional<GST> gst = gstRepository.findById(id);
		if (gst.isPresent()) {
			GST g = gst.get();
			return passwordService.decrypt(g.getPassword());
		}
		return null;
	}

}