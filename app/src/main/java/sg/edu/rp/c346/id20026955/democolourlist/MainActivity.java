package sg.edu.rp.c346.id20026955.democolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import sg.edu.rp.c346.id20026955.democolourlist.R;

public class MainActivity extends AppCompatActivity {

    EditText etElement;
    Button btnAdd;
    ListView lvColour;
    ArrayList<String> alColours;
    ArrayAdapter<String> aaColours;
    EditText etIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etElement = findViewById(R.id.editTextColour);
        btnAdd = findViewById(R.id.buttonAddItem);
        lvColour = findViewById(R.id.listViewColour);
        etIndex = findViewById(R.id.editTextIndex);

        alColours = new ArrayList<String>();
        //add
        alColours.add("Red");
        alColours.add("Orange");

        aaColours = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, alColours);

        lvColour.setAdapter(aaColours);

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String colour = etElement.getText().toString();
                alColours.add(colour);
                aaColours.notifyDataSetChanged();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String colour = etElement.getText().toString();
                // alColours .add (colour);
                int pos =Integer.parseInt(etIndex.getText().toString());
                alColours.add(pos,colour);
                aaColours.notifyDataSetChanged();
            }
        });
    }
}