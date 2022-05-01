package elektroGo.adminapp.ui.reportList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import elektroGo.adminapp.R

class DetailsReportActivity : AppCompatActivity() {
    private lateinit var userWhoReports: TextView

    private lateinit var reportedUser: TextView

    private lateinit var reason: TextView

    private lateinit var solveButton: Button

    private lateinit var deleteUser: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_report)

        userWhoReports = findViewById(R.id.Username)
        reportedUser = findViewById(R.id.reportedUsername)
        reason = findViewById(R.id.brieflyReason)
        solveButton = findViewById(R.id.solveButton)
        deleteUser = findViewById(R.id.deleteUserButton)

        //Assignem els texts corresponents
        userWhoReports.text = intent.getStringExtra("userWhoReports")
        reportedUser.text = intent.getStringExtra("userReported")
        reason.text = intent.getStringExtra("reason")

        solveButton.setOnClickListener{
            //TODO: FER LA CRIDA AMB BACKEND, CONTROL D'ERRORS I FER UN TOAST
            finish()
        }

        deleteUser.setOnClickListener{
            //TODO: FER LA CRIDA AMB BACKEND, CONTROL D'ERRORS I FER UN TOAST
            finish()
        }

    }
}