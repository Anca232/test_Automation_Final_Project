package Tests.ObjectModels;

public class LoginModel {
     private MyAccountModel account;
     private String emailError;
     private String passwordError;

     public LoginModel(){
     }
     public LoginModel(String email, String password, String emailError, String passwordError){
          MyAccountModel mam = new MyAccountModel();
          mam.setEmail(email);
          mam.setPassword(password);

          this.account = mam;
          this.emailError = emailError;
          this.passwordError = passwordError;
     }
     public MyAccountModel getAccount() {
          return account;
     }

     public void setAccount(MyAccountModel account) {
          this.account = account;
     }

     public String getEmailError() {
          return emailError;
     }

     public void setEmailError(String emailError) {
          this.emailError = emailError;
     }

     public String getPasswordError() {
          return passwordError;
     }

     public void setPasswordError(String passwordError) {
          this.passwordError = passwordError;
     }

     @Override
     public String toString() {
          return "LoginData{" +
                  "account={email:" + account.getEmail() + ",password:" + account.getPassword() +
                  "}, userError='" + emailError + '\'' +
                  ", passwordError='" + passwordError + '\'' +
                  '}';
     }
}
