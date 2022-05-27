package elektroGo.adminapp.ui.driversConfirmation

import elektroGo.adminapp.controller.AdminAppController
import elektroGo.adminapp.model.Driver
import kotlinx.coroutines.runBlocking

class DriverViewModel {
    fun verifyUser(username: String) : Int = runBlocking {
        AdminAppController.validateDriver(username)
    }

    fun denyUser(username: String) : Int = runBlocking {
        AdminAppController.denyUser(username)
    }
}