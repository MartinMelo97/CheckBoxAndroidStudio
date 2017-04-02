package com.example.actosoft.estadiohidalgowcheckbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chboxGral, chboxVIP, chboxPlatino, chboxPalco;
    EditText inputGral, inputVIP, inputPlatino, inputPalco;
    int no_boletos,total, subtotal;
    Button compra;
    boolean boolGral, boolVIP, boolPlatino, boolPalco;
    Intent intento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chboxGral = (CheckBox) findViewById(R.id.chboxGral);
        chboxVIP = (CheckBox) findViewById(R.id.chboxVIP);
        chboxPlatino = (CheckBox) findViewById(R.id.chboxPlatino);
        chboxPalco = (CheckBox) findViewById(R.id.chboxPalco);

        inputGral = (EditText) findViewById(R.id.inputGral);
        inputVIP = (EditText) findViewById(R.id.inputVIP);
        inputPlatino = (EditText) findViewById(R.id.inputPlatino);
        inputGral = (EditText) findViewById(R.id.inputPalco);

        compra = (Button) findViewById(R.id.btnCompra);

        compra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intento = new Intent(MainActivity.this, MostrarResultados.class);
                total = 0;

                boolGral = checked(chboxGral, inputGral, "General", 100, intento);
                boolPlatino = checked(chboxPlatino, inputPlatino, "Platino", 300, intento);
                boolVIP = checked(chboxVIP, inputVIP, "VIP", 250, intento);
                boolPalco = checked(chboxPalco, inputPalco, "Palco", 500, intento);

                if(boolGral && boolPlatino && boolVIP && boolPalco)
                {
                    intento.putExtra("total", total);
                    startActivity(intento);
                }


            }
        });

    }

    public boolean checked(CheckBox check, EditText boletos, String localidad, int precio, Intent intento)
    {
        if(check.isChecked())
        {
            Toast.makeText(this, "Esta chequeado", Toast.LENGTH_SHORT).show();
            try
            {
                no_boletos = Integer.parseInt(boletos.getText().toString());

                Toast.makeText(this, "Hola", Toast.LENGTH_SHORT).show();
                if(no_boletos > 0)
                {
                    Toast.makeText(this, "Holax2", Toast.LENGTH_SHORT).show();
                    subtotal = no_boletos * precio;
                    total = total + subtotal;
                    intento.putExtra("numBoletos" + localidad, no_boletos);
                    intento.putExtra("subtotal" + localidad, subtotal);
                    return true;
                }
                else
                {
                    Toast.makeText(this, "Elige un numero valido en "+localidad, Toast.LENGTH_SHORT).show();
                    //intento.putExtra("numBoletos" + localidad, 0);
                  //  intento.putExtra("subtotal" + localidad, 0);
                    return false;
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                Toast.makeText(this, "Ingresa numero de boletos en "+localidad, Toast.LENGTH_SHORT).show();
                //intento.putExtra("numBoletos" + localidad, 0);
                //intento.putExtra("subtotal" + localidad, 0);
                return false;
            }
        }
        return true;
    }
}
