package com.example.parsaniahardik.recyclerview_edittext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CustomAdapter customAdapter;
    public ArrayList<EditModel> editModelArrayList;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.showData:
                Intent intent = new Intent(MainActivity.this,NextActivity.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        editModelArrayList = populateList();
        customAdapter = new CustomAdapter(this,editModelArrayList);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }

    private ArrayList<EditModel> populateList(){

        ArrayList<EditModel> list = new ArrayList<>();

        for(int i = 0; i < 8; i++){
            EditModel editModel = new EditModel();
            editModel.setEditTextValue(String.valueOf(i));
            list.add(editModel);
        }

        return list;
    }

}
