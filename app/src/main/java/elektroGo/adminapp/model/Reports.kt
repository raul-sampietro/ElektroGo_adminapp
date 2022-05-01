package elektroGo.adminapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Reports(
    val userWhoReports: String,
    val reportedUser: String,
    val reason: String
)
