package odravison.com.br.justtolearning;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by odravison on 14/10/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String KEY_NAME = "name";
    private static final String KEY_TABLE = "nomes"
    private static final String KEY_ID = "id";
    private static final int VERSION_DB = 1;
    private static final String DB_NAME = "MyFirstDB";



    public DatabaseHelper(Context context) {
        super(context, "MyFirstDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableNome = "CREATE TABLE" + KEY_TABLE +"(" +
                KEY_ID + " INTEGER PRIMARY KEY, "+ KEY_NAME +" TEXT)";
        sqLiteDatabase.execSQL(createTableNome);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS nomes");
        onCreate(sqLiteDatabase);
    }

    public void addNome(Dado dado){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", dado.getName());
        values.put("id", dado.getId());

        //INSERT
        db.insert("nomes", null, values);
        db.close();

    }

    //READ
    public List<Dado> getAllDados(){
        List<Dado> dados = new LinkedList<Dado>();
        String query = "SELECT * FROM nomes";
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);
        Dado dado = null;

        if (cursor.moveToFirst()){
            do {
                dado = new Dado();
                dado.setId(Integer.parseInt(cursor.getString(0)));
                dado.setName(cursor.getString(1));
                dados.add(dado);
            }while(cursor.moveToNext());

        }

        return dados;

    }

    public void deleteDado(Dado dado){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(KEY_TABLE, "id =  ?",
                new String[] { String.valueOf(dado.getId()) });
        db.close();
    }


































}
