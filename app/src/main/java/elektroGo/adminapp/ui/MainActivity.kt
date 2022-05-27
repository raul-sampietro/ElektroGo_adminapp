package elektroGo.adminapp.ui

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import elektroGo.adminapp.R
import elektroGo.adminapp.databinding.ActivityMainBinding
import elektroGo.adminapp.ui.driversConfirmation.DriversListFragment
import elektroGo.adminapp.ui.reportList.ReportListFragment
import elektroGo.adminapp.ui.vehicleConfirmation.VehicleListFragment

/**
 * @brief La classe MainActivity incorpora el menú principal i permet visualitzar els fragments de les funcionalitats principals d'ElektroGo.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    //Configuració dels events clic
    private val mOnNavigationItemSelectedListener = NavigationBarView.OnItemSelectedListener { item ->
        when (item.itemId) {
            R.id.viewReportListFragment -> {
                toolbar.title = "Llistat de denuncies"
                val llistatReports = ReportListFragment()
                openFragment(llistatReports)
                return@OnItemSelectedListener true
            }
            R.id.driversList -> {
                toolbar.title = "Llistat de conductors"
                //linia que havia escrit la Marina
                val llistatConductors = DriversListFragment()
                openFragment(llistatConductors)
                return@OnItemSelectedListener true
            }
            R.id.vehicleListFragment -> {
                toolbar.title = "Llistat de vehicles"
                val llistatVehicles = VehicleListFragment()
                openFragment(llistatVehicles)
                return@OnItemSelectedListener true
            }
        }
        false
    }

    //Inicialització de la barra superior
    private lateinit var toolbar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = supportActionBar!!
        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigation.setOnItemSelectedListener(mOnNavigationItemSelectedListener)

        //Fem que la funcionalitat que se selecciona per defecte en obrir l'app sigui el mapa
        //Si es ve de la vista de VehicleList, el fragment seleccionat és el perfil
        if (intent.getStringExtra("origin").isNullOrBlank())
            bottomNavigation.selectedItemId = R.id.viewReportListFragment
        else if (intent.getStringExtra("origin").equals("vehicleList"))
            bottomNavigation.selectedItemId = R.id.driversList
    }

    /**
     * @brief Metode per obrir un fragment.
     * @param fragment Fragment que es vol obrir.
     * @pre El fragment passat per paràmetre existeix.
     * @post Es carrega el fragment i es mostra al main container.
     */
    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}