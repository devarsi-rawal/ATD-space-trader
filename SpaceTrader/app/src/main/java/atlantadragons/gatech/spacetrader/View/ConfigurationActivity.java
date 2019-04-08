package atlantadragons.gatech.spacetrader.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import atlantadragons.gatech.spacetrader.Model.GameMode;
import atlantadragons.gatech.spacetrader.Model.RepoHolder;
import atlantadragons.gatech.spacetrader.ViewModel.ConfigurationViewModel;


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

        ArrayAdapter<GameMode> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, GameMode.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modeSpinner.setAdapter(adapter);

        setTitle("Configuration");
        viewModel = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
    }

    public void onSubmit(View view) {
        //create new player with attributes and send to viewmodel
        String name = nameField.getText().toString();
        int pilot = Integer.parseInt(pilotField.getText().toString());
        int fighter = Integer.parseInt(fighterField.getText().toString());
        int trader = Integer.parseInt(traderField.getText().toString());
        int engineer = Integer.parseInt(engineerField.getText().toString());
        GameMode mode = (GameMode) modeSpinner.getSelectedItem();


        if (viewModel.setGame(name, pilot, fighter, trader, engineer, mode)) {
            startActivity(new Intent(ConfigurationActivity.this, PlanetActivity.class));
            finish();
        } else {
            errorBox.setText("Error: Skill points must add up to exactly 16");
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.load_save_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        RepoHolder rh = RepoHolder.getHolder();
        File file;

        switch (item.getItemId()) {
            case R.id.saveItem:
                file = new File(this.getFilesDir(), RepoHolder.DEFAULT_JSON_FILE_NAME);
                Toast.makeText(this, "Saved Game", Toast.LENGTH_SHORT).show();
                return rh.saveJson(file);
            case R.id.loadItem:
                file = new File(this.getFilesDir(), RepoHolder.DEFAULT_JSON_FILE_NAME);
                rh.loadJson(file);
                Toast.makeText(this, "Loaded Game", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ConfigurationActivity.this, PlanetActivity.class));
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
