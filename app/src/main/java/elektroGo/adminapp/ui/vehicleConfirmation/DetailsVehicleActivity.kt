package elektroGo.adminapp.ui.vehicleConfirmation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import elektroGo.adminapp.R

class DetailsVehicleActivity : AppCompatActivity() {
    private lateinit var licensePlateValue: TextView

    private lateinit var branchValue: TextView

    private lateinit var modelValue : TextView

    private lateinit var seatsValue : TextView

    private lateinit var drivingRangeValue : TextView

    private lateinit var fabricationYear : TextView

    private lateinit var imageView : ImageView

    private lateinit var acceptButton : Button

    private lateinit var rejectButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_vehicle)

        licensePlateValue = findViewById(R.id.licensePlateValue)
        branchValue = findViewById(R.id.branchValue)
        modelValue = findViewById(R.id.modelValue)
        seatsValue = findViewById(R.id.seatsValue)
        drivingRangeValue = findViewById(R.id.drivingRangeValue)
        fabricationYear = findViewById(R.id.fabricationYearValue)
        imageView = findViewById(R.id.imageView)
        acceptButton = findViewById(R.id.acceptButton)
        rejectButton = findViewById(R.id.declineButton)

        licensePlateValue.text = intent.getStringExtra("licensePlate")
        branchValue.text = intent.getStringExtra("brand")
        modelValue.text = intent.getStringExtra("model")
        seatsValue.text = intent.getStringExtra("seats")
        fabricationYear.text = intent.getStringExtra("fabricationYear")
        drivingRangeValue.text = intent.getStringExtra("drivingRange")


    }
}