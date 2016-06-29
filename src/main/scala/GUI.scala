import scala.collection.mutable.ArrayBuffer
import scalafx.Includes._
import scalafx.application.JFXApp.PrimaryStage
import scalafx.application.{JFXApp, Platform}
import scalafx.collections.ObservableBuffer
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.control.ButtonBar.ButtonData
import scalafx.scene.control._
import scalafx.scene.layout.GridPane
import scalafx.scene.paint.Color

object GUI extends JFXApp {
  /*
    stage = new JFXApp.PrimaryStage {
      //icons += new Image("/scalafx/sfx.png")
      scene = new Scene {
        title = "login"
        content = new VBox {
          children = new Button("Press to continue") {
            onAction = handle {onShowLoginDialog()}
          }
          padding = Insets(top = 24, right = 64, bottom = 24, left = 64)
        }
      }
    }
  */
  val characters = ObservableBuffer[Order]()
  var OrderList1 = new OrderList

  onShowLoginDialog
  def onShowLoginDialog(): Unit = {

    case class Result(username: String, password: String)

    // Create the custom dialog.
    val dialog = new Dialog[Result]() {
      initOwner(stage)
      title = "Login"
      headerText = "Please login"
      // graphic = new ImageView(this.getClass.getResource("login_icon.png").toString)
    }

    // Set the button types.
    val loginButtonType = new ButtonType("Login", ButtonData.OKDone)
    dialog.dialogPane().buttonTypes = Seq(loginButtonType, ButtonType.Cancel)

    // Create the username and password labels and fields.
    val username = new TextField() {
      promptText = "Type username here"
    }
    val password = new PasswordField() {
      promptText = "Type password here"
    }

    val grid = new GridPane() {
      hgap = 30
      vgap = 30
      padding = Insets(30, 300, 30, 30)

      add(new Label("Username:"), 0, 0)
      add(username, 1, 0)
      add(new Label("Password:"), 0, 1)
      add(password, 1, 1)
    }

    // Enable/Disable login button depending on whether a username was entered.
    val loginButton = dialog.dialogPane().lookupButton(loginButtonType)
    loginButton.disable = true

    // Do some validation (disable when username is empty).
    username.text.onChange { (_, _, newValue) => loginButton.disable = newValue.trim().isEmpty}

    dialog.dialogPane().content = grid

    // Request focus on the username field by default.
    Platform.runLater(username.requestFocus())

    // Convert the result to a username-password-pair when the login button is clicked.
    dialog.resultConverter = dialogButton =>
      if (dialogButton == loginButtonType) Result(username.text(), password.text())
      else null

    val result = dialog.showAndWait()

    result match {
      case Some(Result(user, pass)) => continue(user, pass)
      case None               => println("Dialog returned: None")

    }

    def continue(userr: String, passs: String): Unit = {
      var accountType = ""
      var confirm = main1.checkworker(userr, passs)
      accountType = main1.accountTypeCheck()

      if (main1.continue == true) {
        if (accountType == "admin") {
          new Alert(AlertType.Information, "Admin session activated").showAndWait()
          Sessions.standard
        } else {
          new Alert(AlertType.Information, "Standard session activated").showAndWait()
          Sessions
        }
      }
    }

  }
/*
    def PrintOrderList(): Unit = {

      stage = new PrimaryStage {
        title = "Order Table"
        scene = new Scene {
          content = new TableView[Order](characters) {
            columns ++= List(
              new TableColumn[Order, String] {
                text = "Item"
                cellValueFactory = {_.value.item}
                prefWidth = 100
              },
              prefWidth = 100
            )
          }
        }
      }*/

}
