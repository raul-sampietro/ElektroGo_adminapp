package elektroGo.adminapp.ui.reports

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import elektroGo.adminapp.R

class ViewReportListFragment : Fragment() {

    companion object {
        fun newInstance() = ViewReportListFragment()
    }

    private lateinit var viewModel: ViewReportListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.view_report_list_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ViewReportListViewModel::class.java]
    }

}