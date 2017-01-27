package br.com.jonathan.service.executor;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.jonathan.infrastructure.dto.PasswordMeterDTO;
import br.com.jonathan.processor.PasswordProcessor;
import br.com.jonathan.processor.ProcessorException;

@Service
public class PasswordServiceExecutor {
	private final Logger logger = LogManager.getLogger(PasswordServiceExecutor.class);

	@Autowired
	private PasswordProcessor processor;

	@Async
	public PasswordMeterDTO meter(String password) {
		try {
			return processor.process(password);
		} catch (ProcessorException e) {
			logger.error(e.getMessage());
			throw new ServiceProcessorException(e);
		}
	}

}