package com.example.ejercicio1;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    private static final String LOGTAG = "INFORMACIÓN";


    private TextView tvTexto1;
    private Button btnBoton1;
    private Button btnBoton2;
    private EditText text;
    private EditText fecha;
    private Spinner genero;
    String date2;
    String horoscopo;
    int dia,mess,mes,ano,resano,contador;

    String[] names = { "Hombre", "Mujer" };


@Override
        protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    tvTexto1 = findViewById(R.id.tvTexto1);

    btnBoton1 = findViewById(R.id.btnBoton1); //enviar
    btnBoton2 = findViewById(R.id.btnBoton2); //limpiar
    text = (EditText) findViewById(R.id.editnombre);

        fecha = (EditText) findViewById(R.id.editfecha);

        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.editfecha:
                        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                month = month + 1;
                                dia = day;
                                mess = month;
                                ano = year;
                                if (day < 10 && month < 10) {
                                    final String selectedDate = "0" + day + "/0" + month + "/" + year;
                                    date2 = year + "0" + month + "0" + day;
                                    fecha.setText(selectedDate);
                                } else if (day < 10 && month > 9) {
                                    final String selectedDate = "0" + day + "/" + month + "/" + year;
                                    date2 = year + "" + month + "0" + day;
                                    fecha.setText(selectedDate);
                                } else if (day > 9 && month < 10) {
                                    final String selectedDate = day + "/0" + month + "/" + year;
                                    date2 = year + "0" + month + "" + day;
                                    fecha.setText(selectedDate);
                                } else {
                                    final String selectedDate = day + "/" + month + "/" + year;
                                    date2 = year + "" + month + "" + day;
                                    fecha.setText(selectedDate);
                                }

                            }
                        });
                        newFragment.show(getSupportFragmentManager(), "datePicker");
                        break;
                }
            }
        });
        genero = (Spinner) findViewById(R.id.spinnergenero);

        ArrayAdapter adapter = ArrayAdapter.createFromResource( this, R.array.genero_spinner , android.R.layout.simple_spinner_item);

        //ArrayAdapter adapter = new ArrayAdapter<String>(this,
          //      android.R.layout.simple_spinner_dropdown_item, R.array.genero_spinner);

        genero.setAdapter(adapter);
        btnBoton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String nombrecom = text.getText().toString();
                String fechacom = fecha.getText().toString();
                String generocom = genero.getSelectedItem().toString();
                TimeZone tz = TimeZone.getTimeZone("GMT+05:30");
                Calendar c = Calendar.getInstance(tz);
                String mont = String.format("%02d" , c.get(Calendar.MONTH));
                int mess11=Integer.parseInt(mont);
                String year = String.format("%02d" , c.get(Calendar.YEAR));
                int mess111=Integer.parseInt(year);
                mes = mess;
                    if (mes <= mess11+1) {
                        resano = mess111 - ano;
                        if (mes == 1) {
                            if (dia < 21) {
                                horoscopo = getResources().getString(R.string.horocopo_Capricornio);
                            } else {
                                horoscopo = getResources().getString(R.string.horocopo_Acuario);
                            }
                        } else if (mes == 2) {
                            if (dia < 20) {
                                horoscopo = getResources().getString(R.string.horocopo_Acuario);
                            } else {
                                horoscopo = getResources().getString(R.string.horocopo_Piscis);
                            }

                        } else if (mes == 3) {
                            if (dia < 21) {
                                horoscopo = getResources().getString(R.string.horocopo_Piscis);
                            } else {
                                horoscopo = getResources().getString(R.string.horocopo_Aries);
                            }

                        } else if (mes == 4) {
                            if (dia < 21) {
                                horoscopo = getResources().getString(R.string.horocopo_Aries);
                            } else {
                                horoscopo = getResources().getString(R.string.horocopo_Tauro);
                            }

                        } else if (mes == 5) {
                            if (dia < 21) {
                                horoscopo = getResources().getString(R.string.horocopo_Tauro);
                            } else {
                                horoscopo = getResources().getString(R.string.horocopo_Geminis);
                            }
                        } else {
                            if (dia < 22) {
                                horoscopo = getResources().getString(R.string.horocopo_Geminis);
                            } else {
                                horoscopo = getResources().getString(R.string.horocopo_Cancer);
                            }
                        }
                    } else {
                        resano = (mess111-1) - ano;
                        if (mes == 7) {
                            if (dia < 24) {
                                horoscopo = getResources().getString(R.string.horocopo_Cancer);
                            } else {
                                horoscopo = getResources().getString(R.string.horocopo_Leo);
                            }
                        } else if (mes == 8) {
                            if (dia < 24) {
                                horoscopo = getResources().getString(R.string.horocopo_Leo);
                            } else {
                                horoscopo = getResources().getString(R.string.horocopo_Virgo);
                            }
                        } else if (mes == 9) {
                            if (dia < 24) {
                                horoscopo = getResources().getString(R.string.horocopo_Virgo);
                            } else {
                                horoscopo = getResources().getString(R.string.horocopo_Libra);
                            }
                        } else if (mes == 10) {
                            if (dia < 24) {
                                horoscopo = getResources().getString(R.string.horocopo_Libra);
                            } else {
                                horoscopo = getResources().getString(R.string.horocopo_Escorpion);
                            }

                        } else if (mes == 11) {
                            if (dia < 23) {
                                horoscopo = getResources().getString(R.string.horocopo_Escorpion);
                            } else {
                                horoscopo = getResources().getString(R.string.horocopo_Sagitario);
                            }

                        } else {
                            if (dia < 22) {
                                horoscopo = getResources().getString(R.string.horocopo_Sagitario);
                            } else {
                                horoscopo = getResources().getString(R.string.horocopo_Capricornio);
                            }
                        }
                    }

                    String edadcom = Integer.toString(resano);
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    String[] datos = nombrecom.split(" ");
                    int tamano=datos.length;
                String nombre;
                String letra3;
                String apellido1;
                String letra1;
                String apellido2;
                String letra2;
                String date3;
                    if(tamano==3) {
                        nombre = datos[0].toUpperCase();
                        letra3 = nombre.substring(0, 1);
                        apellido1 = datos[1].toUpperCase();
                        letra1 = apellido1.substring(0, 2);
                        apellido2 = datos[2].toUpperCase();;
                        letra2 = apellido2.substring(0, 1);
                        date3 = date2.substring(2, 8);
                    }
                    else{
                            nombre = datos[0].toUpperCase();
                            letra3 = nombre.substring(0, 1);
                            apellido1 = datos[tamano-2].toUpperCase();
                            letra1 = apellido1.substring(0, 2);
                            apellido2 = datos[tamano-1].toUpperCase();
                            letra2 = apellido2.substring(0, 1);
                            date3 = date2.substring(2, 8);
                    }

                    intent.putExtra("usuario", nombrecom);
                    intent.putExtra("fecha", fechacom);
                    intent.putExtra("genero", generocom);
                    intent.putExtra("edad", edadcom);
                    intent.putExtra("horoscopo", horoscopo);
                    intent.putExtra("rfc", letra1 + letra2 + letra3 + date3);

                    startActivity(intent);

                    Log.i(LOGTAG, nombrecom);

            }
        });
        btnBoton2.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
                text.setText("");
                fecha.setText("");
            }
        });




        Log.d(LOGTAG, "dsdsdsds");



}



}
