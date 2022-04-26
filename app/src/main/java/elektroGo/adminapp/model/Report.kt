package elektroGo.adminapp.model

data class Report(
    val userWhoReports: String,
    val reportedUser: String,
    val reason: String
)
