package tests

import org.junit.runner._
import org.specs2.mutable._
import org.specs2.runner._
import play.api.test.WithBrowser

/**
  * add your integration spec here.
  * An integration test will fire up a whole play application in a real (or headless) browser
  */
@RunWith(classOf[JUnitRunner])
class IntegrationSpec extends Specification {

  "Application" should {

    "work from within a browser" in new WithBrowser {

      browser.goTo("http://localhost:" + port)

      browser.pageSource must contain("users")
    }

    /* // this fails
    "work from within a browser again" in new WithBrowser {

      browser.goTo("http://localhost:" + port)

      browser.pageSource must contain("users")
    }
    */
  }
}
/*
// when I try "work from within a browser again"

[play-heroku-seed] $ test
[info] Compiling 1 Scala source to /home/johnreed/Desktop/Apps/play-heroku-seed/target/scala-2.11/test-classes...
[info] ApplicationSpec
[info]
[info] Application should
[info] + send 404 on a bad request
[info]
[info] Total for specification ApplicationSpec
[info] Finished in 3 seconds, 417 ms
[info] 1 example, 0 failure, 0 error
[error] application -

! @70o3h3fp8 - Internal server error, for (GET) [/] ->

play.api.Application$$anon$1: Execution exception[[SQLException: Attempting to obtain a connection from a pool that has already been shutdown.
Stack trace of location where pool was shutdown follows:
 java.lang.Thread.getStackTrace(Thread.java:1589)
 com.jolbox.bonecp.BoneCP.captureStackTrace(BoneCP.java:572)
 com.jolbox.bonecp.BoneCP.shutdown(BoneCP.java:161)
 com.jolbox.bonecp.BoneCPDataSource.close(BoneCPDataSource.java:143)
 play.api.db.BoneCPApi.shutdownPool(DB.scala:424)
 play.api.db.BoneCPPlugin$$anonfun$onStop$1.apply(DB.scala:260)
 play.api.db.BoneCPPlugin$$anonfun$onStop$1.apply(DB.scala:258)
 scala.collection.immutable.List.foreach(List.scala:381)
 play.api.db.BoneCPPlugin.onStop(DB.scala:258)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1$$anonfun$apply$mcV$sp$2.apply(Play.scala:108)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1$$anonfun$apply$mcV$sp$2.apply(Play.scala:107)
 scala.collection.immutable.List.foreach(List.scala:381)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply$mcV$sp(Play.scala:107)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply(Play.scala:107)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply(Play.scala:107)
 play.utils.Threads$.withContextClassLoader(Threads.scala:21)
 play.api.Play$$anonfun$stop$1.apply(Play.scala:106)
 play.api.Play$$anonfun$stop$1.apply(Play.scala:105)
 scala.Option.map(Option.scala:146)
 play.api.Play$.stop(Play.scala:105)
 play.api.test.PlayRunners$class.running(Helpers.scala:51)
 play.api.test.Helpers$.running(Helpers.scala:405)
 play.api.test.WithApplication.around(Specs.scala:23)
 org.specs2.mutable.Around$$anonfun$delayedInit$1.apply(Around.scala:13)
 org.specs2.mutable.Around$$anonfun$delayedInit$1.apply(Around.scala:13)
 org.specs2.execute.ResultExecution$class.effectively(ResultExecution.scala:38)
 org.specs2.execute.ResultExecution$.effectively(ResultExecution.scala:116)
 org.specs2.mutable.Around$class.delayedInit(Around.scala:13)
 play.api.test.WithApplication.delayedInit(Specs.scala:20)
 ApplicationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.<init>(ApplicationSpec.scala:20)
 ApplicationSpec$$anonfun$1$$anonfun$apply$1.apply(ApplicationSpec.scala:20)
 ApplicationSpec$$anonfun$1$$anonfun$apply$1.apply(ApplicationSpec.scala:20)
 org.specs2.matcher.Scope$$anon$3.asResult(ThrownExpectations.scala:120)
 org.specs2.execute.AsResult$.apply(Result.scala:253)
 org.specs2.specification.Example$$anonfun$apply$1.apply(Fragment.scala:209)
 org.specs2.specification.Example$$anonfun$apply$1.apply(Fragment.scala:209)
 org.specs2.specification.Example.execute(Fragment.scala:176)
 org.specs2.specification.FragmentExecution$$anonfun$1.apply(FragmentExecution.scala:46)
 org.specs2.specification.FragmentExecution$$anonfun$1.apply(FragmentExecution.scala:46)
 org.specs2.execute.ResultExecution$class.execute(ResultExecution.scala:22)
 org.specs2.execute.ResultExecution$.execute(ResultExecution.scala:116)
 org.specs2.specification.FragmentExecution$class.executeBody(FragmentExecution.scala:28)
 org.specs2.reporter.SbtConsoleReporter.executeBody(SbtReporter.scala:20)
 org.specs2.specification.FragmentExecution$class.execute(FragmentExecution.scala:46)
 org.specs2.reporter.SbtConsoleReporter.execute(SbtReporter.scala:20)
 org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1$$anonfun$apply$1.apply(FragmentExecution.scala:35)
 org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1$$anonfun$apply$1.apply(FragmentExecution.scala:35)
 org.specs2.control.Exceptions$class.catchAllOr(Exceptions.scala:54)
 org.specs2.control.Exceptions$.catchAllOr(Exceptions.scala:109)
 org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1.apply(FragmentExecution.scala:35)
 org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1.apply(FragmentExecution.scala:35)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$executeSequentially$1.apply(ExecutionStrategy.scala:104)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$executeSequentially$1.apply(ExecutionStrategy.scala:104)
 scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:234)
 scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:234)
 scala.collection.immutable.List.foreach(List.scala:381)
 scala.collection.TraversableLike$class.map(TraversableLike.scala:234)
 scala.collection.immutable.List.map(List.scala:285)
 org.specs2.reporter.DefaultExecutionStrategy$class.executeSequentially(ExecutionStrategy.scala:104)
 org.specs2.reporter.SbtConsoleReporter.executeSequentially(SbtReporter.scala:20)
 org.specs2.reporter.DefaultExecutionStrategy$class.executeSequence(ExecutionStrategy.scala:98)
 org.specs2.reporter.SbtConsoleReporter.executeSequence(SbtReporter.scala:20)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1$$anonfun$2.apply(ExecutionStrategy.scala:43)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1$$anonfun$2.apply(ExecutionStrategy.scala:41)
 scala.collection.immutable.Stream.foldLeft(Stream.scala:610)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1.apply(ExecutionStrategy.scala:41)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1.apply(ExecutionStrategy.scala:38)
 scalaz.syntax.IdOps$class.$bar$greater(IdOps.scala:15)
 scalaz.syntax.ToIdOps$$anon$1.$bar$greater(IdOps.scala:82)
 org.specs2.reporter.AllExporting$class.report(AllExporting.scala:17)
 org.specs2.reporter.SbtConsoleReporter.report(SbtReporter.scala:20)
 org.specs2.runner.SbtRunner.org$specs2$runner$SbtRunner$$specificationRun(SbtRunner.scala:75)
 org.specs2.runner.SbtRunner$$anonfun$newTask$1$$anon$5.execute(SbtRunner.scala:59)
 sbt.ForkMain$Run$2.call(ForkMain.java:294)
 sbt.ForkMain$Run$2.call(ForkMain.java:284)
 java.util.concurrent.FutureTask.run(FutureTask.java:262)
 java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
 java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
 java.lang.Thread.run(Thread.java:745)
]]
        at play.api.Application$class.handleError(Application.scala:296) ~[play_2.11-2.3.10.jar:2.3.10]
        at play.api.test.FakeApplication.handleError(Fakes.scala:211) [play-test_2.11-2.3.10.jar:2.3.10]
        at play.core.server.netty.PlayDefaultUpstreamHandler$$anonfun$14$$anonfun$apply$1.applyOrElse(PlayDefaultUpstreamHandler.scala:205) [play_2.11-2.3.10.jar:2.3.10]
        at play.core.server.netty.PlayDefaultUpstreamHandler$$anonfun$14$$anonfun$apply$1.applyOrElse(PlayDefaultUpstreamHandler.scala:202) [play_2.11-2.3.10.jar:2.3.10]
        at scala.runtime.AbstractPartialFunction.apply(AbstractPartialFunction.scala:36) [scala-library-2.11.8.jar:na]
Caused by: java.sql.SQLException: Attempting to obtain a connection from a pool that has already been shutdown.
Stack trace of location where pool was shutdown follows:
 java.lang.Thread.getStackTrace(Thread.java:1589)
 com.jolbox.bonecp.BoneCP.captureStackTrace(BoneCP.java:572)
 com.jolbox.bonecp.BoneCP.shutdown(BoneCP.java:161)
 com.jolbox.bonecp.BoneCPDataSource.close(BoneCPDataSource.java:143)
 play.api.db.BoneCPApi.shutdownPool(DB.scala:424)
 play.api.db.BoneCPPlugin$$anonfun$onStop$1.apply(DB.scala:260)
 play.api.db.BoneCPPlugin$$anonfun$onStop$1.apply(DB.scala:258)
 scala.collection.immutable.List.foreach(List.scala:381)
 play.api.db.BoneCPPlugin.onStop(DB.scala:258)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1$$anonfun$apply$mcV$sp$2.apply(Play.scala:108)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1$$anonfun$apply$mcV$sp$2.apply(Play.scala:107)
 scala.collection.immutable.List.foreach(List.scala:381)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply$mcV$sp(Play.scala:107)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply(Play.scala:107)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply(Play.scala:107)
 play.utils.Threads$.withContextClassLoader(Threads.scala:21)
 play.api.Play$$anonfun$stop$1.apply(Play.scala:106)
 play.api.Play$$anonfun$stop$1.apply(Play.scala:105)
 scala.Option.map(Option.scala:146)
 play.api.Play$.stop(Play.scala:105)
 play.api.test.PlayRunners$class.running(Helpers.scala:51)
 play.api.test.Helpers$.running(Helpers.scala:405)
 play.api.test.WithApplication.around(Specs.scala:23)
 org.specs2.mutable.Around$$anonfun$delayedInit$1.apply(Around.scala:13)
 org.specs2.mutable.Around$$anonfun$delayedInit$1.apply(Around.scala:13)
 org.specs2.execute.ResultExecution$class.effectively(ResultExecution.scala:38)
 org.specs2.execute.ResultExecution$.effectively(ResultExecution.scala:116)
 org.specs2.mutable.Around$class.delayedInit(Around.scala:13)
 play.api.test.WithApplication.delayedInit(Specs.scala:20)
 ApplicationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.<init>(ApplicationSpec.scala:20)
 ApplicationSpec$$anonfun$1$$anonfun$apply$1.apply(ApplicationSpec.scala:20)
 ApplicationSpec$$anonfun$1$$anonfun$apply$1.apply(ApplicationSpec.scala:20)
 org.specs2.matcher.Scope$$anon$3.asResult(ThrownExpectations.scala:120)
 org.specs2.execute.AsResult$.apply(Result.scala:253)
 org.specs2.specification.Example$$anonfun$apply$1.apply(Fragment.scala:209)
 org.specs2.specification.Example$$anonfun$apply$1.apply(Fragment.scala:209)
 org.specs2.specification.Example.execute(Fragment.scala:176)
 org.specs2.specification.FragmentExecution$$anonfun$1.apply(FragmentExecution.scala:46)
 org.specs2.specification.FragmentExecution$$anonfun$1.apply(FragmentExecution.scala:46)
 org.specs2.execute.ResultExecution$class.execute(ResultExecution.scala:22)
 org.specs2.execute.ResultExecution$.execute(ResultExecution.scala:116)
 org.specs2.specification.FragmentExecution$class.executeBody(FragmentExecution.scala:28)
 org.specs2.reporter.SbtConsoleReporter.executeBody(SbtReporter.scala:20)
 org.specs2.specification.FragmentExecution$class.execute(FragmentExecution.scala:46)
 org.specs2.reporter.SbtConsoleReporter.execute(SbtReporter.scala:20)
 org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1$$anonfun$apply$1.apply(FragmentExecution.scala:35)
 org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1$$anonfun$apply$1.apply(FragmentExecution.scala:35)
 org.specs2.control.Exceptions$class.catchAllOr(Exceptions.scala:54)
 org.specs2.control.Exceptions$.catchAllOr(Exceptions.scala:109)
 org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1.apply(FragmentExecution.scala:35)
 org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1.apply(FragmentExecution.scala:35)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$executeSequentially$1.apply(ExecutionStrategy.scala:104)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$executeSequentially$1.apply(ExecutionStrategy.scala:104)
 scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:234)
 scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:234)
 scala.collection.immutable.List.foreach(List.scala:381)
 scala.collection.TraversableLike$class.map(TraversableLike.scala:234)
 scala.collection.immutable.List.map(List.scala:285)
 org.specs2.reporter.DefaultExecutionStrategy$class.executeSequentially(ExecutionStrategy.scala:104)
 org.specs2.reporter.SbtConsoleReporter.executeSequentially(SbtReporter.scala:20)
 org.specs2.reporter.DefaultExecutionStrategy$class.executeSequence(ExecutionStrategy.scala:98)
 org.specs2.reporter.SbtConsoleReporter.executeSequence(SbtReporter.scala:20)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1$$anonfun$2.apply(ExecutionStrategy.scala:43)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1$$anonfun$2.apply(ExecutionStrategy.scala:41)
 scala.collection.immutable.Stream.foldLeft(Stream.scala:610)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1.apply(ExecutionStrategy.scala:41)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1.apply(ExecutionStrategy.scala:38)
 scalaz.syntax.IdOps$class.$bar$greater(IdOps.scala:15)
 scalaz.syntax.ToIdOps$$anon$1.$bar$greater(IdOps.scala:82)
 org.specs2.reporter.AllExporting$class.report(AllExporting.scala:17)
 org.specs2.reporter.SbtConsoleReporter.report(SbtReporter.scala:20)
 org.specs2.runner.SbtRunner.org$specs2$runner$SbtRunner$$specificationRun(SbtRunner.scala:75)
 org.specs2.runner.SbtRunner$$anonfun$newTask$1$$anon$5.execute(SbtRunner.scala:59)
 sbt.ForkMain$Run$2.call(ForkMain.java:294)
 sbt.ForkMain$Run$2.call(ForkMain.java:284)
 java.util.concurrent.FutureTask.run(FutureTask.java:262)
 java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
 java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
 java.lang.Thread.run(Thread.java:745)

        at com.jolbox.bonecp.AbstractConnectionStrategy.preConnection(AbstractConnectionStrategy.java:52) ~[bonecp-0.8.0.RELEASE.jar:na]
        at com.jolbox.bonecp.AbstractConnectionStrategy.getConnection(AbstractConnectionStrategy.java:88) ~[bonecp-0.8.0.RELEASE.jar:na]
        at com.jolbox.bonecp.BoneCP.getConnection(BoneCP.java:553) ~[bonecp-0.8.0.RELEASE.jar:na]
        at com.jolbox.bonecp.BoneCPDataSource.getConnection(BoneCPDataSource.java:131) ~[bonecp-0.8.0.RELEASE.jar:na]
        at scala.slick.jdbc.PlayDatabase.createConnection(PlayDatabase.scala:8) ~[play-slick_2.11-0.8.0.jar:na]
[error] application -

! @70o3h3hp5 - Internal server error, for (GET) [/] ->

play.api.Application$$anon$1: Execution exception[[SQLException: Attempting to obtain a connection from a pool that has already been shutdown.
Stack trace of location where pool was shutdown follows:
 java.lang.Thread.getStackTrace(Thread.java:1589)
 com.jolbox.bonecp.BoneCP.captureStackTrace(BoneCP.java:572)
 com.jolbox.bonecp.BoneCP.shutdown(BoneCP.java:161)
 com.jolbox.bonecp.BoneCPDataSource.close(BoneCPDataSource.java:143)
 play.api.db.BoneCPApi.shutdownPool(DB.scala:424)
 play.api.db.BoneCPPlugin$$anonfun$onStop$1.apply(DB.scala:260)
 play.api.db.BoneCPPlugin$$anonfun$onStop$1.apply(DB.scala:258)
 scala.collection.immutable.List.foreach(List.scala:381)
 play.api.db.BoneCPPlugin.onStop(DB.scala:258)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1$$anonfun$apply$mcV$sp$2.apply(Play.scala:108)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1$$anonfun$apply$mcV$sp$2.apply(Play.scala:107)
 scala.collection.immutable.List.foreach(List.scala:381)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply$mcV$sp(Play.scala:107)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply(Play.scala:107)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply(Play.scala:107)
 play.utils.Threads$.withContextClassLoader(Threads.scala:21)
 play.api.Play$$anonfun$stop$1.apply(Play.scala:106)
 play.api.Play$$anonfun$stop$1.apply(Play.scala:105)
 scala.Option.map(Option.scala:146)
 play.api.Play$.stop(Play.scala:105)
 play.api.test.PlayRunners$class.running(Helpers.scala:51)
 play.api.test.Helpers$.running(Helpers.scala:405)
 play.api.test.WithApplication.around(Specs.scala:23)
 org.specs2.mutable.Around$$anonfun$delayedInit$1.apply(Around.scala:13)
 org.specs2.mutable.Around$$anonfun$delayedInit$1.apply(Around.scala:13)
 org.specs2.execute.ResultExecution$class.effectively(ResultExecution.scala:38)
 org.specs2.execute.ResultExecution$.effectively(ResultExecution.scala:116)
 org.specs2.mutable.Around$class.delayedInit(Around.scala:13)
 play.api.test.WithApplication.delayedInit(Specs.scala:20)
 ApplicationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.<init>(ApplicationSpec.scala:20)
 ApplicationSpec$$anonfun$1$$anonfun$apply$1.apply(ApplicationSpec.scala:20)
 ApplicationSpec$$anonfun$1$$anonfun$apply$1.apply(ApplicationSpec.scala:20)
 org.specs2.matcher.Scope$$anon$3.asResult(ThrownExpectations.scala:120)
 org.specs2.execute.AsResult$.apply(Result.scala:253)
 org.specs2.specification.Example$$anonfun$apply$1.apply(Fragment.scala:209)
 org.specs2.specification.Example$$anonfun$apply$1.apply(Fragment.scala:209)
 org.specs2.specification.Example.execute(Fragment.scala:176)
 org.specs2.specification.FragmentExecution$$anonfun$1.apply(FragmentExecution.scala:46)
 org.specs2.specification.FragmentExecution$$anonfun$1.apply(FragmentExecution.scala:46)
 org.specs2.execute.ResultExecution$class.execute(ResultExecution.scala:22)
 org.specs2.execute.ResultExecution$.execute(ResultExecution.scala:116)
 org.specs2.specification.FragmentExecution$class.executeBody(FragmentExecution.scala:28)
 org.specs2.reporter.SbtConsoleReporter.executeBody(SbtReporter.scala:20)
 org.specs2.specification.FragmentExecution$class.execute(FragmentExecution.scala:46)
 org.specs2.reporter.SbtConsoleReporter.execute(SbtReporter.scala:20)
 org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1$$anonfun$apply$1.apply(FragmentExecution.scala:35)
 org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1$$anonfun$apply$1.apply(FragmentExecution.scala:35)
 org.specs2.control.Exceptions$class.catchAllOr(Exceptions.scala:54)
 org.specs2.control.Exceptions$.catchAllOr(Exceptions.scala:109)
 org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1.apply(FragmentExecution.scala:35)
 org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1.apply(FragmentExecution.scala:35)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$executeSequentially$1.apply(ExecutionStrategy.scala:104)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$executeSequentially$1.apply(ExecutionStrategy.scala:104)
 scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:234)
 scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:234)
 scala.collection.immutable.List.foreach(List.scala:381)
 scala.collection.TraversableLike$class.map(TraversableLike.scala:234)
 scala.collection.immutable.List.map(List.scala:285)
 org.specs2.reporter.DefaultExecutionStrategy$class.executeSequentially(ExecutionStrategy.scala:104)
 org.specs2.reporter.SbtConsoleReporter.executeSequentially(SbtReporter.scala:20)
 org.specs2.reporter.DefaultExecutionStrategy$class.executeSequence(ExecutionStrategy.scala:98)
 org.specs2.reporter.SbtConsoleReporter.executeSequence(SbtReporter.scala:20)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1$$anonfun$2.apply(ExecutionStrategy.scala:43)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1$$anonfun$2.apply(ExecutionStrategy.scala:41)
 scala.collection.immutable.Stream.foldLeft(Stream.scala:610)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1.apply(ExecutionStrategy.scala:41)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1.apply(ExecutionStrategy.scala:38)
 scalaz.syntax.IdOps$class.$bar$greater(IdOps.scala:15)
 scalaz.syntax.ToIdOps$$anon$1.$bar$greater(IdOps.scala:82)
 org.specs2.reporter.AllExporting$class.report(AllExporting.scala:17)
 org.specs2.reporter.SbtConsoleReporter.report(SbtReporter.scala:20)
 org.specs2.runner.SbtRunner.org$specs2$runner$SbtRunner$$specificationRun(SbtRunner.scala:75)
 org.specs2.runner.SbtRunner$$anonfun$newTask$1$$anon$5.execute(SbtRunner.scala:59)
 sbt.ForkMain$Run$2.call(ForkMain.java:294)
 sbt.ForkMain$Run$2.call(ForkMain.java:284)
 java.util.concurrent.FutureTask.run(FutureTask.java:262)
 java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
 java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
 java.lang.Thread.run(Thread.java:745)
]]
        at play.api.Application$class.handleError(Application.scala:296) ~[play_2.11-2.3.10.jar:2.3.10]
        at play.api.test.FakeApplication.handleError(Fakes.scala:211) [play-test_2.11-2.3.10.jar:2.3.10]
        at play.core.server.netty.PlayDefaultUpstreamHandler$$anonfun$14$$anonfun$apply$1.applyOrElse(PlayDefaultUpstreamHandler.scala:205) [play_2.11-2.3.10.jar:2.3.10]
        at play.core.server.netty.PlayDefaultUpstreamHandler$$anonfun$14$$anonfun$apply$1.applyOrElse(PlayDefaultUpstreamHandler.scala:202) [play_2.11-2.3.10.jar:2.3.10]
        at scala.runtime.AbstractPartialFunction.apply(AbstractPartialFunction.scala:36) [scala-library-2.11.8.jar:na]
Caused by: java.sql.SQLException: Attempting to obtain a connection from a pool that has already been shutdown.
Stack trace of location where pool was shutdown follows:
 java.lang.Thread.getStackTrace(Thread.java:1589)
 com.jolbox.bonecp.BoneCP.captureStackTrace(BoneCP.java:572)
 com.jolbox.bonecp.BoneCP.shutdown(BoneCP.java:161)
 com.jolbox.bonecp.BoneCPDataSource.close(BoneCPDataSource.java:143)
 play.api.db.BoneCPApi.shutdownPool(DB.scala:424)
 play.api.db.BoneCPPlugin$$anonfun$onStop$1.apply(DB.scala:260)
 play.api.db.BoneCPPlugin$$anonfun$onStop$1.apply(DB.scala:258)
 scala.collection.immutable.List.foreach(List.scala:381)
 play.api.db.BoneCPPlugin.onStop(DB.scala:258)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1$$anonfun$apply$mcV$sp$2.apply(Play.scala:108)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1$$anonfun$apply$mcV$sp$2.apply(Play.scala:107)
 scala.collection.immutable.List.foreach(List.scala:381)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply$mcV$sp(Play.scala:107)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply(Play.scala:107)
 play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply(Play.scala:107)
 play.utils.Threads$.withContextClassLoader(Threads.scala:21)
 play.api.Play$$anonfun$stop$1.apply(Play.scala:106)
 play.api.Play$$anonfun$stop$1.apply(Play.scala:105)
 scala.Option.map(Option.scala:146)
 play.api.Play$.stop(Play.scala:105)
 play.api.test.PlayRunners$class.running(Helpers.scala:51)
 play.api.test.Helpers$.running(Helpers.scala:405)
 play.api.test.WithApplication.around(Specs.scala:23)
 org.specs2.mutable.Around$$anonfun$delayedInit$1.apply(Around.scala:13)
 org.specs2.mutable.Around$$anonfun$delayedInit$1.apply(Around.scala:13)
 org.specs2.execute.ResultExecution$class.effectively(ResultExecution.scala:38)
 org.specs2.execute.ResultExecution$.effectively(ResultExecution.scala:116)
 org.specs2.mutable.Around$class.delayedInit(Around.scala:13)
 play.api.test.WithApplication.delayedInit(Specs.scala:20)
 ApplicationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.<init>(ApplicationSpec.scala:20)
 ApplicationSpec$$anonfun$1$$anonfun$apply$1.apply(ApplicationSpec.scala:20)
 ApplicationSpec$$anonfun$1$$anonfun$apply$1.apply(ApplicationSpec.scala:20)
 org.specs2.matcher.Scope$$anon$3.asResult(ThrownExpectations.scala:120)
 org.specs2.execute.AsResult$.apply(Result.scala:253)
 org.specs2.specification.Example$$anonfun$apply$1.apply(Fragment.scala:209)
 org.specs2.specification.Example$$anonfun$apply$1.apply(Fragment.scala:209)
 org.specs2.specification.Example.execute(Fragment.scala:176)
 org.specs2.specification.FragmentExecution$$anonfun$1.apply(FragmentExecution.scala:46)
 org.specs2.specification.FragmentExecution$$anonfun$1.apply(FragmentExecution.scala:46)
 org.specs2.execute.ResultExecution$class.execute(ResultExecution.scala:22)
 org.specs2.execute.ResultExecution$.execute(ResultExecution.scala:116)
 org.specs2.specification.FragmentExecution$class.executeBody(FragmentExecution.scala:28)
 org.specs2.reporter.SbtConsoleReporter.executeBody(SbtReporter.scala:20)
 org.specs2.specification.FragmentExecution$class.execute(FragmentExecution.scala:46)
 org.specs2.reporter.SbtConsoleReporter.execute(SbtReporter.scala:20)
 org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1$$anonfun$apply$1.apply(FragmentExecution.scala:35)
 org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1$$anonfun$apply$1.apply(FragmentExecution.scala:35)
 org.specs2.control.Exceptions$class.catchAllOr(Exceptions.scala:54)
 org.specs2.control.Exceptions$.catchAllOr(Exceptions.scala:109)
 org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1.apply(FragmentExecution.scala:35)
 org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1.apply(FragmentExecution.scala:35)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$executeSequentially$1.apply(ExecutionStrategy.scala:104)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$executeSequentially$1.apply(ExecutionStrategy.scala:104)
 scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:234)
 scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:234)
 scala.collection.immutable.List.foreach(List.scala:381)
 scala.collection.TraversableLike$class.map(TraversableLike.scala:234)
 scala.collection.immutable.List.map(List.scala:285)
 org.specs2.reporter.DefaultExecutionStrategy$class.executeSequentially(ExecutionStrategy.scala:104)
 org.specs2.reporter.SbtConsoleReporter.executeSequentially(SbtReporter.scala:20)
 org.specs2.reporter.DefaultExecutionStrategy$class.executeSequence(ExecutionStrategy.scala:98)
 org.specs2.reporter.SbtConsoleReporter.executeSequence(SbtReporter.scala:20)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1$$anonfun$2.apply(ExecutionStrategy.scala:43)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1$$anonfun$2.apply(ExecutionStrategy.scala:41)
 scala.collection.immutable.Stream.foldLeft(Stream.scala:610)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1.apply(ExecutionStrategy.scala:41)
 org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1.apply(ExecutionStrategy.scala:38)
 scalaz.syntax.IdOps$class.$bar$greater(IdOps.scala:15)
 scalaz.syntax.ToIdOps$$anon$1.$bar$greater(IdOps.scala:82)
 org.specs2.reporter.AllExporting$class.report(AllExporting.scala:17)
 org.specs2.reporter.SbtConsoleReporter.report(SbtReporter.scala:20)
 org.specs2.runner.SbtRunner.org$specs2$runner$SbtRunner$$specificationRun(SbtRunner.scala:75)
 org.specs2.runner.SbtRunner$$anonfun$newTask$1$$anon$5.execute(SbtRunner.scala:59)
 sbt.ForkMain$Run$2.call(ForkMain.java:294)
 sbt.ForkMain$Run$2.call(ForkMain.java:284)
 java.util.concurrent.FutureTask.run(FutureTask.java:262)
 java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
 java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
 java.lang.Thread.run(Thread.java:745)

        at com.jolbox.bonecp.AbstractConnectionStrategy.preConnection(AbstractConnectionStrategy.java:52) ~[bonecp-0.8.0.RELEASE.jar:na]
        at com.jolbox.bonecp.AbstractConnectionStrategy.getConnection(AbstractConnectionStrategy.java:88) ~[bonecp-0.8.0.RELEASE.jar:na]
        at com.jolbox.bonecp.BoneCP.getConnection(BoneCP.java:553) ~[bonecp-0.8.0.RELEASE.jar:na]
        at com.jolbox.bonecp.BoneCPDataSource.getConnection(BoneCPDataSource.java:131) ~[bonecp-0.8.0.RELEASE.jar:na]
        at scala.slick.jdbc.PlayDatabase.createConnection(PlayDatabase.scala:8) ~[play-slick_2.11-0.8.0.jar:na]
[info] IntegrationSpec
[info]
[info] Application should
[info] x work from within a browser
[error]    '<?xml version="1.0" encoding="UTF-8"?>
[error]    <html>
[error]      <head>
[error]        <title>
[error]          Execution exception
[error]        </title>
[error]        <link rel="shortcut icon" href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAlFJREFUeNqUU8tOFEEUPVVdNV3dPe8xYRBnjGhmBgKjKzCIiQvBoIaNbly5Z+PSv3Aj7DSiP2B0rwkLGVdGgxITSCRIJGSMEQWZR3eVt5sEFBgTb/dN1yvnnHtPNTPG4PqdHgCMXnPRSZrpSuH8vUJu4DE4rYHDGAZDX62BZttHqTiIayM3gGiXQsgYLEvATaqxU+dy1U13YXapXptpNHY8iwn8KyIAzm1KBdtRZWErpI5lEWTXp5Z/vHpZ3/wyKKwYGGOdAYwR0EZwoezTYApBEIObyELl/aE1/83cp40Pt5mxqCKrE4Ck+mVWKKcI5tA8BLEhRBKJLjez6a7MLq7XZtp+yyOawwCBtkiBVZDKzRk4NN7NQBMYPHiZDFhXY+p9ff7F961vVcnl4R5I2ykJ5XFN7Ab7Gc61VoipNBKF+PDyztu5lfrSLT/wIwCxq0CAGtXHZTzqR2jtwQiXONma6hHpj9sLT7YaPxfTXuZdBGA02Wi7FS48YiTfj+i2NhqtdhP5RC8mh2/Op7y0v6eAcWVLFT8D7kWX5S9mepp+C450MV6aWL1cGnvkxbwHtLW2B9AOkLeUd9KEDuh9fl/7CEj7YH5g+3r/lWfF9In7tPz6T4IIwBJOr1SJyIGQMZQbsh5P9uBq5VJtqHh2mo49pdw5WFoEwKWqWHacaWOjQXWGcifKo6vj5RGS6zykI587XeUIQDqJSmAp+lE4qt19W5P9o8+Lma5DcjsC8JiT607lMVkdqQ0Vyh3lHhmh52tfNy78ajXv0rgYzv8nfwswANuk+7sD/Q0aAAAAAElFTkSuQmCC"/>
[error]        <style>
[error]
[error]                     html, body, pre {
[error]                         margin: 0;
[error]                         padding: 0;
[error]                         font-family: Monaco, 'Lucida Console', monospace;
[error]                         background: #ECECEC;
[error]                     }
[error]                     h1 {
[error]                         margin: 0;
[error]                         background: #A31012;
[error]                         padding: 20px 45px;
[error]                         color: #fff;
[error]                         text-shadow: 1px 1px 1px rgba(0,0,0,.3);
[error]                         border-bottom: 1px solid #690000;
[error]                         font-size: 28px;
[error]                     }
[error]                a {
[error]                    color: #D36D6D;
[error]                }
[error]                p#detail {
[error]                         margin: 0;
[error]                         padding: 15px 45px;
[error]                         background: #F5A0A0;
[error]                         border-top: 4px solid #D36D6D;
[error]                         color: #730000;
[error]                         text-shadow: 1px 1px 1px rgba(255,255,255,.3);
[error]                         font-size: 14px;
[error]                         border-bottom: 1px solid #BA7A7A;
[error]                     }
[error]                     p#detail.pre {
[error]                         white-space: pre;
[error]                         font-size: 13px;
[error]                         overflow: auto;
[error]                     }
[error]                     p#detail input {
[error]                         background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#AE1113), to(#A31012));
[error]                    border: 1px solid #790000;
[error]                    padding: 3px 10px;
[error]                    text-shadow: 1px 1px 0 rgba(0, 0, 0, .5);
[error]                    color: white;
[error]                    border-radius: 3px;
[error]                    cursor: pointer;
[error]                    font-family: Monaco, 'Lucida Console';
[error]                    font-size: 12px;
[error]                    margin: 0 10px;
[error]                    display: inline-block;
[error]                    position: relative;
[error]                    top: -1px;
[error]                     }
[error]                     h2 {
[error]                         margin: 0;
[error]                         padding: 5px 45px;
[error]                         font-size: 12px;
[error]                         background: #333;
[error]                         color: #fff;
[error]                         text-shadow: 1px 1px 1px rgba(0,0,0,.3);
[error]                         border-top: 4px solid #2a2a2a;
[error]                     }
[error]                         pre {
[error]                                 margin: 0;
[error]                                 border-bottom: 1px solid #DDD;
[error]                                 text-shadow: 1px 1px 1px rgba(255,255,255,.5);
[error]                                 position: relative;
[error]                                 font-size: 12px;
[error]                         }
[error]                         pre span.line {
[error]                             text-align: right;
[error]                             display: inline-block;
[error]                             padding: 5px 5px;
[error]                             width: 30px;
[error]                             background: #D6D6D6;
[error]                             color: #8B8B8B;
[error]                             text-shadow: 1px 1px 1px rgba(255,255,255,.5);
[error]                             font-weight: bold;
[error]                         }
[error]                         pre span.code {
[error]                             padding: 5px 5px;
[error]                             position: absolute;
[error]                             right: 0;
[error]                             left: 40px;
[error]                         }
[error]                         pre:first-child span.code {
[error]                             border-top: 4px solid #CDCDCD;
[error]                         }
[error]                         pre:first-child span.line {
[error]                             border-top: 4px solid #B6B6B6;
[error]                         }
[error]                         pre.error span.line {
[error]                             background: #A31012;
[error]                             color: #fff;
[error]                             text-shadow: 1px 1px 1px rgba(0,0,0,.3);
[error]                         }
[error]                         pre.error {
[error]                                 color: #A31012;
[error]                         }
[error]                         pre.error span.marker {
[error]                                 background: #A31012;
[error]                                 color: #fff;
[error]                                 text-shadow: 1px 1px 1px rgba(0,0,0,.3);
[error]                         }
[error]
[error]        </style>
[error]      </head>
[error]      <body id="play-error-page">
[error]        <h1>
[error]          Execution exception
[error]        </h1>
[error]        <p id="detail" class="pre">
[error]          [SQLException: Attempting to obtain a connection from a pool that has already been shutdown.
[error]    Stack trace of location where pool was shutdown follows:
[error]     java.lang.Thread.getStackTrace(Thread.java:1589)
[error]     com.jolbox.bonecp.BoneCP.captureStackTrace(BoneCP.java:572)
[error]     com.jolbox.bonecp.BoneCP.shutdown(BoneCP.java:161)
[error]     com.jolbox.bonecp.BoneCPDataSource.close(BoneCPDataSource.java:143)
[error]     play.api.db.BoneCPApi.shutdownPool(DB.scala:424)
[error]     play.api.db.BoneCPPlugin$$anonfun$onStop$1.apply(DB.scala:260)
[error]     play.api.db.BoneCPPlugin$$anonfun$onStop$1.apply(DB.scala:258)
[error]     scala.collection.immutable.List.foreach(List.scala:381)
[error]     play.api.db.BoneCPPlugin.onStop(DB.scala:258)
[error]     play.api.Play$$anonfun$stop$1$$anonfun$apply$1$$anonfun$apply$mcV$sp$2.apply(Play.scala:108)
[error]     play.api.Play$$anonfun$stop$1$$anonfun$apply$1$$anonfun$apply$mcV$sp$2.apply(Play.scala:107)
[error]     scala.collection.immutable.List.foreach(List.scala:381)
[error]     play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply$mcV$sp(Play.scala:107)
[error]     play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply(Play.scala:107)
[error]     play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply(Play.scala:107)
[error]     play.utils.Threads$.withContextClassLoader(Threads.scala:21)
[error]     play.api.Play$$anonfun$stop$1.apply(Play.scala:106)
[error]     play.api.Play$$anonfun$stop$1.apply(Play.scala:105)
[error]     scala.Option.map(Option.scala:146)
[error]     play.api.Play$.stop(Play.scala:105)
[error]     play.api.test.PlayRunners$class.running(Helpers.scala:51)
[error]     play.api.test.Helpers$.running(Helpers.scala:405)
[error]     play.api.test.WithApplication.around(Specs.scala:23)
[error]     org.specs2.mutable.Around$$anonfun$delayedInit$1.apply(Around.scala:13)
[error]     org.specs2.mutable.Around$$anonfun$delayedInit$1.apply(Around.scala:13)
[error]     org.specs2.execute.ResultExecution$class.effectively(ResultExecution.scala:38)
[error]     org.specs2.execute.ResultExecution$.effectively(ResultExecution.scala:116)
[error]     org.specs2.mutable.Around$class.delayedInit(Around.scala:13)
[error]     play.api.test.WithApplication.delayedInit(Specs.scala:20)
[error]     ApplicationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.&lt;init&gt;(ApplicationSpec.scala:20)
[error]     ApplicationSpec$$anonfun$1$$anonfun$apply$1.apply(ApplicationSpec.scala:20)
[error]     ApplicationSpec$$anonfun$1$$anonfun$apply$1.apply(ApplicationSpec.scala:20)
[error]     org.specs2.matcher.Scope$$anon$3.asResult(ThrownExpectations.scala:120)
[error]     org.specs2.execute.AsResult$.apply(Result.scala:253)
[error]     org.specs2.specification.Example$$anonfun$apply$1.apply(Fragment.scala:209)
[error]     org.specs2.specification.Example$$anonfun$apply$1.apply(Fragment.scala:209)
[error]     org.specs2.specification.Example.execute(Fragment.scala:176)
[error]     org.specs2.specification.FragmentExecution$$anonfun$1.apply(FragmentExecution.scala:46)
[error]     org.specs2.specification.FragmentExecution$$anonfun$1.apply(FragmentExecution.scala:46)
[error]     org.specs2.execute.ResultExecution$class.execute(ResultExecution.scala:22)
[error]     org.specs2.execute.ResultExecution$.execute(ResultExecution.scala:116)
[error]     org.specs2.specification.FragmentExecution$class.executeBody(FragmentExecution.scala:28)
[error]     org.specs2.reporter.SbtConsoleReporter.executeBody(SbtReporter.scala:20)
[error]     org.specs2.specification.FragmentExecution$class.execute(FragmentExecution.scala:46)
[error]     org.specs2.reporter.SbtConsoleReporter.execute(SbtReporter.scala:20)
[error]     org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1$$anonfun$apply$1.apply(FragmentExecution.scala:35)
[error]     org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1$$anonfun$apply$1.apply(FragmentExecution.scala:35)
[error]     org.specs2.control.Exceptions$class.catchAllOr(Exceptions.scala:54)
[error]     org.specs2.control.Exceptions$.catchAllOr(Exceptions.scala:109)
[error]     org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1.apply(FragmentExecution.scala:35)
[error]     org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1.apply(FragmentExecution.scala:35)
[error]     org.specs2.reporter.DefaultExecutionStrategy$$anonfun$executeSequentially$1.apply(ExecutionStrategy.scala:104)
[error]     org.specs2.reporter.DefaultExecutionStrategy$$anonfun$executeSequentially$1.apply(ExecutionStrategy.scala:104)
[error]     scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:234)
[error]     scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:234)
[error]     scala.collection.immutable.List.foreach(List.scala:381)
[error]     scala.collection.TraversableLike$class.map(TraversableLike.scala:234)
[error]     scala.collection.immutable.List.map(List.scala:285)
[error]     org.specs2.reporter.DefaultExecutionStrategy$class.executeSequentially(ExecutionStrategy.scala:104)
[error]     org.specs2.reporter.SbtConsoleReporter.executeSequentially(SbtReporter.scala:20)
[error]     org.specs2.reporter.DefaultExecutionStrategy$class.executeSequence(ExecutionStrategy.scala:98)
[error]     org.specs2.reporter.SbtConsoleReporter.executeSequence(SbtReporter.scala:20)
[error]     org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1$$anonfun$2.apply(ExecutionStrategy.scala:43)
[error]     org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1$$anonfun$2.apply(ExecutionStrategy.scala:41)
[error]     scala.collection.immutable.Stream.foldLeft(Stream.scala:610)
[error]     org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1.apply(ExecutionStrategy.scala:41)
[error]     org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1.apply(ExecutionStrategy.scala:38)
[error]     scalaz.syntax.IdOps$class.$bar$greater(IdOps.scala:15)
[error]     scalaz.syntax.ToIdOps$$anon$1.$bar$greater(IdOps.scala:82)
[error]     org.specs2.reporter.AllExporting$class.report(AllExporting.scala:17)
[error]     org.specs2.reporter.SbtConsoleReporter.report(SbtReporter.scala:20)
[error]     org.specs2.runner.SbtRunner.org$specs2$runner$SbtRunner$$specificationRun(SbtRunner.scala:75)
[error]     org.specs2.runner.SbtRunner$$anonfun$newTask$1$$anon$5.execute(SbtRunner.scala:59)
[error]     sbt.ForkMain$Run$2.call(ForkMain.java:294)
[error]     sbt.ForkMain$Run$2.call(ForkMain.java:284)
[error]     java.util.concurrent.FutureTask.run(FutureTask.java:262)
[error]     java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
[error]     java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
[error]     java.lang.Thread.run(Thread.java:745)
[error]    ]
[error]        </p>
[error]      </body>
[error]    </html>
[error]    ' doesn't contain 'users' (IntegrationSpec.scala:22)
[info]
[info] x work from within a browser again
[error]    '<?xml version="1.0" encoding="UTF-8"?>
[error]    <html>
[error]      <head>
[error]        <title>
[error]          Execution exception
[error]        </title>
[error]        <link rel="shortcut icon" href="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8/9hAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAlFJREFUeNqUU8tOFEEUPVVdNV3dPe8xYRBnjGhmBgKjKzCIiQvBoIaNbly5Z+PSv3Aj7DSiP2B0rwkLGVdGgxITSCRIJGSMEQWZR3eVt5sEFBgTb/dN1yvnnHtPNTPG4PqdHgCMXnPRSZrpSuH8vUJu4DE4rYHDGAZDX62BZttHqTiIayM3gGiXQsgYLEvATaqxU+dy1U13YXapXptpNHY8iwn8KyIAzm1KBdtRZWErpI5lEWTXp5Z/vHpZ3/wyKKwYGGOdAYwR0EZwoezTYApBEIObyELl/aE1/83cp40Pt5mxqCKrE4Ck+mVWKKcI5tA8BLEhRBKJLjez6a7MLq7XZtp+yyOawwCBtkiBVZDKzRk4NN7NQBMYPHiZDFhXY+p9ff7F961vVcnl4R5I2ykJ5XFN7Ab7Gc61VoipNBKF+PDyztu5lfrSLT/wIwCxq0CAGtXHZTzqR2jtwQiXONma6hHpj9sLT7YaPxfTXuZdBGA02Wi7FS48YiTfj+i2NhqtdhP5RC8mh2/Op7y0v6eAcWVLFT8D7kWX5S9mepp+C450MV6aWL1cGnvkxbwHtLW2B9AOkLeUd9KEDuh9fl/7CEj7YH5g+3r/lWfF9In7tPz6T4IIwBJOr1SJyIGQMZQbsh5P9uBq5VJtqHh2mo49pdw5WFoEwKWqWHacaWOjQXWGcifKo6vj5RGS6zykI587XeUIQDqJSmAp+lE4qt19W5P9o8+Lma5DcjsC8JiT607lMVkdqQ0Vyh3lHhmh52tfNy78ajXv0rgYzv8nfwswANuk+7sD/Q0aAAAAAElFTkSuQmCC"/>
[error]        <style>
[error]
[error]                     html, body, pre {
[error]                         margin: 0;
[error]                         padding: 0;
[error]                         font-family: Monaco, 'Lucida Console', monospace;
[error]                         background: #ECECEC;
[error]                     }
[error]                     h1 {
[error]                         margin: 0;
[error]                         background: #A31012;
[error]                         padding: 20px 45px;
[error]                         color: #fff;
[error]                         text-shadow: 1px 1px 1px rgba(0,0,0,.3);
[error]                         border-bottom: 1px solid #690000;
[error]                         font-size: 28px;
[error]                     }
[error]                a {
[error]                    color: #D36D6D;
[error]                }
[error]                p#detail {
[error]                         margin: 0;
[error]                         padding: 15px 45px;
[error]                         background: #F5A0A0;
[error]                         border-top: 4px solid #D36D6D;
[error]                         color: #730000;
[error]                         text-shadow: 1px 1px 1px rgba(255,255,255,.3);
[error]                         font-size: 14px;
[error]                         border-bottom: 1px solid #BA7A7A;
[error]                     }
[error]                     p#detail.pre {
[error]                         white-space: pre;
[error]                         font-size: 13px;
[error]                         overflow: auto;
[error]                     }
[error]                     p#detail input {
[error]                         background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#AE1113), to(#A31012));
[error]                    border: 1px solid #790000;
[error]                    padding: 3px 10px;
[error]                    text-shadow: 1px 1px 0 rgba(0, 0, 0, .5);
[error]                    color: white;
[error]                    border-radius: 3px;
[error]                    cursor: pointer;
[error]                    font-family: Monaco, 'Lucida Console';
[error]                    font-size: 12px;
[error]                    margin: 0 10px;
[error]                    display: inline-block;
[error]                    position: relative;
[error]                    top: -1px;
[error]                     }
[error]                     h2 {
[error]                         margin: 0;
[error]                         padding: 5px 45px;
[error]                         font-size: 12px;
[error]                         background: #333;
[error]                         color: #fff;
[error]                         text-shadow: 1px 1px 1px rgba(0,0,0,.3);
[error]                         border-top: 4px solid #2a2a2a;
[error]                     }
[error]                         pre {
[error]                                 margin: 0;
[error]                                 border-bottom: 1px solid #DDD;
[error]                                 text-shadow: 1px 1px 1px rgba(255,255,255,.5);
[error]                                 position: relative;
[error]                                 font-size: 12px;
[error]                         }
[error]                         pre span.line {
[error]                             text-align: right;
[error]                             display: inline-block;
[error]                             padding: 5px 5px;
[error]                             width: 30px;
[error]                             background: #D6D6D6;
[error]                             color: #8B8B8B;
[error]                             text-shadow: 1px 1px 1px rgba(255,255,255,.5);
[error]                             font-weight: bold;
[error]                         }
[error]                         pre span.code {
[error]                             padding: 5px 5px;
[error]                             position: absolute;
[error]                             right: 0;
[error]                             left: 40px;
[error]                         }
[error]                         pre:first-child span.code {
[error]                             border-top: 4px solid #CDCDCD;
[error]                         }
[error]                         pre:first-child span.line {
[error]                             border-top: 4px solid #B6B6B6;
[error]                         }
[error]                         pre.error span.line {
[error]                             background: #A31012;
[error]                             color: #fff;
[error]                             text-shadow: 1px 1px 1px rgba(0,0,0,.3);
[error]                         }
[error]                         pre.error {
[error]                                 color: #A31012;
[error]                         }
[error]                         pre.error span.marker {
[error]                                 background: #A31012;
[error]                                 color: #fff;
[error]                                 text-shadow: 1px 1px 1px rgba(0,0,0,.3);
[error]                         }
[error]
[error]        </style>
[error]      </head>
[error]      <body id="play-error-page">
[error]        <h1>
[error]          Execution exception
[error]        </h1>
[error]        <p id="detail" class="pre">
[error]          [SQLException: Attempting to obtain a connection from a pool that has already been shutdown.
[error]    Stack trace of location where pool was shutdown follows:
[error]     java.lang.Thread.getStackTrace(Thread.java:1589)
[error]     com.jolbox.bonecp.BoneCP.captureStackTrace(BoneCP.java:572)
[error]     com.jolbox.bonecp.BoneCP.shutdown(BoneCP.java:161)
[error]     com.jolbox.bonecp.BoneCPDataSource.close(BoneCPDataSource.java:143)
[error]     play.api.db.BoneCPApi.shutdownPool(DB.scala:424)
[error]     play.api.db.BoneCPPlugin$$anonfun$onStop$1.apply(DB.scala:260)
[error]     play.api.db.BoneCPPlugin$$anonfun$onStop$1.apply(DB.scala:258)
[error]     scala.collection.immutable.List.foreach(List.scala:381)
[error]     play.api.db.BoneCPPlugin.onStop(DB.scala:258)
[error]     play.api.Play$$anonfun$stop$1$$anonfun$apply$1$$anonfun$apply$mcV$sp$2.apply(Play.scala:108)
[error]     play.api.Play$$anonfun$stop$1$$anonfun$apply$1$$anonfun$apply$mcV$sp$2.apply(Play.scala:107)
[error]     scala.collection.immutable.List.foreach(List.scala:381)
[error]     play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply$mcV$sp(Play.scala:107)
[error]     play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply(Play.scala:107)
[error]     play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply(Play.scala:107)
[error]     play.utils.Threads$.withContextClassLoader(Threads.scala:21)
[error]     play.api.Play$$anonfun$stop$1.apply(Play.scala:106)
[error]     play.api.Play$$anonfun$stop$1.apply(Play.scala:105)
[error]     scala.Option.map(Option.scala:146)
[error]     play.api.Play$.stop(Play.scala:105)
[error]     play.api.test.PlayRunners$class.running(Helpers.scala:51)
[error]     play.api.test.Helpers$.running(Helpers.scala:405)
[error]     play.api.test.WithApplication.around(Specs.scala:23)
[error]     org.specs2.mutable.Around$$anonfun$delayedInit$1.apply(Around.scala:13)
[error]     org.specs2.mutable.Around$$anonfun$delayedInit$1.apply(Around.scala:13)
[error]     org.specs2.execute.ResultExecution$class.effectively(ResultExecution.scala:38)
[error]     org.specs2.execute.ResultExecution$.effectively(ResultExecution.scala:116)
[error]     org.specs2.mutable.Around$class.delayedInit(Around.scala:13)
[error]     play.api.test.WithApplication.delayedInit(Specs.scala:20)
[error]     ApplicationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.&lt;init&gt;(ApplicationSpec.scala:20)
[error]     ApplicationSpec$$anonfun$1$$anonfun$apply$1.apply(ApplicationSpec.scala:20)
[error]     ApplicationSpec$$anonfun$1$$anonfun$apply$1.apply(ApplicationSpec.scala:20)
[error]     org.specs2.matcher.Scope$$anon$3.asResult(ThrownExpectations.scala:120)
[error]     org.specs2.execute.AsResult$.apply(Result.scala:253)
[error]     org.specs2.specification.Example$$anonfun$apply$1.apply(Fragment.scala:209)
[error]     org.specs2.specification.Example$$anonfun$apply$1.apply(Fragment.scala:209)
[error]     org.specs2.specification.Example.execute(Fragment.scala:176)
[error]     org.specs2.specification.FragmentExecution$$anonfun$1.apply(FragmentExecution.scala:46)
[error]     org.specs2.specification.FragmentExecution$$anonfun$1.apply(FragmentExecution.scala:46)
[error]     org.specs2.execute.ResultExecution$class.execute(ResultExecution.scala:22)
[error]     org.specs2.execute.ResultExecution$.execute(ResultExecution.scala:116)
[error]     org.specs2.specification.FragmentExecution$class.executeBody(FragmentExecution.scala:28)
[error]     org.specs2.reporter.SbtConsoleReporter.executeBody(SbtReporter.scala:20)
[error]     org.specs2.specification.FragmentExecution$class.execute(FragmentExecution.scala:46)
[error]     org.specs2.reporter.SbtConsoleReporter.execute(SbtReporter.scala:20)
[error]     org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1$$anonfun$apply$1.apply(FragmentExecution.scala:35)
[error]     org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1$$anonfun$apply$1.apply(FragmentExecution.scala:35)
[error]     org.specs2.control.Exceptions$class.catchAllOr(Exceptions.scala:54)
[error]     org.specs2.control.Exceptions$.catchAllOr(Exceptions.scala:109)
[error]     org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1.apply(FragmentExecution.scala:35)
[error]     org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1.apply(FragmentExecution.scala:35)
[error]     org.specs2.reporter.DefaultExecutionStrategy$$anonfun$executeSequentially$1.apply(ExecutionStrategy.scala:104)
[error]     org.specs2.reporter.DefaultExecutionStrategy$$anonfun$executeSequentially$1.apply(ExecutionStrategy.scala:104)
[error]     scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:234)
[error]     scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:234)
[error]     scala.collection.immutable.List.foreach(List.scala:381)
[error]     scala.collection.TraversableLike$class.map(TraversableLike.scala:234)
[error]     scala.collection.immutable.List.map(List.scala:285)
[error]     org.specs2.reporter.DefaultExecutionStrategy$class.executeSequentially(ExecutionStrategy.scala:104)
[error]     org.specs2.reporter.SbtConsoleReporter.executeSequentially(SbtReporter.scala:20)
[error]     org.specs2.reporter.DefaultExecutionStrategy$class.executeSequence(ExecutionStrategy.scala:98)
[error]     org.specs2.reporter.SbtConsoleReporter.executeSequence(SbtReporter.scala:20)
[error]     org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1$$anonfun$2.apply(ExecutionStrategy.scala:43)
[error]     org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1$$anonfun$2.apply(ExecutionStrategy.scala:41)
[error]     scala.collection.immutable.Stream.foldLeft(Stream.scala:610)
[error]     org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1.apply(ExecutionStrategy.scala:41)
[error]     org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1.apply(ExecutionStrategy.scala:38)
[error]     scalaz.syntax.IdOps$class.$bar$greater(IdOps.scala:15)
[error]     scalaz.syntax.ToIdOps$$anon$1.$bar$greater(IdOps.scala:82)
[error]     org.specs2.reporter.AllExporting$class.report(AllExporting.scala:17)
[error]     org.specs2.reporter.SbtConsoleReporter.report(SbtReporter.scala:20)
[error]     org.specs2.runner.SbtRunner.org$specs2$runner$SbtRunner$$specificationRun(SbtRunner.scala:75)
[error]     org.specs2.runner.SbtRunner$$anonfun$newTask$1$$anon$5.execute(SbtRunner.scala:59)
[error]     sbt.ForkMain$Run$2.call(ForkMain.java:294)
[error]     sbt.ForkMain$Run$2.call(ForkMain.java:284)
[error]     java.util.concurrent.FutureTask.run(FutureTask.java:262)
[error]     java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
[error]     java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
[error]     java.lang.Thread.run(Thread.java:745)
[error]    ]
[error]        </p>
[error]      </body>
[error]    </html>
[error]    ' doesn't contain 'users' (IntegrationSpec.scala:29)
[info]
[info]
[info] Total for specification IntegrationSpec
[info] Finished in 3 seconds, 904 ms
[info] 2 examples, 2 failures, 0 error
[error] Failed: Total 3, Failed 2, Errors 0, Passed 1
[error] Failed tests:
[error]         IntegrationSpec
[error] (test:test) sbt.TestsFailedException: Tests unsuccessful
[error] Total time: 10 s, completed Jul 23, 2016 12:08:28 AM
[play-heroku-seed] $


 */

