package elektroGo.adminapp.ui.reports

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import elektroGo.adminapp.R
import elektroGo.adminapp.databinding.ActivityReportListBinding
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
            intent.putExtra("origin", "vehicleList")
            startActivity(intent)
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.show(fragment)
        transaction.commit()
    }
}