package com.example.actosoft.estadiohidalgowcheckbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MostrarResultados extends AppCompatActivity {

    TextView boletos, subtotal, localidad, precio, totalV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_resultados);

        Intent intento = getIntent();

        int numBoletosGeneral = intento.getIntExtra("numBoletosGeneral",0);
        int numBoletosPlatino = intento.getIntExtra("numBoletosPlatino", 0);
        int numBoletosVIP = intento.getIntExtra("numBoletosVIP", 0);
        int numBoletosPalco = intento.getIntExtra("numBoletosPalco", 0);
        int subtotalGeneral = intento.getIntExtra("subtotalGeneral", 0);
        int subtotalPlatino = intento.getIntExtra("subtotalPlatino", 0);
        int subtotalVIP = intento.getIntExtra("subtotalVIP", 0);
        int subtotalPalco = intento.getIntExtra("subtotalPalco", 0);
        int total = intento.getIntExtra("total", 0);

        if(numBoletosGeneral > 0)
        {
            boletos = (TextView) findViewById(R.id.noBoletosGral);
            boletos.setText(String.format(numBoletosGeneral + " boletos"));
            subtotal = (TextView) findViewById(R.id.subtotalGral);
            subtotal.setText(String.format("$" + subtotalGeneral));
        }
        else
        {
            localidad = (TextView) findViewById(R.id.localidadGral);
            localidad.setVisibility(TextView.GONE);

            precio = (TextView) findViewById(R.id.precioGral);
            precio.setVisibility(TextView.GONE);
        }

        if(numBoletosPlatino > 0)
        {
            boletos = (TextView) findViewById(R.id.noBoletosPlatino);
            boletos.setText(String.format(numBoletosPlatino + " boletos"));
            subtotal = (TextView) findViewById(R.id.subTotalPlatino);
            subtotal.setText(String.format("$" + subtotalPlatino));
        }
        else
        {
            localidad = (TextView) findViewById(R.id.localidadPlatino);
            localidad.setVisibility(TextView.GONE);

            precio = (TextView) findViewById(R.id.precioPlatino);
            precio.setVisibility(TextView.GONE);
        }

        if(numBoletosVIP > 0)
        {
            boletos = (TextView) findViewById(R.id.noBoletosVIP);
            boletos.setText(String.format(numBoletosVIP + " boletos"));
            subtotal = (TextView) findViewById(R.id.subtotalVIP);
            subtotal.setText(String.format("$" + subtotalVIP));
        }
        else
        {
            localidad = (TextView) findViewById(R.id.localidadVIP);
            localidad.setVisibility(TextView.GONE);

            precio = (TextView) findViewById(R.id.precioVIP);
            precio.setVisibility(TextView.GONE);
        }

        if(numBoletosPalco > 0)
        {
            boletos = (TextView) findViewById(R.id.noBoletosPalco);
            boletos.setText(String.format(numBoletosPalco + " boletos"));
            subtotal = (TextView) findViewById(R.id.subtotalPalco);
            subtotal.setText(String.format("$" + subtotalPalco));
        }
        else
        {
            localidad = (TextView) findViewById(R.id.localidadPalco);
            localidad.setVisibility(TextView.GONE);

            precio = (TextView) findViewById(R.id.precioPalco);
            precio.setVisibility(TextView.GONE);
        }


        totalV = (TextView) findViewById(R.id.Total);
        totalV.setText("Total a pagar: $" + total);

    }

}
