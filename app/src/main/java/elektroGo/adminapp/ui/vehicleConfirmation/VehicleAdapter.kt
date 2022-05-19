package elektroGo.adminapp.ui.vehicleConfirmation

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.squareup.picasso.Picasso
import elektroGo.adminapp.R
import elektroGo.adminapp.model.Vehicle
import elektroGo.adminapp.ui.reportList.DetailsReportActivity
import kotlinx.coroutines.runBlocking

class VehicleAdapter(private val context : Activity, private val vehicleList : ArrayList<Vehicle>)
    : ArrayAdapter<Vehicle>(context, R.layout.vehicle_list_fragment, vehicleList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.vehicle_list_item, null)

        val numberPlate : TextView = view.findViewById(R.id.listNumberPlate)
        val brand : TextView = view.findViewById(R.id.listBrand)
        val model : TextView = view.findViewById(R.id.listModel)
        val fabricationYear : TextView = view.findViewById(R.id.listFabricationYear)
        val seats : TextView = view.findViewById(R.id.listSeats)
        val showMore: Button = view.findViewById(R.id.viewMoreButton)

        val v = vehicleList[position]
        val imageViewPhoto : ImageView =view.findViewById(R.id.vehicleImage)
        val nPlate = v.numberPlate
        //TODO: Carregar les imatges de cada vehicle
        Picasso.get().load("http://10.4.41.58:8080/vehicles/$nPlate/image").into(imageViewPhoto)
        numberPlate.text = nPlate
        brand.text = v.brand
        model.text = v.model
        fabricationYear.text = v.fabricationYear.toString()
        seats.text = v.seats.toString()

        showMore.setOnClickListener {
            //Quan es clica sobre un view more s'obra l'activity amb més info
            val i = Intent(context, DetailsVehicleActivity::class.java)
            i.putExtra("licensePlate", v.numberPlate)
            i.putExtra("brand", v.brand)
            i.putExtra("model", v.model)
            i.putExtra("fabricationYear", v.fabricationYear.toString())
            i.putExtra("seats", v.seats.toString())
            i.putExtra("drivingRange", v.drivingRange.toString())
            view.context.startActivity(i)
        }
        return view
    }
}