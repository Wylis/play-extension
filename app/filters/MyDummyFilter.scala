package filters

import play.api.mvc.{Result, RequestHeader, Filter}

import scala.concurrent.Future

class MyDummyFilter extends Filter {
  override def apply(f: (RequestHeader) => Future[Result])(rh: RequestHeader): Future[Result] = {
    // Do fancy stuff
    f(rh)
  }
}
