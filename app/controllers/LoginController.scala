package controllers

import javax.inject.Inject

import play.api.mvc.{ AbstractController, ControllerComponents }

class LoginController @Inject() (cc: ControllerComponents)
  extends AbstractController(cc) {

  def index = Action {
     Ok(views.html.login("Login"))
  }

}