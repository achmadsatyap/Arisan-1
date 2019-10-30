package com.adit.arisan;

public class Grup {
    public String namaArisan, keterangan,nominal;

    public Grup() {
    }

    public Grup(String namaArisan, String keterangan, String nominal) {
        this.namaArisan = namaArisan;
        this.keterangan = keterangan;
        this.nominal = nominal;
    }

    public String getNamaArisan() {
        return namaArisan;
    }

    public void setNamaArisan(String namaArisan) {
        this.namaArisan = namaArisan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }
}
