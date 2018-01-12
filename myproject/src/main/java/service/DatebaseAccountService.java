package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatebaseAccountService implements AccountService {
	private final RiskAssessor riskAssessor;

	@Autowired
	public DatebaseAccountService(RiskAssessor riskAssessor) {
		this.riskAssessor = riskAssessor;
	}
	}
