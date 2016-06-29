/**
  * Created by Administrator on 28/06/2016.
  */
import scala.collection.mutable.ArrayBuffer
import java.util.InputMismatchException



/**
  * Created by MacZ on 17/06/2016.
  */
class Inventory () {
  //stuff

  var item1 = InventoryItem(1, "Bananas", 30, 30.30)
  var item2 = InventoryItem(2, "Apples", 30, 4.24)
  var item3 = InventoryItem(3, "Grapes", 30,14.28)
  var item4 = InventoryItem(4, "Oranges", 30, 21.13)
  var item5 = InventoryItem(5, "Kiwis", 30, 17.4)
  var item6 = InventoryItem(6, "Pears", 30,9.9)
  var item7 = InventoryItem(7, "Avocados", 30,19.17)


  var list = ArrayBuffer(item1)
  list += item2
  list += item3
  list += item4
  list += item5
  list += item6
  list += item7

  def getProductById(id:Int) = list.find(_.id == id)


  def printList(): Unit = {

    //for (i<- 0 to (list.length - 1) ){
    for (i <- list.indices ){
      val prod = list(i)
      println("ID : " + prod.id + " | Item: " + prod.item + " | Quantity : " + prod.quantity)
    }
  }

  def printListIndividual(input: Int): String = {

    val prod  = list(input)
    "ID : " + prod + " | Item: " + prod.item + " | Quantity : " + prod.quantity
  }

  def getInventoryList(): ArrayBuffer[InventoryItem] = {

    list
  }

  def decrementStock(itemID: Int, deduction: Int): Unit = {
    list(itemID).quantity -= deduction
  }


}

