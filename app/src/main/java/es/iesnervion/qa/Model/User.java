package es.iesnervion.qa.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.sql.Date;

/**
 * Object de usuario, necesario para la conexión en la base de datos.
 *
 * Created by adripol94 on 1/27/17.
 */

public class User implements Parcelable {
    private int id;
    private String email;
    private String name;
    private String surname;
    private Date age;
    private String user;
    private String password;

    public User() {
    }

    public User(int id, String email, String name, String surname, Date age, String user, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.user = user;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getAge() {
        return age;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    //Parcelable Methods

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.email);
        dest.writeString(this.name);
        dest.writeString(this.surname);
        dest.writeSerializable(this.age);
        dest.writeString(this.user);
        dest.writeString(this.password);
    }

    protected User(Parcel in) {
        this.id = in.readInt();
        this.email = in.readString();
        this.name = in.readString();
        this.surname = in.readString();
        this.age = (Date) in.readSerializable();
        this.user = in.readString();
        this.password = in.readString();
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
