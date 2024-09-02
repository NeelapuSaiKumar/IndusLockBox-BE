package com.orchasp.app.induslockbox.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.entity.MCA;
import com.orchasp.app.induslockbox.repository.CompanyRepository;
import com.orchasp.app.induslockbox.repository.MCARepository;

@Service
public class MCAService {

    @Autowired
    private MCARepository mcaRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordService passwordService;

    public List<MCA> findAll() {
        return mcaRepository.findAll();
    }

    public Optional<MCA> findById(Long id) {
        return mcaRepository.findById(id);
    }

    public MCA save(MCA mca) {
        Long companyId = mca.getCompany().getCompanyid();
        Optional<Company> company = companyRepository.findById(companyId);
        if (company.isPresent()) {
            mca.setCompany(company.get());
        } else {
            throw new RuntimeException("Company not found with id " + companyId);
        }
        mca.setCreatedDate(LocalDateTime.now());
        mca.setV2password(passwordService.encrypt(mca.getV2password()));
        mca.setV3password(passwordService.encrypt(mca.getV3password()));
        mca.setActive(true);
        return mcaRepository.save(mca);
    }

    public MCA updateMCA(Long id, MCA updatedMCA) {
        Optional<MCA> existingMCAOpt = mcaRepository.findById(id);
        if (existingMCAOpt.isPresent()) {
            MCA existingMCA = existingMCAOpt.get();
            if(updatedMCA.getCin()!=null ) {
            existingMCA.setCin(updatedMCA.getCin());
            }
            if(updatedMCA.getRocName()!=null) {
            existingMCA.setRocName(updatedMCA.getRocName());
            }
            if(updatedMCA.getRegistrationNo()!=null) {
            existingMCA.setRegistrationNo(updatedMCA.getRegistrationNo());
            }
            if(updatedMCA.getDateOfIncorporation()!=null) {
            existingMCA.setDateOfIncorporation(updatedMCA.getDateOfIncorporation());
            }
            if(updatedMCA.getEmail()!=null) {
            existingMCA.setEmail(updatedMCA.getEmail());
            }
            if(updatedMCA.getRegisteredAddress()!=null) {
            existingMCA.setRegisteredAddress(updatedMCA.getRegisteredAddress());
            }
            if(updatedMCA.getStockExchanges()!=null) {
            existingMCA.setStockExchanges(updatedMCA.getStockExchanges());
            }
            if(updatedMCA.getClassOfCompany()!=null) {
            existingMCA.setClassOfCompany(updatedMCA.getClassOfCompany());
            }
            if(updatedMCA.getAuthorisedCapital()!=null) {
            existingMCA.setAuthorisedCapital(updatedMCA.getAuthorisedCapital());
            }
            if(updatedMCA.getPaidUpCapital()!=null) {
            existingMCA.setPaidUpCapital(updatedMCA.getPaidUpCapital());
            }
            if(updatedMCA.getTelephone()!=null) {
            existingMCA.setTelephone(updatedMCA.getTelephone());
            }
            if(updatedMCA.getCompanyName()!=null) {
            existingMCA.setCompanyName(updatedMCA.getCompanyName());
            }
            if(updatedMCA.getMobileNo()!=null) {
            existingMCA.setMobileNo(updatedMCA.getMobileNo());
            }
            if(updatedMCA.getV2loginid()!=null) {
            existingMCA.setV2loginid(updatedMCA.getV2loginid());
            }
            if(updatedMCA.getV3loginid()!=null) {
            existingMCA.setV3loginid(updatedMCA.getV3loginid());
            }
            if(updatedMCA.getV2emailId()!=null) {
            existingMCA.setV2emailId(updatedMCA.getV2emailId());
            }
            if(updatedMCA.getV3emailId()!=null) {
            existingMCA.setV3emailId(updatedMCA.getV3emailId());
            }
            if(updatedMCA.getV2password().equals(existingMCA.getV2password())) {
            	existingMCA.setV2password( updatedMCA.getV2password());
            }
            else {
            existingMCA.setV2password(passwordService.encrypt( updatedMCA.getV2password()));
            }
            if(updatedMCA.getV3password().equals(existingMCA.getV3password())) {
            	existingMCA.setV3password( updatedMCA.getV3password());
            }
            else {
            existingMCA.setV3password(passwordService.encrypt( updatedMCA.getV3password()));
            }
            if(updatedMCA.getCreatedBy()!=null) {
            existingMCA.setCreatedBy(updatedMCA.getCreatedBy());
            }
            if(updatedMCA.getUpdatedBy()!=null) {
            existingMCA.setUpdatedBy(updatedMCA.getUpdatedBy());
            }
            existingMCA.setUpdatedDate(LocalDateTime.now());
            existingMCA.setActive(updatedMCA.isActive());

            Company updatedCompany = updatedMCA.getCompany();
            if (updatedCompany != null) {
                Company existingCompany = existingMCA.getCompany();
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
                    existingMCA.setCompany(updatedCompany);
                }
            }
            return mcaRepository.save(existingMCA);
        } else {
            throw new RuntimeException("MCA not found with id " + id);
        }
    }

    public void deleteById(Long id) {
        Optional<MCA> mcaOpt = mcaRepository.findById(id);
        if (mcaOpt.isPresent()) {
            MCA mca = mcaOpt.get();
            mca.setActive(false);
            mcaRepository.save(mca);
        }
    }
    public List<MCA> findByCompany_id(Long company_id) {
        return mcaRepository.findByCompany_id(company_id);
    }


    public void activateById(Long id) {
        Optional<MCA> mcaOpt = mcaRepository.findById(id);
        if (mcaOpt.isPresent()) {
            MCA mca = mcaOpt.get();
            mca.setActive(true);
            mcaRepository.save(mca);
        }
    }

    public String GetDecryptV2Password(Long id) {
        Optional<MCA> mcaOpt =mcaRepository.findById(id);
        if (mcaOpt.isPresent()) {
          MCA mca = mcaOpt.get();
            return passwordService.decrypt(mca.getV2password());
        } else {
            throw new RuntimeException("MCA not found with id " + id);
        }
    
   }
    public String GetDecryptV3Password(Long id) {
        Optional<MCA> mcaOpt =mcaRepository.findById(id);
        if (mcaOpt.isPresent()) {
          MCA mca = mcaOpt.get();
            return passwordService.decrypt(mca.getV3password());
        } else {
            throw new RuntimeException("MCA not found with id " + id);
        }
    
   }
}
