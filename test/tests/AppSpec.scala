package tests

import play.api.Play

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.Duration

// import org.junit.runner._
import org.specs2.mutable._
import org.specs2.runner._
import play.api.test.Helpers._
import play.api.test._
import play.api.mvc._

object AppWithTestDb2 extends FakeApplication(additionalConfiguration =
  Map(
    ("db.default.driver") -> "org.h2.Driver",
    ("db.default.url") -> (
      "jdbc:h2:mem:play-test-" + scala.util.Random.nextInt +      // in memory database
      // "jdbc:h2:/tmp/play-test-" + scala.util.Random.nextInt +     // file based db that can be accessed using h2-browse in activator
      ";MODE=PostgreSQL;DATABASE_TO_UPPER=false;DB_CLOSE_DELAY=-1"
    )
  )
)

class AppSpec extends Specification { sequential


  step(Play.start(AppWithTestDb2))

  "application" should {

    "send 404 on a bad request" in {
      route(FakeRequest(GET, "/boum")) must beNone
    }

    "render the index page" in {
      val home: Future[Result] = route(FakeRequest(GET, "/")).get

      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/html")
      contentAsString(home) must contain ("users")
    }

    /*
    "post signup request" in {
      val res = route(FakeRequest(POST, "/user", FakeHeaders(), TestData.newUser)).get
      status(res) must equalTo(OK)
      contentType(res) must beSome("application/json")
      contentAsJson(res) mustEqual TestData.newUser
    }

    "fail signup request for existing user" in {
      val res1 = route(FakeRequest(POST, "/user", FakeHeaders(), TestData.newUser)).get
      Await.result(res1, Duration.Inf)
      val res = route(FakeRequest(POST, "/user", FakeHeaders(), TestData.newUser)).get
      Await.result(res, Duration.Inf)
      status(res) must equalTo(CONFLICT)
      contentType(res) must beSome("application/json")
      contentAsJson(res) mustEqual TestData.newUser
    }
    */
  }

  step(Play.stop())

}
