package nl.greenhighway.obp.util;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockserver.configuration.ConfigurationProperties;
import org.mockserver.integration.ClientAndServer;

import nl.greenhighway.obp.config.ObpConfiguration;

@RunWith(JUnitPlatform.class)
public class AbstractTestClass {

	protected static ClientAndServer mockServer;

	@BeforeAll
	public static void before() {
		System.out.println("Initializing obp configuration and test webserver");

		ObpConfiguration.initialize("http://localhost:9999", "TEST");

		// Prevent debug messages
		ConfigurationProperties.overrideLogLevel("INFO");
		((ch.qos.logback.classic.Logger) org.slf4j.LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME)).setLevel(ch.qos.logback.classic.Level.OFF);
		((ch.qos.logback.classic.Logger) org.slf4j.LoggerFactory.getLogger("org.mockserver")).setLevel(ch.qos.logback.classic.Level.OFF);

		mockServer = ClientAndServer.startClientAndServer(9999);
	}

	@AfterAll
	public static void after() {
		System.out.println("Stopping mock server");

		mockServer.stop();
	}

}
