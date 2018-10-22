package cs349.uwaterloo.ca.mvc2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

// Based Upon: Android/MVC2
public class SettingActivity extends AppCompatActivity implements Observer {
    private Spinner NumberOfButtons;
    private Spinner difficulty ;
    private Button update;
    private Button back;

    private Model model;

    /**
     * OnCreate is Called when application is initially launched.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        // Get Model instance
        model = Model.getInstance();
        model.addObserver(this);

        // set spinner references
        NumberOfButtons = (Spinner) findViewById(R.id.game_button);
        difficulty = (Spinner) findViewById(R.id.game_difficulty);

        // 6 choice of number of buttons
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                R.layout.spinner, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        NumberOfButtons.setAdapter(dataAdapter);

        // default number of buttons
        String defaultbuttons = model.getButtonNumbers();

        if (!defaultbuttons.equals(null)) {
            int spinnerPosition = dataAdapter.getPosition(defaultbuttons);
            NumberOfButtons.setSelection(spinnerPosition);
        }

        // 3 choice of difficulties
        List<String> list2 = new ArrayList<String>();
        list2.add("Easy");
        list2.add("Normal");
        list2.add("Hard");
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                R.layout.spinner, list2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficulty.setAdapter(dataAdapter2);

        // default difficulty
        String defaultdifficulty = model.getDifficulty();

        if (!defaultdifficulty.equals(null)) {
            int spinnerPosition = dataAdapter2.getPosition(defaultdifficulty);
            difficulty.setSelection(spinnerPosition);
        }

        // save button that save changes
        update = (Button) findViewById(R.id.game_submit);

        // Create controller to save changes
        update.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                model.Save(String.valueOf(NumberOfButtons.getSelectedItem()), String.valueOf(difficulty.getSelectedItem()));

                Toast.makeText(SettingActivity.this,
                        "Successfully Saved",
                        Toast.LENGTH_SHORT).show();
            }

        });

        // back button
        back = (Button) findViewById(R.id.game_back);

        // Create controller to go to main activity
        back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent myIntent = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
        });

        // Init observers
        model.initObservers();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();

        // Remove observer when activity is destroyed.
        model.deleteObserver(this);
    }

    /**
     * This method is called whenever the observed object is changed.
     */
    @Override
    public void update(Observable o, Object arg) {

    }

}