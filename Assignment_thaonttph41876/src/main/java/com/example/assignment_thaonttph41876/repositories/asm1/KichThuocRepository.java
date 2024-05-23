package com.example.assignment_thaonttph41876.repositories.asm1;

import com.example.assignment_thaonttph41876.entities.KichThuoc;

import java.util.ArrayList;
import java.util.List;

public class KichThuocRepository {
    private List<KichThuoc> ds;

    public KichThuocRepository(){
        this.ds = new ArrayList<>();
        this.ds.add(new KichThuoc(1, "KT01", "S", 1));
        this.ds.add(new KichThuoc(2, "KT02", "M", 1));
    }

    public List<KichThuoc> findAll(){
        return this.ds;
    }

    public void create(KichThuoc kichThuoc){
        kichThuoc.setId(this.ds.size()+1);
        this.ds.add(kichThuoc);
    }

    public void deleteById(int id){
        for (int i = 0; i < this.ds.size(); i++) {
            KichThuoc kt = this.ds.get(i);
            if(kt.getId()==id){
                this.ds.remove(kt);
            }
        }
    }

    public KichThuoc findById(int id){
        KichThuoc ketQua = null;
        for (int i = 0; i < this.ds.size(); i++) {
            KichThuoc kichThuoc = this.ds.get(i);
            if(kichThuoc.getId()==id){
                ketQua = kichThuoc;
            }
        }
        return ketQua;
    }

    public void update(KichThuoc kichThuoc){
        for (int i = 0; i < this.ds.size(); i++) {
            KichThuoc kt = this.ds.get(i);
            if(kt.getId() == kichThuoc.getId()){
                this.ds.set(i, kichThuoc);
            }
        }
    }
}
