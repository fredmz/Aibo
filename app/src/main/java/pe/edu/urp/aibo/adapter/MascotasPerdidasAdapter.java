package pe.edu.urp.aibo.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.List;

import pe.edu.urp.aibo.R;
import pe.edu.urp.aibo.activity.DetalleMascotaPerdidaActivity;
import pe.edu.urp.aibo.activity.MascotasPerdidasActivity;
import pe.edu.urp.aibo.model.Mascota;
import pe.edu.urp.aibo.model.PublicacionMascotaPerdida;

/**
 * Created by FRED on 1/12/2017.
 */

public class MascotasPerdidasAdapter extends BaseAdapter {

    Context context;
    List<PublicacionMascotaPerdida> publicaciones;

    public MascotasPerdidasAdapter(Context context, List<PublicacionMascotaPerdida> publicaciones) {
        this.context = context;
        this.publicaciones = publicaciones;
    }

    @Override
    public int getCount() {
        return publicaciones.size();
    }

    @Override
    public Object getItem(int position) {
        return publicaciones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return publicaciones.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;

        LayoutInflater inflater = LayoutInflater.from(context);
        vista = inflater.inflate(R.layout.mascota_perdida_item, null);

        ImageView ivFoto = (ImageView) vista.findViewById(R.id.ivFoto);
        TextView tvNombre = (TextView) vista.findViewById(R.id.tvNombre);
        TextView tvFecha = (TextView) vista.findViewById(R.id.tvFecha);
        TextView tvDistrito = (TextView) vista.findViewById(R.id.tvDistrito);
        TextView tvEdad = (TextView) vista.findViewById(R.id.tvEdad);
        Button btnVerDetalles = (Button) vista.findViewById(R.id.btnDetalles);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd - MM - yyyy");

        PublicacionMascotaPerdida publicacion = publicaciones.get(position);

        tvNombre.setText(publicacion.getMascota().getNombre());
        tvFecha.setText(simpleDateFormat.format(publicacion.getFecha()));
        tvDistrito.setText(publicacion.getDistrito().getNombre());
        tvEdad.setText(publicacion.getMascota().getEdad());

        String uri = "@drawable/mascota" + publicacion.getMascota().getId();

        int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
        Drawable drawable = context.getResources().getDrawable(imageResource);

        ivFoto.setImageDrawable(drawable);
        btnVerDetalles.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetalleMascotaPerdidaActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
        return vista;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
