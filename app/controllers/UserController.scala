package controllers

import models.User
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}

object UserController extends Controller {

  private val users = Map(
    "markus" -> User("Markus", 1),
    "ian" -> User("Ian", 2),
    "tim" -> User("Tim", 3),
    "scott" -> User("Scott", 4))

  def findByName(name: String) = Action {
    users.get(name.toLowerCase) match {
      case Some(user) => Ok(Json.toJson(user))
      case None => BadRequest(Json.obj("error" -> s"User $name not found"))
    }
  }
}
