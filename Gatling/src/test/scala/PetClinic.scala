
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class PetClinic extends Simulation {

	val httpProtocol = http
		.baseUrl("appUrl")
		.inferHtmlResources()
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/85.0.4183.121 Safari/537.36")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
		"Accept-Encoding" -> "gzip, deflate",
		"Accept-Language" -> "en-US,en;q=0.9",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_7 = Map("Origin" -> "appUrl")

	val headers_11 = Map(
		"Accept" -> "image/avif,image/webp,image/apng,image/*,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate",
		"Accept-Language" -> "en-US,en;q=0.9",
		"Pragma" -> "no-cache")

	val headers_12 = Map(
		"Accept" -> "image/avif,image/webp,image/apng,image/*,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate",
		"Accept-Language" -> "en-US,en;q=0.9")



	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/resources/images/pets.png"),
            http("request_2")
			.get("/resources/images/spring-pivotal-logo.png"),
            http("request_3")
			.get("/webjars/jquery/2.2.4/jquery.min.js"),
            http("request_4")
			.get("/webjars/jquery-ui/1.11.4/jquery-ui.min.js"),
            http("request_5")
			.get("/webjars/bootstrap/3.3.6/js/bootstrap.min.js"),
            http("request_6")
			.get("/resources/css/petclinic.css"),
            http("request_7")
			.get("/webjars/bootstrap/fonts/glyphicons-halflings-regular.woff2")
			.headers(headers_7),
            http("request_8")
			.get("/resources/fonts/varela_round-webfont.woff")
			.headers(headers_7),
            http("request_9")
			.get("/resources/fonts/montserrat-webfont.woff")
			.headers(headers_7),
            http("request_10")
			.get("/resources/images/spring-logo-dataflow.png"),
            http("request_11")
			.get("/resources/images/favicon.png")
			.headers(headers_11)))
		.pause(52)
		.exec(http("request_12")
			.get("/resources/images/spring-logo-dataflow-mobile.png")
			.headers(headers_12))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
