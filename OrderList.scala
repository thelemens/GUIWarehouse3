import com.sun.xml.internal.bind.v2.model.core.ID

import scala.collection.mutable.ArrayBuffer
import scala.concurrent._
import scala.concurrent.duration._
import ExecutionContext.Implicits.global
import scala.util.{Failure, Success}




/**
  * Created by MacZ on 16/06/2016.
  */
class OrderList(){
  //stuff

  var ol1 = OrderLine(901, 3, 1)
  var order1 = Order(1,2, OrderStatus.Ordered, ArrayBuffer(ol1))
  var order2 = new Order(2, 4, OrderStatus.Ordered, ArrayBuffer(ol1))
  var order3 = new Order(3, 2, OrderStatus.Ordered, ArrayBuffer(ol1))
  var order4 = new Order(4, 3, OrderStatus.Ordered, ArrayBuffer(ol1))
  var order5 = new Order(5, 2, OrderStatus.Ordered, ArrayBuffer(ol1))
  var order6 = new Order(6, 1, OrderStatus.Ordered, ArrayBuffer(ol1))
  var order7 = new Order(7, 5, OrderStatus.Ordered, ArrayBuffer(ol1))

  var list = ArrayBuffer(order1)
  list += order2
  list += order3
  list += order4
  list += order5
  list += order6
  list += order7

  def viewOrderItems(products: Inventory): Unit = {

    for (order <- list) {
      for (i <- order.orderLine) {
        println(s"ORDER ${order.id} ITEMS\n------------------\nProductID:\t" + i.pid + "\nQuantity:\t" + i.quantity + "\nPorousware Quantity:\t" + i.porouswareQuantity+"\n------------------\n")

//        val location = products.getProductById(i.pid).location
//        println("\n\nThis product is found in: " + location)

      }
    }
  }


  def printList(products: Inventory): Unit = {


    for (i <- list.indices ){
      println("Order ID : " + list(i).id + " | Quantity : " + list(i).quantity +
        " | Status : " + list(i).status)
    }
  }

  def printListIndividual(i: Int, products: Inventory): String = {


    var ind = list(i)
    "ID : " + list(i).id + " | Item: " + products.getProductById(list(i).id).get.item + " | Quantity : " + list(i).quantity +
      " | Status : " + list(i).status

  }

  def getOrderList: ArrayBuffer[Order] = {
    list
  }

  def addOrder(ID: Int, Quantity : Int, Status : OrderStatus.Value, objectName : String, ab: ArrayBuffer[OrderLine]): Unit = {

    var objectName = Order(ID,  Quantity, Status, ab)
    list += objectName

  }

  def orderAllocation(input: Int): Unit = {

    list(input).status = OrderStatus.Allocated
  }

  def markedShipped(itemID : Int): Unit = {

    list(itemID).status = OrderStatus.Shipped
  }

  def markOrdered(itemID : Int): Unit = {

    list(itemID).status = OrderStatus.Ordered
  }

  def markedDelivered(itemID : Int): Unit = {

    list(itemID).status = OrderStatus.Delivered
    removeOrder(itemID)
  }

  def removeOrder(itemID : Int): Unit = {

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
