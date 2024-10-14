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

import cl.isisur.basedatosfirebase2022.Clases.Producto;


public class MainActivity extends AppCompatActivity {



    EditText eTNombre,eTEditorial;
    Button bTBoton, btListar;
    


    ListView lvListadoProductos;
    private List<Producto> listProducto = new ArrayList<Producto>();
    private List<String> ListLibroNombre = new ArrayList();

    ArrayAdapter<String> arrayAdapterString;
    ArrayAdapter<Producto> arrayAdapterProducto;


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;





    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTNombre=findViewById(R.id.eTNombre);
        eTEditorial=findViewById(R.id.eTEditorial);
        bTBoton=findViewById(R.id.bTAgregar);
        btListar=findViewById(R.id.bTLista);
        lvListadoProductos=findViewById(R.id.lvListado);

        inicializarFireBase();
        listarDatos();

        Intent intent = new Intent(this,MainLista.class);



        bTBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Producto producto = new Producto();
                //libro.setIdAutor("11111");
                producto.setIdAutor(UUID.randomUUID().toString());
                producto.setNombre(eTNombre.getText().toString());
                producto.setPrecio(eTEditorial.getText().toString());
                databaseReference.child("Libro").child(producto.getIdAutor()).setValue(producto);


            }
        });

        btListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(intent);

            }
        });






    }

    private void listarDatos() {
        databaseReference.child("Libro").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listProducto.clear();
                for (DataSnapshot objs : snapshot.getChildren()){
                    Producto li =objs.getValue(Producto.class);
                    listProducto.add(li);
                    ListLibroNombre.add(""+li.getNombre()+" "+li.getPrecio());
                    arrayAdapterString =new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,ListLibroNombre);
                    lvListadoProductos.setAdapter(arrayAdapterString);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    private void inicializarFireBase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference();
    }

}