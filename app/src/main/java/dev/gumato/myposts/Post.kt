package dev.gumato.myposts

data class Post(
    var id: Int,
    var userid: Int,
    var title: String,
    var body: String
)

data class Comment(
    var postId: Int,
    var id: Int,
    var title: String,
    var name: String,
    var email: String,
    var body: String
)
