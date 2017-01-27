package br.com.jonathan.service;

import org.apache.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.jonathan.infrastructure.dto.PasswordMeterDTO;
import br.com.jonathan.service.executor.PasswordServiceExecutor;

@Service
public class PasswordService extends ServiceAbstracted {

	@Autowired
	private PasswordServiceExecutor executor;

	public PasswordService() {
		super(LogManager.getLogger(PasswordService.class));
	}

	@Async
	public PasswordMeterDTO meter(String payload) throws ServiceException {
		return process(getMethodName(), payload, executor::meter);
	}

}