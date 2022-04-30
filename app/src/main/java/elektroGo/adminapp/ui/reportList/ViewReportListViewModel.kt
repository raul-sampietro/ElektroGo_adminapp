package elektroGo.adminapp.ui.reportList

import androidx.lifecycle.ViewModel
import elektroGo.adminapp.controller.AdminAppController
import elektroGo.adminapp.model.Reports
import kotlinx.coroutines.runBlocking

class ViewReportListViewModel : ViewModel() {
    fun getReports() : Pair <Int, ArrayList<Reports> > = runBlocking {
        AdminAppController.getReportsList()
    }
}