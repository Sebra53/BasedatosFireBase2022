package cl.isisur.basedatosfirebase2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cl.isisur.basedatosfirebase2022.Clases.Cliente;
import cl.isisur.basedatosfirebase2022.Clases.Producto;


public class MainActivity extends AppCompatActivity {



    EditText eTNombre,eTEditorial,eTocupacion;
    Button bTBoton, btListar;
    





    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;





    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTNombre=findViewById(R.id.eTNombre);
        eTEditorial=findViewById(R.id.eTEditorial);
        eTocupacion = findViewById(R.id.eTocupacion);
        bTBoton=findViewById(R.id.bTAgregar);
        btListar=findViewById(R.id.bTLista);


        inicializarFireBase();


        Intent intent = new Intent(this,MainLista.class);



        bTBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cliente cliente = new Cliente();
                //libro.setIdAutor("11111");
                cliente.setIdCliente(UUID.randomUUID().toString());
                cliente.setNombreC(eTNombre.getText().toString());
                cliente.setrut(eTEditorial.getText().toString());
                cliente.setOcupacion(eTocupacion.getText().toString());
                databaseReference.child("Cliente").child(cliente.getIdCliente()).setValue(cliente);


            }
        });

        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent);

            }
        });






    }




    private void inicializarFireBase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference();
    }

}