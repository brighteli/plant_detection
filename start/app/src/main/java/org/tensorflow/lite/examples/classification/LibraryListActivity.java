package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;



import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.tensorflow.lite.examples.classification.adapters.LibraryAdapter;
import org.tensorflow.lite.examples.classification.models.Library;

import java.util.ArrayList;
import java.util.List;

public class LibraryListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LibraryAdapter libraryAdapter;


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private ArrayList<Library> libraryList;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_list);

        recyclerView = findViewById(R.id.libraryRecyclerView);
        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        //Firebase


        databaseReference = FirebaseDatabase.getInstance().getReference();

        //ArrayList
        libraryList = new ArrayList<>();

        //Clear Array List

        ClearAll();


        //Get  DATA method

        GetDataFromFirebase();

    }

    private void GetDataFromFirebase() {

        Query query = databaseReference.child("Library");

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){

                    Library library = new Library();

                    library.setTreeImage(snapshot.child("TreeImage").getValue().toString());
                    library.setTreeName(snapshot.child("TreeName").getValue().toString());
                    library.setScientificName(snapshot.child("ScientificName").getValue().toString());
                    library.setDescription(snapshot.child("Description").getValue().toString());


                    libraryList.add(library);

                }

                libraryAdapter = new LibraryAdapter(getApplicationContext(), libraryList);
                recyclerView.setAdapter(libraryAdapter);
                libraryAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }

    private  void ClearAll(){

        if (libraryList != null){

            libraryList.clear();

            if (libraryAdapter != null){

                libraryAdapter.notifyDataSetChanged();
            }
        }

        libraryList = new ArrayList<>();
    }

}