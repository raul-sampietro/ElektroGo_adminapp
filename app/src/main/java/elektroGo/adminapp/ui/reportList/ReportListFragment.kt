package elektroGo.adminapp.ui.reportList

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
import elektroGo.adminapp.model.Reports

class ReportListFragment : Fragment() {

    companion object {
        fun newInstance() = ReportListFragment()
    }

    private lateinit var viewModel: ReportListViewModel

    private lateinit var reportList: ArrayList<Reports>

    private lateinit var emptyList: TextView

    private lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.report_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        listView = view.findViewById(R.id.reportListView)
        emptyList = requireActivity().findViewById(R.id.emptyList)
        reportList = ArrayList<Reports>()

        val httpResponse = viewModel.getReports()
        if (httpResponse.first != 200){
            Toast.makeText(context, getString(R.string.GetReportsError),Toast.LENGTH_SHORT).show()
        }
        else {
            reportList = httpResponse.second
            if (reportList.size == 0) emptyList.text = resources.getString(R.string.emptyReportList)
            else emptyList.text = ""
            listView.adapter = ReportAdapter(context as Activity, reportList)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ReportListViewModel::class.java]
    }

    override fun onResume() {
        super.onResume()
        emptyList = requireActivity().findViewById(R.id.emptyList)
        reportList = ArrayList<Reports>()

        val httpResponse = viewModel.getReports()
        if (httpResponse.first != 200){
            Toast.makeText(context, getString(R.string.GetReportsError),Toast.LENGTH_SHORT).show()
        }
        else {
            reportList = httpResponse.second
            if (reportList.size == 0) emptyList.text = resources.getString(R.string.emptyReportList)
            else emptyList.text = ""
            listView.adapter = ReportAdapter(context as Activity, reportList)
        }

    }

}