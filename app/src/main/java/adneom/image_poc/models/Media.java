package adneom.image_poc.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 */

public class Media implements Parcelable {

    /**
     * File is 0 : image
     * 1 : other
     */
    private int type;

    /**
     * Represents Uri if an image from Os or name if a file
     */
    private String name;

    public static Creator<Media> CREATOR = new Creator<Media>() {
        @Override
        public Media createFromParcel(Parcel source) {
            return new Media(source);
        }

        @Override
        public Media[] newArray(int size) {
            return new Media[size];
        }
    };

    public Media(Parcel in) {
        this.type = in.readInt();
        this.name = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.type);
        dest.writeString(this.name);
    }

    public Media() {
    }

    public Media(int type) {
        this.type = type;
    }

    public Media(String name) {
        this.name = name;
    }

    public Media(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return type + " " + name;
    }

}
