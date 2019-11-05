package com.steven.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "program_studi", schema = "pbo220191", catalog = "")
public class ProgramStudi {
    private int id;
    private String nama;
    private Collection<Mahasiswa> mahasiswasById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nama", nullable = true, length = 100)
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgramStudi that = (ProgramStudi) o;
        return id == that.id &&
                Objects.equals(nama, that.nama);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nama);
    }

    @OneToMany(mappedBy = "programStudiByProgramStudiId")
    public Collection<Mahasiswa> getMahasiswasById() {
        return mahasiswasById;
    }

    public void setMahasiswasById(Collection<Mahasiswa> mahasiswasById) {
        this.mahasiswasById = mahasiswasById;
    }
    @Override
    public String toString() {
        return nama;
    }
}
