package Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Random;

public class GenericUtils {

     //when register new account
     public static String createRandomString(int charCount){
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
          } catch (IOException ex) {
               System.out.println(ex);
          }
          return urlBase;
     }
}
