package br.com.jonathan.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jonathan.infrastructure.dto.PasswordMeterDTO;
import br.com.jonathan.service.PasswordService;
import br.com.jonathan.service.ServiceException;

@RestController
@RequestMapping("/password")
public class PasswordController {
	private final Logger logger = LogManager.getLogger(PasswordController.class);

	@Autowired
	private PasswordService service;

	@RequestMapping(value = "/meter", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PasswordMeterDTO> meter(HttpServletRequest request,
			@RequestBody(required = true) final String password) {
		if (StringUtils.isNotEmpty(password)) {
			try {
				return new ResponseEntity<>(service.meter(password), HttpStatus.OK);
			} catch (ServiceException exception) {
				logger.error(exception.getMessage());
				throw new ControllerException(exception);
			}
		}
		logger.warn("* Password empty!");
		return new ResponseEntity<>(HttpStatus.PRECONDITION_REQUIRED);
	}

}