package core.helpers;

import core.helpers.providers.DateProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log {

    public static Logger LOG = LoggerFactory.getLogger(Log.class);

    /**
     * Writes an information message into log
     *
     * @param message message to be written
     */
    public static void info(String message) {
        LOG.info(String.format("[%s] %s", DateProvider.getLocalDateTime().format(DateProvider.DASH_MMddyyyy_HHmmss), message));
    }

    /**
     * Writes a warning message into log
     *
     * @param message message to be written
     */
    public static void warning(String message) {
        LOG.warn(String.format("[%s] %s", DateProvider.getLocalDateTime().format(DateProvider.DASH_MMddyyyy_HHmmss), message));
    }

    /**
     * Writes a error message into log
     *
     * @param message message to be written
     */
    public static void error(String message) {
        LOG.error(String.format("[%s] %s", DateProvider.getLocalDateTime().format(DateProvider.DASH_MMddyyyy_HHmmss), message));
    }
}
