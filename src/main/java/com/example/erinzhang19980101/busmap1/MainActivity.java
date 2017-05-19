package com.example.erinzhang19980101.busmap1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

//import com.mapbox.mapboxandroiddemo.R;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapboxMapOptions;
import com.mapbox.mapboxsdk.constants.Style;
import com.mapbox.mapboxsdk.camera.CameraPosition;



public class MainActivity extends AppCompatActivity {

    private MapView mapView;
    private FloatingActionButton busButton;
    private MapboxMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Mapbox access token is configured here. This needs to be called either in your application
        // object or in the same activity which contains the mapview.
        Mapbox.getInstance(this, getString(R.string.access_token));

        busButton = (FloatingActionButton) findViewById(R.id.bus_icon);


        // This contains the MapView in XML and needs to be called after the account manager
        setContentView(R.layout.activity_main);

        final LatLng latlng1 = new LatLng(38.825207, -77.095810);

        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {

                map = mapboxMap;

                map.addMarker(new MarkerOptions()
                        .position(latlng1)
                        .title("Hello World!")
                        .snippet("Welcome to my marker."));

                map.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
                            .target(latlng1)
                            .zoom(14)
                            .build()));


            }

        });

    }
//        class BusClickListener implements View.OnClickListener{
//            @Override
//            public void onClick(View view) {
//                final LatLng latlng1 = new LatLng(38.825207, -77.095810);
//                if (mapBox != null) {
//                    mapBox.addMarker(new MarkerOptions()
//                            .position(latlng1)
//                            .title("Hello World!")
//                            .snippet("Welcome to my marker."));
//                    mapBox.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder()
//                            .target(latlng1)
//                            .zoom(14)
//                            .build()));
//                }
//            }
//        }




    // Add the mapView lifecycle to the activity's lifecycle methods
    @Override
    protected void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}

