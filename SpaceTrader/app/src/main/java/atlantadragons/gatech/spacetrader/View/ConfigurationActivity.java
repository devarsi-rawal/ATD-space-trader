package atlantadragons.gatech.spacetrader.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.TextView;

import java.util.ArrayList;

import atlantadragons.gatech.spacetrader.Model.GameMode;
import atlantadragons.gatech.spacetrader.ViewModel.ConfigurationViewModel;
import atlantadragons.gatech.spacetrader.Model.Player;


public class ConfigurationActivity extends AppCompatActivity {

    private ConfigurationViewModel viewModel;

    private EditText nameField;
    private EditText pilotField;
    private EditText fighterField;
    private EditText traderField;
    private EditText engineerField;
    private TextView errorBox;
    private Spinner modeSpinner;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        nameField = findViewById(R.id.nameBox);
        pilotField = findViewById(R.id.pilot);
        fighterField = findViewById(R.id.fighter);
        traderField = findViewById(R.id.trader);
        engineerField = findViewById(R.id.engineer);
        modeSpinner = findViewById(R.id.mode_spinner);
        Button button = findViewById(R.id.newPlayerButton);
        errorBox = findViewById(R.id.errorBox);

        ArrayAdapter<GameMode> adapter = new ArrayAdapter<GameMode>(this, android.R.layout.simple_spinner_item, GameMode.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modeSpinner.setAdapter(adapter);

        setTitle("Configuration");
        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
    }

    public void onSubmit(View view) {
        //create new player with attibutes and send to viewmodel
        String name = nameField.getText().toString();
        int pilot = Integer.parseInt(pilotField.getText().toString());
        int fighter = Integer.parseInt(fighterField.getText().toString());
        int trader = Integer.parseInt(traderField.getText().toString());
        int engineer = Integer.parseInt(engineerField.getText().toString());
        GameMode mode = (GameMode) modeSpinner.getSelectedItem();


        if (viewModel.setGame(name, pilot, fighter, trader, engineer, mode)) {
            startActivity(new Intent(ConfigurationActivity.this, PlanetActivity.class));
        } else {
            errorBox.setText("Error: Skill points must add up to exactly 16");
        }


    }
}
