package co.edu.unipilito;

import static co.edu.unipilito.MaterialDatabaseHelper.COL_1;
import static co.edu.unipilito.MaterialDatabaseHelper.COL_2;
import static co.edu.unipilito.MaterialDatabaseHelper.TABLE_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ComponentActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {


    ListView listViewResiduos;
    private SQLiteDatabase db;
    private Cursor cursor;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteOpenHelper materialesDatabaseHelper=new MaterialDatabaseHelper(this);
        try {
            listViewResiduos = (ListView) findViewById(R.id.residuos);

            db = materialesDatabaseHelper.getReadableDatabase();
            cursor = db.query(TABLE_NAME,
                    new String[]{"_id", COL_2},
                    null, null, null, null, null);
                    SimpleCursorAdapter listAdapter= new SimpleCursorAdapter(this,
                    android.R.layout.simple_expandable_list_item_1,
                    cursor,
                    new String[]{COL_2},
                    new int[]{android.R.id.text1},
                    0);
            listViewResiduos.setAdapter(listAdapter);

        }catch (SQLiteException e){
            Toast toast=Toast.makeText(this, "Base de datos no disponible", Toast.LENGTH_LONG);
            toast.show();
        }

        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> listViewResiduos, View itemview, int position, long id) {
                        Intent intent = new Intent(MainActivity.this, MainActivity5.class);
                        intent.putExtra(MainActivity5.EXTRA_DRINKID, (int) id);
                        startActivity(intent);
                    }
                };
        listViewResiduos.setOnItemClickListener(itemClickListener);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        cursor.close();
        db.close();
    }







    public void OnSendMaps (View View) {

            Uri gmmIntentUri=Uri.parse("google.navigation:Salt+mines,Zipaquira");
            Intent mapIntent=new Intent(Intent.ACTION_VIEW,gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);


    }
    public void OnRegistroMaterial(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity4.class));
    }
}