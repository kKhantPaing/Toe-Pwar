package a2017.group19.samaung.samsungproject.Map;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import a2017.group19.samaung.samsungproject.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        index = getIntent().getIntExtra("id", 0);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng sydney = null;
        // Add a marker in Sydney and move the camera
        switch (index) {
            case 0:
                sydney = new LatLng(16.800710, 96.187163);
                break;
            case 1:
                sydney = new LatLng(17.104690, 96.036807);
                break;
            case 2:
                sydney = new LatLng(16.883533, 96.098333);
                break;
            case 3:
                sydney = new LatLng(16.863189, 96.141856);
                break;
            case 4:
                sydney = new LatLng(16.868634, 96.111440);
                break;
            case 5:
                sydney = new LatLng(16.870927, 96.140524);
                break;
            case 6:
                sydney = new LatLng(16.863189, 96.104644);
                break;
            case 7:
                sydney = new LatLng(16.892347, 96.183686);
                break;
            case 8:
                sydney = new LatLng(16.806213, 96.154551);
                break;
            case 9:
                sydney = new LatLng(16.96433520, 96.1266490);
                break;
            case 10:
                sydney = new LatLng(16.8942120, 96.1215620);
                break;
            case 11:
                sydney = new LatLng(16.80655840, 96.1725330);
                break;
            case 12:
                sydney = new LatLng(16.8907040, 96.1147140);
                break;
        }
        mMap.addMarker(new MarkerOptions().position(sydney));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
