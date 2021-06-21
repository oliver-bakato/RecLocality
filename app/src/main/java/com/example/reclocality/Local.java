package com.example.reclocality;

public class Local {

    private Integer Id;
    private String latitude;
    private String longitude;

    public String getId() {
        return Id.toString();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String toString(){
        return latitude+", "+ longitude;
    }
}
