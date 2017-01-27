package br.com.jonathan.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.jonathan.StartUp;
import br.com.jonathan.infrastructure.dto.PasswordMeterDTO;
import br.com.jonathan.processor.PasswordProcessor;
import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = { StartUp.class })
public class TestApplication extends TestCase {
	protected final Logger logger = LogManager.getLogger(TestApplication.class);

	@Autowired
	private PasswordProcessor processor;

	@Test
	public void test1() throws Exception {
		PasswordMeterDTO meter = processor.process("a");
		PasswordMeterDTO result = new PasswordMeterDTO(3);
		assertEquals(result.getScore(), meter.getScore());
		assertEquals(result.getComplexity(), meter.getComplexity());
	}

	@Test
	public void test2() throws Exception {
		PasswordMeterDTO meter = processor.process("abc");
		PasswordMeterDTO result = new PasswordMeterDTO(2);
		assertEquals(result.getScore(), meter.getScore());
		assertEquals(result.getComplexity(), meter.getComplexity());
	}

	@Test
	public void test3() throws Exception {
		PasswordMeterDTO meter = processor.process("abc123");
		PasswordMeterDTO result = new PasswordMeterDTO(32);
		assertEquals(result.getScore(), meter.getScore());
		assertEquals(result.getComplexity(), meter.getComplexity());
	}

	@Test
	public void test4() throws Exception {
		PasswordMeterDTO meter = processor.process("123abc123");
		PasswordMeterDTO result = new PasswordMeterDTO(61);
		assertEquals(result.getScore(), meter.getScore());
		assertEquals(result.getComplexity(), meter.getComplexity());
	}

	@Test
	public void test5() throws Exception {
		PasswordMeterDTO meter = processor.process("a#");
		PasswordMeterDTO result = new PasswordMeterDTO(16);
		assertEquals(result.getScore(), meter.getScore());
		assertEquals(result.getComplexity(), meter.getComplexity());
	}

	@Test
	public void test6() throws Exception {
		PasswordMeterDTO meter = processor.process("#abc#");
		PasswordMeterDTO result = new PasswordMeterDTO(28);
		assertEquals(result.getScore(), meter.getScore());
		assertEquals(result.getComplexity(), meter.getComplexity());
	}

	@Test
	public void test7() throws Exception {
		PasswordMeterDTO meter = processor.process("#abc123");
		PasswordMeterDTO result = new PasswordMeterDTO(44);
		assertEquals(result.getScore(), meter.getScore());
		assertEquals(result.getComplexity(), meter.getComplexity());
	}

	@Test
	public void test8() throws Exception {
		PasswordMeterDTO meter = processor.process("%123abc123$");
		PasswordMeterDTO result = new PasswordMeterDTO(97);
		assertEquals(result.getScore(), meter.getScore());
		assertEquals(result.getComplexity(), meter.getComplexity());
	}
}