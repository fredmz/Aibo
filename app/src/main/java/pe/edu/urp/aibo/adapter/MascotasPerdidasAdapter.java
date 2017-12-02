package pe.edu.urp.aibo.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import pe.edu.urp.aibo.R;
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
        vista = inflater.inflate(R.layout.activity_mascotas_perdidas, null);

        ImageView ivFoto = (ImageView) vista.findViewById(R.id.ivFoto);
        TextView tvNombre = (TextView) vista.findViewById(R.id.tvNombre);
        TextView tvFecha = (TextView) vista.findViewById(R.id.tvFecha);
        TextView tvDistrito = (TextView) vista.findViewById(R.id.tvDistrito);

        tvNombre.setText(publicaciones.get(position).getMascota().getNombre());
        tvFecha.setText(publicaciones.get(position).getFecha().toString());
        tvDistrito.setText(publicaciones.get(position).getDistrito().getNombre());
//        ivFoto.setImageResource(publicaciones.get(position).getMascota().getFoto());

        return vista;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
