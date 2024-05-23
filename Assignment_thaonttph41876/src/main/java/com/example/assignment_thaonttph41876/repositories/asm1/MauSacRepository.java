package com.example.assignment_thaonttph41876.repositories.asm1;

import com.example.assignment_thaonttph41876.entities.MauSac;

import java.util.ArrayList;
import java.util.List;

public class MauSacRepository {
    private List<MauSac> ds;

    public MauSacRepository() {
        this.ds = new ArrayList<>();
        this.ds.add(new MauSac(1, "MS01", "Black", 1));
        this.ds.add(new MauSac(2, "MS02", "White", 1));
    }

    public void create(MauSac mauSac) {
        mauSac.setId(this.ds.size()+1);
        this.ds.add(mauSac);
    }

    public List<MauSac> findAll() {
        return this.ds;
    }

    public void deleteById(int id) {
        for (int i = 0; i < this.ds.size(); i++) {
            MauSac ms = this.ds.get(i);
            if (ms.getId() == id) {
                this.ds.remove(ms);
            }
        }
    }

    public MauSac findById(int id) {
        MauSac ketQua = null;
        for (int i = 0; i < this.ds.size(); i++) {
            MauSac mauSac = this.ds.get(i);
            if (mauSac.getId() == id) {
                ketQua = mauSac;
            }
        }
        return ketQua;
    }

    public void update(MauSac mauSac) {
        for (int i = 0; i < this.ds.size(); i++) {
            MauSac ms = this.ds.get(i);
            if (ms.getId() == mauSac.getId()) {
                this.ds.set(i, mauSac);
            }
        }
    }
}
