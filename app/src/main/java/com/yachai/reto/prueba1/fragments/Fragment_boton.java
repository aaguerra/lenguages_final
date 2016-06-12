package com.yachai.reto.prueba1.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.yachai.reto.prueba1.R;

/**
 * Created by joelerll on 11/06/16.
 */
public class Fragment_boton extends Fragment implements  View.OnClickListener{
    Button botonFoto;
    ImageView imagen;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_boton, container, false);
        botonFoto=(Button) view.findViewById(R.id.botonFoto);
        botonFoto.setOnClickListener(this);
        imagen=(ImageView)view.findViewById(R.id.imageView);
        return view;


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.botonFoto:
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
                break;

        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bp = (Bitmap) data.getExtras().get("data");
        imagen.setImageBitmap(bp);
    }

}
