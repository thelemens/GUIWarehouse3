import scala.collection.mutable.ArrayBuffer

/**
  * Created by MacZ on 15/06/2016.
  */
case class Order (id: Int, quantity : Int, var status : OrderStatus.Value, var orderLine: ArrayBuffer[OrderLine]){

  def addOrderLineItem(ol: OrderLine): Unit = {
    orderLine += ol
  }

}
