package com.appclase.utad.roomwordssample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private List<Word> wordEntities;

    public WordListAdapter(List<Word> userEntitiesData) {
        wordEntities = userEntitiesData;
    }


    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_recycler, viewGroup, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder wordViewHolder, int i) {
        if (wordEntities != null) {
            Word actual = wordEntities.get(i);
            wordViewHolder.courseNameItemView.setText(actual.getmCourseName());
            wordViewHolder.numberOfStudentsItemView.setText(actual.getmNumberOfStudents());

        } else {
            wordViewHolder.courseNameItemView.setText("Couldnt download");
        }
    }

    @Override
    public int getItemCount() {
        if (wordEntities != null)
            return wordEntities.size();
        else return 0;
    }

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView courseNameItemView;
        private final TextView numberOfStudentsItemView;

        private WordViewHolder(View itemView) {
            super(itemView);
            courseNameItemView = itemView.findViewById(R.id.course_name);
            numberOfStudentsItemView = itemView.findViewById(R.id.student_number);
        }
    }
}