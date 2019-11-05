package com.steven.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "mahasiswa", schema = "pbo220191", catalog = "")
public class Mahasiswa {
    private String id;
    private String namaDepan;
    private String namaBelakang;
    private String tempatLahir;
    private Date tanggalLahir;
    private String alamat;
    private String email;
    private ProgramStudi programStudiByProgramStudiId;

    @Id
    @Column(name = "id", nullable = false, length = 9)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nama_depan", nullable = false, length = 100)
    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    @Basic
    @Column(name = "nama_belakang", nullable = true, length = 100)
    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    @Basic
    @Column(name = "tempat_lahir", nullable = false, length = 80)
    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    @Basic
    @Column(name = "tanggal_lahir", nullable = false)
    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    @Basic
    @Column(name = "alamat", nullable = false, length = 300)
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mahasiswa that = (Mahasiswa) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(namaDepan, that.namaDepan) &&
                Objects.equals(namaBelakang, that.namaBelakang) &&
                Objects.equals(tempatLahir, that.tempatLahir) &&
                Objects.equals(tanggalLahir, that.tanggalLahir) &&
                Objects.equals(alamat, that.alamat) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, namaDepan, namaBelakang, tempatLahir, tanggalLahir, alamat, email);
    }

    @ManyToOne
    @JoinColumn(name = "program_studi_id", referencedColumnName = "id", nullable = false)
    public ProgramStudi getProgramStudiByProgramStudiId() {
        return programStudiByProgramStudiId;
    }

    public void setProgramStudiByProgramStudiId(ProgramStudi programStudiByProgramStudiId) {
        this.programStudiByProgramStudiId = programStudiByProgramStudiId;
    }
}
