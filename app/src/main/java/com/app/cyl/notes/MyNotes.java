package com.app.cyl.notes;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.app.cyl.practice.R;




/**
 * Created by caiyonglong0 on 2015/8/25.
 */
public class MyNotes extends Activity implements View.OnClickListener {

    private Button textbtn,imgbtn,videobtn;
    private ListView lv;
    private Intent i;
    private MyAdapter adapter;
    private NotesDB notesDB;
    private SQLiteDatabase dbReader;
    public Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mynotes);
        initView();
    }

    public void initView() {
        lv = (ListView) findViewById(R.id.list);
        textbtn = (Button) findViewById(R.id.text);
        imgbtn = (Button) findViewById(R.id.img);
        videobtn = (Button) findViewById(R.id.video);
        textbtn.setOnClickListener(this);
        imgbtn.setOnClickListener(this);
        videobtn.setOnClickListener(this);
        notesDB = new NotesDB(this);
        dbReader = notesDB.getReadableDatabase();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                cursor.moveToPosition(position);
                Intent i = new Intent(MyNotes.this, SelectAct.class);
                i.putExtra(NotesDB.ID,
                        cursor.getInt(cursor.getColumnIndex(NotesDB.ID)));
                i.putExtra(NotesDB.CONTENT, cursor.getString(cursor
                        .getColumnIndex(NotesDB.CONTENT)));
                i.putExtra(NotesDB.TIME,
                        cursor.getString(cursor.getColumnIndex(NotesDB.TIME)));
                i.putExtra(NotesDB.PATH,
                        cursor.getString(cursor.getColumnIndex(NotesDB.PATH)));
                i.putExtra(NotesDB.VIDEO,
                        cursor.getString(cursor.getColumnIndex(NotesDB.VIDEO)));
                startActivity(i);
            }
        });
    }

    @Override
    public void onClick(View v) {
        i = new Intent(this, AddContent.class);
        switch (v.getId()) {
            case R.id.text:
                i.putExtra("flag", "1");
                startActivity(i);
                break;

            case R.id.img:
                i.putExtra("flag", "2");
                startActivity(i);
                break;

            case R.id.video:
                i.putExtra("flag", "3");
                startActivity(i);
                break;
        }
    }

    public void selectDB() {
        cursor = dbReader.query(NotesDB.TABLE_NAME, null, null, null, null,
                null, null);
        adapter = new MyAdapter(this, cursor);
        lv.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        selectDB();
    }

}
