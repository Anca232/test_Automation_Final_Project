package Tests.ObjectModels;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LoginModel {
     private AccountModel account;

     public LoginModel(){
     }

     public AccountModel getAccount() {
          return account;
     }
     @XmlElement
     public void setAccount(AccountModel account) {
          this.account = account;
     }

     @Override
     public String toString() {
          return "LoginModel{" +
                  "account=" + account +
                  '}';
     }
}
