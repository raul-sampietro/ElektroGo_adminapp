package elektroGo.adminapp.ui.reportList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import elektroGo.adminapp.R
import elektroGo.adminapp.controller.AdminAppController
import kotlinx.coroutines.runBlocking

class DetailsReportActivity : AppCompatActivity() {
    private lateinit var userWhoReports: TextView

    private lateinit var reportedUser: TextView

    private lateinit var reason: TextView

    private lateinit var solveButton: Button

    private lateinit var deleteUser: Button

    lateinit var toolbar2 : androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_report)

        toolbar2  = findViewById(R.id.toolbar_main)

        toolbar2.title = "Detalls de la denuncia"
        userWhoReports = findViewById(R.id.Username)
        reportedUser = findViewById(R.id.reportedUsername)
        reason = findViewById(R.id.brieflyReason)
        solveButton = findViewById(R.id.acceptButton2)
        deleteUser = findViewById(R.id.denyButton)

        //Assignem els texts corresponents
        userWhoReports.text = intent.getStringExtra("userWhoReports")
        reportedUser.text = intent.getStringExtra("userReported")
        reason.text = intent.getStringExtra("reason")

        solveButton.setOnClickListener{

            var status = -1
            val uWhoReports = intent.getStringExtra("userWhoReports")
            val uReported = intent.getStringExtra("userReported")
            try {
                if ((uWhoReports != null) and (uReported != null)) status = runBlocking { AdminAppController.deleteReport(uWhoReports!!, uReported!!) }
            }
            catch (e: Exception) {
                Toast.makeText(this, "No s'ha pogut connectar amb el servidor.", Toast.LENGTH_LONG).show()
                status = -2
            }

            if (status == -1) Toast.makeText(this, "No s'ha trobat la denúncia.", Toast.LENGTH_LONG).show()
            else if (status == 200) Toast.makeText(this, "La denúncia s'ha eliminat.", Toast.LENGTH_LONG).show()
            else if (status != -2) Toast.makeText(this, "Hi ha hagut un error. ERROR: $status", Toast.LENGTH_LONG).show()

            finish()
        }

        deleteUser.setOnClickListener{
            //TODO: FER LA CRIDA AMB BACKEND, CONTROL D'ERRORS I FER UN TOAST

            var status = -1
            val userToDelete = intent.getStringExtra("userReported")
            try {
                if (userToDelete != null) status = runBlocking { AdminAppController.deleteUser(userToDelete) }
            }
            catch (e: Exception) {
                Toast.makeText(this, "No s'ha pogut connectar amb el servidor.", Toast.LENGTH_LONG).show()
                status = -2
            }

            if (status == -1) Toast.makeText(this, "No s'ha pogut trobar l'usuari reportat.", Toast.LENGTH_LONG).show()
            else if (status == 200) Toast.makeText(this, "L'usuari $userToDelete ha estat eliminat.", Toast.LENGTH_LONG).show()
            else if (status != -2) Toast.makeText(this, "Hi ha hagut un error. ERROR: $status", Toast.LENGTH_LONG).show()

            finish()
        }
    }

}