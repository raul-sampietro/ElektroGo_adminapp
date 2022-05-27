package elektroGo.adminapp.model

import kotlinx.serialization.Serializable

@Serializable

data class Driver(
    val username: String,
    var status: String?
)
