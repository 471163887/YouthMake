package com.example.fury.youthmake.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.fury.youthmake.R;
import com.example.fury.youthmake.model.Note;
import com.example.fury.youthmake.widget.NoteAdapter;

import java.util.ArrayList;
import java.util.List;

public class Note4Activity extends Activity {

    List<Note> noteList;
    private GridView noteGridView;
    private NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_note4);
        noteGridView = (GridView)findViewById(R.id.note_grid);
        noteList = new ArrayList<Note>();
        noteAdapter = new NoteAdapter(Note4Activity.this, noteList);

        SharedPreferences sp = getSharedPreferences("note",
                Activity.MODE_PRIVATE);
        boolean n1hasset = sp.getBoolean("notedes1_hasSet", false);
        boolean n2hasset = sp.getBoolean("notedes2_hasSet", false);
        boolean n3hasset = sp.getBoolean("notedes3_hasSet", false);
        boolean n4hasset = sp.getBoolean("notedes4_hasSet", false);

        String primary_notedes1;
        String primary_notedes2;
        String primary_notedes3;
        String primary_notedes4;
        if(n1hasset)
            primary_notedes1 = sp.getString("primary_notedes1", "");
        else
            primary_notedes1 = "第二象限";
        if(n2hasset)
            primary_notedes2 = sp.getString("primary_notedes2", "");
        else
            primary_notedes2 = "第一象限";
        if(n3hasset)
            primary_notedes3 = sp.getString("primary_notedes3", "");
        else
            primary_notedes3 = "第三象限";
        if(n4hasset)
            primary_notedes4 = sp.getString("primary_notedes4", "");
        else
            primary_notedes4 = "第四象限";

        Note note1 = new Note(primary_notedes1);
        Note note2 = new Note(primary_notedes2);
        Note note3 = new Note(primary_notedes3);
        Note note4 = new Note(primary_notedes4);

        noteList.add(note1);
        noteList.add(note2);
        noteList.add(note3);
        noteList.add(note4);

        noteGridView.setAdapter(noteAdapter);

        final Intent intent = new Intent(Note4Activity.this, NoteModifyActivity.class);

        noteGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        intent.putExtra("number", 0);
                        startActivityForResult(intent, 1);
                        break;
                    case 1:
                        intent.putExtra("number", 1);
                        startActivityForResult(intent, 2);
                        break;
                    case 2:
                        intent.putExtra("number", 2);
                        startActivityForResult(intent, 3);
                        break;
                    case 3:
                        intent.putExtra("number", 3);
                        startActivityForResult(intent, 4);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if(resultCode == RESULT_OK){
                    String nodedes11 = data.getStringExtra("nodedes1");
                    if(nodedes11 == null || nodedes11.length() <= 0){
                        Note note111 = new Note("第二象限");
                        noteList.remove(0);
                        noteList.add(0, note111);
                        noteAdapter.notifyDataSetChanged();
                    } else {
                        Note note = new Note(nodedes11);
                        noteList.remove(0);
                        noteList.add(0, note);
                        noteAdapter.notifyDataSetChanged();
                    }
                }
                break;
            case 2:
                if(resultCode == RESULT_OK){
                    String nodedes22 = data.getStringExtra("nodedes2");
                    if(nodedes22 == null || nodedes22.length() <= 0){
                        Note note111 = new Note("第一象限");
                        noteList.remove(1);
                        noteList.add(1, note111);
                        noteAdapter.notifyDataSetChanged();
                    } else {
                        Note note = new Note(nodedes22);
                        noteList.remove(1);
                        noteList.add(1, note);
                        noteAdapter.notifyDataSetChanged();
                    }
                }
                break;
            case 3:
                if(resultCode == RESULT_OK){
                    String nodedes33 = data.getStringExtra("nodedes3");
                    if(nodedes33 == null || nodedes33.length() <= 0){
                        Note note111 = new Note("第三象限");
                        noteList.remove(2);
                        noteList.add(2, note111);
                        noteAdapter.notifyDataSetChanged();
                    } else {
                        Note note = new Note(nodedes33);
                        noteList.remove(2);
                        noteList.add(2, note);
                        noteAdapter.notifyDataSetChanged();
                    }
                }
                break;
            case 4:
                if(resultCode == RESULT_OK){
                    String nodedes44 = data.getStringExtra("nodedes4");
                    if(nodedes44 == null || nodedes44.length() <= 0){
                        Note note111 = new Note("第四象限");
                        noteList.remove(3);
                        noteList.add(3, note111);
                        noteAdapter.notifyDataSetChanged();
                    } else {
                        Note note = new Note(nodedes44);
                        noteList.remove(3);
                        noteList.add(3, note);
                        noteAdapter.notifyDataSetChanged();
                    }
                }
                break;
            default:
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
