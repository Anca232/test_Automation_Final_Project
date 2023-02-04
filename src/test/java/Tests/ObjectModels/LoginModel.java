package Tests.ObjectModels;



public class LoginModel {
     private AccountModel account;

     public LoginModel(){
     }

     public AccountModel getAccount() {
          return account;
     }

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
