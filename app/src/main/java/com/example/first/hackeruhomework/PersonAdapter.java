package com.example.first.hackeruhomework;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    ArrayList<Person> personList = getPersons();

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tall_recycler_cell, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
//        holder.textView.setText(holder.toString() +" Position: "+position);
        Person currentPerson = personList.get(position);
        holder.textView.setText("First Name: "+currentPerson.getName()+"  Last Name: "+ currentPerson.getLastName());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }


    private ArrayList<Person> getPersons(){
        ArrayList<Person> personList = new ArrayList<Person>();
        for (int i = 0; i < 100; i++) {
            personList.add(new Person("First "+i, "Last "+i));
        }
        return personList;
    }
}

class PersonViewHolder extends RecyclerView.ViewHolder {

    TextView textView;

    public PersonViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.contact_name);
    }
}
