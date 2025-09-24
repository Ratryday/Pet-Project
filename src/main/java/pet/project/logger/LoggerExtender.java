package pet.project.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerExtender extends Logger {

  /**
   * Protected method to construct a logger for a named subsystem.
   *
   * <p>The logger will be initially configured with a null Level and with useParentHandlers set to
   * true.
   *
   * @param name A name for the logger. This should be a dot-separated name and should normally be
   *     based on the package name or class name of the subsystem, such as java.net or javax.swing.
   *     It may be null for anonymous Loggers.
   * @param resourceBundleName name of ResourceBundle to be used for localizing messages for this
   *     logger. May be null if none of the messages require localization.
   * @throws MissingResourceException if the resourceBundleName is non-null and no corresponding
   *     resource can be found.
   */
  public LoggerExtender(String name, String resourceBundleName) {
    super(name, resourceBundleName);
  }

  // =======================================================================
  // Start of simple convenience methods using level names as method names
  // =======================================================================

  /**
   * Log a SEVERE message.
   *
   * <p>If the logger is currently enabled for the SEVERE message level then the given message is
   * forwarded to all the registered output Handler objects.
   *
   * @param msg The string message (or a key in the message catalog)
   */
  public void error(String msg) {
    log(Level.SEVERE, msg);
  }

  public void error(Throwable thrown) {
    log(Level.SEVERE, thrown.getLocalizedMessage(), thrown);
  }
}
