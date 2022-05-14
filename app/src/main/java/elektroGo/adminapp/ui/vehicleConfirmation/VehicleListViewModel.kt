package elektroGo.adminapp.ui.vehicleConfirmation

import androidx.lifecycle.ViewModel
import elektroGo.adminapp.controller.AdminAppController
import elektrogo.front.model.Vehicle
import kotlinx.coroutines.runBlocking

class VehicleListViewModel : ViewModel() {
    fun getVehicleList() : Pair<Int, ArrayList<Vehicle>> = runBlocking {
        AdminAppController.getVehicleList()
    }
}