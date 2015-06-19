package controllers

import models.Account
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

object AccountController extends Controller {

  val accounts = Map(
    1 -> Account(1, 50),
    2 -> Account(2, 450000),
    3 -> Account(3, 75000),
    4 -> Account(4, 3500000))

  def getAccount(id: Int) = Action {
    accounts.get(id) match {
      case Some(balance) => Ok(Json.toJson(balance))
      case None => BadRequest(Json.obj("error" -> s"Account $id not found"))
    }
  }
}
