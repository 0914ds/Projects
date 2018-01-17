package test.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qk365.sample.SampleController;

@ContextConfiguration(locations = { "classpath:config/*.xml" })
public class SampleControllerTest extends AbstractJUnit4SpringContextTests {
	@Autowired
	private SampleController sampleController;

	private final MockHttpServletRequest request = new MockHttpServletRequest();
	private final MockHttpServletResponse response = new MockHttpServletResponse();

	@Test
	public void sample() {
		sampleController.sample(request, response, "哈哈");
	}
}
