import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestLogger {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TestLogger.class);

	public static void main(String[] args) {
		LOGGER.trace("TRACE log");
		LOGGER.debug("DEBUG log");
		LOGGER.info("INFO log");
		LOGGER.warn("WARN log");
		LOGGER.error("ERROR log");
	}

}
