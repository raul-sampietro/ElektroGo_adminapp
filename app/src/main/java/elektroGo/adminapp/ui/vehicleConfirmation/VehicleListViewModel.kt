package elektroGo.adminapp.ui.vehicleConfirmation

import androidx.lifecycle.ViewModel
import elektroGo.adminapp.controller.AdminAppController
import elektroGo.adminapp.model.Vehicle
import kotlinx.coroutines.runBlocking

class VehicleListViewModel : ViewModel() {
    fun getVehicleList() : Pair<Int, ArrayList<Vehicle>> = runBlocking {
        AdminAppController.getVehicleList()
    }

    fun acceptVehicle(numberPlate: String): Int = runBlocking {
        AdminAppController.acceptVehicle(numberPlate)
    }

    fun rejectVehicle(numberPlate: String): Int = runBlocking {
        AdminAppController.rejectVehicle(numberPlate)
    }
}