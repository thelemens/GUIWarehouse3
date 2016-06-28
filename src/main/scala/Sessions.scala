import scalafx.application.JFXApp
import scalafx.scene.control.ChoiceDialog

/**
  * Created by Administrator on 28/06/2016.
  */

object Sessions extends JFXApp{

  standard
  def standard {
  val choices = Seq("Check order list", "Choose/pick order")

  val dialog = new ChoiceDialog(defaultChoice = "Check orders", choices = choices) {
    initOwner(stage)
    title = "Choice Dialog"
    headerText = "Look, a Choice Dialog."
    contentText = "Choose your letter:"
  }

  val result = dialog.showAndWait()

  result match {
    case Some(choice) => println("Your choice: " + choice)
    case None         => println("No selection")
  }
}
}
