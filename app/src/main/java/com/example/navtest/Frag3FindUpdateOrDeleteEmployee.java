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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragment3InteractionListener} interface
 * to handle interaction events.
 * Use the {@link Frag3FindUpdateOrDeleteEmployee#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag3FindUpdateOrDeleteEmployee extends Fragment implements View.OnClickListener{

    EditText etSearchID;
    EditText etEditName;
    EditText etEditBday;
    EditText etEditWage;
    EditText etEditHireDate;
    EditText etEditImage;
    Button btnSearch;
    Button btnEdit;
    Button btnDelete;
    Employee loadedEmployee;
    boolean isEmployeeloaded =false;


    private OnFragment3InteractionListener mListener;

    public Frag3FindUpdateOrDeleteEmployee() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Frag3FindUpdateOrDeleteEmployee newInstance() {
        Frag3FindUpdateOrDeleteEmployee fragment = new Frag3FindUpdateOrDeleteEmployee();
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
        return inflater.inflate(R.layout.fragment_frag3_find_update_or_delete_employee, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etSearchID = view.findViewById(R.id.etEditEmpID);
        etEditName = view.findViewById(R.id.etEditEmpName);
        etEditBday = view.findViewById(R.id.etEditEmpBday);
        etEditWage = view.findViewById(R.id.etEditEmpWage);
        etEditHireDate = view.findViewById(R.id.etEditEmpHireDate);
        etEditImage = view.findViewById(R.id.etEditEmpImage);
        btnSearch = view.findViewById(R.id.btnSearchEmployee);
        btnEdit = view.findViewById(R.id.btnEditEmployee);
        btnDelete = view.findViewById(R.id.btnDeleteEmployee);

        btnSearch.setOnClickListener(this);
        btnEdit.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragment3InteractionListener) {
            mListener = (OnFragment3InteractionListener) context;
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

        EmployeeDBHelper employeeDBHelper= new EmployeeDBHelper(getContext());

        switch (v.getId()){
            case R.id.btnSearchEmployee:
                if (etSearchID.getText()!= null){
                    int id = Integer.parseInt(etSearchID.getText().toString());
                    loadedEmployee = employeeDBHelper.getEmployeeByID(id);

                    etEditName.setText(loadedEmployee.getName());
                    etEditBday.setText(loadedEmployee.getBirthday());
                    etEditWage.setText(loadedEmployee.getWage());
                    etEditHireDate.setText(loadedEmployee.getHiredate());
                    etEditImage.setText(loadedEmployee.getImage());
                    isEmployeeloaded = true;
                }


                break;
            case R.id.btnEditEmployee:
                if (mListener != null && isEmployeeloaded) {
                    if (etSearchID.getText()!= null) {
                        loadedEmployee.setName(etEditName.getText().toString());
                        loadedEmployee.setBirthday(etEditBday.getText().toString());
                        loadedEmployee.setWage(etEditWage.getText().toString());
                        loadedEmployee.setHiredate(etEditHireDate.getText().toString());
                        loadedEmployee.setImage(etEditImage.getText().toString());
                        mListener.onFragment3InteractionEdit(loadedEmployee);
                    }
                }
                break;
            case R.id.btnDeleteEmployee:
                if (mListener != null && isEmployeeloaded) {
                    if (etSearchID.getText()!= null) {

                        mListener.onFragment3InteractionDelete(loadedEmployee);
                    }
                }
                break;
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
    public interface OnFragment3InteractionListener {
        // TODO: Update argument type and name
        void onFragment3InteractionEdit(Employee employee);

        void onFragment3InteractionDelete(Employee employee);
    }
}
