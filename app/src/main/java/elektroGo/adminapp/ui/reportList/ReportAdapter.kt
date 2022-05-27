package elektroGo.adminapp.ui.reportList

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import elektroGo.adminapp.R
import elektroGo.adminapp.model.Reports

class ReportAdapter (private val context: Activity, private val reportList: ArrayList<Reports>): ArrayAdapter<Reports>(context, R.layout.report_list_fragment, reportList) {

    private lateinit var viewModel: ReportListViewModel

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.report_item, null)

        val userWhoReports : TextView = view.findViewById(R.id.Username)
        val userReported : TextView = view.findViewById(R.id.reportedUsername)
        val briefReason : TextView = view.findViewById(R.id.brieflyReason)
        val showMore: Button = view.findViewById(R.id.viewMoreButton)
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

        showMore.setOnClickListener {
            //Quan es clica sobre un view more s'obra l'activity amb més info
            val i = Intent(context, DetailsReportActivity::class.java)
            i.putExtra("userWhoReports", report.userWhoReports)
            i.putExtra("userReported", report.reportedUser)
            i.putExtra("reason", report.reason)
            view.context.startActivity(i)
        }
        return view
    }
}