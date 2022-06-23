package com.example.javaproject.utils;

import com.example.javaproject.entities.Doctor;
import com.example.javaproject.entities.Patient;

import javax.print.Doc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DbUtils {
    public static Doctor findDoctorByName(Connection conn, //
                                          String name, String password) throws SQLException {

        String sql = "Select * from doctor "
                + " where name = ? and password = ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, name);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String role = rs.getString("role");
            String category = rs.getString("category");

            Doctor doctor = new Doctor(id, name, category, role, password);
            return doctor;
        }
        return null;
    }

    public static Doctor findDoctorByName(Connection conn, //
                                          String name) throws SQLException {

        String sql = "Select * from doctor "
                + " where name = ?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, name);
        ResultSet rs = pstm.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String role = rs.getString("role");
            String category = rs.getString("category");
            String password = rs.getString("password");

            Doctor doctor = new Doctor(id, name, category, role, password);
            return doctor;
        }
        return null;
    }

    public static List<Patient> queryPatients(Connection conn) throws SQLException {
        String sql = "Select * from patient";

        PreparedStatement pstm = conn.prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        List<Patient> patients = new ArrayList<Patient>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String birthday = rs.getString("birthday") ;
            String diagnosis = rs.getString("diagnosis");
            boolean status = rs.getBoolean("status");
            int doctor_id = rs.getInt("doctor_id");
            Patient patient = new Patient(id, name, birthday, diagnosis, status, doctor_id);
            patients.add(patient);
        }
        return patients;
    }

    public static Patient findPatientById(Connection conn, int id) throws SQLException {
        String sql = "Select * from patient where id=?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            String name = rs.getString("name");
            String birthday = rs.getString("birthday") ;
            String diagnosis = rs.getString("diagnosis");
            boolean status = rs.getBoolean("status");
            int doctor_id = rs.getInt("doctor_id");
            Patient patient = new Patient(id, name, birthday, diagnosis, status, doctor_id);
            return patient;
        }
        return null;
    }

    public static Patient findPatientByName(Connection conn, String name) throws SQLException {
        String sql = "Select * from patient where name=?";

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, name);

        ResultSet rs = pstm.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String birthday = rs.getString("birthday") ;
            String diagnosis = rs.getString("diagnosis");
            boolean status = rs.getBoolean("status");
            int doctor_id = rs.getInt("doctor_id");
            Patient patient = new Patient(id, name, birthday, diagnosis, status, doctor_id);
            return patient;
        }
        return null;
    }

    public static void updatePatient(Connection conn, Patient patient) throws SQLException {
        String sql = "Update patient set name =?, birthday=?, diagnosis=?, status=?, doctor_id=? where id=? ";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, patient.getName());
        pstm.setString(2, patient.getBirthday());
        pstm.setString(3, patient.getDiagnosis());
        pstm.setBoolean(4, patient.isStatus());
        pstm.setInt(5, patient.getDoctor_id());
        pstm.setInt(6, patient.getId());
        pstm.executeUpdate();
    }

    public static void insertPatient(Connection conn, Patient patient) throws SQLException {
        String sql = "Insert into patient (name, birthday, diagnosis, status, doctor_id) values (?,?,?,?,?)";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, patient.getName());
        pstm.setString(2, patient.getBirthday());
        pstm.setString(3, patient.getDiagnosis());
        pstm.setBoolean(4, patient.isStatus());
        pstm.setInt(5, patient.getDoctor_id());
        pstm.executeUpdate();
    }

    public static void deletePatient(Connection conn, int id) throws SQLException {
        String sql = "Delete From patient where id= ?";

        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setInt(1, id);

        pstm.executeUpdate();
    }

}
