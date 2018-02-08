package controllers


import javax.inject.Inject
import play.api.data.Form
import play.api.data.Forms.mapping
import play.api.data.Forms.text
import play.api.mvc.{ AbstractController, ControllerComponents }

import models.Customer
import models.CustomerFormData
import dao.CustomerDAO

import scala.concurrent.ExecutionContext

class HomeController @Inject() (
    customerDAO: CustomerDAO,
    controllerComponents: ControllerComponents
)(implicit executionContext: ExecutionContext) extends AbstractController(controllerComponents) {

  def index = Action.async { implicit request =>
    customerDAO.all().map { case (customers) => Ok(views.html.index(customers)) }
  }

  val customerForm = Form(
    mapping(
      "firstname" -> text(),
      "lastname" -> text()
    )(CustomerFormData.apply)(CustomerFormData.unapply)
  )


  def insertCustomer = Action.async { implicit request =>
    val customerFormData: CustomerFormData = customerForm.bindFromRequest.get
    val customer = Customer(0, customerFormData.firstname, customerFormData.lastname)
    customerDAO.insert(customer).map(_ => Redirect(routes.HomeController.index))
  }
}