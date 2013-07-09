package test

class Preferences {
  static searchable = {
    only = 'signature'
    root false
  }

  Boolean showEmail
  Boolean receiveEmailFromAdmin
  Boolean receiveEmailFromUser
  Boolean receiveNewsletter
  String avatarUrl
  String signature
}
