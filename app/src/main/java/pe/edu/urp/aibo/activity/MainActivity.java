package pe.edu.urp.aibo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import pe.edu.urp.aibo.R;
import pe.edu.urp.aibo.model.Distrito;
import pe.edu.urp.aibo.model.Mascota;
import pe.edu.urp.aibo.model.Provincia;
import pe.edu.urp.aibo.model.Raza;
import pe.edu.urp.aibo.model.Region;
import pe.edu.urp.aibo.model.enumeration.Sexo;
import pe.edu.urp.aibo.model.enumeration.Tamano;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        loadRazasInDB();
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

    public void loadRazasInDB() {
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

            loadMascotasInDB(raza1);
        }
        loadMascotasInDB(Raza.listAll(Raza.class).get(0));
    }

    private void loadMascotasInDB(Raza raza) {
        if (Mascota.count(Mascota.class) == 0) {
            Mascota m1 = new Mascota();
            m1.setDueno("fred");
            m1.setMeses(15);
            m1.setNombre("Woody");
            m1.setRaza(raza);
            m1.setSexo(Sexo.MACHO);
            m1.setTamano(Tamano.MEDIANO);
            m1.save();
        }
    }
}
