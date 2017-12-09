package com.songle.sgl.songle

// Caution: android.location.LocationListener is the wrong LocationListener
// import android.location.LocationListener
//
// com.google.android.gms.location.LocationListener is the right LocationListener

// Requires Google Maps Android API Utility Library

// Use data binding to import identifiers from the XML layouts
//import org.jetbrains.anko.design.snackbar
//import org.jetbrains.anko.toast
//import org.jetbrains.anko.noButton
import android.Manifest
import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.location.Location
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationListener
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.data.kml.KmlLayer
import kotlinx.android.synthetic.main.activity_maps.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.yesButton
import java.io.File
import java.io.FileInputStream

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private lateinit var mMap: GoogleMap
    private val filename = "points-of-interest.kml"
    private lateinit var mGoogleApiClient: GoogleApiClient
    private val permissionsRequestAccessFineLocation = 1
    private var mLastLocation : Location? = null
    private val universityMap = UniversityMap(this)
    private var currentPOI = universityMap.pointsOfInterest[0]

    private val tag = "UniversityMapActivity"
    private var receiver = NetworkReceiver()
  /*  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }
    private val tag = "UniversityMapActivity" */
  private inner class NetworkReceiver : BroadcastReceiver() {
      override fun onReceive(context: Context, intent: Intent) {
          val connMgr =
                  context.getSystemService(Context.CONNECTIVITY_SERVICE)
                          as ConnectivityManager
          val networkInfo = connMgr.activeNetworkInfo
          if (networkPref == wifi &&
                  networkInfo?.type == ConnectivityManager.TYPE_WIFI) {
// Wi´Fi is connected, so use Wi´Fi
          } else if (networkPref == any && networkInfo != null) {
// Have a network connection and permission, so use data
          } else {
// No Wi´Fi and no permission, or no network connection
          }
      }
  }
    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        println(">>>>> [$tag] entering onCreate ")

        setContentView(R.layout.activity_maps)

        // Create an instance of GoogleAPIClient.
        mGoogleApiClient = GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build()


// Register BroadcastReceiver to track connection changes.
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        this.registerReceiver(receiver, filter)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)


        println(">>>>> [$tag] exiting onCreate, mGoogleApiClient==$mGoogleApiClient")

    }
    val PREFS_FILE = "PrefsFile"
    override fun onStart() {
        super.onStart()
// Restore preferences
        val settings = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE)
        println(">>>>> [$tag] entering onStart, connecting to Google API client")
        mGoogleApiClient.connect()

        println(">>>>> [$tag] onStart, writing map contents to file $filename")
        universityMap.writeToFile(filename)
        println(">>>>> [$tag] exiting onStart, written map contents to file $filename")
    }

    override fun onStop() {
        super.onStop()
        if (mGoogleApiClient.isConnected) {
            println(">>>>> [$tag] onStop, disconnecting from Google API client")
            mGoogleApiClient.disconnect()
        }
    }

    private fun createLocationRequest() {
        // Set the parameters for the location request
        val mLocationRequest = LocationRequest()
        mLocationRequest.interval = 5000 // preferably every 5 seconds
        mLocationRequest.fastestInterval = 1000 // at most every second
        mLocationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY

        // Can we access the user’s current location?
        val permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(
                    mGoogleApiClient, mLocationRequest, this)
        }
    }

    private fun displayPOI(poi: PointOfInterest) : String {
        return if (poi.name == "") {
            universityMap.descriptionDict[poi.type] ?: ""
        } else {
            poi.name
        }
    }

    override fun onLocationChanged(current : Location?) {
        if (current == null) {
            println(">>>>> [$tag] [onLocationChanged] Location unknown")
        } else {
            println(""">>>>> [$tag] [onLocationChanged] Lat/long now
            (${current.latitude},
             ${current.longitude})"""
            )

            // Do something with current location
            val poi = universityMap.nearestPOI(longitude = current.longitude, latitude = current.latitude)
            if (poi.id != currentPOI.id) {
                currentPOI = poi
                println(">>>>> [$tag] onLocationChanged : nearest POI is ${poi.name}, ${poi.distanceInMetres}m away")
                val dist = "%.1f".format(poi.distanceInMetres)

                val desc = displayPOI(poi)
                if (desc != "") {
                    longSnackbar(myCoordinatorLayout, "Near $desc.  Distance ${dist}m.", "Details") {
                        alert(poi.showAddress()) {
                            yesButton { }
                            //noButton { }
                        }.show()
                    }
                }
            }
        }
    }

    override fun onConnectionSuspended(flag : Int) {
        println(" >>>> [$tag] onConnectionSuspended")
    }

    override fun onConnectionFailed(result : ConnectionResult) {
        // An unresolvable error has occurred and a connection to Google APIs
        // could not be established. Display an error message, or handle
        // the failure silently
        println(" >>>> [$tag] onConnectionFailed")
    }

    override fun onConnected(connectionHint : Bundle?) {
        try {
            createLocationRequest()
        }
        catch (ise : IllegalStateException) {
            println(">>>>> [$tag] IllegalStateException thrown [onConnected]")
        }
        // Can we access the user's current location?
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED) {
            val api = LocationServices.FusedLocationApi
            // Caution: getLastLocation can return null
            mLastLocation = api.getLastLocation(mGoogleApiClient)
            if (mLastLocation == null) {
                println(">>>>> [$tag] Warning: mLastLocation is null")
                snackbar(myCoordinatorLayout, "Warning: Unable to get current location")
            }
        } else {
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    permissionsRequestAccessFineLocation)
        }
    }

    /* Manipulates the map once available.

       Using a too-recent version of Google Play Services can cause an
       "App won't run unless you update Google Play Services" error in the emulator.
       Consider using version 10.0.0 of play-services-maps and play-services-location
       even though these are not the latest versions.
    */
    override fun onMapReady(googleMap: GoogleMap) {
        println(">>>>> [$tag] onMapReady")
        mMap = googleMap

        // Move and zoom the camera
        val centre = LatLng(55.944424999999995, -3.188396)
        mMap.addMarker(MarkerOptions().position(centre).title("Marker at centre"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centre, 17F))

        try {
            // Visualise current position with a small blue circle
            mMap.isMyLocationEnabled = true

            // Add "My location" button to the user interface
            mMap.uiSettings.isMyLocationButtonEnabled = true

            // Add [+] and [-] zoom controls
            mMap.uiSettings.isZoomControlsEnabled = true

            mMap.uiSettings.isRotateGesturesEnabled = true
            mMap.uiSettings.isCompassEnabled = true



        } catch (se : SecurityException) {
            println(">>>>> [$tag] Security exception thrown [onMapReady]")
        }

        val kmlInputStream = FileInputStream(File(this.filesDir, filename))
        val layer = KmlLayer(mMap, kmlInputStream, this)
        layer.addLayerToMap()
    }
    fun logExecution(func: () -> Unit) {
        Log.d("tag", "before exc")
        func()
        Log.d("tag", "after exc")
    }
    fun <T : View> Activity.bind(@IdRes res : Int) : T {
        @Suppress("UNCHECKED_CAST")
        return findViewById(res)
    }
}
