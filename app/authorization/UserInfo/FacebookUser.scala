package authorization.UserInfo

import authorization.UserInfo.FacebookStatus.Status

object FacebookStatus {
  type Status = String
  val connected: Status = "connected"
  val not_authorized: Status = "not_authorized"
  val unknown: Status = "unknown"
}

case class FacebookUser(Status: Status, authResponse: AuthResponse) extends UserInfo

// Todo: signedRequest is unknown yet. Get further details and update type
case class AuthResponse(accessToken: String, expiresIn: Int, signedRequest:Any, userID: String)