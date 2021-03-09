package maksim_klimenko1.reporting;

//import com.epam.reportportal.message.ReportPortalMessage;
import org.apache.log4j.Logger;

import java.io.IOException;


public class CustomLogger {

    public static Logger logger = Logger.getLogger(CustomLogger.class);

    public static void error(String message) {
        logger.error(message);
    }

    public static void error(String message, Throwable throwable) {
        logger.error(message, throwable);
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }

    public static void trace(String message) {
        logger.trace(message);
    }

    public static void log(String message){
        logger.info(message);
    }

    public static void attach(String filePath, String rp_message)  throws IOException {
        //ReportPortalMessage message = new ReportPortalMessage(new File(filePath), rp_message);
        //logger.info(message);
    }
}

