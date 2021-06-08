package sg.edu.rp.c346.id20026955.democolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

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
                if (etIndex.getText().toString().isEmpty() == false){
                    int pos =Integer.parseInt(etIndex.getText().toString());
                    alColours.add(pos,colour);
                }else{
                    alColours.add(colour);
                }
                aaColours.notifyDataSetChanged();
            }
        });

        lvColour.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = alColours.get(position);
                Toast.makeText(MainActivity.this, "Selected colour is: " + msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}