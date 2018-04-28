package edu.hzuapps.androidlabs.homeworks.net1414080903215;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import edu.hzuapps.androidlabs.homeworks.net1414080903215.adapter.Animal;

/**
 * Created by acer on 2018/4/25.
 */

public class Net1414080903215_StudyDao {
    private static Net1414080903215_StudyDao animaiDao;
    private SQLiteDatabase db;
            /*将构造方法私有化*/
    private Net1414080903215_StudyDao(Context context){
        Net1414080903215_DBOpenHelper dbHelper=new Net1414080903215_DBOpenHelper(context);
        db=dbHelper.openDatabase();
    }
            /*获取AnimalDao的实例*/
    public synchronized static Net1414080903215_StudyDao getInstance(Context context){
        if(animaiDao==null){
            animaiDao=new Net1414080903215_StudyDao(context);
        }
        return animaiDao;
    }
            /*从数据库读取所有的动物类成语*/
    public List<Animal> getAllAnimals(){
        List<Animal> list=new ArrayList<Animal>();
        Cursor cursor=db.query("animal",null,null,null,null,null,null);
        if(cursor.moveToNext()){
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
                list.add(animal);
            }while(cursor.moveToNext());
        }
        return list;
    }
}
