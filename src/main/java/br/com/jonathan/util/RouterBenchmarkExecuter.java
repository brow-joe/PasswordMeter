package br.com.jonathan.util;

import java.util.function.Function;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Async;

import com.google.common.base.Stopwatch;

@FunctionalInterface
public interface RouterBenchmarkExecuter {

	@Async
	default <I, O> O execute(String locale, String ticket, I in, Function<I, O> executer, Logger logger)
			throws RouterExecutorException {
		Stopwatch timer = Stopwatch.createStarted();
		try {
			return executer.apply(in);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new RouterExecutorException(e);
		} finally {
			logger.info("---> Locale: " + locale + " done: " + timer.stop() + " Ticket: " + ticket);
		}
	}

	@Async
	public String generateTicketExecutor();
}