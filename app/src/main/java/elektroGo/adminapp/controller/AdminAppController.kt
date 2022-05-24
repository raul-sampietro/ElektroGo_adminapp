package elektroGo.adminapp.controller

import elektroGo.adminapp.model.Reports
import elektroGo.adminapp.model.Vehicle
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

object AdminAppController {
    //private const val URL_BASE_WB = "http://10.4.41.58:8080/"
    //private const val URL_BASE = "http://10.4.41.58:8080";
    private const val URL_BASE_WB = "http://192.168.1.82:8080/"
    private const val URL_BASE = "http://192.168.1.82:8080"

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

    // #################################################
    // #  USERS                                        #
    // #################################################

    private const val URL_USERS = "${URL_BASE}/users"

    suspend fun deleteUser(userToDelete: String): Int {

        val httpResponse: HttpResponse = client.delete("${URL_USERS}/${userToDelete}")
        return httpResponse.status.value
    }

    // #################################################
    // #  REPORTS                                      #
    // #################################################

    private const val URL_REPORTS = "${URL_BASE}/reports"

    suspend fun getReportsList(): Pair<Int, ArrayList<Reports> >{
        val reports: HttpResponse = client.get(URL_REPORTS)
        val status: Int = reports.status.value

        val reportList: ArrayList<Reports>
        if (status != 200) reportList = ArrayList<Reports>()
        else reportList = reports.receive()
        return Pair(status, reportList)

    }

    suspend fun deleteReport(uWhoReports: String, uReported: String): Int {
        val httpResponse: HttpResponse = client.delete("${URL_REPORTS}/from/${uWhoReports}/to/${uReported}")
        return httpResponse.status.value
    }

    // #################################################
    // #  VEHICLES                                     #
    // #################################################

    private const val URL_VEHICLES = "${URL_BASE}/vehicles"

    //obté només els no verificats
    suspend fun getVehicleList(): Pair<Int, ArrayList<Vehicle>>{
        val vehicles: HttpResponse = client.get(URL_VEHICLES) {
            parameter("notVerified", true)
        }
        val status: Int = vehicles.status.value

        val vehicleList: ArrayList<Vehicle>
        if (status != 200) vehicleList = ArrayList<Vehicle>()
        else vehicleList = vehicles.receive()
        return Pair(status, vehicleList)
    }

    suspend fun acceptVehicle(numberPlate: String): Int {
        val httpResponse: HttpResponse = client.put("${URL_VEHICLES}/${numberPlate}/verify")
        return httpResponse.status.value
    }

    suspend fun rejectVehicle(numberPlate: String): Int {
        val httpResponse: HttpResponse = client.delete("${URL_VEHICLES}/${numberPlate}")
        return httpResponse.status.value
    }
}