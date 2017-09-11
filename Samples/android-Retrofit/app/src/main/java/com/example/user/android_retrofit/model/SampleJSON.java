
package com.example.user.android_retrofit.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SampleJSON {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("included")
    @Expose
    private List<Included> included = null;

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public List<Included> getIncluded() {
        return included;
    }

    public void setIncluded(List<Included> included) {
        this.included = included;
    }

}
