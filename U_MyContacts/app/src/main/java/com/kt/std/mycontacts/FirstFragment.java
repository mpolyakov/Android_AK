package com.kt.std.mycontacts;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;

public class FirstFragment extends Fragment {
    private MyContactsDatabase myContactsDatabase;
    private ArrayList<Contact> contactArrayList;
    private ContactAdapter contactAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        myContactsDatabase = Room.databaseBuilder(getContext(), MyContactsDatabase.class, "ContactsDB").build();
        loadContacts();

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        contactAdapter = new ContactAdapter();
        recyclerView.setAdapter(contactAdapter);

    }

    private void loadContacts() {
        new FirstFragment.GetAllContactsAsyncTask().execute();
    }

    private void deleteContact(Contact contact){
        new FirstFragment.DeleteContactAsyncTask().execute(contact);
    }

    private void addContact(Contact contact){
        new FirstFragment.AddContactAsyncTask().execute(contact);
    }

    private class GetAllContactsAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {

            contactArrayList = (ArrayList<Contact>) myContactsDatabase.getContactDao().getAllContacts();

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            contactAdapter.setContactArrayList(contactArrayList);
        }
    }
    private class DeleteContactAsyncTask extends AsyncTask<Contact, Void, Void>{

        @Override
        protected Void doInBackground(Contact... contacts) {
            myContactsDatabase.getContactDao().deleteContact(contacts[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            loadContacts();
        }
    }

    private class AddContactAsyncTask extends AsyncTask<Contact, Void, Void>{

        @Override
        protected Void doInBackground(Contact... contacts) {
            myContactsDatabase.getContactDao().insertContact(contacts[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            loadContacts();
        }
    }

    private class UpdateContactAsyncTask extends AsyncTask<Contact, Void, Void>{

        @Override
        protected Void doInBackground(Contact... contacts) {
            myContactsDatabase.getContactDao().updateContact(contacts[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            loadContacts();
        }
    }
}
