package controllers

import scala.concurrent._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.Play.current

import scala.slick.driver.PostgresDriver.simple._
import models.User
import models.Users
import play.mvc.Http.Cookie

import scala.annotation.tailrec

object Application extends Controller {

  val random = new scala.util.Random
  // 4 - tail recursive, no wrapper
  @tailrec
  def randomStringTailRecursive(n: Int, list: List[Char] = List[Char]()): String = {
    if (n == 1) (random.nextPrintableChar :: list).mkString
    else randomStringTailRecursive(n-1, random.nextPrintableChar :: list)
  }

	def index = Action {
		Ok(views.html.index(Users.all))
	}
	def matt = Action { (request: Request[AnyContent]) =>

    /*
		val cookie = new Cookie("name",
			"value",
			-1,
			"",
			"",
			false,
			false)
    val foo: Result = null
    foo.withCookies(Cookie(key, value))
    Ok("foo").withCookies(Cookie(key, value))
    */

    val key: String = randomStringTailRecursive(5)
    val value: String = randomStringTailRecursive(10)

		Ok(views.html.mattindex("Matt's Game")(request)).withSession(request.session + (key -> value))
	}
}
