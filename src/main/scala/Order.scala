import scalafx.beans.property.StringProperty

/**
  * Created by MacZ on 15/06/2016.
  */
class Order (ID: Int, Item : String, Quantity : Int, Status : String){

  val id = ID
  val item = Item
  var quantity = Quantity
  var status = Status

  //val id = new StringProperty(this, "ID", ID)
  //val item  = new StringProperty(this, "item ", Item)
  //val quantity = new StringProperty(this, "quantity ", Quantity)
  //val status = new StringProperty(this, "status", Status)

}
