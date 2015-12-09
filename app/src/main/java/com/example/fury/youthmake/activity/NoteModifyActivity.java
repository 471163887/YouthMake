package com.example.fury.youthmake.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.beardedhen.androidbootstrap.BootstrapEditText;
import com.example.fury.youthmake.R;

public class NoteModifyActivity extends Activity {

    private BootstrapButton finish;
    private BootstrapEditText notedes;
    private BootstrapEditText notedesMost;
    private BootstrapEditText notedesThree;
    private BootstrapEditText notedesFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_note_modify);

        SharedPreferences sharedPreferences = getSharedPreferences("note",
                Activity.MODE_PRIVATE);

        boolean n1hasset = sharedPreferences.getBoolean("notedes1_hasSet", false);
        boolean n2hasset = sharedPreferences.getBoolean("notedes2_hasSet", false);
        boolean n3hasset = sharedPreferences.getBoolean("notedes3_hasSet", false);
        boolean n4hasset = sharedPreferences.getBoolean("notedes4_hasSet", false);

        Intent intent = getIntent();
        int Note4number = intent.getIntExtra("number", 5);
        switch (Note4number){
            case 0:
                notedes = (BootstrapEditText)findViewById(R.id.et_note);
                notedes.setVisibility(View.VISIBLE);
                if(n1hasset) {
                    String primary_notedes = sharedPreferences.getString("primary_notedes1", "");
                    notedes.setText(primary_notedes);
                }
                finish = (BootstrapButton)findViewById(R.id.bnt_finish);
                finish.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        String nodedes1 = notedes.getEditableText().toString();
                        intent.putExtra("nodedes1", nodedes1);
                        setResult(RESULT_OK, intent);
                        SharedPreferences mySharedPreferences = getSharedPreferences("note",
                                Activity.MODE_PRIVATE);
                        SharedPreferences.Editor editor = mySharedPreferences.edit();
                        editor.putString("primary_notedes1", nodedes1);
                        if (nodedes1 == "" || nodedes1.length() <= 0) {
                            editor.putBoolean("notedes1_hasSet", false);
                        } else {
                            editor.putBoolean("notedes1_hasSet", true);
                        }
                        editor.commit();
                        notedes.setVisibility(View.GONE);
                        finish();
                    }
                });
                break;
            case 1:
                notedesMost = (BootstrapEditText)findViewById(R.id.et_note_most);
                notedesMost.setVisibility(View.VISIBLE);
                if(n2hasset) {
                    String primary_notedes = sharedPreferences.getString("primary_notedes2", "");
                    notedesMost.setText(primary_notedes);
                }
                finish = (BootstrapButton)findViewById(R.id.bnt_finish);
                finish.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        String nodedes2 = notedesMost.getEditableText().toString();
                        intent.putExtra("nodedes2", nodedes2);
                        setResult(RESULT_OK, intent);
                        SharedPreferences mySharedPreferences = getSharedPreferences("note",
                                Activity.MODE_PRIVATE);
                        SharedPreferences.Editor editor = mySharedPreferences.edit();
                        editor.putString("primary_notedes2", nodedes2);
                        if (nodedes2 == "" || nodedes2.length() <= 0) {
                            editor.putBoolean("notedes2_hasSet", false);
                        } else {
                            editor.putBoolean("notedes2_hasSet", true);
                        }
                        editor.commit();
                        notedesMost.setVisibility(View.GONE);
                        finish();
                    }
                });
                break;
            case 2:
                notedesThree = (BootstrapEditText)findViewById(R.id.et_note_three);
                notedesThree.setVisibility(View.VISIBLE);
                if(n3hasset) {
                    String primary_notedes = sharedPreferences.getString("primary_notedes3", "");
                    notedesThree.setText(primary_notedes);
                }
                finish = (BootstrapButton)findViewById(R.id.bnt_finish);
                finish.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        String nodedes3 = notedesThree.getEditableText().toString();
                        intent.putExtra("nodedes3", nodedes3);
                        setResult(RESULT_OK, intent);
                        SharedPreferences mySharedPreferences = getSharedPreferences("note",
                                Activity.MODE_PRIVATE);
                        SharedPreferences.Editor editor = mySharedPreferences.edit();
                        editor.putString("primary_notedes3", nodedes3);
                        if (nodedes3 == "" || nodedes3.length() <= 0) {
                            editor.putBoolean("notedes3_hasSet", false);
                        } else {
                            editor.putBoolean("notedes3_hasSet", true);
                        }
                        editor.commit();
                        notedesThree.setVisibility(View.GONE);
                        finish();
                    }
                });
                break;
            case 3:
                notedesFour = (BootstrapEditText)findViewById(R.id.et_note_four);
                notedesFour.setVisibility(View.VISIBLE);
                if(n4hasset) {
                    String primary_notedes = sharedPreferences.getString("primary_notedes4", "");
                    notedesFour.setText(primary_notedes);
                }
                finish = (BootstrapButton)findViewById(R.id.bnt_finish);
                finish.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        String nodedes4 = notedesFour.getEditableText().toString();
                        intent.putExtra("nodedes4", nodedes4);
                        setResult(RESULT_OK, intent);
                        SharedPreferences mySharedPreferences = getSharedPreferences("note",
                                Activity.MODE_PRIVATE);
                        SharedPreferences.Editor editor = mySharedPreferences.edit();
                        editor.putString("primary_notedes4", nodedes4);
                        if (nodedes4 == "" || nodedes4.length() <= 0) {
                            editor.putBoolean("notedes4_hasSet", false);
                        } else {
                            editor.putBoolean("notedes4_hasSet", true);
                        }
                        editor.commit();
                        notedesFour.setVisibility(View.GONE);
                        finish();
                    }
                });
                break;
            default:break;
        }

    }
}
