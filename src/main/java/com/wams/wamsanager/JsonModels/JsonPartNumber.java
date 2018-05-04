package com.wams.wamsanager.JsonModels;

public class JsonPartNumber {

    private String pn;
    private String calibrationProcedure;

    public JsonPartNumber() {
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getCalibrationProcedure() {
        return calibrationProcedure;
    }

    public void setCalibrationProcedure(String calibrationProcedure) {
        this.calibrationProcedure = calibrationProcedure;
    }
}
