package elektroGo.adminapp.ui.reports

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import elektroGo.adminapp.R
import elektroGo.adminapp.model.Report

class ReportAdapter (private val context: Activity, private val reportList: ArrayList<Report>): ArrayAdapter<Report>(context, R.layout.view_report_list_fragment, filteredList) {

    private lateinit var viewModel: ViewReportListViewModel

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.report_item, null)

        val userWhoReporter : TextView = view.findViewById(R.id.Username)
        val userReported : TextView = view.findViewById(R.id.reportedUsername)
        val briefReason : TextView = view.findViewById(R.id.brieflyReason)
        val report  = reportList[position]

        return view
    }
}