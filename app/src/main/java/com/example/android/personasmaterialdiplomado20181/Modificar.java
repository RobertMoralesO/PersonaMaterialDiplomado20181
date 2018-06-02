package com.example.android.personasmaterialdiplomado20181;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Modificar extends AppCompatActivity {
    private EditText txtCedula, txtNombre, txtApellido;
    private Spinner cmbSexo;
    private ArrayAdapter<String> adapter;
    private String opc[];
    private Intent i;
    private Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        txtCedula = findViewById(R.id.txtCedulaModificar);
        txtNombre = findViewById(R.id.txtNombreModificar);
        txtApellido = findViewById(R.id.txtApellidoModificar);
        cmbSexo = findViewById(R.id.cmbSexoModificar);

        opc = this.getResources().getStringArray(R.array.sexo);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc);
        cmbSexo.setAdapter(adapter);

        i = getIntent();
        b = i.getBundleExtra("datos");

        txtCedula.setText(b.getString("cedula"));
        txtNombre.setText(b.getString("nombre"));
        txtApellido.setText(b.getString("apellido"));
        cmbSexo.setSelection(b.getInt("sexo"));



    }

    public void guardar(View v){
        String ced, nomb,apell, foto,id;
        int  sexo;

        id = b.getString("id");
        ced = txtCedula.getText().toString();
        nomb = txtNombre.getText().toString();
        apell = txtApellido.getText().toString();
        sexo = cmbSexo.getSelectedItemPosition();
        //foto = b.getInt("foto");
        foto ="";
        Persona p = new Persona(id,foto,ced,nomb,apell,sexo);
        if(b.getString("cedula").equals(ced)){
            p.modificar();
            Snackbar.make(v,getResources().getString(R.string.mensaje_modificar),Snackbar.LENGTH_SHORT)
                    .setAction("Action",null).show();
        }else{
            if(Datos.validar_existencia(Datos.obtener(),ced)){
                txtCedula.setError(getResources().getString(R.string.mensaje_error_cedula_existente));
                txtCedula.requestFocus();
            }else{
                p.modificar();
                Snackbar.make(v,getResources().getString(R.string.mensaje_modificar),Snackbar.LENGTH_SHORT)
                        .setAction("Action",null).show();
            }
        }
    }

    public void limpiar(){
        txtCedula.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        cmbSexo.setSelection(0);
        txtCedula.requestFocus();
    }

    public void limpiar(View v){
        limpiar();
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(Modificar.this,Principal.class);
        startActivity(i);
    }
}
