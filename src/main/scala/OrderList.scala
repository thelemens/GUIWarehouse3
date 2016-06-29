import com.sun.xml.internal.bind.v2.model.core.ID

import scala.collection.mutable.ArrayBuffer
import scala.concurrent._
import scala.concurrent.duration._
import ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
import scalafx.beans.property.StringProperty




/**
  * Created by MacZ on 16/06/2016.
  */
class OrderList (){

  var order1 = new Order(1, "Bananas", 2, "ordered")
  var order2 = new Order(2, "Apples", 4, "ordered")
  var order3 = new Order(3, "Grapes", 2, "ordered")
  var order4 = new Order(4, "Oranges", 3, "ordered")
  var order5 = new Order(5, "Kiwis", 2, "ordered")
  var order6 = new Order(6, "Pears", 1, "ordered")
  var order7 = new Order(7, "Avocados", 5, "ordered")

  var list = ArrayBuffer(order1)
  list += order2
  list += order3
  list += order4
  list += order5
  list += order6
  list += order7


  def printList(): Unit = {

    for (i<- 0 to (list.length - 1) ){
      println("ID : " + list(i).id + " | Item: " + list(i).item + " | Quantity : " + list(i).quantity +
        " | Status : " + list(i).status)
    }
  }

  def printListIndividual(input: Int): String = {

    var ind = list(input)
    var Return = ""
    Return = ("ID : " + ind.id + " | Item: " + ind.item + " | Quantity : " + ind.quantity +
      " | Status : " + ind.status)

    Return
  }

  def getOrderList(): ArrayBuffer[Order] = {
    list
  }

  def addOrder(ID: Int, Item : String, Quantity : Int, Status : String, objectName : String): Unit = {

    var objectName = new Order(ID, Item, Quantity, Status)
    list += objectName

  }

  def orderAllocation(input: Int): Unit = {

    list(input).status = "Allocated"
  }

  def markedShipped(itemID : Int): Unit = {

    list(itemID).status = "Shipped"
  }

  def markeddelivered(itemID : Int): Unit = {

    list(itemID).status = "Delivered"

    RemoveOrder(itemID)
  }

  def RemoveOrder(itemID : Int): Unit = {

    val delete = Future  {
      Thread.sleep(5000)
      println("")
    }
    delete onSuccess {
      case f =>
        list -= list(itemID)
        println("Order " + itemID + " deleted")
    }
    println("Deleting")
  }


}
