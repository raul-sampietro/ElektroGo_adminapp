package elektroGo.adminapp.controller

import elektroGo.adminapp.model.Reports
import elektrogo.front.model.Vehicle
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

object AdminAppController {
    private const val URL_BASE = "http://10.4.41.58:8080/"

    private val client = HttpClient(Android) {   //Exemple de com fer una crida amb el nostre servidor!
        expectSuccess = false
        engine {
            connectTimeout = 60_000
            socketTimeout = 60_000
        }
        install(Logging) {
            level = LogLevel.ALL
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }

    suspend fun getReportsList(): Pair<Int, ArrayList<Reports> >{
        val reports: HttpResponse = client.get("${URL_BASE}users/Allreports")
        val status: Int = reports.status.value

        val reportList: ArrayList<Reports>
        if (status != 200) reportList = ArrayList<Reports>()
        else reportList = reports.receive()
        return Pair(status, reportList)

    }

    suspend fun getVehicleList(): Pair<Int, ArrayList<Vehicle>>{
        val vehicles: HttpResponse = client.get("${URL_BASE}users/Allreports")
        val status: Int = vehicles.status.value

        val vehicleList: ArrayList<Vehicle>
        if (status != 200) vehicleList = ArrayList<Vehicle>()
        else vehicleList = vehicles.receive()
        return Pair(status, vehicleList)
    }
    //TODO add methods here


    suspend fun deleteUser(userToDelete: String): Int {

        val httpResponse: HttpResponse = client.post("${URL_BASE}users/delete") {
            parameter("username", userToDelete)
        }
        return httpResponse.status.value
    }

    suspend fun deleteReport(uWhoReports: String, uReported: String): Int {

        val httpResponse: HttpResponse = client.post("${URL_BASE}user/unreport") {
            parameter("userWhoReports", uWhoReports)
            parameter("reportedUser", uReported)
        }
        return httpResponse.status.value
    }

}