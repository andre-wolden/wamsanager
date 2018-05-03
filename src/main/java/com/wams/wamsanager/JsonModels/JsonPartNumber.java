package com.wams.wamsanager.JsonModels;

public class JsonPartNumber {

    private String pn;
    private String calibrationProcedure;

    public JsonPartNumber() {
    }

    public JsonPartNumber(String pn, String calibrationProcedure) {
        this.pn = pn;
        this.calibrationProcedure = calibrationProcedure;
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
