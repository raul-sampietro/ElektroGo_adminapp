package elektroGo.adminapp.ui.reportList

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import elektroGo.adminapp.R
import elektroGo.adminapp.model.Reports

class ReportAdapter (private val context: Activity, private val reportList: ArrayList<Reports>): ArrayAdapter<Reports>(context, R.layout.view_report_list_fragment, reportList) {

    private lateinit var viewModel: ViewReportListViewModel

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.report_item, null)

        val userWhoReports : TextView = view.findViewById(R.id.Username)
        val userReported : TextView = view.findViewById(R.id.reportedUsername)
        val briefReason : TextView = view.findViewById(R.id.brieflyReason)
        val report  = reportList[position]

        userWhoReports.text = report.userWhoReports
        userReported.text = report.reportedUser
        var reasonBrief: String
        if (report.reason.length > 50){
            reasonBrief = report.reason.substring(0, 50)
            reasonBrief += "..."
        }
        else reasonBrief = report.reason

        briefReason.text = reasonBrief

        return view
    }
}