package com.orchasp.app.induslockbox.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.entity.TDS;
import com.orchasp.app.induslockbox.repository.CompanyRepository;
import com.orchasp.app.induslockbox.repository.TDSRepository;

@Service
public class TDSService {
    @Autowired
    private TDSRepository tdsRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordService passwordService;

    public List<TDS> findAll() {
        return tdsRepository.findAll();
    }

    public Optional<TDS> findById(Long id) {
        return tdsRepository.findById(id);
    }

    public TDS updateTDS(Long id, TDS updatedTDS) {
        Optional<TDS> existingTDSOpt = tdsRepository.findById(id);
        if (existingTDSOpt.isPresent()) {
            TDS existingTDS = existingTDSOpt.get();
            if(updatedTDS.getTanNo()!=null) {
            existingTDS.setTanNo(updatedTDS.getTanNo());
            }
            if(updatedTDS.getEmail()!=null) {
            existingTDS.setEmail(updatedTDS.getEmail());
            }
            if(updatedTDS.getPhoneNumber()!=null) {
            existingTDS.setPhoneNumber(updatedTDS.getPhoneNumber());
            }
            if(updatedTDS.getUserid()!=null) {
            existingTDS.setUserid(updatedTDS.getUserid());
            }
            if(updatedTDS.getPassword().equals(existingTDS.getPassword())) {
            	existingTDS.setPassword(updatedTDS.getPassword());
            }
            else {
            existingTDS.setPassword(passwordService.encrypt(updatedTDS.getPassword()));
            }
            if(updatedTDS.getSurrendered()!=null) {
            existingTDS.setSurrendered(updatedTDS.getSurrendered());
            }
            if(updatedTDS.getSignatory()!=null) {
            existingTDS.setSignatory(updatedTDS.getSignatory());
            }
            if(updatedTDS.getCreatedBy()!=null) {
            existingTDS.setCreatedBy(updatedTDS.getCreatedBy());
            }
            if(updatedTDS.getCreatedDate()!=null) {
            existingTDS.setCreatedDate(updatedTDS.getCreatedDate());
            }
            if(updatedTDS.getUpdatedBy()!=null) {
            existingTDS.setUpdatedBy(updatedTDS.getUpdatedBy());
            }
            existingTDS.setUpdatedDate(LocalDateTime.now());
            existingTDS.setActive(updatedTDS.isActive());

            Company updatedCompany = updatedTDS.getCompany();
            if (updatedCompany != null) {
                Company existingCompany = existingTDS.getCompany();
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
                    existingTDS.setCompany(updatedCompany);
                }
            }
            return tdsRepository.save(existingTDS);
        } else {
            throw new RuntimeException("TDS not found with id " + id);
        }
    }

    public TDS save(TDS tds) {
        Long companyId = tds.getCompany().getCompanyid();
        Optional<Company> companyOpt = companyRepository.findById(companyId);
        if (companyOpt.isPresent()) {
            Company company = companyOpt.get();
            tds.setCompany(company);
            tds.setActive(true);
            tds.setPassword(passwordService.encrypt(tds.getPassword()));
            tds.setCreatedDate(LocalDateTime.now());
            return tdsRepository.save(tds);
        } else {
            throw new RuntimeException("Company not found with id " + companyId);
        }
    }

    public List<TDS> findByCompany_id(Long company_id) {
        return tdsRepository.findByCompany_id(company_id);
    }

    public void deleteById(Long id) {
        Optional<TDS> tdsOpt = tdsRepository.findById(id);
        if (tdsOpt.isPresent()) {
            TDS tds = tdsOpt.get();
            tds.setActive(false);
            tdsRepository.save(tds);
        } else {
            throw new RuntimeException("TDS not found with id " + id);
        }
    }

    public void activateById(Long id) {
        Optional<TDS> tdsOpt = tdsRepository.findById(id);
        if (tdsOpt.isPresent()) {
            TDS tds = tdsOpt.get();
            tds.setActive(true);
            tdsRepository.save(tds);
        } else {
            throw new RuntimeException("TDS not found with id " + id);
        }
    }

    public String getDecryptPassword(Long id) {
        Optional<TDS> tdsOpt = tdsRepository.findById(id);
        if (tdsOpt.isPresent()) {
            TDS tds = tdsOpt.get();
            return passwordService.decrypt(tds.getPassword());
        } else {
            throw new RuntimeException("TDS not found with id " + id);
        }
    }
}
