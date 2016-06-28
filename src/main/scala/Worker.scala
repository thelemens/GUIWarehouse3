/**
  * Created by MacZ on 15/06/2016.
  */
class Worker (Username: String, Password: String, accounttype: String, Location: Double) {

  var user = Username;
  var pass = Password;
  var acctype = accounttype;
  var location = Location



  override def toString(): String = "Username : " + user + ", Password : " + pass + ", Account type : " + acctype;



}
