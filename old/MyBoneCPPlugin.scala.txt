package tests

import org.specs2.execute.{AsResult, Result}
import org.specs2.mutable._
import org.specs2.specification.Scope
import play.api.db.BoneCPPlugin
import play.api.test.Helpers._
import play.api.test._

// Doesn't work.
/*
class MyBoneCPPlugin(val app: play.api.Application) extends BoneCPPlugin(app) {

  override def onStop() {
    //don't stop the BoneCPPlugin because it is not restartable
    //plugin.onStop()
  }
}

object WithDb {

  val fak = FakeApplication(additionalConfiguration = inMemoryDatabase(options = Map("MODE" -> "MySQL",
    "DB_CLOSE_DELAY" -> "-1",
    "DB_CLOSE_ON_EXIT" -> "FALSE")),
    withoutPlugins = Seq("play.api.db.BoneCPPlugin"),
    additionalPlugins = Seq("helpers.MyBoneCPPlugin"))
}

abstract class WithApplication2(val app: FakeApplication = WithDb.fak) extends Around with Scope {
  implicit def implicitApp = app
  override def around[T: AsResult](t: => T): Result = {
    Helpers.running(app)(AsResult.effectively(t))
  }
}
*/