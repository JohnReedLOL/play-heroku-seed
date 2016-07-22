package controllers

import scala.concurrent._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api._
import play.api.mvc.{Cookie, _}
import play.api.data._
import play.api.data.Forms._
import play.api.Play.current

import scala.slick.driver.PostgresDriver.simple._
import models.User
import models.Users
import play.api.mvc.Cookie

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

  /**
    * An HTTP cookie.
    *
    * @param name the cookie name
    * @param value the cookie value
    * @param maxAge the cookie expiration date in seconds, `None` for a transient cookie, or a value less than 0 to expire a cookie now
    * @param path the cookie path, defaulting to the root path `/`
    * @param domain the cookie domain
    * @param secure whether this cookie is secured, sent only for HTTPS requests
    * @param httpOnly whether this cookie is HTTP only, i.e. not accessible from client-side JavaScipt code
    */
  //case class Cookie(name: String, value: String, maxAge: Option[Int] = None, path: String = "/", domain: Option[String] = None, secure: Boolean = false, httpOnly: Boolean = true)
  val default5secCookie = Cookie("5secondcookie", "0", Some(2), "/", None, false, true)
  val defaultForeverCookie = Cookie("forevercookie", "0", Some(Int.MaxValue), "/", None, false, true)

	def matt = Action { (request: Request[AnyContent]) =>

    /*
    val fiveSecondCookieOp = request.cookies.get("5secondcookie")
    val foreverCookieOp = request.cookies.get("forevercookie")

    val fiveSecondCookie = fiveSecondCookieOp.getOrElse(default5secCookie)
    val foreverCookie = foreverCookieOp.getOrElse(defaultForeverCookie)
    */
    val sessionCount = request.session.get("count").getOrElse("0").toInt // the count stored in the session
		Ok(views.html.mattindex("Matt's Game")(request))
      .withSession(
        request.session + ("count" -> (sessionCount + 1).toString )
      )
	}
}
