package org.wylis.authorization

import UserInfo.FacebookUser
import play.api.mvc.{RequestHeader, Result}

trait FacebookOAuth2 extends OAuth2[FacebookUser]{
  override def userInfo(request: RequestHeader): Option[FacebookUser] = ???

  override def onUnauthorized(request: RequestHeader): Result = ???
}
