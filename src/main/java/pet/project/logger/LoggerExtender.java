package pet.project.logger;

import java.io.Serial;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerExtender implements Serializable {

  @Serial private static final long serialVersionUID = 3817051216946817816L;

  private final Logger logger;

  public LoggerExtender(String loggerName) {
    logger = Logger.getLogger(loggerName);
  }

  public void error(String msg) {
    logger.log(Level.SEVERE, msg);
  }

  public void error(Throwable thrown) {
    logger.log(Level.SEVERE, thrown.getLocalizedMessage(), thrown);
  }

  public void warn(String msg) {
    logger.log(Level.WARNING, msg);
  }

  public void info(String msg) {
    logger.log(Level.INFO, msg);
  }
}
