package elektroGo.adminapp.ui.reportList

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import elektroGo.adminapp.R
import elektroGo.adminapp.ui.MainActivity

class ReportListActivity : AppCompatActivity() {

    private val reportListFragment = ViewReportListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_list)
        loadFragment(reportListFragment)
    }

    override fun onBackPressed() {
        if (onBackPressedDispatcher.hasEnabledCallbacks()) {
            super.onBackPressed()
        } else {
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("origin", "reportList")
            startActivity(intent)
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        transaction.commit()
    }
}