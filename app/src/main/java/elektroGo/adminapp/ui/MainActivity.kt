package elektroGo.adminapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import elektroGo.adminapp.R
import elektroGo.adminapp.ui.reportList.ReportListActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO: AQUI HAURIA D'ANAR EL FRAGMENT DEL MENU

        //TODO: Les dues linies d'abaix es podran esborrar quan tinguem el menu
        val reportListIntent = Intent(this, ReportListActivity::class.java)
        startActivity(reportListIntent)
    }
}