package com.example.fury.youthmake.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fury.youthmake.R;
import com.example.fury.youthmake.model.Note;

import java.util.List;

/**
 * Copyright (C) 年少才华
 * Date: 2015-12-08  08:21
 * Mail: 18844195756@163.com
 * Auth: flt
 */
public class NoteAdapter extends BaseAdapter {
    private Context noteContext;
    private List<Note> noteList;
    private int bg;

    public NoteAdapter(Context noteContext, List<Note> noteList) {
        this.noteContext = noteContext;
        this.noteList = noteList;
    }

    @Override
    public int getCount() {
        return noteList.size();
    }

    @Override
    public Object getItem(int position) {
        return noteList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view= LayoutInflater.from(noteContext).inflate(R.layout.view_note, parent, false);

        switch(position%4){
            case 1:
                //view.setBackgroundResource(R.color.red);
                bg = Color.rgb((int) Math.floor(Math.random() * 128) + 64,
                        (int) Math.floor(Math.random() * 128) + 64,
                        (int) Math.floor(Math.random() * 128) + 64);
                view.setBackgroundColor(bg);
                break;
            case 2:
                bg = Color.rgb((int) Math.floor(Math.random() * 128) + 64,
                        (int) Math.floor(Math.random() * 128) + 64,
                        (int) Math.floor(Math.random() * 128) + 64);
                view.setBackgroundColor(bg);
                break;
            case 3:
                bg = Color.rgb((int) Math.floor(Math.random() * 128) + 64,
                        (int) Math.floor(Math.random() * 128) + 64,
                        (int) Math.floor(Math.random() * 128) + 64);
                view.setBackgroundColor(bg);
                break;
            case 0:
                bg = Color.rgb((int) Math.floor(Math.random() * 128) + 64,
                        (int) Math.floor(Math.random() * 128) + 64,
                        (int) Math.floor(Math.random() * 128) + 64);
                view.setBackgroundColor(bg);
                break;
            default:
                break;
        }
        TextView text=(TextView)view.findViewById(R.id.des_text);
        text.setText(noteList.get(position).getDescription());
        int Height = parent.getHeight() / 2;
        view.setMinimumHeight(Height);
        return view;
    }
}
