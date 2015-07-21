package authorization

import play.api.mvc.{Result, RequestHeader}
import authorization.UserInfo.FacebookUser

trait FacebookOAuth extends OAuth[FacebookUser]{
  override def userInfo(request: RequestHeader): Option[FacebookUser] = ???

  override def onUnauthorized(request: RequestHeader): Result = ???
}
