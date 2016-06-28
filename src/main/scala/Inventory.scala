/**
  * Created by Administrator on 28/06/2016.
  */
import scala.collection.mutable.ArrayBuffer
import java.util.InputMismatchException



/**
  * Created by MacZ on 17/06/2016.
  */
class Inventory () {


  var item1 = new InventoryItem(1, "Bananas", 30, 30.30)
  var item2 = new InventoryItem(2, "Apples", 30, 4.24)
  var item3 = new InventoryItem(3, "Grapes", 30,14.28)
  var item4 = new InventoryItem(4, "Oranges", 30, 21.13)
  var item5 = new InventoryItem(5, "Kiwis", 30, 17.4)
  var item6 = new InventoryItem(6, "Pears", 30,9.9)
  var item7 = new InventoryItem(7, "Avocados", 30,19.17)


  var list = ArrayBuffer(item1)
  list += item2
  list += item3
  list += item4
  list += item5
  list += item6
  list += item7


  def printList(): Unit = {

    for (i<- 0 to (list.length - 1) ){
      println("ID : " + list(i).id + " | Item: " + list(i).item + " | Quantity : " + list(i).quantity)
    }
  }

  def printListIndividual(input: Int): String = {

    var Return = ""
    Return = ("ID : " + list(input).id + " | Item: " + list(input).item + " | Quantity : " + list(input).quantity)

    Return
  }

  def getInventoryList(): ArrayBuffer[InventoryItem] = {

    list
  }

  def decrementStock(itemID: Int, deduction: Int): Unit = {
    list(itemID).quantity -= deduction
  }


}

