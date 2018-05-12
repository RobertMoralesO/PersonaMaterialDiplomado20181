package com.example.android.personasmaterialdiplomado20181;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallePersona extends AppCompatActivity {
    private TextView lblCedula;
    private TextView lblNombre;
    private TextView lblApellido;
    private TextView lblSexo;
    private String[] sexo;
    private Bundle bundle;
    private Intent i;
    private ImageView foto;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private String ced,nomb,apell,id;
    private int sex,fot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_persona);

        lblCedula = findViewById(R.id.lblCedulaDatos);
        lblNombre = findViewById(R.id.lblNombreDatos);
        lblApellido = findViewById(R.id.lblApellidoDatos);
        lblSexo = findViewById(R.id.lblSexoDatos);
        foto = findViewById(R.id.fotoPersona);
        collapsingToolbarLayout = findViewById(R.id.layout);
        sexo = getResources().getStringArray(R.array.sexo);
        i = getIntent();
        bundle = i.getBundleExtra("datos");

        ced = bundle.getString("cedula");
        nomb = bundle.getString("nombre");
        apell = bundle.getString("apellido");
        fot = bundle.getInt("foto");
        sex = bundle.getInt("sexo");
        id = bundle.getString("id");

        lblCedula.setText(ced);
        lblNombre.setText(nomb);
        lblApellido.setText(apell);
        lblSexo.setText(sexo[sex]);

        foto.setImageResource(fot);
        collapsingToolbarLayout.setTitle(nomb+" "+apell);


    }

    public void eliminar(View v){
        String positivo, negativo;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getResources().getString(R.string.eliminar));
        builder.setMessage(getResources().getString(R.string.mensaje_eliminar));
        positivo = getResources().getString(R.string.eliminar_si);
        negativo = getResources().getString(R.string.eliminar_no);

        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Persona p = new Persona(id);
                p.eliminar();
                onBackPressed();
            }
        });

        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(DetallePersona.this,Principal.class);
        startActivity(i);
    }

    public void modificar(View v){
        Intent i = new Intent(DetallePersona.this,Modificar.class);
        i.putExtra("datos",bundle);
        startActivity(i);
    }


}
