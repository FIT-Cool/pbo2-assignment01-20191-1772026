package src.com.joshua.dao;

import com.steven.entity.ProgramStudi;
import com.steven.util.DBHelper;
import com.steven.util.DaoService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements DaoService<ProgramStudi> {

    @Override
    public List<ProgramStudi> showAll() {
        List<ProgramStudi> departments = new ArrayList<>();
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "SELECT * FROM program_studi";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                ProgramStudi programStudi = new ProgramStudi();
                programStudi.setId(rs.getInt("id"));
                programStudi.setNama(rs.getString("nama"));
                departments.add(programStudi);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return departments;
    }

    @Override
    public int addData(ProgramStudi object) {
        int result = 0;
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "INSERT INTO program_studi(id, nama) VALUES(?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,object.getId());
            ps.setString(2, object.getNama());
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
    public int updateData(ProgramStudi object) {
        int result = 0;
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "UPDATE program_studi SET nama = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,object.getId());
            ps.setString(2, object.getNama());
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
    public int deleteData(ProgramStudi object) {
        int result = 0;
        try {
            Connection connection = DBHelper.createMySQLConnection();
            String query = "DELETE FROM program_studi WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,object.getId());
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
}
