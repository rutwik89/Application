package com.example.sppinerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;                                   //taking taxtview
    EditText editText;					//taking edit text
    Spinner spinner;					 //taking spinner
    static String string,string1;
    RadioButton radioButton,radioButton1;		 //taking radiobutton and radiogroup
    RadioGroup radioGroup;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner=findViewById(R.id.spinner);
        textView=findViewById(R.id.textView);
        editText=findViewById(R.id.editTextTextPersonName);
        radioButton=findViewById(R.id.radioButton);
        radioButton1=findViewById(R.id.radioButton2);
        radioGroup=findViewById(R.id.radio_may);
        checkBox=findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked())                              //checking the checkbox is visible or not if visible all text are invisble and visa versa
                {
                    editText.setVisibility(View.INVISIBLE);                 // coding for invisible text
                    radioGroup.setVisibility(View.INVISIBLE);
                    spinner.setVisibility(View.INVISIBLE);
                    textView.setVisibility(View.INVISIBLE);
                }else
                {
                    editText.setVisibility(View.VISIBLE);                  // coding for visible text
                    radioGroup.setVisibility(View.VISIBLE);
                    spinner.setVisibility(View.VISIBLE);
                    textView.setVisibility(View.VISIBLE);
                }

            }
        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() //set on item select listener on spinner is it will shows drop down list
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String s= editText.getText().toString().trim();
                string= String.valueOf(adapterView.getItemAtPosition(i));
                string=string + "\n Welcome " +s +string1;
                textView.setText(string);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void onRadioButtonClicked(View view)  {
    boolean status_checked=((RadioButton)view).isChecked();
        switch (view.getId())
    {
        case R.id.radioButton:
            if(status_checked)                   //checking for male
            {
                string1= "\n"+"Gender "+radioButton.getText().toString().trim();
            }

            break;
        case R.id.radioButton2:	         
            if(status_checked) {
                string1 = "\n"+"Gender " + radioButton1.getText().toString().trim() + "\n";
            }
            break;
    }

}
}