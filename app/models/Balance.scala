package models

import play.api.libs.json.Json

object Account {
  implicit val accountFormat = Json.format[Account]
}

case class Account(id: Int, balance: Int)
