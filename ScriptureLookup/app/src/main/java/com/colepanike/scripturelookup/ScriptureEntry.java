package com.colepanike.scripturelookup;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class ScriptureEntry extends ActionBarActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scripture_entry);

        btn = (Button) findViewById(R.id.share_btn);
        btn.setOnClickListener( new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("com.colepanike.android.activity_show_scripture");

                Spinner testament_spinner =(Spinner) findViewById(R.id.testament);
                String testament = testament_spinner.getSelectedItem().toString();

                EditText book_view = (EditText) findViewById(R.id.book);
                String book = book_view.getText().toString();

                EditText chapter_view = (EditText) findViewById(R.id.chapter);
                String chapter = chapter_view.getText().toString();

                EditText verse_view = (EditText) findViewById(R.id.verse);
                String verse = verse_view.getText().toString();

                intent.putExtra("testament", testament);
                intent.putExtra("book", book);
                intent.putExtra("chapter", chapter);
                intent.putExtra("verse", verse);

                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scripture_entry, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
