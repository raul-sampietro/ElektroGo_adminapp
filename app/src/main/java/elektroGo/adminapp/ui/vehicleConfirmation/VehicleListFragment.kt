package elektroGo.adminapp.ui.vehicleConfirmation

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
import elektroGo.adminapp.ui.reportList.ReportAdapter
import elektrogo.front.model.Vehicle

class VehicleListFragment : Fragment() {

    companion object {
        fun newInstance() = VehicleListFragment()
    }

    private lateinit var viewModel: VehicleListViewModel

    private lateinit var vehicleList: ArrayList<Vehicle>

    private lateinit var emptyList: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.vehicle_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listView: ListView = view.findViewById(R.id.vehicleListFragment)
        emptyList = requireActivity().findViewById(R.id.emptyList)
        vehicleList = ArrayList<Vehicle>()

        val httpResponse = viewModel.getVehicleList()
        if (httpResponse.first != 200){
            Toast.makeText(context, getString(R.string.GetReportsError), Toast.LENGTH_SHORT).show()
        }
        else {
            vehicleList = httpResponse.second
            if (vehicleList.size == 0) emptyList.text = "No hi cap vehicle a verificar."
            else emptyList.text = ""
            listView.adapter = VehicleAdapter(context as Activity, vehicleList)
            Toast.makeText(context, getString(R.string.GetReportsGood), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(VehicleListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}