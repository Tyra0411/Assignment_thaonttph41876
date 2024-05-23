package com.example.assignment_thaonttph41876.repositories.asm1;

import com.example.assignment_thaonttph41876.entities.KichThuoc;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class KichThuocRepository {
    private List<KichThuoc> ds;

    public KichThuocRepository(){
        this.ds = new ArrayList<>();
        this.ds.add(new KichThuoc(1, "KT01", "S", 1));
        this.ds.add(new KichThuoc(2, "KT02", "M", 1));
        this.ds.add(new KichThuoc(3, "KT03", "L", 1));
        this.ds.add(new KichThuoc(4, "KT04", "XL", 1));
        this.ds.add(new KichThuoc(5, "KT05", "XXL", 1));
        this.ds.add(new KichThuoc(6, "KT06", "XS", 1));
        this.ds.add(new KichThuoc(7, "KT07", "3XL", 1));
        this.ds.add(new KichThuoc(8, "KT08", "4XL", 1));
        this.ds.add(new KichThuoc(9, "KT09", "5XL", 1));
        this.ds.add(new KichThuoc(10, "KT10", "6XL", 1));
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
    public List<KichThuoc> findByName(String name) {
        return this.ds.stream()
                .filter(kt -> kt.getTen().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<KichThuoc> findPaginated(int page, int size) {
        int startIndex = (page - 1) * size;
        if (startIndex >= this.ds.size()) {
            return new ArrayList<>();
        }
        int endIndex = Math.min(startIndex + size, this.ds.size());
        return this.ds.subList(startIndex, endIndex);
    }

    public int getTotalItems() {
        return ds.size();
    }

    public int getTotalSearchItems(String name) {
        return (int) ds.stream()
                .filter(kt -> kt.getTen().equalsIgnoreCase(name))
                .count();
    }

    public List<KichThuoc> findByKeyword(String keyword, int page, int size) {
        return this.ds.stream()
                .filter(kt -> kt.getTen().toLowerCase().contains(keyword.toLowerCase()))
                .skip((long) (page - 1) * size)
                .limit(size)
                .collect(Collectors.toList());
    }

    public int getTotalItems(String keyword) {
        return (int) this.ds.stream()
                .filter(kt -> kt.getTen().toLowerCase().contains(keyword.toLowerCase()))
                .count();
    }
}
