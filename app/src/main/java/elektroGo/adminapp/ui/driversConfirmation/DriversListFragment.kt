package elektroGo.adminapp.ui.driversConfirmation

import android.app.Activity
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import elektroGo.adminapp.R
import elektroGo.adminapp.model.Driver
import elektroGo.adminapp.model.Reports
import elektroGo.adminapp.ui.reportList.ReportAdapter

class DriversListFragment : Fragment() {

    companion object {
        fun newInstance() = DriversListFragment()
    }

    private lateinit var viewModel: DriversListViewModel

    private lateinit var driverList: ArrayList<Driver>

    private lateinit var emptyList: TextView

    private lateinit var listView: ListView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = DriversListViewModel()
        listView = view.findViewById(R.id.driverListView)
        emptyList = requireActivity().findViewById(R.id.emptyListDrivers)
        driverList = ArrayList<Driver>()

        val httpResponse = viewModel.getDrivers()
        if (httpResponse.first != 200){
            Toast.makeText(context, getString(R.string.GetDriversError), Toast.LENGTH_SHORT).show()
        }
        else {
            driverList = httpResponse.second
            if (driverList.size == 0) emptyList.text = resources.getString(R.string.emptyReportList)
            else emptyList.text = ""
            listView.adapter = DriverAdapter(context as Activity, driverList)
            Toast.makeText(context, getString(R.string.GetDriversGood), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.drivers_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DriversListViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onResume() {
        super.onResume()
        emptyList = requireActivity().findViewById(R.id.emptyListDrivers)
        driverList = ArrayList<Driver>()

        val httpResponse = viewModel.getDrivers()
        if (httpResponse.first != 200){
            Toast.makeText(context, getString(R.string.GetDriversError), Toast.LENGTH_SHORT).show()
        }
        else {
            driverList = httpResponse.second
            if (driverList.size == 0) emptyList.text = resources.getString(R.string.emptyReportList)
            else emptyList.text = ""
            listView.adapter = DriverAdapter(context as Activity, driverList)
            Toast.makeText(context, getString(R.string.GetDriversGood), Toast.LENGTH_SHORT).show()
        }
    }

}