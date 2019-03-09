package be.howest.addressbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import models.Contact;

public class ContactDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        applyIntentData();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void applyIntentData() {
        Intent intent = this.getIntent();
        Contact contact = (Contact) intent.getSerializableExtra(NewContactActivity.EXTRA_CONTACT);
        ((TextView)findViewById(R.id.firstnameLabel)).setText(contact.getFirstname());
        ((TextView)findViewById(R.id.lastnameLabel)).setText(contact.getLastname());
        ((TextView)findViewById(R.id.phoneNumberLabel)).setText(contact.getPhoneNumber());
        ((TextView)findViewById(R.id.emailLabel)).setText(contact.getEmail());
        ((TextView)findViewById(R.id.streetNameLabel)).setText(contact.getStreetName());
        ((TextView)findViewById(R.id.streetNumberLabel)).setText(String.valueOf(contact.getStreetNumber()));
        ((TextView)findViewById(R.id.postcodeLabel)).setText(String.valueOf(contact.getPostcode()));
        ((TextView)findViewById(R.id.cityLabel)).setText(contact.getCity());
    }
}
