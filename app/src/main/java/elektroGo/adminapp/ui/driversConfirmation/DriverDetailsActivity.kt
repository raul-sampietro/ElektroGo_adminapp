package elektroGo.adminapp.ui.driversConfirmation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import elektroGo.adminapp.R

class DriverDetailsActivity : AppCompatActivity() {
    private lateinit var username : TextView

    private lateinit var acceptButton : Button

    private lateinit var denyButton: Button

    private lateinit var frontImage : ImageView

    private lateinit var reverseImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_details)

        username = findViewById(R.id.UsernameValue)
        acceptButton = findViewById(R.id.acceptButton2)
        denyButton = findViewById(R.id.denyButton)
        frontImage = findViewById(R.id.fronatlImage)
        reverseImage = findViewById(R.id.backImage)

        username.text = intent.getStringExtra("username")

        //Carregar les dues imatges

        acceptButton.setOnClickListener{

        }

        denyButton.setOnClickListener{

        }
    }
}