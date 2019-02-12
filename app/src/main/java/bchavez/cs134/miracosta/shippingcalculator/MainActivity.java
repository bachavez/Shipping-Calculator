package bchavez.cs134.miracosta.shippingcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());
    String weight = "0";

    //Member Variables for each component used in the app
    private EditText inputWeight;
    private TextView outputBaseCost;
    private TextView outputAddedCost;
    private TextView outputTotalCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialze Link to the view
        inputWeight = findViewById(R.id.inputWeight);
        outputBaseCost = findViewById(R.id.outputBaseCost);
        outputAddedCost = findViewById(R.id.outputAddedCost);
        outputTotalCost = findViewById(R.id.outputTotalCost);

        //Initialize Link to the Model

        final ShippingCost currentShippingCost = new ShippingCost();

        //connect code to the event that the text is changed

        inputWeight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                weight = inputWeight.getText().toString();
                if (weight.equals("")){
                    weight = "0";
                }

                currentShippingCost.setWeight(Double.parseDouble(weight));
                outputBaseCost.setText(currency.format(currentShippingCost.getBaseCost()));
                outputAddedCost.setText(currency.format(currentShippingCost.getAddedCost()));
                outputTotalCost.setText(currency.format(currentShippingCost.getTotalCost()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
