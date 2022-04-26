package elektroGo.adminapp.ui.reports

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import elektroGo.adminapp.R

class ViewReportList : Fragment() {

    companion object {
        fun newInstance() = ViewReportList()
    }

    private lateinit var viewModel: ViewReportListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.view_report_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ViewReportListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}