package co.edu.unipilito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity5 extends AppCompatActivity {

    public static final  String EXTRA_DRINKID="drinkId";
    private SQLiteDatabase db;
    private Cursor cursor;
    public String Direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        int drinkId = (Integer)getIntent().getExtras().get(EXTRA_DRINKID);

        SQLiteOpenHelper materialesDatabaseHelper=new MaterialDatabaseHelper(this);
        try {


            db = materialesDatabaseHelper.getReadableDatabase();
            cursor = db.query("Registro",
                    new String[]{"MATERIAL", "DESCRIPCION","PESO","TAMANO","DIRECCION"},
                    "_id= ?",
                    new String[]{Integer.toString(drinkId)}, null, null, null, null);
            if(cursor.moveToFirst()){
                String nameText=cursor.getString(0);
                String descripcionText=cursor.getString(1);
                String pesoText=cursor.getString(2);
                String tamanoText=cursor.getString(3);
                String direccionText=cursor.getString(4);
                TextView name = (TextView) findViewById(R.id.textView5);
                name.setText(nameText);

                TextView descripcionn = (TextView) findViewById(R.id.textView6);
                descripcionn.setText(descripcionText);

                TextView peso = (TextView) findViewById(R.id.textView7);
                peso.setText(pesoText);

                TextView tamano = (TextView) findViewById(R.id.textView8);
                tamano.setText(tamanoText);

                Direccion=direccionText;




            }

        }
        catch (SQLiteException e){
            Toast toast=Toast.makeText(this, "Base de datos no disponible", Toast.LENGTH_LONG);
            toast.show();
        }

    }


    public void OnSendMaps2(View view) {
        Uri.Builder builder=new Uri.Builder();
        builder.scheme("https")
                .authority("www.google.com")
                .appendPath("maps")
                .appendPath("dir")
                .appendPath("")
                .appendQueryParameter("api","1")
        .appendQueryParameter("destination",Direccion);
        String url=builder.build().toString();
        Log.d("Direccion",url);
        Intent intent=new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);

    }
}