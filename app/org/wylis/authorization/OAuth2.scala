package org.wylis.authorization

import UserInfo.UserInfo
import play.api.mvc.Security._
import play.api.mvc._

trait OAuth2[A <: UserInfo] {
  def userInfo(request: RequestHeader): Option[A]

  def onUnauthorized(request: RequestHeader): Result

  def authenticate(f: => A => Request[AnyContent] => Result) = {
    Authenticated(userInfo, onUnauthorized) { user =>
      Action(request => f(user)(request))
    }
  }

  def authenticateWithFilter(filter: A => Boolean)(f: => A => Request[AnyContent] => Result) = {
    Authenticated(userInfo, onUnauthorized) { user =>
      if(filter(user))
        Action(request => f(user)(request))
      else
        Action(request => onUnauthorized(request))
    }
  }
}
