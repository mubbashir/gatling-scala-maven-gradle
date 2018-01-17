package com.test.computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BasicSimulation extends Simulation {

  val httpConf = http
    .baseURL("http://computer-database.gatling.io") // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn = scenario("Search Computer") // A scenario is a chain of requests and pauses
    .exec(http("request_1")
      .get("/"))
    .pause(7) // Note that Gatling has recorder real time pauses
    .exec(http("request_2")
      .get("/computers?f=macbook"))
    .pause(2)
    .exec(http("request_3") // Here's an example of a POST request
      .post("/computers")
      .formParam("""name""", """Beautiful Computer""") // Note the triple double quotes: used in Scala for protecting a whole chain of characters (no need for backslash)
      .formParam("""introduced""", """2012-05-30""")
      .formParam("""discontinued""", """""")
      .formParam("""company""", """37"""))

  //setUp(scn.inject(atOnceUsers(1)).protocols(httpConf)) // For one user 
  setUp(scn.inject(rampUsers(2) over (1 seconds)).protocols(httpConf)) // For 2 VU rampup in 1 seaconds
}
