package Utilities;
import org.apache.log4j.Logger;

public class Log4j {
    private static Logger Log = Logger.getLogger(Log4j.class.getName());
    public static void startLog(){
        Log.info("Test başladı");
    }

    public static void endLog(){
        Log.info("Test bitti");
    }

    public static void info(String message){
        Log.info(message);
    }

    public static void warn(String message){
        Log.warn(message);
    }

    public static void error(String message){
        Log.error(message);
    }

    public static void fatal(String message){
        Log.fatal(message);
    }

    public static void debug(String message){
        Log.debug(message);
    }
}