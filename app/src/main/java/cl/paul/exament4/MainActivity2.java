package cl.paul.exament4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity2 extends AppCompatActivity {

    TextInputEditText editText_nameOnCard, editText_cardNumber, editText_cvv, editText_domicilio, editText_region, editText_comuna, editText_expiryDate;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button2 = findViewById(R.id.button2);
        editText_nameOnCard = findViewById(R.id.editText_nameOnCard);
        editText_cardNumber = findViewById(R.id.editText_cardNumber);
        editText_cvv = findViewById(R.id.editText_cvv);
        editText_domicilio = findViewById(R.id.editText_domicilio);
        editText_region = findViewById(R.id.editText_region);
        editText_comuna = findViewById(R.id.editText_comuna);
        editText_expiryDate = findViewById(R.id.editText_expiryDate);

        Intent intent = new Intent(this, MainActivity3.class);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los valores de los campos de texto
                String nombreTarjeta = editText_nameOnCard.getText().toString();
                String numeroTarjeta = editText_cardNumber.getText().toString();
                String cvv = editText_cvv.getText().toString();
                String domicilio = editText_domicilio.getText().toString();
                String region = editText_region.getText().toString();
                String comuna = editText_comuna.getText().toString();
                String expiryDate = editText_expiryDate.getText().toString();

                // Guardar los valores en Firebase
                FirebaseHelper firebaseHelper = new FirebaseHelper();
                firebaseHelper.guardarInformacionPago(nombreTarjeta, numeroTarjeta, cvv, domicilio, region, comuna, expiryDate);

                // Iniciar la siguiente actividad
                startActivity(intent);
            }
        });
    }
}
