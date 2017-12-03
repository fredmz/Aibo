package pe.edu.urp.aibo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import pe.edu.urp.aibo.R;
import pe.edu.urp.aibo.adapter.MascotasPerdidasAdapter;
import pe.edu.urp.aibo.model.PublicacionMascotaPerdida;

public class MascotasPerdidasActivity extends AppCompatActivity {

    ListView lvMascotasPerdidas;
    List<PublicacionMascotaPerdida> publicaciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_perdidas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvMascotasPerdidas = (ListView) findViewById(R.id.lvMascotasPerdidas);
        loadPublicaciones();



//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private void loadPublicaciones() {
        publicaciones = PublicacionMascotaPerdida.listAll(PublicacionMascotaPerdida.class);
        MascotasPerdidasAdapter adapter = new MascotasPerdidasAdapter(getApplicationContext(), publicaciones);
        lvMascotasPerdidas.setAdapter(adapter);
    }

    public void onClickToRegistrar(View view) {
        startActivity(new Intent(MascotasPerdidasActivity.this, RegistrarMascotaPerdidaActivity.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadPublicaciones();
    }
}
