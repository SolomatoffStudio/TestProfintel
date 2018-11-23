package com.solomatoff.testprofintel;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Note implements Serializable, Parcelable {
    String address;
    String fio;
    String contacts;
    String tariff;
    String connectionDate;
    String numberOfContract;

    public Note(String address, String fio, String contacts, String tariff, String connectionDate, String numberOfContract) {
        this.address = address;
        this.fio = fio;
        this.contacts = contacts;
        this.tariff = tariff;
        this.connectionDate = connectionDate;
        this.numberOfContract = numberOfContract;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public String getConnectionDate() {
        return connectionDate;
    }

    public void setConnectionDate(String connectionDate) {
        this.connectionDate = connectionDate;
    }

    public String getNumberOfContract() {
        return numberOfContract;
    }

    public void setNumberOfContract(String numberOfContract) {
        this.numberOfContract = numberOfContract;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(address);
        dest.writeString(fio);
        dest.writeString(contacts);
        dest.writeString(tariff);
        dest.writeString(connectionDate);
        dest.writeString(numberOfContract);
    }

    public static final Parcelable.Creator<Note> CREATOR = new Parcelable.Creator<Note>() {
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public static Creator<Note> getCREATOR() {
        return CREATOR;
    }

    /** recreate object from parcel */
    private Note(Parcel in) {
        address = in.readString();
        fio = in.readString();
        contacts = in.readString();
        tariff = in.readString();
        connectionDate = in.readString();
        numberOfContract = in.readString();
    }
}
