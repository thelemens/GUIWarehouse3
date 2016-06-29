/**
  * Created by Administrator on 28/06/2016.
  */
import scala.collection.mutable.ArrayBuffer
import Array._


class CurrentWorker (Username: String, Password: String, accounttype: String){

  var list = ofDim[String](1, 3)

  var user = Username;
  var pass = Password;
  var acctype = accounttype;

  list(0)(0) = user
  list(0)(1) = pass
  list(0)(2) = acctype
  def getCurrentWorker(): Array[Array[String]]= {

    list
  }
}
