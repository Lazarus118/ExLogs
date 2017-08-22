package co.aulatech.exlogs;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;

public class MainActivity extends AppCompatActivity {
    // DatabaseReference database;
    Data d;
    static int amount = 50;
    static Long monday, tuesday, wednesday, thursday, friday, saturday, sunday = 0L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //////////////////////////////////////////////////////////////////////
        d = new Data(monday);

//        database = FirebaseDatabase.getInstance().getReference();
//        database.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                monday = (Long) dataSnapshot.child("data").child("Monday").getValue();
//                d.setMonday(monday);
//            }
//            @Override
//            public void onCancelled(DatabaseError databaseError) {}
//        });
        Toast.makeText(getApplicationContext(), "" + d.getMonday(), Toast.LENGTH_SHORT).show();

        // SPINNER INIT & LOGIC
        //////////////////////////////////////////////////////////////////////
        Spinner dropdown = (Spinner) findViewById(R.id.spinner);
        String[] items = new String[]{"Amount ... ", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70", "75", "80", "85", "90", "95", "100"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                switch (selectedItem) {
                    case "10":
                        amount = 10;
                        break;
                    case "15":
                        amount = 15;
                        break;
                    case "20":
                        amount = 20;
                        break;
                    case "25":

                        break;
                    case "30":

                        break;
                    case "35":

                        break;
                    case "40":

                        break;
                    case "45":

                        break;
                    case "50":

                        break;
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        // SPINNER 1 INIT & LOGIC
        //////////////////////////////////////////////////////////////////////
        Spinner dropdown1 = (Spinner) findViewById(R.id.spinner1);
        String[] items1 = new String[]{"Day ... ", "Sunday", "Monday", "Tuesday", "Wednesday", "Thurday", "Friday", "Saturday"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        dropdown1.setAdapter(adapter1);
        dropdown1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                switch (selectedItem) {
                    case "Sunday":
                           sunday = 0L;
                        break;
                    case "Monday":
                            monday = 1L;
                        break;
                    case "Tuesday":
                            tuesday = 2L;
                        break;
                    case "Pearl's Cuisine":

                        break;
                    case "Fusion Village":

                        break;
                    case "Urban Garden Cafe":

                        break;
                    case "The Champs Picard":

                        break;
                    case "Guiyave Restaurant & Patisserie":

                        break;
                    case "Fort Young Hotel":

                        break;
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //////////////////////////////////////////////////////////////////////
        SeekBar simpleSeekBar = (SeekBar)findViewById(R.id.seekBar); // initiate the Seek bar
        simpleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                GraphView graph = (GraphView) findViewById(R.id.graph);
                BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[]{
                        new DataPoint(1, i),
                        new DataPoint(2, 0),
                        new DataPoint(3, 0),
                        new DataPoint(4, 0),
                        new DataPoint(5, 15),
                        new DataPoint(6, 0),
                        new DataPoint(7, 0)
                });
                graph.addSeries(series);
                // draw values on top
                series.setDrawValuesOnTop(true);
                series.setValuesOnTopColor(Color.LTGRAY);
                series.setColor(Color.DKGRAY);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        //////////////////////////////////////////////////////////////////////
        Button submit = (Button) findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount = 10;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}
