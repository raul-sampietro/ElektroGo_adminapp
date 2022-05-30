package elektroGo.adminapp.ui.vehicleConfirmation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import elektroGo.adminapp.R

class DetailsVehicleActivity : AppCompatActivity() {
    private lateinit var viewModel: VehicleListViewModel

    private lateinit var licensePlateValue: TextView

    private lateinit var branchValue: TextView

    private lateinit var modelValue : TextView

    private lateinit var seatsValue : TextView

    private lateinit var drivingRangeValue : TextView

    private lateinit var fabricationYear : TextView

    private lateinit var imageView : ImageView

    private lateinit var acceptButton : Button

    private lateinit var rejectButton : Button

    lateinit var toolbar2 : androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_vehicle)

        toolbar2  = findViewById(R.id.toolbar_main)

        toolbar2.title = "Detalls del vehicle"
        viewModel = VehicleListViewModel()
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
        imageView.setImageResource(R.drawable.ic_baseline_image_24)


        Picasso.get().load("http://10.4.41.58:8080/vehicles/${licensePlateValue.text}/image").into(imageView)

        acceptButton.setOnClickListener {
            var status = viewModel.acceptVehicle(intent.getStringExtra("licensePlate")!!)
            if (status != 200) Toast.makeText(this, "No s'ha trobat el vehicle.", Toast.LENGTH_LONG).show()
            else {
                Toast.makeText(this, "El vehícle ha estat acceptat.", Toast.LENGTH_LONG).show()
                finish()
            }
        }

        rejectButton.setOnClickListener {
            var status = viewModel.rejectVehicle(intent.getStringExtra("licensePlate")!!)
            if (status != 200) Toast.makeText(this, "No s'ha trobat el vehicle.", Toast.LENGTH_LONG).show()
            else {
                Toast.makeText(this, "El vehícle ha estat eliminat.", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }
}