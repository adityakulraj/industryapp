package aarnav100.developer.iitd.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import aarnav100.developer.iitd.Main3Activity;
import aarnav100.developer.iitd.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {


    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment2,container,false);
        ArrayList<String> names=new ArrayList<>();
        //TODO:change to custom view
        /*names.add("Aarnav");
        names.add("Daizy");
        names.add("Aditya");
        names.add("Anmol");*/
        ((ListView)v.findViewById(R.id.list))
                .setAdapter(new ArrayAdapter<String>(
                        getActivity(),
                        R.layout.support_simple_spinner_dropdown_item,
                        names
                ));
        ((ListView)v.findViewById(R.id.list))
                .setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        startActivity(new Intent(getActivity(), Main3Activity.class));
                    }
                });
        ImageView img = (ImageView) v.findViewById(R.id.imgCC);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://www.facebook.com/DceSpeaksUp/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        ImageView yes = (ImageView) v.findViewById(R.id.btnYes);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Added!", Toast.LENGTH_SHORT).show();
            }
        });
        ImageView no = (ImageView) v.findViewById(R.id.btnNo);
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Deleted!", Toast.LENGTH_SHORT).show();
            }
        });
        ImageView mail = (ImageView) v.findViewById(R.id.btnMail);
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_SENDTO);
                i.setType("message/rfc822");
                i.setData(Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"teamdcoder@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Query/Feedback");
                startActivity(i);
            }
        });
        return v;
    }


}
