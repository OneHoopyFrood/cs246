package com.colepanike.favoritescripture;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;


public class ScriptureInput extends ActionBarActivity implements OnClickListener {

    Button btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scripture_input);

        btnShare = (Button) findViewById(R.id.share_btn);
        btnShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(getApplicationContext(), ShowScripture.class);

        EditText textField;
        textField = (EditText) findViewById(R.id.book);
        String book = textField.getText().toString();
        textField = (EditText) findViewById(R.id.chapter);
        int chap = Integer.parseInt(textField.getText().toString());
        textField = (EditText) findViewById(R.id.verse);
        int verse = Integer.parseInt(textField.getText().toString());

        intent.putExtra("book", book);
        intent.putExtra("chap", chap);
        intent.putExtra("verse", verse);

        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scripture_input, menu);

        btnShare = (Button) findViewById(R.id.share_btn);
        btnShare.setOnClickListener(this);
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
