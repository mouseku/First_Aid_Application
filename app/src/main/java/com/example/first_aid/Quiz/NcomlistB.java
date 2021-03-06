package com.example.first_aid.Quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.first_aid.R;
import com.example.first_aid.database.numQuiz;
import com.example.first_aid.database.oxquiz;

import java.util.List;

public class NcomlistB extends AppCompatActivity {
    private oxquiz quizB= new oxquiz();
    private numQuiz quizNB = new numQuiz();
    private List<List<String>> listB = quizB.getoxB();
    private List<List<String>> listNB = quizNB.getnumA();
    private ListView listView;
    private ListViewAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_comment);

        final int[] index=new int[listB.size()+ listNB.size()];
        for(int i=0; i<listB.size(); i++){
            index[i]=i;
        }

        for(int i = listNB.size(); i< listB.size()+ listNB.size(); i++){
            index[i]=i;
        }

        adapter=new ListViewAdapter();

        listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        for(int i=0; i<listB.size(); i++){
            adapter.addItem(listB.get(i).get(0), listB.get(i).get(1), listB.get(i).get(2));
        }

        for(int i = 0; i< listNB.size(); i++){
            adapter.addItem(listNB.get(i).get(0), listNB.get(i).get(1), listNB.get(i).get(2));
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NcomlistB.this, NcommentB.class);
                intent.putExtra("indexs", index[position]);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
        adapter.notifyDataSetChanged();
    }
}
