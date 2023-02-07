package Utils;

import org.openqa.selenium.InvalidArgumentException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Random;

public class GenericUtils {

     public static String createRandomString(int charCount) {
          StringBuilder sb = new StringBuilder();
          String charSet = "abcdefghijklmonopqrstvwxyz";
          charSet += charSet.toUpperCase();
          for (int i = 0; i < charCount; i++) {
               Random r = new Random();
               char x = charSet.toCharArray()[r.nextInt(charSet.length())];
               sb.append(x);
          }
          return sb.toString();
     }

     public static String createBaseUrl(String configFile) {
          String urlBase = "";
          try {
               Properties appProps = new Properties();
               appProps.load(Files.newInputStream(Paths.get(configFile)));
               urlBase = appProps.getProperty("protocol") + "://" + appProps.getProperty("hostname") + ":" + appProps.getProperty("port");
          } catch (InvalidArgumentException | IOException ex) {
               System.out.println(ex);
          }
          return urlBase;
     }

     public static String getBrowserConfig(String configFile) {
          return ConfigUtils.getGenericValue(configFile, "browser", "CHROME");
     }

     public static Boolean getHeadlessMode(String configFile) {
          return Boolean.parseBoolean(ConfigUtils.getGenericValue(configFile, "headlessMode", "false"));
     }

     public static boolean isProxyEnabled(String configFile) {
          return Boolean.parseBoolean(ConfigUtils.getGenericValue(configFile, "proxyEnabled", "false"));
     }

     public static Boolean getInsecureCertOptions(String configFile) {
          return Boolean.parseBoolean(ConfigUtils.getGenericValue(configFile, "acceptInsecureCerts", "false"));
     }
     public static String getDBHostname(String configFile){
          return ConfigUtils.getGenericValue(configFile, "dbHostname", "");
     }

     public static String getDBUser(String configFile){
          return ConfigUtils.getGenericValue(configFile, "dbUser", "");
     }

     public static String getDBPassword(String configFile){
          return ConfigUtils.getGenericValue(configFile, "dbPassword", "");
     }

     public static String getDBPort(String configFile){
          return ConfigUtils.getGenericValue(configFile, "dbPort", "3306");
     }

     public static String getDBSchema(String configFile){
          return ConfigUtils.getGenericValue(configFile, "dbSchema", "");
     }

     public static String getapiVersion(String configFile){
          return ConfigUtils.getGenericValue(configFile, "apiVersion", "");
     }

     public static boolean isDownloadDirectoryEnabled(String configFile) {
          return Boolean.parseBoolean(ConfigUtils.getGenericValue(configFile, "downloadDirectoryEnabled", "false"));
     }

     public static boolean startMaximized(String configFile) {
          return Boolean.parseBoolean(ConfigUtils.getGenericValue(configFile, "startMaximized", "false"));
     }
     public static boolean enableExtension(String configFile) {
          return Boolean.parseBoolean(ConfigUtils.getGenericValue(configFile, "enableExtension", "false"));
     }
}
