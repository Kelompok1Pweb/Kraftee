/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.pengunjung;
import dbutil.AksesJdbcOdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HP MINI
 */
public class pengunjungHome {
    public pengunjung[]getDaftarPengunjung(){
        pengunjung[]daftarPengunjung=null;
        pengunjung tempPengunjung=null;
        ArrayList listPengunjung=new ArrayList();
        
        String pwd=null;
        String login="root";
        Connection con=null;
        ResultSet rs=null;
        
        AksesJdbcOdbc db=new AksesJdbcOdbc("kraftee",login,pwd);
        String sql="Select * from pengunjung";
        try{
            con=db.connect();
            String nim=null;
            rs=db.executeQuery(sql);
            while(rs.next()){
                tempPengunjung=new pengunjung();
                tempPengunjung.setNama(rs.getString("nama"));
                tempPengunjung.setAlamat(rs.getString("nama_mhs"));
                tempPengunjung.setEmail(rs.getString("email"));
                tempPengunjung.setNohp(rs.getString("nohp"));
                listPengunjung.add(tempPengunjung);
            }
            daftarPengunjung=new pengunjung[listPengunjung.size()];
            listPengunjung.toArray(daftarPengunjung);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                db.disconnect();
                return daftarPengunjung;
            }catch(SQLException e){
                e.printStackTrace();
                return null;
            }
        }
    }
    public pengunjung getDataPengunjungByUname(String uname){
        pengunjung pgj=null;
        String pwd=null;
        String login="root";
        Connection con=null;
        ResultSet rs=null;
        
         AksesJdbcOdbc db=new AksesJdbcOdbc("kraftee",login,pwd);
         String sql="select * from pengunjung where username="+uname+"";
        
         try{
             con=db.connect();
             rs=db.executeQuery(sql);
             if(rs.next()){
                 pgj=new pengunjung();
                 pgj.setNama(rs.getString("nama"));
                 pgj.setAlamat(rs.getString("alamat"));
                 pgj.setEmail(rs.getString("email"));
                 pgj.setNohp(rs.getString("nohp"));
             }
         }
         catch(ClassNotFoundException e){
              e.printStackTrace();
         }catch(SQLException e){
              e.printStackTrace();
         }
         finally{
             try{
                 db.disconnect();
                 return pgj;
             }catch(SQLException e){
                  e.printStackTrace();
                  return null;
             }
         }
    }
    public boolean create(pengunjung dataPengunjung){
        String username=dataPengunjung.getUname();
        String password=dataPengunjung.getPassword();
        String nama=dataPengunjung.getNama();
        String alamat=dataPengunjung.getAlamat();
        String email=dataPengunjung.getEmail();
        String nohp=dataPengunjung.getNohp();
        
        Connection con=null;
        PreparedStatement pst=null;
        AksesJdbcOdbc akses = new AksesJdbcOdbc("kraftee","root","");
        try{
            String insert="insert into `pengunjung`(`username`,`password`,`nama`,`alamat`,`email`,`nohp` )values("
                    +"'"+username+"',"
                    +"'"+password+"',"
                    +"'"+nama+"',"
                    +"'"+alamat+"',"
                    +"'"+email+"',"
                    +"'"+nohp+"')";
            akses.connect();
            akses.executeUpdate(insert);
            akses.disconnect();
            return true;
                   
        }catch(ClassNotFoundException e){
            e.printStackTrace();
            return false;
        }catch(SQLException e){
           e.printStackTrace();
           return false;
        }
    }
}
