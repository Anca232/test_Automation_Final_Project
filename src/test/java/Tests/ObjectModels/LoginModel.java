package Tests.ObjectModels;



public class LoginModel {
     private MyAccountModel account;

     public LoginModel(){
     }
     public MyAccountModel getAccount() {
          return account;
     }

     public void setAccount(MyAccountModel account) {
          this.account = account;
     }

     @Override
     public String toString() {
          return "LoginModel{" +
                  "account=" + account +
                  '}';
     }
}