/*
// Test failure:

$ sbt test
[info] Loading project definition from /home/johnreed/Desktop/Apps/play-heroku-seed/project
[info] Set current project to play-heroku-seed (in build file:/home/johnreed/Desktop/Apps/play-heroku-seed/)
[info] Compiling 11 Scala sources and 1 Java source to /home/johnreed/Desktop/Apps/play-heroku-seed/target/scala-2.11/classes...
[info] Compiling 2 Scala sources to /home/johnreed/Desktop/Apps/play-heroku-seed/target/scala-2.11/test-classes...
[info] IntegrationSpec
[info]
[info] Application should
[info] ! work from within a browser
[error]    WebDriverException: : com.gargoylesoftware.htmlunit.ScriptException: Error: Bootstrap's JavaScript requires jQuery (https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js#6)
[error] Build info: version: '2.39.0', revision: '14fa800511cc5d66d426e08b0b2ab926c7ed7398', time: '2013-12-16 13:18:38'
[error] System info: host: 'johnreed-Galago-UltraPro', ip: '127.0.1.1', os.name: 'Linux', os.arch: 'amd64', os.version: '4.2.0-27-generic', java.version: '1.7.0_79'
[error] Driver info: driver.version: HtmlUnitDriver  (HtmlUnitDriver.java:484)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:484)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:463)
[error] org.fluentlenium.core.Fluent.goTo(Fluent.java:336)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.delayedEndpoint$IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$1(IntegrationSpec.scala:19)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$delayedInit$body.apply(IntegrationSpec.scala:17)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.PlayRunners$class.running(Helpers.scala:63)
[error] play.api.test.Helpers$.running(Helpers.scala:403)
[error] play.api.test.WithBrowser.around(Specs.scala:65)
[error] play.api.test.WithBrowser.delayedInit(Specs.scala:48)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.<init>(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine$HtmlUnitContextAction.run(JavaScriptEngine.java:684)
[error] net.sourceforge.htmlunit.corejs.javascript.Context.call(Context.java:602)
[error] net.sourceforge.htmlunit.corejs.javascript.ContextFactory.call(ContextFactory.java:507)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine.execute(JavaScriptEngine.java:570)
[error] com.gargoylesoftware.htmlunit.html.HtmlPage.loadExternalJavaScriptFile(HtmlPage.java:1062)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript.executeScriptIfNeeded(HtmlScript.java:409)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript$3.execute(HtmlScript.java:266)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript.onAllChildrenAddedToPage(HtmlScript.java:286)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.endElement(HTMLParser.java:683)
[error] org.apache.xerces.parsers.AbstractSAXParser.endElement(Unknown Source)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.endElement(HTMLParser.java:642)
[error] org.cyberneko.html.HTMLTagBalancer.callEndElement(HTMLTagBalancer.java:1170)
[error] org.cyberneko.html.HTMLTagBalancer.endElement(HTMLTagBalancer.java:1072)
[error] org.cyberneko.html.filters.DefaultFilter.endElement(DefaultFilter.java:206)
[error] org.cyberneko.html.filters.NamespaceBinder.endElement(NamespaceBinder.java:330)
[error] org.cyberneko.html.HTMLScanner$ContentScanner.scanEndElement(HTMLScanner.java:3116)
[error] org.cyberneko.html.HTMLScanner$ContentScanner.scan(HTMLScanner.java:2083)
[error] org.cyberneko.html.HTMLScanner.scanDocument(HTMLScanner.java:918)
[error] org.cyberneko.html.HTMLConfiguration.parse(HTMLConfiguration.java:499)
[error] org.cyberneko.html.HTMLConfiguration.parse(HTMLConfiguration.java:452)
[error] org.apache.xerces.parsers.XMLParser.parse(Unknown Source)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.parse(HTMLParser.java:899)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser.parse(HTMLParser.java:242)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser.parseHtml(HTMLParser.java:188)
[error] com.gargoylesoftware.htmlunit.DefaultPageCreator.createHtmlPage(DefaultPageCreator.java:268)
[error] com.gargoylesoftware.htmlunit.DefaultPageCreator.createPage(DefaultPageCreator.java:156)
[error] com.gargoylesoftware.htmlunit.WebClient.loadWebResponseInto(WebClient.java:437)
[error] com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:311)
[error] com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:376)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:474)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:463)
[error] org.fluentlenium.core.Fluent.goTo(Fluent.java:336)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.delayedEndpoint$IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$1(IntegrationSpec.scala:19)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$delayedInit$body.apply(IntegrationSpec.scala:17)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.PlayRunners$class.running(Helpers.scala:63)
[error] play.api.test.Helpers$.running(Helpers.scala:403)
[error] play.api.test.WithBrowser.around(Specs.scala:65)
[error] play.api.test.WithBrowser.delayedInit(Specs.scala:48)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.<init>(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error] net.sourceforge.htmlunit.corejs.javascript.Interpreter.interpretLoop(Interpreter.java:1006)
[error] net.sourceforge.htmlunit.corejs.javascript.Interpreter.interpret(Interpreter.java:798)
[error] net.sourceforge.htmlunit.corejs.javascript.InterpretedFunction.call(InterpretedFunction.java:105)
[error] net.sourceforge.htmlunit.corejs.javascript.ContextFactory.doTopCall(ContextFactory.java:405)
[error] com.gargoylesoftware.htmlunit.javascript.HtmlUnitContextFactory.doTopCall(HtmlUnitContextFactory.java:309)
[error] net.sourceforge.htmlunit.corejs.javascript.ScriptRuntime.doTopCall(ScriptRuntime.java:3031)
[error] net.sourceforge.htmlunit.corejs.javascript.InterpretedFunction.exec(InterpretedFunction.java:115)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine$3.doRun(JavaScriptEngine.java:561)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine$HtmlUnitContextAction.run(JavaScriptEngine.java:669)
[error] net.sourceforge.htmlunit.corejs.javascript.Context.call(Context.java:602)
[error] net.sourceforge.htmlunit.corejs.javascript.ContextFactory.call(ContextFactory.java:507)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine.execute(JavaScriptEngine.java:570)
[error] com.gargoylesoftware.htmlunit.html.HtmlPage.loadExternalJavaScriptFile(HtmlPage.java:1062)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript.executeScriptIfNeeded(HtmlScript.java:409)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript$3.execute(HtmlScript.java:266)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript.onAllChildrenAddedToPage(HtmlScript.java:286)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.endElement(HTMLParser.java:683)
[error] org.apache.xerces.parsers.AbstractSAXParser.endElement(Unknown Source)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.endElement(HTMLParser.java:642)
[error] org.cyberneko.html.HTMLTagBalancer.callEndElement(HTMLTagBalancer.java:1170)
[error] org.cyberneko.html.HTMLTagBalancer.endElement(HTMLTagBalancer.java:1072)
[error] org.cyberneko.html.filters.DefaultFilter.endElement(DefaultFilter.java:206)
[error] org.cyberneko.html.filters.NamespaceBinder.endElement(NamespaceBinder.java:330)
[error] org.cyberneko.html.HTMLScanner$ContentScanner.scanEndElement(HTMLScanner.java:3116)
[error] org.cyberneko.html.HTMLScanner$ContentScanner.scan(HTMLScanner.java:2083)
[error] org.cyberneko.html.HTMLScanner.scanDocument(HTMLScanner.java:918)
[error] org.cyberneko.html.HTMLConfiguration.parse(HTMLConfiguration.java:499)
[error] org.cyberneko.html.HTMLConfiguration.parse(HTMLConfiguration.java:452)
[error] org.apache.xerces.parsers.XMLParser.parse(Unknown Source)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.parse(HTMLParser.java:899)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser.parse(HTMLParser.java:242)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser.parseHtml(HTMLParser.java:188)
[error] com.gargoylesoftware.htmlunit.DefaultPageCreator.createHtmlPage(DefaultPageCreator.java:268)
[error] com.gargoylesoftware.htmlunit.DefaultPageCreator.createPage(DefaultPageCreator.java:156)
[error] com.gargoylesoftware.htmlunit.WebClient.loadWebResponseInto(WebClient.java:437)
[error] com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:311)
[error] com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:376)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:474)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:463)
[error] org.fluentlenium.core.Fluent.goTo(Fluent.java:336)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.delayedEndpoint$IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$1(IntegrationSpec.scala:19)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$delayedInit$body.apply(IntegrationSpec.scala:17)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.PlayRunners$class.running(Helpers.scala:63)
[error] play.api.test.Helpers$.running(Helpers.scala:403)
[error] play.api.test.WithBrowser.around(Specs.scala:65)
[error] play.api.test.WithBrowser.delayedInit(Specs.scala:48)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.<init>(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error]
[error] Caused by com.gargoylesoftware.htmlunit.ScriptException: Error: Bootstrap's JavaScript requires jQuery (https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js#6)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine$HtmlUnitContextAction.run(JavaScriptEngine.java:684)
[error] net.sourceforge.htmlunit.corejs.javascript.Context.call(Context.java:602)
[error] net.sourceforge.htmlunit.corejs.javascript.ContextFactory.call(ContextFactory.java:507)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine.execute(JavaScriptEngine.java:570)
[error] com.gargoylesoftware.htmlunit.html.HtmlPage.loadExternalJavaScriptFile(HtmlPage.java:1062)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript.executeScriptIfNeeded(HtmlScript.java:409)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript$3.execute(HtmlScript.java:266)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript.onAllChildrenAddedToPage(HtmlScript.java:286)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.endElement(HTMLParser.java:683)
[error] org.apache.xerces.parsers.AbstractSAXParser.endElement(Unknown Source)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.endElement(HTMLParser.java:642)
[error] org.cyberneko.html.HTMLTagBalancer.callEndElement(HTMLTagBalancer.java:1170)
[error] org.cyberneko.html.HTMLTagBalancer.endElement(HTMLTagBalancer.java:1072)
[error] org.cyberneko.html.filters.DefaultFilter.endElement(DefaultFilter.java:206)
[error] org.cyberneko.html.filters.NamespaceBinder.endElement(NamespaceBinder.java:330)
[error] org.cyberneko.html.HTMLScanner$ContentScanner.scanEndElement(HTMLScanner.java:3116)
[error] org.cyberneko.html.HTMLScanner$ContentScanner.scan(HTMLScanner.java:2083)
[error] org.cyberneko.html.HTMLScanner.scanDocument(HTMLScanner.java:918)
[error] org.cyberneko.html.HTMLConfiguration.parse(HTMLConfiguration.java:499)
[error] org.cyberneko.html.HTMLConfiguration.parse(HTMLConfiguration.java:452)
[error] org.apache.xerces.parsers.XMLParser.parse(Unknown Source)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.parse(HTMLParser.java:899)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser.parse(HTMLParser.java:242)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser.parseHtml(HTMLParser.java:188)
[error] com.gargoylesoftware.htmlunit.DefaultPageCreator.createHtmlPage(DefaultPageCreator.java:268)
[error] com.gargoylesoftware.htmlunit.DefaultPageCreator.createPage(DefaultPageCreator.java:156)
[error] com.gargoylesoftware.htmlunit.WebClient.loadWebResponseInto(WebClient.java:437)
[error] com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:311)
[error] com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:376)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:474)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:463)
[error] org.fluentlenium.core.Fluent.goTo(Fluent.java:336)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.delayedEndpoint$IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$1(IntegrationSpec.scala:19)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$delayedInit$body.apply(IntegrationSpec.scala:17)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.PlayRunners$class.running(Helpers.scala:63)
[error] play.api.test.Helpers$.running(Helpers.scala:403)
[error] play.api.test.WithBrowser.around(Specs.scala:65)
[error] play.api.test.WithBrowser.delayedInit(Specs.scala:48)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.<init>(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error]
[error] Caused by net.sourceforge.htmlunit.corejs.javascript.JavaScriptException: Error: Bootstrap's JavaScript requires jQuery (https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js#6)
[error] net.sourceforge.htmlunit.corejs.javascript.Interpreter.interpretLoop(Interpreter.java:1006)
[error] net.sourceforge.htmlunit.corejs.javascript.Interpreter.interpret(Interpreter.java:798)
[error] net.sourceforge.htmlunit.corejs.javascript.InterpretedFunction.call(InterpretedFunction.java:105)
[error] net.sourceforge.htmlunit.corejs.javascript.ContextFactory.doTopCall(ContextFactory.java:405)
[error] com.gargoylesoftware.htmlunit.javascript.HtmlUnitContextFactory.doTopCall(HtmlUnitContextFactory.java:309)
[error] net.sourceforge.htmlunit.corejs.javascript.ScriptRuntime.doTopCall(ScriptRuntime.java:3031)
[error] net.sourceforge.htmlunit.corejs.javascript.InterpretedFunction.exec(InterpretedFunction.java:115)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine$3.doRun(JavaScriptEngine.java:561)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine$HtmlUnitContextAction.run(JavaScriptEngine.java:669)
[error] net.sourceforge.htmlunit.corejs.javascript.Context.call(Context.java:602)
[error] net.sourceforge.htmlunit.corejs.javascript.ContextFactory.call(ContextFactory.java:507)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine.execute(JavaScriptEngine.java:570)
[error] com.gargoylesoftware.htmlunit.html.HtmlPage.loadExternalJavaScriptFile(HtmlPage.java:1062)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript.executeScriptIfNeeded(HtmlScript.java:409)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript$3.execute(HtmlScript.java:266)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript.onAllChildrenAddedToPage(HtmlScript.java:286)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.endElement(HTMLParser.java:683)
[error] org.apache.xerces.parsers.AbstractSAXParser.endElement(Unknown Source)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.endElement(HTMLParser.java:642)
[error] org.cyberneko.html.HTMLTagBalancer.callEndElement(HTMLTagBalancer.java:1170)
[error] org.cyberneko.html.HTMLTagBalancer.endElement(HTMLTagBalancer.java:1072)
[error] org.cyberneko.html.filters.DefaultFilter.endElement(DefaultFilter.java:206)
[error] org.cyberneko.html.filters.NamespaceBinder.endElement(NamespaceBinder.java:330)
[error] org.cyberneko.html.HTMLScanner$ContentScanner.scanEndElement(HTMLScanner.java:3116)
[error] org.cyberneko.html.HTMLScanner$ContentScanner.scan(HTMLScanner.java:2083)
[error] org.cyberneko.html.HTMLScanner.scanDocument(HTMLScanner.java:918)
[error] org.cyberneko.html.HTMLConfiguration.parse(HTMLConfiguration.java:499)
[error] org.cyberneko.html.HTMLConfiguration.parse(HTMLConfiguration.java:452)
[error] org.apache.xerces.parsers.XMLParser.parse(Unknown Source)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.parse(HTMLParser.java:899)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser.parse(HTMLParser.java:242)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser.parseHtml(HTMLParser.java:188)
[error] com.gargoylesoftware.htmlunit.DefaultPageCreator.createHtmlPage(DefaultPageCreator.java:268)
[error] com.gargoylesoftware.htmlunit.DefaultPageCreator.createPage(DefaultPageCreator.java:156)
[error] com.gargoylesoftware.htmlunit.WebClient.loadWebResponseInto(WebClient.java:437)
[error] com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:311)
[error] com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:376)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:474)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:463)
[error] org.fluentlenium.core.Fluent.goTo(Fluent.java:336)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.delayedEndpoint$IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$1(IntegrationSpec.scala:19)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$delayedInit$body.apply(IntegrationSpec.scala:17)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.PlayRunners$class.running(Helpers.scala:63)
[error] play.api.test.Helpers$.running(Helpers.scala:403)
[error] play.api.test.WithBrowser.around(Specs.scala:65)
[error] play.api.test.WithBrowser.delayedInit(Specs.scala:48)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.<init>(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[info]
[info]
[info] Total for specification IntegrationSpec
[info] Finished in 7 seconds, 470 ms
[info] 1 example, 0 failure, 1 error
[info] ApplicationSpec
[info]
[info] Application should
[info] + send 404 on a bad request
[info] ! render the index page
[error]    SQLException: : Attempting to obtain a connection from a pool that has already been shutdown.
[error] Stack trace of location where pool was shutdown follows:
[error]  java.lang.Thread.getStackTrace(Thread.java:1589)
[error]  com.jolbox.bonecp.BoneCP.captureStackTrace(BoneCP.java:572)
[error]  com.jolbox.bonecp.BoneCP.shutdown(BoneCP.java:161)
[error]  com.jolbox.bonecp.BoneCPDataSource.close(BoneCPDataSource.java:143)
[error]  play.api.db.BoneCPApi.shutdownPool(DB.scala:423)
[error]  play.api.db.BoneCPPlugin$$anonfun$onStop$1.apply(DB.scala:260)
[error]  play.api.db.BoneCPPlugin$$anonfun$onStop$1.apply(DB.scala:258)
[error]  scala.collection.immutable.List.foreach(List.scala:381)
[error]  play.api.db.BoneCPPlugin.onStop(DB.scala:258)
[error]  play.api.Play$$anonfun$stop$1$$anonfun$apply$1$$anonfun$apply$mcV$sp$2.apply(Play.scala:108)
[error]  play.api.Play$$anonfun$stop$1$$anonfun$apply$1$$anonfun$apply$mcV$sp$2.apply(Play.scala:107)
[error]  scala.collection.immutable.List.foreach(List.scala:381)
[error]  play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply$mcV$sp(Play.scala:107)
[error]  play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply(Play.scala:107)
[error]  play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply(Play.scala:107)
[error]  play.utils.Threads$.withContextClassLoader(Threads.scala:21)
[error]  play.api.Play$$anonfun$stop$1.apply(Play.scala:106)
[error]  play.api.Play$$anonfun$stop$1.apply(Play.scala:105)
[error]  scala.Option.map(Option.scala:146)
[error]  play.api.Play$.stop(Play.scala:105)
[error]  play.core.server.NettyServer.stop(NettyServer.scala:158)
[error]  play.api.test.TestServer.stop(Selenium.scala:161)
[error]  play.api.test.PlayRunners$class.running(Helpers.scala:65)
[error]  play.api.test.Helpers$.running(Helpers.scala:403)
[error]  play.api.test.WithBrowser.around(Specs.scala:65)
[error]  org.specs2.mutable.Around$$anonfun$delayedInit$1.apply(Around.scala:13)
[error]  org.specs2.mutable.Around$$anonfun$delayedInit$1.apply(Around.scala:13)
[error]  org.specs2.execute.ResultExecution$class.effectively(ResultExecution.scala:38)
[error]  org.specs2.execute.ResultExecution$.effectively(ResultExecution.scala:116)
[error]  org.specs2.mutable.Around$class.delayedInit(Around.scala:13)
[error]  play.api.test.WithBrowser.delayedInit(Specs.scala:48)
[error]  IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.<init>(IntegrationSpec.scala:17)
[error]  IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error]  IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error]  org.specs2.matcher.Scope$$anon$3.asResult(ThrownExpectations.scala:120)
[error]  org.specs2.execute.AsResult$.apply(Result.scala:253)
[error]  org.specs2.specification.Example$$anonfun$apply$1.apply(Fragment.scala:209)
[error]  org.specs2.specification.Example$$anonfun$apply$1.apply(Fragment.scala:209)
[error]  org.specs2.specification.Example.execute(Fragment.scala:176)
[error]  org.specs2.specification.FragmentExecution$$anonfun$1.apply(FragmentExecution.scala:46)
[error]  org.specs2.specification.FragmentExecution$$anonfun$1.apply(FragmentExecution.scala:46)
[error]  org.specs2.execute.ResultExecution$class.execute(ResultExecution.scala:22)
[error]  org.specs2.execute.ResultExecution$.execute(ResultExecution.scala:116)
[error]  org.specs2.specification.FragmentExecution$class.executeBody(FragmentExecution.scala:28)
[error]  org.specs2.reporter.SbtConsoleReporter.executeBody(SbtReporter.scala:20)
[error]  org.specs2.specification.FragmentExecution$class.execute(FragmentExecution.scala:46)
[error]  org.specs2.reporter.SbtConsoleReporter.execute(SbtReporter.scala:20)
[error]  org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1$$anonfun$apply$1.apply(FragmentExecution.scala:35)
[error]  org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1$$anonfun$apply$1.apply(FragmentExecution.scala:35)
[error]  org.specs2.control.Exceptions$class.catchAllOr(Exceptions.scala:54)
[error]  org.specs2.control.Exceptions$.catchAllOr(Exceptions.scala:109)
[error]  org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1.apply(FragmentExecution.scala:35)
[error]  org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1.apply(FragmentExecution.scala:35)
[error]  org.specs2.reporter.DefaultExecutionStrategy$$anonfun$executeSequentially$1.apply(ExecutionStrategy.scala:104)
[error]  org.specs2.reporter.DefaultExecutionStrategy$$anonfun$executeSequentially$1.apply(ExecutionStrategy.scala:104)
[error]  scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:234)
[error]  scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:234)
[error]  scala.collection.immutable.List.foreach(List.scala:381)
[error]  scala.collection.TraversableLike$class.map(TraversableLike.scala:234)
[error]  scala.collection.immutable.List.map(List.scala:285)
[error]  org.specs2.reporter.DefaultExecutionStrategy$class.executeSequentially(ExecutionStrategy.scala:104)
[error]  org.specs2.reporter.SbtConsoleReporter.executeSequentially(SbtReporter.scala:20)
[error]  org.specs2.reporter.DefaultExecutionStrategy$class.executeSequence(ExecutionStrategy.scala:98)
[error]  org.specs2.reporter.SbtConsoleReporter.executeSequence(SbtReporter.scala:20)
[error]  org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1$$anonfun$2.apply(ExecutionStrategy.scala:43)
[error]  org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1$$anonfun$2.apply(ExecutionStrategy.scala:41)
[error]  scala.collection.immutable.Stream.foldLeft(Stream.scala:610)
[error]  org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1.apply(ExecutionStrategy.scala:41)
[error]  org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1.apply(ExecutionStrategy.scala:38)
[error]  scalaz.syntax.IdOps$class.$bar$greater(IdOps.scala:15)
[error]  scalaz.syntax.ToIdOps$$anon$1.$bar$greater(IdOps.scala:82)
[error]  org.specs2.reporter.AllExporting$class.report(AllExporting.scala:17)
[error]  org.specs2.reporter.SbtConsoleReporter.report(SbtReporter.scala:20)
[error]  org.specs2.runner.SbtRunner.org$specs2$runner$SbtRunner$$specificationRun(SbtRunner.scala:75)
[error]  org.specs2.runner.SbtRunner$$anonfun$newTask$1$$anon$5.execute(SbtRunner.scala:59)
[error]  sbt.ForkMain$Run$2.call(ForkMain.java:294)
[error]  sbt.ForkMain$Run$2.call(ForkMain.java:284)
[error]  java.util.concurrent.FutureTask.run(FutureTask.java:262)
[error]  java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
[error]  java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
[error]  java.lang.Thread.run(Thread.java:745)
[error]   (AbstractConnectionStrategy.java:52)
[error] com.jolbox.bonecp.AbstractConnectionStrategy.preConnection(AbstractConnectionStrategy.java:52)
[error] com.jolbox.bonecp.AbstractConnectionStrategy.getConnection(AbstractConnectionStrategy.java:88)
[error] com.jolbox.bonecp.BoneCP.getConnection(BoneCP.java:553)
[error] com.jolbox.bonecp.BoneCPDataSource.getConnection(BoneCPDataSource.java:131)
[error] models.Users$$anonfun$all$1.apply(Users.scala:21)
[error] models.Users$$anonfun$all$1.apply(Users.scala:20)
[error] models.Users$.all(Users.scala:20)
[error] controllers.Application$$anonfun$index$1.apply(Application.scala:17)
[error] controllers.Application$$anonfun$index$1.apply(Application.scala:17)
[error] play.api.mvc.ActionBuilder$$anonfun$apply$17.apply(Action.scala:464)
[error] play.api.mvc.ActionBuilder$$anonfun$apply$17.apply(Action.scala:464)
[error] play.api.mvc.ActionBuilder$$anonfun$apply$16.apply(Action.scala:433)
[error] play.api.mvc.ActionBuilder$$anonfun$apply$16.apply(Action.scala:432)
[error] play.api.mvc.Action$.invokeBlock(Action.scala:556)
[error] play.api.mvc.Action$.invokeBlock(Action.scala:555)
[error] play.api.mvc.ActionBuilder$$anon$1.apply(Action.scala:518)
[error] play.api.mvc.Action$$anonfun$apply$1$$anonfun$apply$4$$anonfun$apply$5.apply(Action.scala:130)
[error] play.api.mvc.Action$$anonfun$apply$1$$anonfun$apply$4$$anonfun$apply$5.apply(Action.scala:130)
[error] play.utils.Threads$.withContextClassLoader(Threads.scala:21)
[error] play.api.mvc.Action$$anonfun$apply$1$$anonfun$apply$4.apply(Action.scala:129)
[error] play.api.mvc.Action$$anonfun$apply$1$$anonfun$apply$4.apply(Action.scala:128)
[error] play.api.mvc.Action$$anonfun$apply$1.apply(Action.scala:128)
[error] play.api.mvc.Action$$anonfun$apply$1.apply(Action.scala:121)
[error] play.api.libs.iteratee.DoneIteratee$$anonfun$mapM$2.apply(Iteratee.scala:705)
[error] play.api.libs.iteratee.DoneIteratee$$anonfun$mapM$2.apply(Iteratee.scala:705)
[error] akka.dispatch.TaskInvocation.run(AbstractDispatcher.scala:41)
[error] akka.dispatch.ForkJoinExecutorConfigurator$AkkaForkJoinTask.exec(AbstractDispatcher.scala:393)
[info]
[info]
[info] Total for specification ApplicationSpec
[info] Finished in 2 seconds, 811 ms
[info] 2 examples, 0 failure, 1 error
[error] Error: Total 3, Failed 0, Errors 2, Passed 1
[error] Error during tests:
[error]         ApplicationSpec
[error]         IntegrationSpec
[error] (test:test) sbt.TestsFailedException: Tests unsuccessful
[error] Total time: 27 s, completed Jul 21, 2016 12:50:45 AM
johnreed@johnreed-Galago-UltraPro:~/Desktop/Apps/play-heroku-seed$ sbt test
[info] Loading project definition from /home/johnreed/Desktop/Apps/play-heroku-seed/project
[info] Set current project to play-heroku-seed (in build file:/home/johnreed/Desktop/Apps/play-heroku-seed/)
[info] Compiling 2 Scala sources to /home/johnreed/Desktop/Apps/play-heroku-seed/target/scala-2.11/test-classes...
[info] IntegrationSpec
[info]
[info] Application should
[info] ! work from within a browser
[error]    WebDriverException: : com.gargoylesoftware.htmlunit.ScriptException: Error: Bootstrap's JavaScript requires jQuery (https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js#6)
[error] Build info: version: '2.39.0', revision: '14fa800511cc5d66d426e08b0b2ab926c7ed7398', time: '2013-12-16 13:18:38'
[error] System info: host: 'johnreed-Galago-UltraPro', ip: '127.0.1.1', os.name: 'Linux', os.arch: 'amd64', os.version: '4.2.0-27-generic', java.version: '1.7.0_79'
[error] Driver info: driver.version: HtmlUnitDriver  (HtmlUnitDriver.java:484)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:484)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:463)
[error] org.fluentlenium.core.Fluent.goTo(Fluent.java:336)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.delayedEndpoint$IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$1(IntegrationSpec.scala:19)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$delayedInit$body.apply(IntegrationSpec.scala:17)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.PlayRunners$class.running(Helpers.scala:63)
[error] play.api.test.Helpers$.running(Helpers.scala:403)
[error] play.api.test.WithBrowser.around(Specs.scala:65)
[error] play.api.test.WithBrowser.delayedInit(Specs.scala:48)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.<init>(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine$HtmlUnitContextAction.run(JavaScriptEngine.java:684)
[error] net.sourceforge.htmlunit.corejs.javascript.Context.call(Context.java:602)
[error] net.sourceforge.htmlunit.corejs.javascript.ContextFactory.call(ContextFactory.java:507)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine.execute(JavaScriptEngine.java:570)
[error] com.gargoylesoftware.htmlunit.html.HtmlPage.loadExternalJavaScriptFile(HtmlPage.java:1062)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript.executeScriptIfNeeded(HtmlScript.java:409)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript$3.execute(HtmlScript.java:266)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript.onAllChildrenAddedToPage(HtmlScript.java:286)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.endElement(HTMLParser.java:683)
[error] org.apache.xerces.parsers.AbstractSAXParser.endElement(Unknown Source)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.endElement(HTMLParser.java:642)
[error] org.cyberneko.html.HTMLTagBalancer.callEndElement(HTMLTagBalancer.java:1170)
[error] org.cyberneko.html.HTMLTagBalancer.endElement(HTMLTagBalancer.java:1072)
[error] org.cyberneko.html.filters.DefaultFilter.endElement(DefaultFilter.java:206)
[error] org.cyberneko.html.filters.NamespaceBinder.endElement(NamespaceBinder.java:330)
[error] org.cyberneko.html.HTMLScanner$ContentScanner.scanEndElement(HTMLScanner.java:3116)
[error] org.cyberneko.html.HTMLScanner$ContentScanner.scan(HTMLScanner.java:2083)
[error] org.cyberneko.html.HTMLScanner.scanDocument(HTMLScanner.java:918)
[error] org.cyberneko.html.HTMLConfiguration.parse(HTMLConfiguration.java:499)
[error] org.cyberneko.html.HTMLConfiguration.parse(HTMLConfiguration.java:452)
[error] org.apache.xerces.parsers.XMLParser.parse(Unknown Source)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.parse(HTMLParser.java:899)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser.parse(HTMLParser.java:242)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser.parseHtml(HTMLParser.java:188)
[error] com.gargoylesoftware.htmlunit.DefaultPageCreator.createHtmlPage(DefaultPageCreator.java:268)
[error] com.gargoylesoftware.htmlunit.DefaultPageCreator.createPage(DefaultPageCreator.java:156)
[error] com.gargoylesoftware.htmlunit.WebClient.loadWebResponseInto(WebClient.java:437)
[error] com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:311)
[error] com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:376)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:474)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:463)
[error] org.fluentlenium.core.Fluent.goTo(Fluent.java:336)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.delayedEndpoint$IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$1(IntegrationSpec.scala:19)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$delayedInit$body.apply(IntegrationSpec.scala:17)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.PlayRunners$class.running(Helpers.scala:63)
[error] play.api.test.Helpers$.running(Helpers.scala:403)
[error] play.api.test.WithBrowser.around(Specs.scala:65)
[error] play.api.test.WithBrowser.delayedInit(Specs.scala:48)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.<init>(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error] net.sourceforge.htmlunit.corejs.javascript.Interpreter.interpretLoop(Interpreter.java:1006)
[error] net.sourceforge.htmlunit.corejs.javascript.Interpreter.interpret(Interpreter.java:798)
[error] net.sourceforge.htmlunit.corejs.javascript.InterpretedFunction.call(InterpretedFunction.java:105)
[error] net.sourceforge.htmlunit.corejs.javascript.ContextFactory.doTopCall(ContextFactory.java:405)
[error] com.gargoylesoftware.htmlunit.javascript.HtmlUnitContextFactory.doTopCall(HtmlUnitContextFactory.java:309)
[error] net.sourceforge.htmlunit.corejs.javascript.ScriptRuntime.doTopCall(ScriptRuntime.java:3031)
[error] net.sourceforge.htmlunit.corejs.javascript.InterpretedFunction.exec(InterpretedFunction.java:115)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine$3.doRun(JavaScriptEngine.java:561)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine$HtmlUnitContextAction.run(JavaScriptEngine.java:669)
[error] net.sourceforge.htmlunit.corejs.javascript.Context.call(Context.java:602)
[error] net.sourceforge.htmlunit.corejs.javascript.ContextFactory.call(ContextFactory.java:507)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine.execute(JavaScriptEngine.java:570)
[error] com.gargoylesoftware.htmlunit.html.HtmlPage.loadExternalJavaScriptFile(HtmlPage.java:1062)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript.executeScriptIfNeeded(HtmlScript.java:409)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript$3.execute(HtmlScript.java:266)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript.onAllChildrenAddedToPage(HtmlScript.java:286)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.endElement(HTMLParser.java:683)
[error] org.apache.xerces.parsers.AbstractSAXParser.endElement(Unknown Source)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.endElement(HTMLParser.java:642)
[error] org.cyberneko.html.HTMLTagBalancer.callEndElement(HTMLTagBalancer.java:1170)
[error] org.cyberneko.html.HTMLTagBalancer.endElement(HTMLTagBalancer.java:1072)
[error] org.cyberneko.html.filters.DefaultFilter.endElement(DefaultFilter.java:206)
[error] org.cyberneko.html.filters.NamespaceBinder.endElement(NamespaceBinder.java:330)
[error] org.cyberneko.html.HTMLScanner$ContentScanner.scanEndElement(HTMLScanner.java:3116)
[error] org.cyberneko.html.HTMLScanner$ContentScanner.scan(HTMLScanner.java:2083)
[error] org.cyberneko.html.HTMLScanner.scanDocument(HTMLScanner.java:918)
[error] org.cyberneko.html.HTMLConfiguration.parse(HTMLConfiguration.java:499)
[error] org.cyberneko.html.HTMLConfiguration.parse(HTMLConfiguration.java:452)
[error] org.apache.xerces.parsers.XMLParser.parse(Unknown Source)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.parse(HTMLParser.java:899)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser.parse(HTMLParser.java:242)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser.parseHtml(HTMLParser.java:188)
[error] com.gargoylesoftware.htmlunit.DefaultPageCreator.createHtmlPage(DefaultPageCreator.java:268)
[error] com.gargoylesoftware.htmlunit.DefaultPageCreator.createPage(DefaultPageCreator.java:156)
[error] com.gargoylesoftware.htmlunit.WebClient.loadWebResponseInto(WebClient.java:437)
[error] com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:311)
[error] com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:376)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:474)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:463)
[error] org.fluentlenium.core.Fluent.goTo(Fluent.java:336)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.delayedEndpoint$IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$1(IntegrationSpec.scala:19)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$delayedInit$body.apply(IntegrationSpec.scala:17)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.PlayRunners$class.running(Helpers.scala:63)
[error] play.api.test.Helpers$.running(Helpers.scala:403)
[error] play.api.test.WithBrowser.around(Specs.scala:65)
[error] play.api.test.WithBrowser.delayedInit(Specs.scala:48)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.<init>(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error]
[error] Caused by com.gargoylesoftware.htmlunit.ScriptException: Error: Bootstrap's JavaScript requires jQuery (https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js#6)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine$HtmlUnitContextAction.run(JavaScriptEngine.java:684)
[error] net.sourceforge.htmlunit.corejs.javascript.Context.call(Context.java:602)
[error] net.sourceforge.htmlunit.corejs.javascript.ContextFactory.call(ContextFactory.java:507)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine.execute(JavaScriptEngine.java:570)
[error] com.gargoylesoftware.htmlunit.html.HtmlPage.loadExternalJavaScriptFile(HtmlPage.java:1062)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript.executeScriptIfNeeded(HtmlScript.java:409)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript$3.execute(HtmlScript.java:266)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript.onAllChildrenAddedToPage(HtmlScript.java:286)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.endElement(HTMLParser.java:683)
[error] org.apache.xerces.parsers.AbstractSAXParser.endElement(Unknown Source)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.endElement(HTMLParser.java:642)
[error] org.cyberneko.html.HTMLTagBalancer.callEndElement(HTMLTagBalancer.java:1170)
[error] org.cyberneko.html.HTMLTagBalancer.endElement(HTMLTagBalancer.java:1072)
[error] org.cyberneko.html.filters.DefaultFilter.endElement(DefaultFilter.java:206)
[error] org.cyberneko.html.filters.NamespaceBinder.endElement(NamespaceBinder.java:330)
[error] org.cyberneko.html.HTMLScanner$ContentScanner.scanEndElement(HTMLScanner.java:3116)
[error] org.cyberneko.html.HTMLScanner$ContentScanner.scan(HTMLScanner.java:2083)
[error] org.cyberneko.html.HTMLScanner.scanDocument(HTMLScanner.java:918)
[error] org.cyberneko.html.HTMLConfiguration.parse(HTMLConfiguration.java:499)
[error] org.cyberneko.html.HTMLConfiguration.parse(HTMLConfiguration.java:452)
[error] org.apache.xerces.parsers.XMLParser.parse(Unknown Source)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.parse(HTMLParser.java:899)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser.parse(HTMLParser.java:242)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser.parseHtml(HTMLParser.java:188)
[error] com.gargoylesoftware.htmlunit.DefaultPageCreator.createHtmlPage(DefaultPageCreator.java:268)
[error] com.gargoylesoftware.htmlunit.DefaultPageCreator.createPage(DefaultPageCreator.java:156)
[error] com.gargoylesoftware.htmlunit.WebClient.loadWebResponseInto(WebClient.java:437)
[error] com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:311)
[error] com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:376)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:474)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:463)
[error] org.fluentlenium.core.Fluent.goTo(Fluent.java:336)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.delayedEndpoint$IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$1(IntegrationSpec.scala:19)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$delayedInit$body.apply(IntegrationSpec.scala:17)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.PlayRunners$class.running(Helpers.scala:63)
[error] play.api.test.Helpers$.running(Helpers.scala:403)
[error] play.api.test.WithBrowser.around(Specs.scala:65)
[error] play.api.test.WithBrowser.delayedInit(Specs.scala:48)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.<init>(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error]
[error] Caused by net.sourceforge.htmlunit.corejs.javascript.JavaScriptException: Error: Bootstrap's JavaScript requires jQuery (https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js#6)
[error] net.sourceforge.htmlunit.corejs.javascript.Interpreter.interpretLoop(Interpreter.java:1006)
[error] net.sourceforge.htmlunit.corejs.javascript.Interpreter.interpret(Interpreter.java:798)
[error] net.sourceforge.htmlunit.corejs.javascript.InterpretedFunction.call(InterpretedFunction.java:105)
[error] net.sourceforge.htmlunit.corejs.javascript.ContextFactory.doTopCall(ContextFactory.java:405)
[error] com.gargoylesoftware.htmlunit.javascript.HtmlUnitContextFactory.doTopCall(HtmlUnitContextFactory.java:309)
[error] net.sourceforge.htmlunit.corejs.javascript.ScriptRuntime.doTopCall(ScriptRuntime.java:3031)
[error] net.sourceforge.htmlunit.corejs.javascript.InterpretedFunction.exec(InterpretedFunction.java:115)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine$3.doRun(JavaScriptEngine.java:561)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine$HtmlUnitContextAction.run(JavaScriptEngine.java:669)
[error] net.sourceforge.htmlunit.corejs.javascript.Context.call(Context.java:602)
[error] net.sourceforge.htmlunit.corejs.javascript.ContextFactory.call(ContextFactory.java:507)
[error] com.gargoylesoftware.htmlunit.javascript.JavaScriptEngine.execute(JavaScriptEngine.java:570)
[error] com.gargoylesoftware.htmlunit.html.HtmlPage.loadExternalJavaScriptFile(HtmlPage.java:1062)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript.executeScriptIfNeeded(HtmlScript.java:409)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript$3.execute(HtmlScript.java:266)
[error] com.gargoylesoftware.htmlunit.html.HtmlScript.onAllChildrenAddedToPage(HtmlScript.java:286)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.endElement(HTMLParser.java:683)
[error] org.apache.xerces.parsers.AbstractSAXParser.endElement(Unknown Source)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.endElement(HTMLParser.java:642)
[error] org.cyberneko.html.HTMLTagBalancer.callEndElement(HTMLTagBalancer.java:1170)
[error] org.cyberneko.html.HTMLTagBalancer.endElement(HTMLTagBalancer.java:1072)
[error] org.cyberneko.html.filters.DefaultFilter.endElement(DefaultFilter.java:206)
[error] org.cyberneko.html.filters.NamespaceBinder.endElement(NamespaceBinder.java:330)
[error] org.cyberneko.html.HTMLScanner$ContentScanner.scanEndElement(HTMLScanner.java:3116)
[error] org.cyberneko.html.HTMLScanner$ContentScanner.scan(HTMLScanner.java:2083)
[error] org.cyberneko.html.HTMLScanner.scanDocument(HTMLScanner.java:918)
[error] org.cyberneko.html.HTMLConfiguration.parse(HTMLConfiguration.java:499)
[error] org.cyberneko.html.HTMLConfiguration.parse(HTMLConfiguration.java:452)
[error] org.apache.xerces.parsers.XMLParser.parse(Unknown Source)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser$HtmlUnitDOMBuilder.parse(HTMLParser.java:899)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser.parse(HTMLParser.java:242)
[error] com.gargoylesoftware.htmlunit.html.HTMLParser.parseHtml(HTMLParser.java:188)
[error] com.gargoylesoftware.htmlunit.DefaultPageCreator.createHtmlPage(DefaultPageCreator.java:268)
[error] com.gargoylesoftware.htmlunit.DefaultPageCreator.createPage(DefaultPageCreator.java:156)
[error] com.gargoylesoftware.htmlunit.WebClient.loadWebResponseInto(WebClient.java:437)
[error] com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:311)
[error] com.gargoylesoftware.htmlunit.WebClient.getPage(WebClient.java:376)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:474)
[error] org.openqa.selenium.htmlunit.HtmlUnitDriver.get(HtmlUnitDriver.java:463)
[error] org.fluentlenium.core.Fluent.goTo(Fluent.java:336)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.delayedEndpoint$IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$1(IntegrationSpec.scala:19)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1$delayedInit$body.apply(IntegrationSpec.scala:17)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.WithBrowser$$anonfun$around$3.apply(Specs.scala:65)
[error] play.api.test.PlayRunners$class.running(Helpers.scala:63)
[error] play.api.test.Helpers$.running(Helpers.scala:403)
[error] play.api.test.WithBrowser.around(Specs.scala:65)
[error] play.api.test.WithBrowser.delayedInit(Specs.scala:48)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.<init>(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error] IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[info]
[info]
[info] Total for specification IntegrationSpec
[info] Finished in 6 seconds, 423 ms
[info] 1 example, 0 failure, 1 error
[info] ApplicationSpec
[info]
[info] Application should
[info] ! render the index page
[error]    SQLException: : Attempting to obtain a connection from a pool that has already been shutdown.
[error] Stack trace of location where pool was shutdown follows:
[error]  java.lang.Thread.getStackTrace(Thread.java:1589)
[error]  com.jolbox.bonecp.BoneCP.captureStackTrace(BoneCP.java:572)
[error]  com.jolbox.bonecp.BoneCP.shutdown(BoneCP.java:161)
[error]  com.jolbox.bonecp.BoneCPDataSource.close(BoneCPDataSource.java:143)
[error]  play.api.db.BoneCPApi.shutdownPool(DB.scala:423)
[error]  play.api.db.BoneCPPlugin$$anonfun$onStop$1.apply(DB.scala:260)
[error]  play.api.db.BoneCPPlugin$$anonfun$onStop$1.apply(DB.scala:258)
[error]  scala.collection.immutable.List.foreach(List.scala:381)
[error]  play.api.db.BoneCPPlugin.onStop(DB.scala:258)
[error]  play.api.Play$$anonfun$stop$1$$anonfun$apply$1$$anonfun$apply$mcV$sp$2.apply(Play.scala:108)
[error]  play.api.Play$$anonfun$stop$1$$anonfun$apply$1$$anonfun$apply$mcV$sp$2.apply(Play.scala:107)
[error]  scala.collection.immutable.List.foreach(List.scala:381)
[error]  play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply$mcV$sp(Play.scala:107)
[error]  play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply(Play.scala:107)
[error]  play.api.Play$$anonfun$stop$1$$anonfun$apply$1.apply(Play.scala:107)
[error]  play.utils.Threads$.withContextClassLoader(Threads.scala:21)
[error]  play.api.Play$$anonfun$stop$1.apply(Play.scala:106)
[error]  play.api.Play$$anonfun$stop$1.apply(Play.scala:105)
[error]  scala.Option.map(Option.scala:146)
[error]  play.api.Play$.stop(Play.scala:105)
[error]  play.core.server.NettyServer.stop(NettyServer.scala:158)
[error]  play.api.test.TestServer.stop(Selenium.scala:161)
[error]  play.api.test.PlayRunners$class.running(Helpers.scala:65)
[error]  play.api.test.Helpers$.running(Helpers.scala:403)
[error]  play.api.test.WithBrowser.around(Specs.scala:65)
[error]  org.specs2.mutable.Around$$anonfun$delayedInit$1.apply(Around.scala:13)
[error]  org.specs2.mutable.Around$$anonfun$delayedInit$1.apply(Around.scala:13)
[error]  org.specs2.execute.ResultExecution$class.effectively(ResultExecution.scala:38)
[error]  org.specs2.execute.ResultExecution$.effectively(ResultExecution.scala:116)
[error]  org.specs2.mutable.Around$class.delayedInit(Around.scala:13)
[error]  play.api.test.WithBrowser.delayedInit(Specs.scala:48)
[error]  IntegrationSpec$$anonfun$1$$anonfun$apply$1$$anon$1.<init>(IntegrationSpec.scala:17)
[error]  IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error]  IntegrationSpec$$anonfun$1$$anonfun$apply$1.apply(IntegrationSpec.scala:17)
[error]  org.specs2.matcher.Scope$$anon$3.asResult(ThrownExpectations.scala:120)
[error]  org.specs2.execute.AsResult$.apply(Result.scala:253)
[error]  org.specs2.specification.Example$$anonfun$apply$1.apply(Fragment.scala:209)
[error]  org.specs2.specification.Example$$anonfun$apply$1.apply(Fragment.scala:209)
[error]  org.specs2.specification.Example.execute(Fragment.scala:176)
[error]  org.specs2.specification.FragmentExecution$$anonfun$1.apply(FragmentExecution.scala:46)
[error]  org.specs2.specification.FragmentExecution$$anonfun$1.apply(FragmentExecution.scala:46)
[error]  org.specs2.execute.ResultExecution$class.execute(ResultExecution.scala:22)
[error]  org.specs2.execute.ResultExecution$.execute(ResultExecution.scala:116)
[error]  org.specs2.specification.FragmentExecution$class.executeBody(FragmentExecution.scala:28)
[error]  org.specs2.reporter.SbtConsoleReporter.executeBody(SbtReporter.scala:20)
[error]  org.specs2.specification.FragmentExecution$class.execute(FragmentExecution.scala:46)
[error]  org.specs2.reporter.SbtConsoleReporter.execute(SbtReporter.scala:20)
[error]  org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1$$anonfun$apply$1.apply(FragmentExecution.scala:35)
[error]  org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1$$anonfun$apply$1.apply(FragmentExecution.scala:35)
[error]  org.specs2.control.Exceptions$class.catchAllOr(Exceptions.scala:54)
[error]  org.specs2.control.Exceptions$.catchAllOr(Exceptions.scala:109)
[error]  org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1.apply(FragmentExecution.scala:35)
[error]  org.specs2.specification.FragmentExecution$$anonfun$executeFragment$1.apply(FragmentExecution.scala:35)
[error]  org.specs2.reporter.DefaultExecutionStrategy$$anonfun$executeSequentially$1.apply(ExecutionStrategy.scala:104)
[error]  org.specs2.reporter.DefaultExecutionStrategy$$anonfun$executeSequentially$1.apply(ExecutionStrategy.scala:104)
[error]  scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:234)
[error]  scala.collection.TraversableLike$$anonfun$map$1.apply(TraversableLike.scala:234)
[error]  scala.collection.immutable.List.foreach(List.scala:381)
[error]  scala.collection.TraversableLike$class.map(TraversableLike.scala:234)
[error]  scala.collection.immutable.List.map(List.scala:285)
[error]  org.specs2.reporter.DefaultExecutionStrategy$class.executeSequentially(ExecutionStrategy.scala:104)
[error]  org.specs2.reporter.SbtConsoleReporter.executeSequentially(SbtReporter.scala:20)
[error]  org.specs2.reporter.DefaultExecutionStrategy$class.executeSequence(ExecutionStrategy.scala:98)
[error]  org.specs2.reporter.SbtConsoleReporter.executeSequence(SbtReporter.scala:20)
[error]  org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1$$anonfun$2.apply(ExecutionStrategy.scala:43)
[error]  org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1$$anonfun$2.apply(ExecutionStrategy.scala:41)
[error]  scala.collection.immutable.Stream.foldLeft(Stream.scala:610)
[error]  org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1.apply(ExecutionStrategy.scala:41)
[error]  org.specs2.reporter.DefaultExecutionStrategy$$anonfun$execute$1.apply(ExecutionStrategy.scala:38)
[error]  scalaz.syntax.IdOps$class.$bar$greater(IdOps.scala:15)
[error]  scalaz.syntax.ToIdOps$$anon$1.$bar$greater(IdOps.scala:82)
[error]  org.specs2.reporter.AllExporting$class.report(AllExporting.scala:17)
[error]  org.specs2.reporter.SbtConsoleReporter.report(SbtReporter.scala:20)
[error]  org.specs2.runner.SbtRunner.org$specs2$runner$SbtRunner$$specificationRun(SbtRunner.scala:75)
[error]  org.specs2.runner.SbtRunner$$anonfun$newTask$1$$anon$5.execute(SbtRunner.scala:59)
[error]  sbt.ForkMain$Run$2.call(ForkMain.java:294)
[error]  sbt.ForkMain$Run$2.call(ForkMain.java:284)
[error]  java.util.concurrent.FutureTask.run(FutureTask.java:262)
[error]  java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)
[error]  java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)
[error]  java.lang.Thread.run(Thread.java:745)
[error]   (AbstractConnectionStrategy.java:52)
[error] com.jolbox.bonecp.AbstractConnectionStrategy.preConnection(AbstractConnectionStrategy.java:52)
[error] com.jolbox.bonecp.AbstractConnectionStrategy.getConnection(AbstractConnectionStrategy.java:88)
[error] com.jolbox.bonecp.BoneCP.getConnection(BoneCP.java:553)
[error] com.jolbox.bonecp.BoneCPDataSource.getConnection(BoneCPDataSource.java:131)
[error] models.Users$$anonfun$all$1.apply(Users.scala:21)
[error] models.Users$$anonfun$all$1.apply(Users.scala:20)
[error] models.Users$.all(Users.scala:20)
[error] controllers.Application$$anonfun$index$1.apply(Application.scala:17)
[error] controllers.Application$$anonfun$index$1.apply(Application.scala:17)
[error] play.api.mvc.ActionBuilder$$anonfun$apply$17.apply(Action.scala:464)
[error] play.api.mvc.ActionBuilder$$anonfun$apply$17.apply(Action.scala:464)
[error] play.api.mvc.ActionBuilder$$anonfun$apply$16.apply(Action.scala:433)
[error] play.api.mvc.ActionBuilder$$anonfun$apply$16.apply(Action.scala:432)
[error] play.api.mvc.Action$.invokeBlock(Action.scala:556)
[error] play.api.mvc.Action$.invokeBlock(Action.scala:555)
[error] play.api.mvc.ActionBuilder$$anon$1.apply(Action.scala:518)
[error] play.api.mvc.Action$$anonfun$apply$1$$anonfun$apply$4$$anonfun$apply$5.apply(Action.scala:130)
[error] play.api.mvc.Action$$anonfun$apply$1$$anonfun$apply$4$$anonfun$apply$5.apply(Action.scala:130)
[error] play.utils.Threads$.withContextClassLoader(Threads.scala:21)
[error] play.api.mvc.Action$$anonfun$apply$1$$anonfun$apply$4.apply(Action.scala:129)
[error] play.api.mvc.Action$$anonfun$apply$1$$anonfun$apply$4.apply(Action.scala:128)
[error] play.api.mvc.Action$$anonfun$apply$1.apply(Action.scala:128)
[error] play.api.mvc.Action$$anonfun$apply$1.apply(Action.scala:121)
[error] play.api.libs.iteratee.DoneIteratee$$anonfun$mapM$2.apply(Iteratee.scala:705)
[error] play.api.libs.iteratee.DoneIteratee$$anonfun$mapM$2.apply(Iteratee.scala:705)
[error] akka.dispatch.TaskInvocation.run(AbstractDispatcher.scala:41)
[error] akka.dispatch.ForkJoinExecutorConfigurator$AkkaForkJoinTask.exec(AbstractDispatcher.scala:393)
[info]
[info]
[info] Total for specification ApplicationSpec
[info] Finished in 1 second, 273 ms
[info] 1 example, 0 failure, 1 error
[error] Error: Total 2, Failed 0, Errors 2, Passed 0
[error] Error during tests:
[error]         ApplicationSpec
[error]         IntegrationSpec
[error] (test:test) sbt.TestsFailedException: Tests unsuccessful
[error] Total time: 18 s, completed Jul 21, 2016 12:53:33 AM


 */
