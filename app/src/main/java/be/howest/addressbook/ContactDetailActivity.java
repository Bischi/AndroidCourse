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

    private Contact _contact;

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
                // Create the text message with a string
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, _contact.toString());
                sendIntent.setType("text/plain");

                // Verify that the intent will resolve to an activity
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void applyIntentData() {
        Intent intent = this.getIntent();
        _contact = (Contact) intent.getSerializableExtra(NewContactActivity.EXTRA_CONTACT);
        ((TextView) findViewById(R.id.firstnameLabel)).setText(_contact.getFirstname());
        ((TextView) findViewById(R.id.lastnameLabel)).setText(_contact.getLastname());
        ((TextView) findViewById(R.id.phoneNumberLabel)).setText(_contact.getPhoneNumber());
        ((TextView) findViewById(R.id.emailLabel)).setText(_contact.getEmail());
        ((TextView) findViewById(R.id.streetNameLabel)).setText(_contact.getStreetName());
        ((TextView) findViewById(R.id.streetNumberLabel)).setText(String.valueOf(_contact.getStreetNumber()));
        ((TextView) findViewById(R.id.postcodeLabel)).setText(String.valueOf(_contact.getPostcode()));
        ((TextView) findViewById(R.id.cityLabel)).setText(_contact.getCity());
    }
}
