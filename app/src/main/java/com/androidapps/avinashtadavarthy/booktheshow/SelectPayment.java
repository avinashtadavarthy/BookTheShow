package com.androidapps.avinashtadavarthy.booktheshow;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SelectPayment extends AppCompatActivity {

    EditText final_card, final_nameoncard, final_mm, final_yyyy, final_cvv;
    ImageView visa, mastercard;
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_payment);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.action_bar_payment);

        final_card = (EditText) findViewById(R.id.final_card);
        final_nameoncard = (EditText) findViewById(R.id.final_nameoncard);
        final_mm = (EditText) findViewById(R.id.final_mm);
        final_yyyy = (EditText) findViewById(R.id.final_yyyy);
        final_cvv = (EditText) findViewById(R.id.final_cvv);

        visa = (ImageView) findViewById(R.id.visa);
        mastercard = (ImageView) findViewById(R.id.mastercard);

        error = (TextView) findViewById(R.id.error);

        final_card.addTextChangedListener(new TextWatcher() {
            int count = 0;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                /*if(final_card.getText().toString() != "") {
                    switch(final_card.getText().toString().substring(0, 1)){
                        case "4": visa.setBackground(ContextCompat.getDrawable(SelectPayment.this, R.drawable.spinner_border)); break;
                        case "5": mastercard.setBackground(ContextCompat.getDrawable(SelectPayment.this, R.drawable.spinner_border)); break;
                        default:  error.setText("Only Visa or MasterCard"); break;
                    }
                } */

               if(final_card.getText().toString().length() != 19  || final_card.getText().toString() == ""){
                   final_card.setBackground(ContextCompat.getDrawable(SelectPayment.this, R.drawable.bottom_stroke_red));
               }
            }

            @Override
            public void afterTextChanged(Editable s) {

                if (count <= final_card.getText().toString().length()
                        &&(final_card.getText().toString().length()==4
                        ||final_card.getText().toString().length()==9
                        ||final_card.getText().toString().length()==14)){
                    final_card.setText(final_card.getText().toString()+" ");
                    int pos = final_card.getText().length();
                    final_card.setSelection(pos);
                }else if (count >= final_card.getText().toString().length()
                        &&(final_card.getText().toString().length()==4
                        ||final_card.getText().toString().length()==9
                        ||final_card.getText().toString().length()==14)){
                    final_card.setText(final_card.getText().toString().substring(0,final_card.getText().toString().length()-1));
                    int pos = final_card.getText().length();
                    final_card.setSelection(pos);
                }
                count = final_card.getText().toString().length();

                 if(final_card.getText().toString().length() != 19 || final_card.getText().toString() == "")
                    final_card.setBackground(ContextCompat.getDrawable(SelectPayment.this, R.drawable.bottom_stroke_red));
                else
                    final_card.setBackground(ContextCompat.getDrawable(SelectPayment.this, R.drawable.bottom_stroke));


            }
        });

    }
}
