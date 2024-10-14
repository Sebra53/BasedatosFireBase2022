package cl.isisur.basedatosfirebase2022;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

import cl.isisur.basedatosfirebase2022.Clases.Producto;


public class MainActivity extends AppCompatActivity {



    EditText eTNombre,eTEditorial;
    Button bTBoton, btListar;
    
    ArrayAdapter<Producto> arrayAdapterProducto;


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTNombre=findViewById(R.id.eTNombre);
        eTEditorial=findViewById(R.id.eTEditorial);
        bTBoton=findViewById(R.id.bTAgregar);
        btListar=findViewById(R.id.bTLista);



        bTBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Producto producto = new Producto();
                //libro.setIdAutor("11111");
                producto.setIdAutor(UUID.randomUUID().toString());
                producto.setNombre(eTNombre.getText().toString());
                producto.setPrecio(eTEditorial.getText().toString());
                databaseReference.child("producto").child(producto.getIdAutor()).setValue(producto);


            }
        });




    }

}