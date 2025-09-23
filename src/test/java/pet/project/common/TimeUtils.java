package pet.project.common;

import java.util.logging.Logger;

public class TimeUtils {

    private static final Logger log = Logger.getLogger(TimeUtils.class.getName());

    public static void calculateMethodTimeWork(Runnable runnable) {
        long startTime = System.currentTimeMillis();

        runnable.run();

        long endTime = System.currentTimeMillis();

        long timeSpent = endTime - startTime;
        log.info("Time spent: " + timeSpent + " ms");
        System.gc();
    }
}
