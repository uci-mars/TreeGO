package com.mmm.treego;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.content.res.Resources;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.MapStyleOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final String TAG = MapsActivity.class.getSimpleName();


    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        mtextView = (TextView) findViewById(R.id.textView);
        mRef = new Firebase("..........................LINK..............................");  // DataBase Profile Link
        mbutton = (Button) findViewById(R.id.button);
        mbutton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {

                mRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String v = dataSnapshot.getValue(String.class);
                        mtextView.setText(v);
                    }
                    @Override
                    public void onCancelled(FirebaseError firebaseError) {

                    }
                });}});
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

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style_json));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }

        // Add a marker in Sydney and move the camera
        LatLng botanic_gardens = new LatLng(1.3138, 103.8159);
        mMap.addMarker(new MarkerOptions().position(botanic_gardens).title("You're at: Singapore Botanic Gardens"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(botanic_gardens, 16));
    }
}