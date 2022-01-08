package br.com.arodevsistemas.dominandorecyclerview.model

data class Email(
    val user: String,
    val subject: String,
    val preview: String,
    val date: String,
    val stared: Boolean,
    val unread: Boolean,
    var selected: Boolean = false
)

class EmailBuilder {
    var user: String = ""
    var subject: String = ""
    var preview: String = ""
    var date: String = ""
    var stared: Boolean = false
    var unread: Boolean = false

    fun build() : Email = Email(user, subject, preview, date, stared, unread, false)
}

fun email(block: EmailBuilder.() -> Unit): Email = EmailBuilder().apply(block).build()

fun fakeEmails() = mutableListOf(
    email {
        user = "Facebook"
        subject = "Lorem Ipsum is simply dummy text of the printing and typesetting industry"
        preview = "The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English"
        date = "26 Jun"
        stared = false
    },
    email {
        user = "Facebook"
        subject = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout."
        preview = "The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English"
        date = "26 Jun"
        stared = false
    },
    email {
        user = "Youtube"
        subject = "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text"
        preview = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable"
        date = "26 Jun"
        stared = true
        unread = true
    },
    email {
        user = "Instagram"
        subject = "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text"
        preview = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable"
        date = "26 Jun"
        stared = false
        unread = true
    },
    email {
        user = "Facebook"
        subject = "Lorem Ipsum is simply dummy text of the printing and typesetting industry"
        preview = "The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English"
        date = "26 Jun"
        stared = false
    },
    email {
        user = "Facebook"
        subject = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout."
        preview = "The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English"
        date = "26 Jun"
        stared = false
    },
    email {
        user = "Youtube"
        subject = "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text"
        preview = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable"
        date = "26 Jun"
        stared = true
        unread = true
    },
    email {
        user = "Instagram"
        subject = "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text"
        preview = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable"
        date = "26 Jun"
        stared = false
        unread = true
    },
    email {
        user = "Facebook"
        subject = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout."
        preview = "The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English"
        date = "26 Jun"
        stared = false
    },
    email {
        user = "Youtube"
        subject = "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text"
        preview = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable"
        date = "26 Jun"
        stared = true
        unread = true
    },
    email {
        user = "Instagram"
        subject = "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text"
        preview = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable"
        date = "26 Jun"
        stared = false
        unread = true
    },
    email {
        user = "Facebook"
        subject = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout."
        preview = "The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English"
        date = "26 Jun"
        stared = false
    },
    email {
        user = "Youtube"
        subject = "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text"
        preview = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable"
        date = "26 Jun"
        stared = true
        unread = true
    },
    email {
        user = "Instagram"
        subject = "Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text"
        preview = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable"
        date = "26 Jun"
        stared = false
        unread = true
    }
)