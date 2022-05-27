package elektroGo.adminapp.ui.driversConfirmation

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import elektroGo.adminapp.R
import elektroGo.adminapp.model.Driver
import elektroGo.adminapp.ui.reportList.DetailsReportActivity
import elektroGo.adminapp.ui.reportList.ReportListViewModel

class DriverAdapter (private val context: Activity, private val driversList: ArrayList<Driver>): ArrayAdapter<Driver>(context, R.layout.driver_list_item, driversList){
    private lateinit var viewModel: ReportListViewModel

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.driver_list_item, null)

        val username : TextView = view.findViewById(R.id.UsernameValue)
        val showMore : Button = view.findViewById(R.id.viewMoreButton2)
        val driver  = driversList[position]

        username.text = driver.username

        showMore.setOnClickListener {
            //Quan es clica sobre un view more s'obra l'activity amb més info
            val i = Intent(context, DriverDetailsActivity::class.java)
            i.putExtra("username", driver.username)
            view.context.startActivity(i)
        }
        return view
    }
}