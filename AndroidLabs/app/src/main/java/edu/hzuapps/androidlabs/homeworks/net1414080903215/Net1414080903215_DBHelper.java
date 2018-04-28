package edu.hzuapps.androidlabs.homeworks.net1414080903215;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import edu.hzuapps.androidlabs.homeworks.net1414080903215.adapter.Animal;

/**
 * Created by acer on 2018/4/27.
 */

public class Net1414080903215_DBHelper extends SQLiteOpenHelper {//直接在Andriod中创建数据库和表
    public static final String saveWordListTable = "saveWordListTable";
    public static final String wordID = "wordID";
    public static final String wordName = "wordName";
    public static final String wordPronunciation = "wordPronunciation";
    public static final String wordAntonym= "wordAntonym=";
    public static final String wordHomoionym= "wordHomoionym";
    public static final String wordDerivation= "wordDerivation";
    public static final String wordExamples= "wordExamples";
    public static final String wordExplain = "wordexplain";
    public static final String CREATE_SAVE="create table saveWordListTable(" +
            "wordID integer ," +
            "wordName text," +
            "wordPronunciation varchar,"+
            "wordAntonym varchar,"+
            "wordHomoionym varchar,"+
            "wordDerivation varchar,"+
            "wordExamples varchar,"+
            "wordExplain varchar)";

    public Net1414080903215_DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_SAVE);//创建数据库的同时创建表
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }
    public void addAttentionWord(int wordId,String wordName,String wordPronunciation,String wordAntonym,String wordHomoionym,String wordDerivation,String wordExamples,String wordExplain) {
        ContentValues values = new ContentValues();
        values.put(Net1414080903215_DBHelper.wordID ,wordId);
        values.put(Net1414080903215_DBHelper.wordName ,wordName);
        values.put(Net1414080903215_DBHelper.wordPronunciation ,wordPronunciation);
        values.put(Net1414080903215_DBHelper.wordAntonym ,wordAntonym);
        values.put(Net1414080903215_DBHelper.wordHomoionym ,wordHomoionym);
        values.put(Net1414080903215_DBHelper.wordDerivation ,wordDerivation);
        values.put(Net1414080903215_DBHelper.wordExamples ,wordExamples);
        values.put(Net1414080903215_DBHelper.wordExplain,wordExplain);
        this.getWritableDatabase().insert( Net1414080903215_DBHelper.saveWordListTable, null, values);
    }
    public ArrayList<Animal> QueryAllAttentionWord(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Animal> List= new ArrayList<Animal>();
        Cursor cursor =db.rawQuery("select * from saveWordListTable",null);
        if (cursor.moveToFirst()){

            do{
                Animal animal=new Animal();
                animal.setId(cursor.getInt(cursor.getColumnIndex("_id")));
                animal.setName(cursor.getString(cursor.getColumnIndex("name")));
                animal.setPronounce(cursor.getString(cursor.getColumnIndex("pronounce")));
                animal.setAntonym(cursor.getString(cursor.getColumnIndex("antonym")));
                animal.setHomoionym(cursor.getString(cursor.getColumnIndex("homoionym")));
                animal.setDerivation(cursor.getString(cursor.getColumnIndex("derivation")));
                animal.setExamples(cursor.getString(cursor.getColumnIndex("examples")));
                animal.setExplain(cursor.getString(cursor.getColumnIndex("explain")));
                List.add(animal);
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return List;
    }
    public void deleteAttentionWord(int wordId) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "delete from saveWordListTable" +
                " where wordID="+"'"+wordId+"'";
        db.execSQL(sql);
        db.close();
    }
}

