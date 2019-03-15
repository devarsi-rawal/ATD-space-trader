package atlantadragons.gatech.spacetrader.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import atlantadragons.gatech.spacetrader.Model.Resource;
import atlantadragons.gatech.spacetrader.ViewModel.TradeViewModel;

public class TradeActivity extends AppCompatActivity {

    private TradeViewModel viewModel;

    private TextView resourceName;
    private TextView creditsView;
    private TextView priceView;
    private TextView cargoStockView;
    private TextView inStockView;
    private EditText input;
    private Button buyButton;
    private Button sellButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trade);

        final int resourceID = getIntent().getIntExtra("RESOURCE_ID", 0);
        Resource resource = Resource.values()[resourceID];

        resourceName = findViewById(R.id.resourceName);
        creditsView = findViewById(R.id.creditsView);
        priceView =  findViewById(R.id.priceView);
        cargoStockView = findViewById(R.id.cargoStockView);
        inStockView  =findViewById(R.id.inStockView);
        input = findViewById(R.id.quantityInput);
        buyButton = findViewById(R.id.buyButton);
        sellButton = findViewById(R.id.sellButton);

        setTitle("Trade Resource");
        viewModel = ViewModelProviders.of(this).get(TradeViewModel.class);

        resourceName.setText(resource.getName());
        priceView.setText(String.format("Buy Price: %.2f\tSell Price: %.2f",
                viewModel.getMarketPrices().get(resourceID),
                viewModel.getMarketPrices().get(resourceID)/2
                ));
        creditsView.setText(String.format("Credits: %.2f", viewModel.getCredits()));
        cargoStockView.setText(String.format("You have: %d units (%d Total)", viewModel.getCargoStock().get(resourceID), viewModel.getGoodsCount()));
        inStockView.setText(String.format("In Stock: %d units", viewModel.getMarketStock().get(resourceID)));

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = Integer.parseInt(input.getText().toString());
                if (viewModel.buyGood(resourceID, quantity, viewModel.getMarketPrices().get(resourceID))) {
                    closeKeyboard();
                    creditsView.setText(String.format("Credits: %.2f", viewModel.getCredits()));
                    cargoStockView.setText(String.format("You have: %d units (%d Total)", viewModel.getCargoStock().get(resourceID), viewModel.getGoodsCount()));
                    inStockView.setText(String.format("In Stock: %d units", viewModel.getMarketStock().get(resourceID)));
                } else {
                    Toast.makeText(getBaseContext(), "Please review transaction decision", Toast.LENGTH_LONG).show();
                }
            }
        });

        sellButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeKeyboard();
                int quantity = Integer.parseInt(input.getText().toString());
                if (viewModel.sellGood(resourceID, quantity, viewModel.getMarketPrices().get(resourceID))) {
                    creditsView.setText(String.format("Credits: %.2f", viewModel.getCredits()));
                    cargoStockView.setText(String.format("You have: %d units (%d Total)", viewModel.getCargoStock().get(resourceID), viewModel.getGoodsCount()));
                    inStockView.setText(String.format("In Stock: %d units", viewModel.getMarketStock().get(resourceID)));
                } else {
                    Toast.makeText(getBaseContext(), "Please review transaction decision", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(TradeActivity.this, MarketActivity.class));
        finish();
    }

    private void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
