package pe.edu.urp.aibo.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import pe.edu.urp.aibo.R;
import pe.edu.urp.aibo.model.Distrito;
import pe.edu.urp.aibo.model.Mascota;
import pe.edu.urp.aibo.model.PublicacionMascotaPerdida;
import pe.edu.urp.aibo.model.enumeration.EstadoMascotaPerdida;

public class RegistrarMascotaPerdidaActivity extends AppCompatActivity {
    private Spinner spinMascotas, spinDistritos;
    private List<Mascota> misMascotas = new ArrayList<>();
    private List<Distrito> distritos = new ArrayList<>();
    private DatePicker dpFecha;
    private PublicacionMascotaPerdida publicacionMascotaPerdida = new PublicacionMascotaPerdida();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_mascota_perdida);

        dpFecha = (DatePicker)findViewById(R.id.dpFecha);

        dpFecha.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar cal = Calendar.getInstance();
                cal.set(year, monthOfYear, dayOfMonth);
                publicacionMascotaPerdida.setFecha(cal.getTime());
            }
        });

        loadMascotas();
        loadDistritos();

        publicacionMascotaPerdida.setDistrito(distritos.get(spinDistritos.getSelectedItemPosition()));
        publicacionMascotaPerdida.setMascota(misMascotas.get(spinMascotas.getSelectedItemPosition()));
        publicacionMascotaPerdida.setDueno("fred");
        publicacionMascotaPerdida.setEstado(EstadoMascotaPerdida.PERDIDA);

        Calendar cal = Calendar.getInstance();
        cal.set(dpFecha.getYear(), dpFecha.getMonth(), dpFecha.getDayOfMonth());
        publicacionMascotaPerdida.setFecha(cal.getTime());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void loadMascotas() {
        misMascotas = Mascota.listAll(Mascota.class);
        spinMascotas = (Spinner) findViewById(R.id.spinMascotas);

        int cntMascotas = misMascotas.size();
        String[] spinnerArray = new String[cntMascotas];
        final HashMap<Integer, Mascota> spinnerMap = new HashMap<>();

        for (int i = 0; i < cntMascotas; i++)
        {
            spinnerMap.put(i, misMascotas.get(i));
            spinnerArray[i] = misMascotas.get(i).getNombre();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinMascotas.setAdapter(adapter);

        spinMascotas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                publicacionMascotaPerdida.setMascota(spinnerMap.get(parent.getSelectedItemPosition()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                makeToast("Seleccione una mascota");
                spinMascotas.requestFocus();
            }
        });
    }

    private void loadDistritos() {
        distritos = Distrito.listAll(Distrito.class);
        spinDistritos = (Spinner) findViewById(R.id.spinDistritos);

        int cntDistritos = distritos.size();
        String[] spinnerArray = new String[cntDistritos];
        final HashMap<Integer, Distrito> spinnerMap = new HashMap<>();

        for (int i = 0; i < cntDistritos; i++)
        {
            spinnerMap.put(i, distritos.get(i));
            spinnerArray[i] = distritos.get(i).getNombre();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinDistritos.setAdapter(adapter);

        spinDistritos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                publicacionMascotaPerdida.setDistrito(spinnerMap.get(parent.getSelectedItemPosition()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                makeToast("Seleccione un distrito");
                spinDistritos.requestFocus();
            }
        });
    }

    public void onClickRegistrarMascotaPerdida(View target) {
        if (PublicacionMascotaPerdida.count(PublicacionMascotaPerdida.class) >= 3) {
            throw new RuntimeException("El celular se quedó sin espacio, no se pudo registrar la publicación");
        }
        if (publicacionMascotaPerdida.getFecha() == null) {
            makeToast("Ingrese la fecha");
            dpFecha.requestFocus();
            return;
        }
        if (publicacionMascotaPerdida.getMascota() == null) {
            makeToast("Seleccione una mascota");
            spinMascotas.requestFocus();
            return;
        }
        if (publicacionMascotaPerdida.getDistrito() == null) {
            makeToast("Seleccione un distrito");
            spinDistritos.requestFocus();
            return;
        }
        publicacionMascotaPerdida.save();
        finish();
    }

    private void makeToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
