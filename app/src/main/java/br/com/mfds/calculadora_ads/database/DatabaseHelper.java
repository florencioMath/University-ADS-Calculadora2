package br.com.mfds.calculadora_ads.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import br.com.mfds.calculadora_ads.R;

public class DatabaseHelper  extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "calculadora";
    private static final int VERSAO_BANCO = 1;
    private static final String TABLE_NAME = "calculadora";

    private static final String CREATE_TABLE = "CREATE TABLE " +TABLE_NAME+ "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " + //
            "expressao VARCHAR, resultado VARCHAR);";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+ TABLE_NAME;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public long insert(String expressao, String resultado){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("expressao", expressao);
        cv.put("resultado", resultado);
        try {
            return db.insert(TABLE_NAME, null, cv);
        } finally {
            db.close();
        }
    }
    public void select(Context context, ListView lv){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"_id","expressao", "resultado" };
        int[] to = {R.id.textView_id_historico, R.id.textView_expressao_historico, R.id.textView_resultado_historico};
        Cursor data = db.query(TABLE_NAME, columns, null, null, null, null, "_id DESC" );
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(context, R.layout.item_historico, data, columns, to, 0);
        lv.setAdapter(simpleCursorAdapter);
        db.close();
    }

    public void delete() {
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }
}
