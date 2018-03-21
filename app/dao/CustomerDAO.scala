package dao

import scala.concurrent.{ ExecutionContext, Future }
import javax.inject.Inject

import models.Customer
import play.api.db.slick.DatabaseConfigProvider
import slick.dbio
import slick.dbio.Effect.Read
import slick.jdbc.JdbcProfile
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class CustomerDAO @Inject() (protected val dbConfigProvider: DatabaseConfigProvider) {
  
   val dbConfig = dbConfigProvider.get[JdbcProfile]
   val db = dbConfig.db
   import dbConfig.profile.api._

  private val customers = new TableQuery(new CustomerTable(_))
   
  def all(): Future[Seq[Customer]] = db.run(customers.result)
  
  def insert(customer: Customer): Future[Unit] = db.run(customers += customer).map { _ => () }
   
  def update(customer: Customer): Future[Unit] = {
    val q = for { c <- customers if c.id === customer.id } yield (c.firstName, c.lastName)
    db.run(q.update(customer.firstname, customer.lastname)).map(_ => ())
  }
   
  def delete(id: Long): Future[Int] = db.run(customers.filter(_.id === id).delete)

  private class CustomerTable(tag: Tag) extends Table[Customer](tag, "customer") {
    
    def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
    def firstName = column[String]("firstname")
    def lastName = column[String]("lastname")

   def * = (id, firstName, lastName) <> (Customer.tupled, Customer.unapply)
  }
}