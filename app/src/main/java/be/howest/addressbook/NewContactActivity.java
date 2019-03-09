package be.howest.addressbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import models.Contact;

public class NewContactActivity extends AppCompatActivity {

    static final String EXTRA_CONTACT = NewContactActivity.class.getCanonicalName() + ".contact";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

        findViewById(R.id.saveBtn).setOnClickListener(e -> onSaveBtnClicked(e));
        initView();
    }

    private void initView() {
        ((TextView) findViewById(R.id.firstnameInput)).setHint("firstname");
        ((TextView) findViewById(R.id.lastnameInput)).setHint("lastname");
        ((TextView) findViewById(R.id.emailInput)).setHint("email");
        ((TextView) findViewById(R.id.streetNameInput)).setHint("street name");
        ((TextView) findViewById(R.id.houseNumberInput)).setHint("street number");
        ((TextView) findViewById(R.id.phoneInput)).setHint("phone number");
        ((TextView) findViewById(R.id.postcodeInput)).setHint("postcode");
        ((TextView) findViewById(R.id.cityInput)).setHint("city");
    }

    public void onSaveBtnClicked(View v) {
        String fname = ((TextView) findViewById(R.id.firstnameInput)).getText().toString();
        String lname = ((TextView) findViewById(R.id.lastnameInput)).getText().toString();
        String email = ((TextView) findViewById(R.id.emailInput)).getText().toString();
        String streetName = ((TextView) findViewById(R.id.streetNameInput)).getText().toString();
        int streetNumber = Integer.parseInt(((TextView) findViewById(R.id.houseNumberInput)).getText().toString());
        String phoneNumber = ((TextView) findViewById(R.id.phoneInput)).getText().toString();
        int postalCode = Integer.parseInt(((TextView) findViewById(R.id.postcodeInput)).getText().toString());
        String cityName = ((TextView) findViewById(R.id.cityInput)).getText().toString();

        Contact contact = new Contact(fname, lname);
        contact.setEmail(email);
        contact.setStreetName(streetName);
        contact.setStreetNumber(streetNumber);
        contact.setPhoneNumber(phoneNumber);
        contact.setPostcode(postalCode);
        contact.setCity(cityName);

        showAcceptanceScreen(contact);
    }

    private void showAcceptanceScreen(Contact contact) {
        Intent intent = new Intent(this, ContactDetailActivity.class);
        intent.putExtra(EXTRA_CONTACT, contact);
        this.startActivity(intent);
    }
}
