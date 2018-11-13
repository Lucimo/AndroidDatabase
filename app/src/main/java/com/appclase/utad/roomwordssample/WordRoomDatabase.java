package com.appclase.utad.roomwordssample;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

@Database(entities = {Word.class}, version = 2)
public abstract class WordRoomDatabase extends RoomDatabase {
    public abstract WordDao wordDao();

    private static WordRoomDatabase INSTANCE;

    public static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                            .fallbackToDestructiveMigration()
                            .build();

                }
            }
        }
        return INSTANCE;
    }
    static Callback callBackData = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            (new WordAsyncTask(INSTANCE)).execute();
        }
    };

    private static class WordAsyncTask extends AsyncTask<Void,Void,Void> {
        public WordDao wordDao;

        public WordAsyncTask(WordRoomDatabase wordRoomDatabase) {
            wordDao = wordRoomDatabase.wordDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            Word eng = new Word("1","English","30");
            Word spa = new Word("2","Spanish","40");
            Word ger = new Word("3","German","50");
            Word ita = new Word("4","Italian", "25");
            Word hung = new Word("5","Hungarian", "33");

            List<Word> data = new ArrayList<>();
            data.add(eng);
            data.add(spa);
            data.add(ger);
            data.add(ita);
            data.add(hung);

           wordDao.deleteAll();
            wordDao.insertAll(data);
            return null;
        }
    }

}
