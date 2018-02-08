package dao

import org.scalatest.BeforeAndAfterEach
import org.scalatestplus.play._
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.Helpers._
import play.api.test._
import testhelpers.{EvolutionHelper, Injector}
import play.api.inject.guice.GuiceApplicationBuilder

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import models.Customer


class DAOScalaTestSpec extends PlaySpec with GuiceOneAppPerTest  with BeforeAndAfterEach {

  val customerDAO = Injector.inject[CustomerDAO]

  override def afterEach() = EvolutionHelper.clean()

  "A customer" should {

    "be inserted during the first test case" in  {
        val customer = Customer(4, "John", "Hops")
        val action = customerDAO.insert(customer)
          .flatMap(_ => customerDAO.all)

        val result = Await.result(action, Duration.Inf)

        result mustBe List(Customer(1, "John", "Hops"))
    }

    "and not exist in the second test case" in  {
        val action = customerDAO.all

        val result = Await.result(action, Duration.Inf)

        result mustBe List.empty
    }


  }

}
