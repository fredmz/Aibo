package pe.edu.urp.aibo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.crashlytics.android.Crashlytics;

import java.util.Date;

import io.fabric.sdk.android.Fabric;
import pe.edu.urp.aibo.R;
import pe.edu.urp.aibo.model.Distrito;
import pe.edu.urp.aibo.model.Mascota;
import pe.edu.urp.aibo.model.Provincia;
import pe.edu.urp.aibo.model.PublicacionMascotaPerdida;
import pe.edu.urp.aibo.model.Raza;
import pe.edu.urp.aibo.model.Region;
import pe.edu.urp.aibo.model.enumeration.EstadoMascotaPerdida;
import pe.edu.urp.aibo.model.enumeration.Sexo;
import pe.edu.urp.aibo.model.enumeration.Tamano;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        Crashlytics.setUserEmail("fredmz86@gmail.com");
        Crashlytics.setUserName("Fred Martínez");
        Crashlytics.setUserIdentifier("fred");
        initLoadInDB();
        setContentView(R.layout.activity_main);
    }

    public void onClickToMisMascotas(View view) {
        startActivity(new Intent(MainActivity.this, MisMascotasActivity.class));
    }

    public void onClickToMascotasPerdidasActivity(View view) {
        startActivity(new Intent(MainActivity.this, MascotasPerdidasActivity.class));
    }
    
    private void initLoadInDB() {
        loadUbicacionesInDB();
        loadRazasInDB(Distrito.listAll(Distrito.class).get(0));
    }

    private void loadUbicacionesInDB() {
        if (Region.count(Region.class) == 0) {
            Region region = new Region();
            region.setNombre("Lima");
            region.save();
            
            if (Provincia.count(Provincia.class) == 0) {
                Provincia provincia = new Provincia();
                provincia.setNombre("Lima");
                provincia.setRegion(region);
                provincia.save();
                
                if (Distrito.count(Distrito.class) == 0) {
                    Distrito distrito1 = new Distrito();
                    distrito1.setNombre("Lince");
                    distrito1.setProvincia(provincia);
                    distrito1.save();

                    Distrito distrito2 = new Distrito();
                    distrito2.setNombre("Magdalena");
                    distrito2.setProvincia(provincia);
                    distrito2.save();

                    Distrito distrito3 = new Distrito();
                    distrito3.setNombre("San Isidro");
                    distrito3.setProvincia(provincia);
                    distrito3.save();

                    Distrito distrito4 = new Distrito();
                    distrito4.setNombre("Miraflores");
                    distrito4.setProvincia(provincia);
                    distrito4.save();
                }
            }
        }
    }

    public void loadRazasInDB(Distrito distrito) {
        if (Raza.count(Raza.class) == 0) {
            Raza raza1 = new Raza();
            raza1.setNombre("Pequines");
            raza1.save();

            Raza raza2 = new Raza();
            raza2.setNombre("Pug");
            raza2.save();

            Raza raza3 = new Raza();
            raza3.setNombre("Doberman");

            Raza raza4 = new Raza();
            raza4.setNombre("Labrador");
            raza4.save();

            Raza raza5 = new Raza();
            raza5.setNombre("Chihuahua");
            raza5.save();

            loadMascotasInDB(raza1, distrito);
        }
        loadMascotasInDB(Raza.listAll(Raza.class).get(0), distrito);
    }

    private void loadMascotasInDB(Raza raza, Distrito distrito) {
        if (Mascota.count(Mascota.class) == 0) {
            Mascota m1 = new Mascota();
            m1.setDueno("fred");
            m1.setMeses(15);
            m1.setNombre("Woody");
            m1.setRaza(raza);
            m1.setSexo(Sexo.MACHO);
            m1.setTamano(Tamano.MEDIANO);
            m1.save();

            loadPublicacion(m1, distrito);

            Mascota m2 = new Mascota();
            m2.setDueno("fred");
            m2.setMeses(10);
            m2.setNombre("Devorador");
            m2.setRaza(raza);
            m2.setSexo(Sexo.MACHO);
            m2.setTamano(Tamano.PEQUENO);
            m2.save();

            loadPublicacion(m2, distrito);

            Mascota m3 = new Mascota();
            m3.setDueno("fred");
            m3.setMeses(36);
            m3.setNombre("Matty");
            m3.setRaza(raza);
            m3.setSexo(Sexo.HEMBRA);
            m3.setTamano(Tamano.PEQUENO);
            m3.save();

            Mascota m4 = new Mascota();
            m4.setDueno("fred");
            m4.setMeses(20);
            m4.setNombre("Mocka");
            m4.setRaza(raza);
            m4.setSexo(Sexo.HEMBRA);
            m4.setTamano(Tamano.PEQUENO);
            m4.save();
        }
    }

    private void loadPublicacion(Mascota mascota, Distrito distrito) {
        PublicacionMascotaPerdida p = new PublicacionMascotaPerdida();
        p.setMascota(mascota);
        p.setFecha(new Date());
        p.setEstado(EstadoMascotaPerdida.PERDIDA);
        p.setDueno("fred");
        p.setDistrito(distrito);
        p.setLugar("Se perdió cerca a dos cuadras de la av principa, tiene un collar de color rojo");
        p.save();
    }
}
