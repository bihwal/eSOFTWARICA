package com.example.esoftwarica.ui.addstudent;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.esoftwarica.R;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;
import static android.os.ParcelFileDescriptor.open;

public class AddStudentFragment extends Fragment  {

    private AddStudentViewModel dashboardViewModel;
    private EditText etfname,etage,etaddress;
    private RadioGroup rdogrp;
    private RadioButton rdomale,rdofemale,rdoothers;
    private Button btnadd;
    public List<String> name;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(AddStudentViewModel.class);
        View root = inflater.inflate(R.layout.fragment_addstudent, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        btnadd=root.findViewById(R.id.btnadd);
        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        etage=root.findViewById(R.id.etage);
        etfname=root.findViewById(R.id.etfname);
        etaddress=root.findViewById(R.id.etaddress);
        rdogrp=root.findViewById(R.id.radioGroup);
        rdomale=root.findViewById(R.id.rdoMale);
        rdofemale=root.findViewById(R.id.rdoGender);
        rdoothers=root.findViewById(R.id.rdoFemale);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = rdogrp.getCheckedRadioButtonId();
                RadioButton radioButton;
                radioButton =getActivity().findViewById(selectedId);
                //Toast.makeText(getActivity(), "Checked is"+radioButton.getText(), Toast.LENGTH_SHORT).show();

                try {
                    PrintStream printStream=new PrintStream(getActivity().openFileOutput("words.txt",MODE_PRIVATE|Context.MODE_APPEND));
                    printStream.println(etfname.getText().toString() +"->"+ etage.getText().toString()+","+radioButton.getText()+"."+etaddress.getText());
                    Toast.makeText(getActivity(), "Saved to"+getActivity().getFilesDir(), Toast.LENGTH_SHORT).show();
                }
                catch (IOException e)
                {

                }


                // save();

            }
        });
        return root;
    }
}