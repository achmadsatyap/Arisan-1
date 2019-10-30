package com.adit.arisan;

public class Peserta {
    public String nama,alamat,nomerHp;

    public Peserta(String nama, String alamat,String nomerHp) {
        this.nama = nama;
        this.alamat = alamat;
        this.nomerHp = nomerHp;
    }

    public Peserta() {
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNomerHp() {
        return nomerHp;
    }

    public void setNomerHp(String nomerHp) {
        this.nomerHp = nomerHp;
    }
}
