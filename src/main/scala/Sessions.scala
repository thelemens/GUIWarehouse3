import scalafx.application.JFXApp
import scalafx.scene.control.ChoiceDialog

/**
  * Created by Administrator on 28/06/2016.
  */

object Sessions extends JFXApp {

  standard

  def standard {
    val choices = Seq("Check order list", "Choose/pick order")

    val dialog = new ChoiceDialog(defaultChoice = "Check order list", choices = choices) {
      initOwner(stage)
      title = "Standard Session Menu"
      headerText = "What would you like to do?"
      contentText = "Choose an option:"
    }

    val result = dialog.showAndWait()

    result match {
      case Some("Check order list") => //GUI.PrintOrderList
      case None => println("No selection")
    }
  }
}
