package cl.paul.exament4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapLongClickListener, GoogleMap.OnMapClickListener {

    EditText txtLatitud,txtLongitud;
    GoogleMap Map;

    DatabaseReference mDatabase;
    Button button3;

    @Override




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        txtLatitud=findViewById(R.id.txtLatitud);
        txtLongitud=findViewById(R.id.txtLongitud);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        button3 =(Button) findViewById(R.id.button3);
        Intent intent =new Intent(this, MainActivity4.class);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        Map=googleMap;
        this.Map.setOnMapClickListener(this);
        this.Map.setOnMapLongClickListener(this);

        LatLng chile = new LatLng(-36.590859,-72.0891116);

        Map.addMarker(new MarkerOptions().position(chile).title("chile"));
        Map.moveCamera(CameraUpdateFactory.newLatLng(chile));


    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {



        txtLatitud.setText(""+ latLng.latitude);
        txtLongitud.setText(""+ latLng.longitude);
        mDatabase.child("Direcion").push().child("cordenadas").setValue(latLng);

    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {
        txtLatitud.setText(""+ latLng.latitude);
        txtLongitud.setText(""+ latLng.longitude);
        MarkerOptions markerOptions = new MarkerOptions().position(latLng).title("Nuevo marcador");
        Map.addMarker(markerOptions);
        mDatabase.child("Direcion").push().child("cordenadas").setValue(latLng);

    }






}