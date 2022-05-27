package elektroGo.adminapp.ui.driversConfirmation

import androidx.lifecycle.ViewModel
import elektroGo.adminapp.controller.AdminAppController
import elektroGo.adminapp.model.Driver
import kotlinx.coroutines.runBlocking

class DriversListViewModel : ViewModel() {
    fun getDrivers() : Pair <Int, ArrayList<Driver> > = runBlocking {
        AdminAppController.getDriversList()
    }
}