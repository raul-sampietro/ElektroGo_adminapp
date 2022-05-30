package elektroGo.adminapp.ui.vehicleConfirmation

import android.app.ActionBar
import android.app.Activity
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import elektroGo.adminapp.R
import elektroGo.adminapp.model.Vehicle
import elektroGo.adminapp.ui.reportList.ReportListViewModel

class VehicleListFragment : Fragment() {

    companion object {
        fun newInstance() = VehicleListFragment()
    }

    private lateinit var viewModel: VehicleListViewModel

    private lateinit var vehicleList: ArrayList<Vehicle>

    private lateinit var emptyList: TextView

    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.vehicle_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listView = view.findViewById(R.id.vehicleListFragment)
        viewModel = VehicleListViewModel()
        emptyList = requireActivity().findViewById(R.id.emptyListVehicle)
        vehicleList = ArrayList<Vehicle>()

        val httpResponse = viewModel.getVehicleList()
        if (httpResponse.first != 200){
            Toast.makeText(context, getString(R.string.GetVehiclesError), Toast.LENGTH_SHORT).show()
        }
        else {
            vehicleList = httpResponse.second
            if (vehicleList.size == 0){
                emptyList.text = getString(R.string.emptyVehicle)
            }
            else emptyList.text = ""
            listView.adapter = VehicleAdapter(context as Activity, vehicleList)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[VehicleListViewModel::class.java]
    }

    override fun onResume() {
        super.onResume()
        viewModel = VehicleListViewModel()
        emptyList = requireActivity().findViewById(R.id.emptyListVehicle)
        vehicleList = ArrayList<Vehicle>()

        val httpResponse = viewModel.getVehicleList()
        if (httpResponse.first != 200){
            Toast.makeText(context, getString(R.string.GetVehiclesError), Toast.LENGTH_SHORT).show()
        }
        else {
            vehicleList = httpResponse.second
            if (vehicleList.size == 0){
                emptyList.text = getString(R.string.emptyVehicle)
            }
            else emptyList.text = ""
            listView.adapter = VehicleAdapter(context as Activity, vehicleList)
        }
    }

}