package com.example.desen.dsspinneradapter;

import android.text.Html;

/**
 * Created by desen on 2016-10-27.
 */

public class ParameterThreshold implements DSSpinnerAdapter.hasFields {
    private String uuid;
    private String name;

    private double tempLimitUpper;
    private double tempLimitLower;
    private double strengthLimit;

    public double getMaturityLimit() {
        return maturityLimit;
    }

    public void setMaturityLimit(double maturityLimit) {
        this.maturityLimit = maturityLimit;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTempLimitUpper() {
        return tempLimitUpper;
    }

    public void setTempLimitUpper(double tempLimitUpper) {
        this.tempLimitUpper = tempLimitUpper;
    }

    public double getTempLimitLower() {
        return tempLimitLower;
    }

    public void setTempLimitLower(double tempLimitLower) {
        this.tempLimitLower = tempLimitLower;
    }

    public double getStrengthLimit() {
        return strengthLimit;
    }

    public void setStrengthLimit(double strengthLimit) {
        this.strengthLimit = strengthLimit;
    }

    private double maturityLimit;
    @Override
    public String toString()
    {
        return name;
    }

    @Override
    public CharSequence[] getFields() {
        return new CharSequence[]{
                Html.fromHtml(String.format("<font color='#2196F3'>%.0f</font> - <font color='#F44336'>%.0f</font>%s",
                        getTempLimitLower(),
                        getTempLimitUpper(),
                        "°C")),
                String.format("%.0f%s", getStrengthLimit(),
                        "MPa")
        };
    }
}
