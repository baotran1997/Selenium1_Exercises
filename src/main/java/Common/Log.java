package Common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    // Print log for the beginning of the test case
    public static void startTestCase(String testCaseName){
        Log.info("------------------------Start "+testCaseName+ "------------------------");
    }

    //Print log for the ending of the test case

    public static void endTestCase(){
        Log.info("------------------------"+"-E---N---D-"+"------------------------");
    }

    //Initialize Log4j instance
        private final static  Logger Log =  LogManager.getLogger(Log.class);

        //Info Level Logs
        public static void info (String message) {
            Log.info(message);
        }

        //Warn Level Logs
        public static void warn (String message) {
            Log.warn(message);
        }

        //Error Level Logs
        public static void error (String message) {
            Log.error(message);
        }

        //Fatal Level Logs
        public static void fatal (String message) {
            Log.fatal(message);
        }

        //Debug Level Logs
        public static void debug (String message) {
            Log.debug(message);
        }

}
