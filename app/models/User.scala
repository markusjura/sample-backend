package models

import play.api.libs.json.Json

object User {
  implicit val userFormat = Json.format[User]
}

case class User(name: String, accountId: Int)
