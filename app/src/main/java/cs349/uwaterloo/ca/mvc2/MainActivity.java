package cs349.uwaterloo.ca.mvc2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;

// Based Upon: Android/MVC2
public class MainActivity extends AppCompatActivity implements Observer {

    Button button;
    Button setting;

    Model model;

    /**
       onCreate is Called when application is initially launched.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Set Content View
        setContentView(R.layout.activity_main);

        // Get Model instance
        model = Model.getInstance();
        model.addObserver(this);

        // Get button reference.
        button = (Button) findViewById(R.id.view1_button);
        setting = (Button)  findViewById(R.id.view1_setting);

        // Create controller to go to game(second) activity
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(myIntent);
            }
        });

        // Create controller to go to setting activity
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, SettingActivity.class);
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
    public void update(Observable o, Object arg) {

    }
}
