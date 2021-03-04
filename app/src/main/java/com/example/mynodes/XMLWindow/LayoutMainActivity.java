package com.example.mynodes.XMLWindow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mynodes.ClassJava.NotesClass;
import com.example.mynodes.ClassJava.NotesXML;
import com.example.mynodes.R;

import org.xmlpull.v1.XmlPullParser;

public class LayoutMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_main);
        ListView v = (ListView)findViewById(R.id.nodeitems);

        XmlPullParser xpp = getResources().getXml(R.xml.notes);
        NotesXML parser = new NotesXML();
        if(parser.parse(xpp)){
            for(NotesClass notesClass : parser.getNotes()) {
                Log.d("XML", notesClass.toString());
            }

            ArrayAdapter<NotesClass> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, parser.getNotes());
            v.setAdapter(adapter);
        }
    }
}