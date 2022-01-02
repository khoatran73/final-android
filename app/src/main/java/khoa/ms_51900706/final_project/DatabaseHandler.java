package khoa.ms_51900706.final_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Lock_Manager";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "lock";

    private static final String KEY_ID = "id";
    private static final String KEY_ISLOCK = "isLock";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_FLAG = "flag";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public DatabaseHandler(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create_lock_table = String.format("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT)", TABLE_NAME, KEY_ID, KEY_ISLOCK, KEY_PASSWORD,KEY_FLAG);
        sqLiteDatabase.execSQL(create_lock_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String drop_students_table = String.format("DROP TABLE IF EXISTS %s", TABLE_NAME);
        sqLiteDatabase.execSQL(drop_students_table);

        onCreate(sqLiteDatabase);
    }

    public void addLock(Lock lock) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ISLOCK, lock.getLock());
        values.put(KEY_PASSWORD, lock.getPassword());
        values.put(KEY_FLAG, lock.getFlag());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public Lock getLock(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] { KEY_ID,
                        KEY_PASSWORD, KEY_ISLOCK, KEY_FLAG }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if(cursor != null)
            cursor.moveToFirst();
        Lock lock = new Lock(cursor.getInt(0), cursor.getString(1), cursor.getString(2),cursor.getString(3));
        return lock;
    }

    public void updateLock(Lock lock) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PASSWORD, lock.getPassword());
        values.put(KEY_ISLOCK,lock.getLock());
        values.put(KEY_FLAG,lock.getFlag());

        db.update(TABLE_NAME, values, KEY_ID + " = ?", new String[] { String.valueOf(lock.getId()) });
        db.close();
    }


}
