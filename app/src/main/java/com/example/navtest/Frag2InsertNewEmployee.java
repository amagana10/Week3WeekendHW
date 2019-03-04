package com.example.navtest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragment2InteractionListener} interface
 * to handle interaction events.
 * Use the {@link Frag2InsertNewEmployee#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag2InsertNewEmployee extends Fragment implements View.OnClickListener {
    private OnFragment2InteractionListener mListener;

    EditText etName;
    EditText etBday;
    EditText etwage;
    EditText etHiredate;
    EditText etImage;
    Button btnNewEmployee;

    public Frag2InsertNewEmployee() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Frag2InsertNewEmployee newInstance() {
        Frag2InsertNewEmployee fragment = new Frag2InsertNewEmployee();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag2_insert_new_employee, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etName = view.findViewById(R.id.etNewEmpName);
        etBday = view.findViewById(R.id.etNewEmpBday);
        etwage = view.findViewById(R.id.etNewEmpWage);
        etHiredate = view.findViewById(R.id.etNewEmpHireDate);
        etImage = view.findViewById(R.id.etNewEmpImage);
        btnNewEmployee = view.findViewById(R.id.btnNewEmployee);
        btnNewEmployee.setOnClickListener(this);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragment2InteractionListener) {
            mListener = (OnFragment2InteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragment1InteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) {
            String name = etName.getText()!=null?etName.getText().toString():"";
            String bday = etBday.getText()!=null?etBday.getText().toString():"";
            String wage = etwage.getText()!=null?etwage.getText().toString():"";
            String hireDate = etHiredate.getText()!=null?etHiredate.getText().toString():"";
            String image = etImage.getText()!=null?etImage.getText().toString():"";
            Employee employee = new Employee();
            employee.setName(name);
            employee.setBirthday(bday);
            employee.setWage(wage);
            employee.setHiredate(hireDate);
            employee.setImage(image);
            mListener.onFragment2Interaction(employee);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragment2InteractionListener {
        // TODO: Update argument type and name
        void onFragment2Interaction(Employee employee);
    }
}
