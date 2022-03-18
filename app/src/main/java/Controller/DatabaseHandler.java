package Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Model.Msg;
import Model.User;
import Utils.Utils;

public class DatabaseHandler extends SQLiteOpenHelper {


    public DatabaseHandler(  Context context) {
        super(context, Utils.DATABASE_NAME, null, Utils.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_USERS_TABLE="CREATE TABLE "+Utils.TABLE_NAME2+ " (" +
                Utils.KEY_USERID+ " INTEGER PRIMARY KEY,"
                + Utils.KEY_USERNAME + " TEXT,"
                + Utils.KEY_FIRSTNAME + " TEXT,"
                + Utils.KEY_LASTNAME + " TEXT,"
                + Utils.KEY_USERAGE + " TEXT,"
                + Utils.KEY_GENDER + " TEXT,"
                + Utils.KEY_PASSWORD + " TEXT,"
                + Utils.KEY_Weight + " TEXT)";

        String CREATE_MESSAGES_TABLE="CREATE TABLE "+Utils.TABLE_NAME3+ " (" +
                Utils.KEY_MSGID+ " INTEGER PRIMARY KEY,"
                + Utils.KEY_RECIVERUSERNAME + " TEXT,"
                + Utils.KEY_TIME + "  DATETIME DEFAULT CURRENT_TIMESTAMP,"
                + Utils.KEY_MSG + " TEXT)";
        db.execSQL(CREATE_USERS_TABLE);
        db.execSQL(CREATE_MESSAGES_TABLE);
        Log.d("oncreate","worked");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Utils.TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + Utils.TABLE_NAME3);
        onCreate(db);
        Log.d("onupgrade","worked");
    }


    public void addUser(User u){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Utils.KEY_USERNAME , u.getUsername());
        contentValues.put(Utils.KEY_FIRSTNAME , u.getFirstname());
        contentValues.put(Utils.KEY_LASTNAME , u.getLastname());
        contentValues.put(Utils.KEY_USERAGE , String.valueOf(u.getAge()));
        contentValues.put(Utils.KEY_GENDER ,u.getGender());
        contentValues.put(Utils.KEY_PASSWORD ,u.getPassword());
        contentValues.put(Utils.KEY_Weight ,u.getWeight());

        database.insert(Utils.TABLE_NAME2 , null,contentValues);
        database.close();
    }

    public  User At(int id){
        SQLiteDatabase database = this.getReadableDatabase() ;
        Cursor cursor = database.query(Utils.TABLE_NAME2 ,
                new String[]{Utils.KEY_USERID,Utils.KEY_USERNAME,
                        Utils.KEY_FIRSTNAME,
                        Utils.KEY_LASTNAME,Utils.KEY_USERAGE,
                        Utils.KEY_GENDER, Utils.KEY_PASSWORD,Utils.KEY_Weight
                },
                Utils.KEY_USERID + "=?",new String[]{String.valueOf(id)},
                null,null,null,null);

        if (cursor != null)
            cursor.moveToFirst();

        User user = new User(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), Integer.parseInt(cursor.getString(4)), cursor.getString(5),
                cursor.getString(6),Integer.parseInt(cursor.getString(7)));
        return user;
    }


    public List<User> ALL(){
        SQLiteDatabase database = this.getReadableDatabase() ;
        List<User> users = new ArrayList<>();

        String getAll = "SELECT * FROM "+ Utils.TABLE_NAME2;
        Cursor cursor = database.rawQuery(getAll ,null );

        if (cursor.moveToFirst())

            do{
                User u = new User();
                u.setId(Integer.parseInt(cursor.getString(0)));
                u.setUsername(cursor.getString(1));
                u.setFirstname(cursor.getString(2));
                u.setLastname(cursor.getString(3));
                u.setAge(Integer.parseInt(cursor.getString(4)));
                u.setGender(cursor.getString(5));
                u.setPassword(cursor.getString(6));

                users.add(u);
            }while (cursor.moveToNext());

        return  users;
    }

    public void updateUser(User user){
        SQLiteDatabase database = this.getWritableDatabase() ;
        ContentValues contentValues = new ContentValues();
        //contentValues.put(Utils.KEY_USERNAME , user.getUsername());
        //contentValues.put(Utils.KEY_FIRSTNAME , user.getFirstname());
        //contentValues.put(Utils.KEY_LASTNAME , user.getLastname());
        //contentValues.put(Utils.KEY_USERAGE , String.valueOf(user.getAge()));
        //contentValues.put(Utils.KEY_GENDER , user.getGender());
        contentValues.put(Utils.KEY_PASSWORD , user.getPassword());
        //contentValues.put(Utils.KEY_Weight , String.valueOf(user.getWeight()) );

        database.update(Utils.TABLE_NAME2 , contentValues,Utils.KEY_ID + "=?",
                new String[]{ String.valueOf(user.getId())});
        database.close();
    }

    public  void deleteUser(User user){
        SQLiteDatabase database = this.getWritableDatabase() ;
        database.delete(Utils.TABLE_NAME2 , Utils.KEY_ID + "=?",
                new String[]{ String.valueOf(user.getId())});
        database.close();
    }
//Msgs
    public void sendMsg(Msg m)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Utils.KEY_RECIVERUSERNAME , m.getReciver());
        contentValues.put(Utils.KEY_MSG , m.getMsg());
        database.insert(Utils.TABLE_NAME3,null,contentValues);
        database.close();
    }

    public  Msg getMsg(int id){
        SQLiteDatabase database = this.getReadableDatabase() ;
        Cursor cursor = database.query(Utils.TABLE_NAME3 ,
                new String[]{Utils.KEY_MSGID,Utils.KEY_RECIVERUSERNAME,Utils.KEY_TIME,Utils.KEY_MSG},
                Utils.KEY_MSGID + "=?",new String[]{String.valueOf(id)},
                null,null,null,null);

        if (cursor != null)
            cursor.moveToFirst();
        Msg m=new Msg(Integer.parseInt(cursor.getString(0)), cursor.getString(1),cursor.getString(2),cursor.getString(3));
        return m;
    }

    public  List<Msg> getUserMsgs(String username){
        SQLiteDatabase database = this.getReadableDatabase();
        List<Msg> Msgs = new ArrayList<>();
        Cursor cursor = database.query(Utils.TABLE_NAME3 ,
                new String[]{Utils.KEY_MSGID,Utils.KEY_RECIVERUSERNAME,Utils.KEY_TIME,Utils.KEY_MSG},
                Utils.KEY_RECIVERUSERNAME + "=?",new String[]{username},
                null,null,Utils.KEY_TIME +" DESC",null);
        if (cursor.moveToFirst())
            do{
                Msg m = new Msg();
                m.setId(Integer.parseInt(cursor.getString(0)));
                m.setReciver(cursor.getString(1));
                m.setTime(cursor.getString(2));
                m.setMsg(cursor.getString(3));
                Msgs.add(m);
            }while (cursor.moveToNext());

            return Msgs;
    }

    public  void deleteMsg(Msg m){
        SQLiteDatabase database = this.getWritableDatabase() ;
        database.delete(Utils.TABLE_NAME3 , Utils.KEY_MSGID + "=?",
                new String[]{ String.valueOf(m.getId())});
        database.close();
    }


    public  int getUsersNum(){
        String getAll = "SELECT * FROM "+ Utils.TABLE_NAME2;
        SQLiteDatabase database = this.getReadableDatabase() ;
        Cursor cursor = database.rawQuery(getAll ,null );
        return cursor.getCount();
    }
}