package ca.bcit.safetymap;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.gson.*;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.List;

import ca.bcit.safetymap.data.CrimeLocations;
import ca.bcit.safetymap.database.CrimeLocation;
import ca.bcit.safetymap.database.CrimeLocationDAO;
import ca.bcit.safetymap.database.CrimeLocationDatabase;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @NonNull
    private static final String TAG = MapsActivity.class.getName();
    String url = "https://gis.mapleridge.ca/arcgis/rest/services/OpenData/PublicSafety/MapServer/7/query?outFields=*&where=1%3D1";
    private CrimeLocationDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        database = Room.databaseBuilder(getApplicationContext(),
                CrimeLocationDatabase.class,
                "crimes").build();

    }

    private void downloadData(final String url,
                              final CrimeLocationDAO crimeLocationDAO)
    {
        if (crimeLocationDAO.count() == 0)
        {
            Ion.with(MapsActivity.this)
                    .load(url)
                    .asJsonObject()
                    .setCallback(new FutureCallback<JsonObject>()
                    {
                        @Override
                        public void onCompleted(final Exception ex,
                                                final JsonObject json)
                        {
                            if (ex != null)
                            {
                                Log.e(TAG, "Error", ex);
                            }

                            if (json != null)
                            {
                                AsyncTask.execute(new Runnable()
                                {
                                    @Override
                                    public void run()
                                    {
                                        parseJSON(json, crimeLocationDAO);
                                        updateLocations(crimeLocationDAO);
                                    }
                                });
                            }
                        }
                    });
        }
    }

    private void parseJSON(final JsonObject json,
                           final CrimeLocationDAO votingLocationDAO)
    {
        final Gson gson;
        final CrimeLocations crimeLocations;

        gson = new Gson();
        crimeLocations = gson.fromJson(json, CrimeLocations.class);

        for(CrimeLocations.Feature feature : crimeLocations.getFeatures())
        {
            final CrimeLocations.Feature.Properties properties;
            final String     category;
            final double     latitude;
            final double     longitude;
            final CrimeLocation crimeLocation;

            properties  = feature.getProperties();
            latitude    = Double.parseDouble(properties.getLatitude());
            longitude   = Double.parseDouble(properties.getLongitude());
            crimeLocation = new CrimeLocation();
            crimeLocation.setLatitude(latitude);
            crimeLocation.setLongitude(longitude);

            CrimeLocationDAO.insertAll(crimeLocation);
        }
    }

    private void updateLocations(final CrimeLocationDAO votingLocationDAO)
    {
        final List<CrimeLocation> locations = votingLocationDAO.getAll();

        runOnUiThread(new Runnable()
        {
            public void run()
            {
                for(final CrimeLocation location : locations)
                {
                    final double latitude;
                    final double longitude;
                    final String name;

                    latitude  = 0.0;
                    longitude = 0.0;
                    name       = "x";
                    addPoint(latitude, longitude, name);
                }
            }
        });
    }

    private void addPoint(final double latitude, final double longitude, final String title)
    {
        final LatLng location = new LatLng(latitude, longitude);

        mMap.addMarker(new MarkerOptions().position(location).title(title));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
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

        final CrimeLocationDAO crimeLocationDAO;

        crimeLocationDAO = database.crimeLocationDao();

        mMap = googleMap;

        AsyncTask.execute(new Runnable()
        {
            @Override
            public void run()
            {
                downloadData("https://gis.mapleridge.ca/arcgis/rest/services/OpenData/PublicSafety/MapServer/7/query?outFields=*&where=1%3D1", crimeLocationDAO);
            }
        });
    }


}
