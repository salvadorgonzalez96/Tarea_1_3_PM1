package com.example.Tarea_1_3_SQLite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.Tarea_1_3_SQLite.configuracion.SQLiteConexion;
import com.example.Tarea_1_3_SQLite.configuracion.Transacciones;

public class ActivityIngresar extends AppCompatActivity
{
    EditText id, nombres, apellidos, edad, correo, direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);
        id = (EditText) findViewById(R.id.txtid);
        nombres = (EditText) findViewById(R.id.txtnombre);
        apellidos =(EditText) findViewById(R.id.txtapellidos);
        edad = (EditText)  findViewById(R.id.txtedad);
        correo = (EditText) findViewById(R.id.txtcorreo);
        direccion = (EditText) findViewById(R.id.txtdireccion);

        Button btnguardar = (Button) findViewById(R.id.btnguardar);
        btnguardar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                AgregarPersonas();
            }
        });

        Button btnatras = (Button) findViewById(R.id.btnAtras);
        btnatras.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent pantalla = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(pantalla);
            }
        });

    }
    private void AgregarPersonas()
    {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Transacciones.id, id.getText().toString());
        valores.put(Transacciones.nombres, nombres.getText().toString());
        valores.put(Transacciones.apellidos, apellidos.getText().toString());
        valores.put(Transacciones.edad, edad.getText().toString());
        valores.put(Transacciones.correo, correo.getText().toString());
        valores.put(Transacciones.direccion, direccion.getText().toString());

        Long resultado = db.insert(Transacciones.tablaPersonas,Transacciones.id,valores);
        Toast.makeText(getApplicationContext(), "El Registro sea Ingresado Exitosamente: " +  id.getText().toString(),Toast.LENGTH_LONG).show();
        db.close();
        //LimpiarPantalla();
        PantallaInicio();
    }

    private void LimpiarPantalla()
    {
        id.setText("");
        nombres.setText("");
        apellidos.setText("");
        edad.setText("");
        correo.setText("");
        direccion.setText("");
    }

    private void PantallaInicio(){
        Intent pantalla = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(pantalla);
    }
}