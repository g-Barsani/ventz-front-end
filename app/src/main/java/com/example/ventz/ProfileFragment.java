package com.example.ventz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ventz.model.Dados;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Now use the inflated view to find your TextView
        TextView labelNome = view.findViewById(R.id.labelNome);
        TextView labelEmail = view.findViewById(R.id.labelEmail);
        TextView labelCpf = view.findViewById(R.id.labelCpf);

        ImageButton ibScan = view.findViewById(R.id.ibScan);

         labelNome.setText(Dados.getInstance().getNomeAtual());
         labelEmail.setText(Dados.getInstance().getEmailAtual());
        labelCpf.setText(Dados.getInstance().getCpfAtual());


        // add event to myImageButton


        ibScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(requireContext(), "Abrindo leitor de QR Code...", Toast.LENGTH_SHORT).show();
                scanCode();
            }
        });

        // You can now set text or other properties on txtNome









//        return inflater.inflate(R.layout.fragment_profile, container, false);
        return view;
    }


    private void scanCode() {
        ScanOptions options = new ScanOptions();


        options.setPrompt("< Volume up > para usar o flash");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(CaptureAct.class);
        barLauncher.launch(options);
    }

    private String qrResult;
    ActivityResultLauncher<ScanOptions> barLauncher = registerForActivityResult(new ScanContract(), result -> {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Resultado");
        builder.setMessage(result.getContents());

        qrResult = result.getContents(); // #######

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();

    });
}