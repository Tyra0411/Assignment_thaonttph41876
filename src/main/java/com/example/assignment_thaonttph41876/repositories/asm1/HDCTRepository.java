package com.example.assignment_thaonttph41876.repositories.asm1;

import com.example.assignment_thaonttph41876.entities.HDCT;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class HDCTRepository {
    private List<HDCT> list;

    public HDCTRepository(){
        list = new ArrayList<>();
        list.add(new HDCT(1, 1, 1, 2, 150000, 1));
        list.add(new HDCT(2, 1, 2, 3, 190000, 1));
        list.add(new HDCT(3, 2, 3, 1, 130000, 0));
        list.add(new HDCT(4, 2, 4, 4, 150000, 1));
        list.add(new HDCT(5, 3, 5, 2, 110000, 1));
        list.add(new HDCT(6, 3, 6, 5, 120000, 0));
        list.add(new HDCT(7, 4, 7, 2, 100000, 1));
        list.add(new HDCT(8, 4, 8, 3, 160000, 1));
        list.add(new HDCT(9, 5, 9, 1, 170000, 0));
        list.add(new HDCT(10, 5, 10, 4, 180000, 1));
    }

    public List<HDCT> findAll() {
        return list;
    }

    public void create(HDCT hdct) {
        hdct.setId(this.list.size() + 1);
        this.list.add(hdct);
    }

    public void deleteById(int id) {
        this.list.removeIf(hdct -> hdct.getId() == id);
    }

    public HDCT findById(int id) {
        return this.list.stream().filter(hdct -> hdct.getId() == id).findFirst().orElse(null);
    }

    public void update(HDCT hdct) {
        for (int i = 0; i < this.list.size(); i++) {
            if (this.list.get(i).getId() == hdct.getId()) {
                this.list.set(i, hdct);
                break;
            }
        }
    }


    public List<HDCT> findPaginated(int page, int size) {
        int start = (page - 1) * size;
        int end = Math.min(start + size, list.size());
        return list.subList(start, end);
    }

    public List<HDCT> findByHoaDonIdPaginated(int idHoaDon, int page, int size) {
        List<HDCT> filteredList = list.stream().filter(hdct -> hdct.getIdHoaDon() == idHoaDon).toList();
        int start = (page - 1) * size;
        int end = Math.min(start + size, filteredList.size());
        return filteredList.subList(start, end);
    }

    public int getTotalItems() {
        return list.size();
    }

    public int getTotalItemsByHoaDonId(int idHoaDon) {
        return (int) list.stream().filter(hdct -> hdct.getIdHoaDon() == idHoaDon).count();
    }
}
