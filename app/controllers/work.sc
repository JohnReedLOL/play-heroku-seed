import scala.concurrent._
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api._
import play.api.mvc.{Cookie, _}
import play.api.data._
import play.api.data.Forms._
import play.api.Play.current

import scala.slick.driver.PostgresDriver.simple._
import play.api.libs.Files.TemporaryFile
import play.api.libs.iteratee._
import play.api.mvc.Cookie
import play.api.mvc.MultipartFormData.FilePart

import scala.trace._
import scala.annotation.tailrec


  val consumeOneInputAndEventuallyReturnIt = new Iteratee[String, Int] {

    def fold[B](folder: Step[String, Int] => Future[B])(implicit ec: ExecutionContext): Future[B] = {
      Debug.err("Fold")
      folder(Step.Cont {
        case Input.EOF => Done(0, Input.EOF) //Assuming 0 for default value
        case Input.Empty => this
        case Input.El(e) => Done(e.toInt, Input.EOF)
      })
    }
  }

  def folder(step: Step[String, Int]): Future[Int] = step match {
    case Step.Done(a, _) => System.exit(-1); future(a)
    case Step.Cont(continuation) => {
      Macro.codeErr("Folding " + continuation)
      continuation(Input.EOF).fold({
        case Step.Done(a1, _) => Future.successful(a1) // this is what gets returned
        case _ => throw new Exception("Erroneous or diverging iteratee")
      })
    }
    case _ => throw new Exception("Erroneous iteratee")
  }

//def main(args: Array[String]) {
val result: Future[Int] = consumeOneInputAndEventuallyReturnIt.fold[Int](folder)

import scala.concurrent.duration._

val myInt: Int = Await.result(result, 5.second) // scala.concurrent.duration
Macro.codeErr("Done: " + myInt)

"Done: " + myInt

6
//}