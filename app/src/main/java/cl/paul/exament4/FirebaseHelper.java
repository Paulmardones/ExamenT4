package cl.paul.exament4;



import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseHelper {

    private DatabaseReference databaseReference;

    public FirebaseHelper() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("InformacionPago");
    }

    public void guardarInformacionPago(String nombreTarjeta, String numeroTarjeta, String cvv, String domicilio, String region, String comuna, String expiryDate) {
        databaseReference.child("NombreTarjeta").setValue(nombreTarjeta);
        databaseReference.child("NumeroTarjeta").setValue(numeroTarjeta);
        databaseReference.child("CVV").setValue(cvv);
        databaseReference.child("Domicilio").setValue(domicilio);
        databaseReference.child("Region").setValue(region);
        databaseReference.child("Comuna").setValue(comuna);
        databaseReference.child("ExpiryDate").setValue(expiryDate);
    }
}
