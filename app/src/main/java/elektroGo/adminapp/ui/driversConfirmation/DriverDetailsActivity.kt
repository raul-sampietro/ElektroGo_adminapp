package elektroGo.adminapp.ui.driversConfirmation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import elektroGo.adminapp.R

class DriverDetailsActivity : AppCompatActivity() {
    private lateinit var username : TextView

    private lateinit var acceptButton : Button

    private lateinit var denyButton: Button

    private lateinit var frontImage : ImageView

    private lateinit var reverseImage : ImageView

    lateinit var toolbar2 : androidx.appcompat.widget.Toolbar


    private val viewModel = DriverViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_details)

        toolbar2  = findViewById(R.id.toolbar_main)

        toolbar2.title = "Detalls del conductor"

        username = findViewById(R.id.UsernameValue)
        acceptButton = findViewById(R.id.acceptButton2)
        denyButton = findViewById(R.id.denyButton)
        frontImage = findViewById(R.id.fronatlImage)
        reverseImage = findViewById(R.id.backImage)

        username.text = intent.getStringExtra("username")

        Picasso.get().load("http://10.4.41.58:8080/drivers/${username.text}/imageFront").into(frontImage)
        Picasso.get().load("http://10.4.41.58:8080/drivers/${username.text}/imageBack").into(reverseImage)


        acceptButton.setOnClickListener{
            val statusCode = viewModel.verifyUser(username.text.toString())
            if (statusCode == 200){
                Toast.makeText(this, "El driver ha estat verificat correctament", Toast.LENGTH_LONG).show()
                finish()
            }
            else if (statusCode == 432){
                Toast.makeText(this, "No s'ha pogut trobar el driver.", Toast.LENGTH_LONG).show()
            }
            else if (statusCode == 500){
                Toast.makeText(this, "Hi ha hagut un problema amb el servidor. Prova-ho de nou més tard.", Toast.LENGTH_LONG).show()
            }
        }

        denyButton.setOnClickListener{
            val statusCode = viewModel.denyUser(username.text.toString())
            if (statusCode == 200){
                Toast.makeText(this, "El driver ha estat rebutjat correctament", Toast.LENGTH_LONG).show()
                finish()
            }
            else if (statusCode == 432){
                Toast.makeText(this, "No s'ha pogut trobar el driver.", Toast.LENGTH_LONG).show()
            }
            else if (statusCode == 500){
                Toast.makeText(this, "Hi ha hagut un problema amb el servidor. Prova-ho de nou més tard.", Toast.LENGTH_LONG).show()
            }
        }
    }
}