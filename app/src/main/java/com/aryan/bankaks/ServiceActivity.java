package com.aryan.bankaks;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.ActionBar.LayoutParams;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.aryan.bankaks.Model.BankaksModel;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceActivity extends AppCompatActivity {

    private TextView idd, op, ser;
    private Button btnOK;
    public BankaksModel model;
    public LinearLayout linearLayout;
    public boolean anyEmpty = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        idd = findViewById(R.id.idd);
        op = findViewById(R.id.opName);
        ser = findViewById(R.id.ser);
        linearLayout = findViewById(R.id.linearO);
        btnOK = findViewById(R.id.btnOK);

        Intent intent = getIntent();
        String type = intent.getStringExtra("type");

        // create the layout params that will be used to define how your
        // button will be displayed
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

        ResultAPI resultAPI = RetroURL.getInstance().create(ResultAPI.class);
        Call<BankaksModel> result = resultAPI.getBalanceDetail(type.toString());

        result.enqueue(new Callback<BankaksModel>() {
            @Override
            public void onResponse(Call<BankaksModel> call, Response<BankaksModel> response) {
                model = response.body();
                idd.setText(model.getResult().getScreen_title().toString());
                op.setText("Operator Name: "+model.getResult().getOperator_name().toString());
                ser.setText("Service ID: "+model.getResult().getService_id().toString());

                for(int j=0; j<model.getResult().getNumber_of_fields(); j++){

                    // Create LinearLayout
                    LinearLayout ll = new LinearLayout(ServiceActivity.this);
                    LayoutParams params = new LayoutParams(
                            LayoutParams.WRAP_CONTENT,
                            LayoutParams.WRAP_CONTENT
                    );
                    params.setMargins(0, 0, 0, 20);
                    ll.setLayoutParams(params);
                    ll.setOrientation(LinearLayout.HORIZONTAL);

                    if(model.getResult().getFields()[j].isIs_mandatory()) {
                        TextView tv = new TextView(ServiceActivity.this);
                        tv.setText("*  ");
                        ll.addView(tv);
                    }

                    // Create Placeholder
                    TextView pHolder = new TextView(ServiceActivity.this);
                    pHolder.setText(model.getResult().getFields()[j].getPlaceholder().toString() + "   ");
                    ll.addView(pHolder);


                    if(model.getResult().getFields()[j].getUi_type().getType().equals("textfield")) {
                        EditText editText = new EditText(ServiceActivity.this);
                        editText.setHint("" + model.getResult().getFields()[j].getHint_text().toString());
                        editText.setBackgroundResource(R.drawable.et_bg);

                        float scale = getResources().getDisplayMetrics().density;
                        int dpAsPixels = (int) (15 * scale + 0.5f);
                        editText.setPadding(dpAsPixels, dpAsPixels, dpAsPixels, dpAsPixels);
                        int dpAsWidthPixels = (int) (200 * scale + 0.5f);
                        editText.setSingleLine(true);
                        if(model.getResult().getFields()[j].getType().getData_type().equals("int")) {
                            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                        }

                        if(model.getResult().getFields()[j].isIs_mandatory()) {
                    //   ??
                        }

                        editText.setMaxWidth(dpAsWidthPixels);
                        ll.addView(editText);
                    }
                    else if(model.getResult().getFields()[j].getUi_type().getType().equals("dropdown")){
                        Spinner spinner = new Spinner(ServiceActivity.this);
                        spinner.setBackgroundResource(R.drawable.et_bg);
                        int value = model.getResult().getFields()[j].getUi_type().getValues().length;

                        String[] spinnerArray = new String[value];
                        HashMap<Integer,String> spinnerMap = new HashMap<Integer, String>();
                        for (int i = 0; i < value; i++)
                        {
                            spinnerMap.put(i, model.getResult().getFields()[j].getUi_type().getValues()[i].getId());
                            spinnerArray[i] = model.getResult().getFields()[j].getUi_type().getValues()[i].getName();
                        }

                        ArrayAdapter<String> adapter =new ArrayAdapter<String>(ServiceActivity.this,android.R.layout.simple_spinner_item, spinnerArray);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner.setAdapter(adapter);

                        float scale = getResources().getDisplayMetrics().density;
                        int dpAsPixels = (int) (15 * scale + 0.5f);
                        spinner.setPadding(dpAsPixels, dpAsPixels, dpAsPixels, dpAsPixels);
                        adapter.notifyDataSetChanged();
                        ll.addView(spinner);


//                        Checking the key and value for spinner

//                        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                            @Override
//                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                                Toast.makeText(ServiceActivity.this, ""+spinnerMap.get(position), Toast.LENGTH_SHORT).show();
//                            }
//
//                            @Override
//                            public void onNothingSelected(AdapterView<?> parent) {
//
//                            }
//                        });
                    }


                    //Add view to LinearLayout defined in XML
                    linearLayout.addView(ll);

                }
            }

            @Override
            public void onFailure(Call<BankaksModel> call, Throwable t) {
                Toast.makeText(ServiceActivity.this, "Sorry can not load data currently", Toast.LENGTH_SHORT).show();
            }
        });

        btnOK.setOnClickListener(v -> {
            if(anyEmpty)
            {
                Toast.makeText(this, "Please fill all the mandatory fields!", Toast.LENGTH_SHORT).show();
            }
            else{
                Intent finalIntent = new Intent(ServiceActivity.this, FinalActivity.class);
                startActivity(finalIntent);
            }
        });
    }

}
