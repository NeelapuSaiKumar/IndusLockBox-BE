package com.orchasp.app.induslockbox.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orchasp.app.induslockbox.entity.Bank;
import com.orchasp.app.induslockbox.entity.Company;
import com.orchasp.app.induslockbox.repository.BankRepository;
import com.orchasp.app.induslockbox.repository.CompanyRepository;

@Service
public class BankService {

	@Autowired
	private BankRepository bankRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private PasswordService passwordService;

	public List<Bank> findAll() {
		return bankRepository.findAll();
	}

	public List<Bank> findByCompanyId(Long companyId) {
		return bankRepository.findByCompany_id(companyId);
	}

	public Optional<Bank> findById(Long id) {
		return bankRepository.findById(id);
	}

	public Bank updateBank(Long id, Bank updatedBank) {
		Optional<Bank> existingBankOpt = bankRepository.findById(id);
		if (existingBankOpt.isPresent()) {
			Bank existingBank = existingBankOpt.get();

			if (updatedBank.getAccountHolderName() != null) {
				existingBank.setAccountHolderName(updatedBank.getAccountHolderName());
			}
			if (updatedBank.getBankAccountNumber() != null) {
				existingBank.setBankAccountNumber(updatedBank.getBankAccountNumber());
			}
			if (updatedBank.getIfsccode() != null) {
				existingBank.setIfsccode(updatedBank.getIfsccode());
			}
			if (updatedBank.getBankName() != null) {
				existingBank.setBankName(updatedBank.getBankName());
			}
			if (updatedBank.getBranch() != null) {
				existingBank.setBranch(updatedBank.getBranch());
			}
			if (updatedBank.getMirccode() != null) {
				existingBank.setMirccode(updatedBank.getMirccode());
			}
			if (updatedBank.getEmailId() != null) {
				existingBank.setEmailId(updatedBank.getEmailId());
			}
			if (updatedBank.getTransactionpassword().equals(existingBank.getTransactionpassword())) {
				existingBank.setTransactionpassword(updatedBank.getTransactionpassword());
			} else {
				existingBank.setTransactionpassword(passwordService.encrypt(updatedBank.getTransactionpassword()));
			}
			if(updatedBank.getAccountType()!=null) {
			existingBank.setAccountType(updatedBank.getAccountType());
			}
			if (updatedBank.getLoginpassword().equals(existingBank.getLoginpassword())) {
				existingBank.setLoginpassword(updatedBank.getLoginpassword());
			} else {
				existingBank.setLoginpassword(passwordService.encrypt(updatedBank.getLoginpassword()));
			}
			if(updatedBank.getPrimarySignatory()!=null) {
			existingBank.setPrimarySignatory(updatedBank.getPrimarySignatory());
			}
			if(updatedBank.getSecondarySignatory()!=null) {
			existingBank.setSecondarySignatory(updatedBank.getSecondarySignatory());
			}
			if(updatedBank.getUserid()!=null) {
			existingBank.setUserid(updatedBank.getUserid());
			}
			if(updatedBank.getCreatedBy()!=null) {
			existingBank.setCreatedBy(updatedBank.getCreatedBy());
			}
			if(updatedBank.getCreatedDate()!=null) {
			existingBank.setCreatedDate(updatedBank.getCreatedDate());
			}
			if(updatedBank.getUpdatedBy()!=null) {
			existingBank.setUpdatedBy(updatedBank.getUpdatedBy());
			}
			
			existingBank.setUpdatedDate(LocalDateTime.now());
			existingBank.setActive(updatedBank.isActive());

		
			Company updatedCompany = updatedBank.getCompany();
			if (updatedCompany != null) {
				Company existingCompany = existingBank.getCompany();
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
					existingBank.setCompany(updatedCompany);
				}
			}

			return bankRepository.save(existingBank);
		} else {
			throw new RuntimeException("Bank not found with id " + id);
		}
	}

	public Bank save(Bank bank) {
		Long companyId = bank.getCompany().getCompanyid();
		Optional<Company> company = companyRepository.findById(companyId);
		if (company.isPresent()) {
			Company c = company.get();
			bank.setCompany(c);
			bank.setActive(true);
			bank.setCreatedDate(LocalDateTime.now());
			bank.setLoginpassword(passwordService.encrypt(bank.getLoginpassword()));
			bank.setTransactionpassword(passwordService.encrypt(bank.getTransactionpassword()));
			return bankRepository.save(bank);
		} else {
			throw new RuntimeException("Company not found with id " + companyId);
		}
	}

	public void deleteById(Long id) {
		Optional<Bank> bankOpt = bankRepository.findById(id);
		if (bankOpt.isPresent()) {
			Bank bank = bankOpt.get();
			bank.setActive(false);
			bankRepository.save(bank);
		} else {
			throw new RuntimeException("Bank not found with id " + id);
		}
	}

	public void activateById(Long id) {
		Optional<Bank> bankOpt = bankRepository.findById(id);
		if (bankOpt.isPresent()) {
			Bank bank = bankOpt.get();
			bank.setActive(true);
			bankRepository.save(bank);
		} else {
			throw new RuntimeException("Bank not found with id " + id);
		}
	}

	public String GetDecryptLoginPassword(Long id) {
		Optional<Bank> bankOpt = bankRepository.findById(id);
		if (bankOpt.isPresent()) {
			Bank bank = bankOpt.get();
			return passwordService.decrypt(bank.getLoginpassword());
		} else {
			throw new RuntimeException("Bank not found with id " + id);
		}

	}

	public String GetDecryptTransactionPassword(Long id) {
		Optional<Bank> bankOpt = bankRepository.findById(id);
		if (bankOpt.isPresent()) {
			Bank bank = bankOpt.get();
			return passwordService.decrypt(bank.getTransactionpassword());
		} else {
			throw new RuntimeException("Bank not found with id " + id);
		}

	}
}
