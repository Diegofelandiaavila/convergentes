package co.edu.unipilito;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteException;

import androidx.annotation.Nullable;



public class MaterialDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Materiales.db";
    public static final String TABLE_NAME="Registro";
    public static final String COL_1="ID";
    public static final String COL_2="MATERIAL";
    public static final String COL_3="DESCRIPCION";
    public static final String COL_4="PESO";
    public static final String COL_5="TAMANO";
    public static final String COL_6="DIRECCION";


    public MaterialDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"( _id"+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_2+" TEXT, "+COL_3+" TEXT, "+COL_4+" TEXT, "+COL_5+" TEXT, "+COL_6+" TEXT);");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public void initData(){
        SQLiteDatabase db=this.getWritableDatabase();
        onUpgrade(db,1,2);
    }
    public boolean insertMaterialData(Material material){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2, material.getMaterial());
        contentValues.put(COL_3, material.getDescripcion());
        contentValues.put(COL_4, material.getPeso());
        contentValues.put(COL_5, material.getTamano());
        contentValues.put(COL_6, material.getDireccion());
        long result = db.insert(TABLE_NAME, null,contentValues);
        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public Cursor getAllData(){
        SQLiteDatabase db2=this.getReadableDatabase();
        return db2.rawQuery("select * from "+TABLE_NAME,null);
    }
    public Cursor getData(int id){
        SQLiteDatabase db2=this.getReadableDatabase();
        Cursor result=db2.rawQuery("select * from "+TABLE_NAME+"where id="+id+"",null);
        return result;
    }
}
