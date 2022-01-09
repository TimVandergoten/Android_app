package com.timvandergoten.beercollect.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.audiofx.AudioEffect;
import android.widget.Toast;
import com.timvandergoten.beercollect.R;

import static android.widget.Toast.LENGTH_SHORT;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Room;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.timvandergoten.beercollect.Models.LikedBeer;

@Database(entities = {LikedBeer.class}, version = 1)
public abstract class DatabaseHelper extends RoomDatabase {
    public abstract LikedBeerDao likedBeerDao();
    private static volatile DatabaseHelper INSTANCE;

    public static synchronized DatabaseHelper getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = create(context);
        }
        return INSTANCE;
    }
    private static  DatabaseHelper create(final Context context){
        return Room.databaseBuilder(context,DatabaseHelper.class,"DB_LikedBeers").allowMainThreadQueries().build();
    }
}
/*public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TABEL = "drinkedBeers";
    public static final String ID = "ID";
    public static final String BEERID = "beerID";
    public static final String BEERNAME = "beerName";
    public static final String TAGLINE = "tagLine";
    public static final String DESC = "beerDesc";
    public static final String IMAGE = "imageUrl";
    public static final String COMMENT = "comment";

    public DatabaseHelper(@Nullable Context context) {
        super(context, TABEL, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE "+TABEL+"(ID INTEGER PRIMARY KEY AUTOINCREMENT, "+BEERID+" INTEGER, "+ BEERNAME+" TEXT, "+ TAGLINE+" TEXT, "+ DESC+" TEXT, "+ IMAGE+"TEXT, "+ COMMENT+" TEXT)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public boolean addBeer(LikedBeer beer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BEERID,beer.getBeerId());
        contentValues.put(BEERNAME,beer.getName());
        contentValues.put(TAGLINE,beer.getTagline());
        contentValues.put(DESC,beer.getDescription());
        contentValues.put(IMAGE,beer.getImageUrl());
        contentValues.put(COMMENT,beer.getComment());

        long result = db.insert(TABEL,null,contentValues);

        return result != -1;
    }
    public Cursor getBeer(){
        try (SQLiteDatabase database = this.getWritableDatabase()) {
            return database.rawQuery("SELECT * FROM " + TABEL, null);
        }
    }
}*/
