package cl.isisur.basedatosfirebase2022;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import cl.isisur.basedatosfirebase2022.Clases.Producto;

public class MainLista extends AppCompatActivity {


    ListView lvLista;
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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_lista);

        lvLista=findViewById(R.id.LvLista);

        inicializarFireBase();
        lista();

        Intent intent2 = new Intent(this,MainActivity.class);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    private void lista() {
        databaseReference.child("producto").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listProducto.clear();
                for (DataSnapshot objs : snapshot.getChildren()){
                    Producto li =objs.getValue(Producto.class);
                    listProducto.add(li);
                    ListLibroNombre.add(""+li.getNombre()+" "+li.getPrecio());
                    arrayAdapterString =new ArrayAdapter<String>(MainLista.this, android.R.layout.simple_expandable_list_item_1,ListLibroNombre);
                    lvLista.setAdapter(arrayAdapterString);
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