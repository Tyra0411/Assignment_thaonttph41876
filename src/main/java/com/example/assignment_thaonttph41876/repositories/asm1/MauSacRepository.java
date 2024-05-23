package com.example.assignment_thaonttph41876.repositories.asm1;

import com.example.assignment_thaonttph41876.entities.MauSac;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MauSacRepository {
    private List<MauSac> ds;

    public MauSacRepository() {
        this.ds = new ArrayList<>();
        this.ds.add(new MauSac(1, "MS01", "Black", 1));
        this.ds.add(new MauSac(2, "MS02", "White", 1));
        this.ds.add(new MauSac(3, "MS03", "Red", 1));
        this.ds.add(new MauSac(4, "MS04", "Blue", 1));
        this.ds.add(new MauSac(5, "MS05", "Green", 1));
        this.ds.add(new MauSac(6, "MS06", "Yellow", 1));
        this.ds.add(new MauSac(7, "MS07", "Purple", 1));
        this.ds.add(new MauSac(8, "MS08", "Orange", 1));
        this.ds.add(new MauSac(9, "MS09", "Pink", 1));
        this.ds.add(new MauSac(10, "MS10", "Brown", 1));
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

    public List<MauSac> findByName(String name) {
        return this.ds.stream()
                .filter(ms -> ms.getTen().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<MauSac> findPaginated(int page, int size) {
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
                .filter(ms -> ms.getTen().equalsIgnoreCase(name))
                .count();
    }

    public List<MauSac> findByKeyword(String keyword, int page, int size) {
        return this.ds.stream()
                .filter(ms -> ms.getTen().toLowerCase().contains(keyword.toLowerCase()))
                .skip((long) (page - 1) * size)
                .limit(size)
                .collect(Collectors.toList());
    }

    public int getTotalItems(String keyword) {
        return (int) this.ds.stream()
                .filter(ms -> ms.getTen().toLowerCase().contains(keyword.toLowerCase()))
                .count();
    }
}
