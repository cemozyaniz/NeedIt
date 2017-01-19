package com.example.okanaydin.needit;

import android.content.Intent;
import android.database.DataSetObserver;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

public class bagisci extends AppCompatActivity {

    public ListView liste;
    public Button fotoadd;
    public static int TAKE_PICTURE = 1;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bagisci);
        liste = (ListView) findViewById(R.id.bagislananlar);


        fotoadd = (Button) findViewById(R.id.button);
        fotoadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photo_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photo_intent , TAKE_PICTURE);


            }

        });

        adapter = new ListAdapter() {
            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEnabled(int position) {
                return false;
            }

            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return null;
            }

            @Override
            public int getItemViewType(int position) {
                return 0;
            }

            @Override
            public int getViewTypeCount() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }
        };

        liste.setAdapter(adapter);


    }

        protected void onActivityResult(int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode,resultCode,data);
            if(resultCode != RESULT_OK)
                return;
            if (requestCode == 1){
                Bundle extras = data.getExtras();

            }
    }


    }



