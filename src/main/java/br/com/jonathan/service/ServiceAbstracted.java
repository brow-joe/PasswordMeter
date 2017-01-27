package br.com.jonathan.service;

import java.util.UUID;
import java.util.function.Function;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;

import br.com.jonathan.util.RouterBenchmarkExecuter;
import br.com.jonathan.util.RouterExecutorException;

@Async
public abstract class ServiceAbstracted implements RouterBenchmarkExecuter {
	protected final Logger logger;
	private static final String PREFIX = "SERVICE_";

	public ServiceAbstracted(Logger logger) {
		this.logger = logger;
	}

	@Async
	protected <I, O> O process(String method, I in, Function<I, O> executer) throws ServiceException {
		try {
			String ticket = generateTicketExecutor();
			String locale = PREFIX + method;
			return execute(locale, ticket, in, executer, logger);
		} catch (RouterExecutorException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public String generateTicketExecutor() {
		return UUID.randomUUID().toString();
	}

	@Async
	public String getMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}

}