package sg.edu.rp.dmsd.ps11_mydatabook;


import android.app.ActionBar;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BioFragment extends Fragment {

    ActionBar ab;
    Button btnBio;
    TextView tvBio;
    EditText et;

    public BioFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View layoutView = inflater.inflate(R.layout.fragment_bio, container, false);
        tvBio = layoutView.findViewById(R.id.tvBio);
        btnBio = layoutView.findViewById(R.id.btnBioEdit);

        btnBio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View layoutView = inflater.inflate(R.layout.layout_dialog, null);
                et = layoutView.findViewById(R.id.et);
                et.setText(tvBio.getText().toString());
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Edit Bio").setView(layoutView).setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String text = et.getText().toString();
                                tvBio.setText(text);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        return layoutView;
    }

}
