package models

case class Customer(id: Long, firstname: String, lastname: String)

case class CustomerFormData(firstname: String, lastname: String)