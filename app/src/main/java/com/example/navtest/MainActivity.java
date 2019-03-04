package com.example.navtest;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
    Frag1recyclerViewDisplay.OnFragment1InteractionListener,
    Frag2InsertNewEmployee.OnFragment2InteractionListener,
    Frag3FindUpdateOrDeleteEmployee.OnFragment3InteractionListener
{

    FragmentManager fragmentManager;
    EmployeeDBHelper employeeDBHelper;
    Frag1recyclerViewDisplay frag1recyclerViewDisplay;

    public static final String DYNAMIC_FRAG_ONE = "dynamic_frag_one";
    public static final String DYNAMIC_FRAG_TWO = "dynamic_frag_two";
    public static final String DYNAMIC_FRAG_THREE = "dynamic_frag_three";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentManager.popBackStack();
                    fragmentManager
                            .beginTransaction()
                            .replace(R.id.frmDynamic1,frag1recyclerViewDisplay)
                            .addToBackStack(DYNAMIC_FRAG_ONE)
                            .commit();
                    return true;
                case R.id.navigation_dashboard:
                    fragmentManager.popBackStack();
                    fragmentManager
                            .beginTransaction()
                            .replace(R.id.frmDynamic2,Frag2InsertNewEmployee.newInstance())
                            .addToBackStack(DYNAMIC_FRAG_TWO)
                            .commit();
                    return true;
                case R.id.navigation_notifications:
                    fragmentManager.popBackStack();
                    fragmentManager
                            .beginTransaction()
                            .replace(R.id.frmDynamic3,Frag3FindUpdateOrDeleteEmployee.newInstance())
                            .addToBackStack(DYNAMIC_FRAG_THREE)
                            .commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeDBHelper = new EmployeeDBHelper(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fragmentManager = getSupportFragmentManager();

        frag1recyclerViewDisplay = Frag1recyclerViewDisplay.newInstance();

        fragmentManager
                .beginTransaction()
                .replace(R.id.frmDynamic1,frag1recyclerViewDisplay)
                .addToBackStack(DYNAMIC_FRAG_ONE)
                .commit();
    }

    @Override
    public void onFragment1Interaction(Uri uri) {

    }

    @Override
    public void onFragment2Interaction(Employee employee) {
        employeeDBHelper.insertEmployeeIntoDB(employee);
        frag1recyclerViewDisplay.refreshRecycler();
    }

    @Override
    public void onFragment3InteractionEdit(Employee employee) {
        employeeDBHelper.updateEmployeeInDB(employee);

        Log.d("TAG", "onFragment3InteractionEdit: "+employee.toString() );
        frag1recyclerViewDisplay.refreshRecycler();
    }

    @Override
    public void onFragment3InteractionDelete(Employee employee) {
        employeeDBHelper.deleteDromDBbyID(employee.getId());
        frag1recyclerViewDisplay.refreshRecycler();

    }
}
