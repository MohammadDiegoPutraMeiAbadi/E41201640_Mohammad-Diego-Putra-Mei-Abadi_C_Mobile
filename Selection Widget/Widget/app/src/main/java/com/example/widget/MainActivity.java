package com.example.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String[] Prodi = new String[]{
            "Teknik Informatika", "Teknik Komputer", "Manajemen Informatika"
    };

    public static final String[] Bayar = new String[]{
            "BRI", "BNI", "BCA", "Bank Jatim", "GO-PAY", "DANA"
    };

    Spinner gol;
    Spinner ukt;
    ListView ListBayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //AUTOCOMPLETETEXT PRODI
        AutoCompleteTextView editText = findViewById(R.id.Prodi);
        ArrayAdapter<String> adapterProdi = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,Prodi);
        editText.setAdapter(adapterProdi);

        //SPINNER GOLONGAN
        gol = findViewById(R.id.Golongan);
        ArrayAdapter<CharSequence> golongan = ArrayAdapter.createFromResource(this,R.array.Gol, android.R.layout.simple_spinner_dropdown_item);
        golongan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        gol.setAdapter(golongan);

        gol.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String Golongan = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Choose: " +Golongan, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //SPINNER UKT
        ukt = findViewById(R.id.UKT);
        ArrayAdapter<CharSequence> uang = ArrayAdapter.createFromResource(this, R.array.Ukt, android.R.layout.simple_spinner_item);
        uang.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ukt.setAdapter(uang);

        ukt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String Uangkt = parent.getItemAtPosition(position).toString();
                Toast.makeText(parent.getContext(), "Choose: " +Uangkt, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //LISTVIEW BAYAR
        ListBayar = findViewById(R.id.lvBayar);
        ArrayAdapter<String> pembayaran = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Bayar);
        ListBayar.setAdapter(pembayaran);
        ListBayar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String bayar = ((TextView) view).getText().toString();
                Toast.makeText(getApplicationContext(), "Clicked"+bayar, Toast.LENGTH_SHORT).show();
            }
        });

    }
}