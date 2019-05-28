package com.example.ejercicio1;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageView;
        import android.widget.ListView;
        import android.widget.TextView;

        import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String valor = getIntent().getStringExtra("usuario");
        String valor2 = getIntent().getStringExtra("horoscopo");
        String valor3 = getIntent().getStringExtra("genero");
        String valor4=getIntent().getStringExtra("edad");
        String valor5=getIntent().getStringExtra("rfc");


        TextView tvNombreLista = findViewById(R.id.tvNombreLista);
        TextView tvApellidoLista = findViewById(R.id.tvApellidoLista);
        ImageView ivImagenLista = findViewById(R.id.ivImagenLista);
        TextView tvedad= findViewById(R.id.tvedad);
        TextView tvhoroscopo= findViewById(R.id.texthoroscopo);
        TextView tvgenero= findViewById(R.id.tvGenero);
            ivImagenLista.setImageResource(R.drawable.persona);
            tvNombreLista.setText(valor);
            tvedad.setText(valor4);
            tvhoroscopo.setText(valor2);
            tvApellidoLista.setText(valor5);
            tvgenero.setText(valor3);





    }
}
