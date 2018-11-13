package com.appclase.utad.roomwordssample;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class RecyclerActivityDatabase extends AppCompatActivity {
public RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_item);
        recyclerView = findViewById(R.id.my_recycler_view);


        WordRepository wordRepository = new WordRepository(getApplication());
       wordRepository.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable List<Word> word) {
                if(word!= null ) {
                    WordListAdapter adapter = new WordListAdapter(word);
                    recyclerView.setAdapter(adapter);
                }
            }

        });

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }
}
