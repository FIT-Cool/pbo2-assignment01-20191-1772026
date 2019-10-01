package src.com.joshua.dao;

import com.steven.entity.Mahasiswa;
import com.steven.entity.ProgramStudi;
import com.steven.util.DBHelper;
import com.steven.util.DaoService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaDaoImpl implements DaoService<Mahasiswa> {
    @Override
    public List<Mahasiswa> showAll() {
        List<Mahasiswa> students = new ArrayList<>();
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "SELECT * FROM mahasiswa m JOIN program_studi ps ON m.program_studi_id = ps.id";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                ProgramStudi programStudi =new ProgramStudi();
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.setId(rs.getInt("id"));
                mahasiswa.setNamaDepan(rs.getString("nama_depan"));
                mahasiswa.setNamaBelakang(rs.getString("nama_belakang"));
                mahasiswa.setTempatLahir(rs.getString("tempat_lahir"));
                mahasiswa.setTanggalLahir(rs.getDate("tanggal_lahir"));
                mahasiswa.setAlamat(rs.getString("alamat"));
                mahasiswa.setEmail(rs.getString("email"));
                programStudi.setNama(rs.getString("nama"));
                programStudi.setId(rs.getInt("program_studi_id"));
                mahasiswa.setProgramStudi(programStudi);
                students.add(mahasiswa);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public int addData(Mahasiswa object) {
        int result = 0;
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "INSERT INTO mahasiswa(id, nama_depan, nama_belakang, tempat_lahir, tanggal_lahir, alamat, email, program_studi_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,object.getId());
            ps.setString(2, object.getNamaDepan());
            ps.setString(3, object.getNamaBelakang());
            ps.setString(4, object.getTempatLahir());
            ps.setDate(5, new java.sql.Date(object.getTanggalLahir().getTime()));
            ps.setString(6, object.getAlamat());
            ps.setString(7, object.getEmail());
            ps.setString(8, object.getProgramStudi());
            if(ps.executeUpdate() != 0)
            {
                connection.commit();
                result = 1;
            }
            else
            {
                connection.rollback();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateData(Mahasiswa object) {
        return 0;
    }

    @Override
    public int deleteData(Mahasiswa object) {
        return 0;
    }
}
