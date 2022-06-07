package co.edu.unipilito;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;





public class MainActivity4 extends AppCompatActivity {

    private MaterialDatabaseHelper db;
    Button btLocalizacion;
    public String Direccion, material1, kg, cm, nombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        db = new MaterialDatabaseHelper(this);
        EditText descripcion = (EditText) findViewById(R.id.Descripcion);
        EditText editmaterial = (EditText) findViewById(R.id.Material);
        EditText peso = (EditText) findViewById(R.id.Peso);
        EditText tamano = (EditText) findViewById(R.id.Tamaño);
        EditText dir = (EditText) findViewById(R.id.Direccion);
        btLocalizacion = (Button) findViewById(R.id.localizacion2);
        material1 = editmaterial.getText().toString();
        nombre = descripcion.getText().toString();
        kg = peso.getText().toString();
        cm = tamano.getText().toString();
        Direccion = dir.getText().toString();
        db.initData();
        addData();
    }

    public void addData(){
        btLocalizacion.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Material material = new Material(material1, nombre, kg, cm, Direccion);
                        material.setMaterial(material1);
                        material.setDescripcion(nombre);
                        material.setPeso(kg);
                        material.setTamano(cm);
                        material.setDireccion(Direccion);
                        boolean isInserted;
                        if (db.insertMaterialData(material)) isInserted = true;
                        else isInserted = false;
                        if (isInserted) {
                            Toast.makeText(MainActivity4.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity4.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );
    }
}