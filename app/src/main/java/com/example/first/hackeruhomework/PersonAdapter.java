package com.example.first.hackeruhomework;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    ArrayList<Person> personList = getPersons();

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.short_recycler_cell, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
//        holder.textView.setText(holder.toString() +" Position: "+position);
        Person person = personList.get(position);
        boolean isMale = person.getGender() == 'M' || person.getGender() == 'm';
        boolean isRetired = person.getAge() >=67 || (!isMale && person.getAge() >= 65);

        if (isMale && isRetired) {//all males
            holder.textView.setBackgroundColor(Color.RED);
        } else if (isMale) {
            holder.textView.setBackgroundColor(Color.YELLOW);
        } else if (isRetired) {//all females by contract can have two values
            holder.textView.setBackgroundColor(Color.GREEN);
        } else {
            holder.textView.setBackgroundColor(Color.BLUE);
        }

//        Person currentPerson = personList.get(position);
//        if (position%2 == 0)
//            holder.textView.setBackgroundColor(Color.RED);
//        else
//            holder.textView.setBackgroundColor(Color.WHITE);
        holder.textView.setText("First Name: "+person.getName()+"  Last Name: "+ person.getLastName()+"  age: "+person.getAge());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }


    private ArrayList<Person> getPersons(){
        ArrayList<Person> personList = new ArrayList<Person>();
        for (int i = 0; i < 100; i++) {
            int age = new Random().nextInt(100);
            char gender = (i%2 == 0)? 'm' : 'f';
            Person p = new Person("First "+i, "Last "+i);
            p.setAge(age);
            p.setGender(gender);
            personList.add(p);
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
