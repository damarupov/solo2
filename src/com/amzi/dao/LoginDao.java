package com.amzi.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

public class LoginDao {
    
	public static boolean validate(String name, String pass) {        
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String url = 	  "jdbc:mysql://ec2-18-223-152-203.us-east-2.compute.amazonaws.com:3306/";
        String dbName =   "myDB2?useSSL=false";
        String driver =   "com.mysql.jdbc.Driver";
        String userName = "newMysqlRemoteuser";
        String password = "mypassword";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager
                    .getConnection(url + dbName, userName, password);

            pst = conn
                    .prepareStatement("select * from login where user=? and password=?");
            pst.setString(1, name);
            pst.setString(2, pass);
            

            rs = pst.executeQuery();
            status = rs.next();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;
    }
	
	public static boolean newUser (String name, String pass , int a) {        
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String result = "";

        String url = 	  "jdbc:mysql://ec2-18-223-152-203.us-east-2.compute.amazonaws.com:3306/";
        String dbName =   "myDB2?useSSL=false";
        String driver =   "com.mysql.jdbc.Driver";
        String userName = "newMysqlRemoteuser";
        String password = "mypassword";
        try {
        	System.out.println(name + pass);
            Class.forName(driver).newInstance();
            conn = DriverManager
                    .getConnection(url + dbName, userName, password);

            pst = conn.prepareStatement("insert into login (user, password, entries) values ('"+name+"', '"+pass+"', 0)");
            
            pst.executeUpdate();
            status = true;


        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }      
        return status;
    }
    
	public static String incrementEntry (String name) {        
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String result = "";

        String url = 	  "jdbc:mysql://ec2-18-223-152-203.us-east-2.compute.amazonaws.com:3306/";
        String dbName =   "myDB2?useSSL=false";
        String driver =   "com.mysql.jdbc.Driver";
        String userName = "newMysqlRemoteuser";
        String password = "mypassword";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager
                    .getConnection(url + dbName, userName, password);

            pst = conn
                    .prepareStatement("select entries from login where user=?");
            pst.setString(1, name);    
            rs = pst.executeQuery();
            rs.next();
            
            result = rs.getString("entries");
            
            int i = Integer.parseInt(result);
            
            
            if(i == 0) {
            	result = "1";
            }
            else if ( i > 1) {
            	
            	i++;
            	result = "" + i;
            }
            

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
	
	public static String incrementEntry (String name, String pass , int a) {        
        boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String result = "";

        String url = 	  "jdbc:mysql://ec2-18-223-152-203.us-east-2.compute.amazonaws.com:3306/";
        String dbName =   "myDB2?useSSL=false";
        String driver =   "com.mysql.jdbc.Driver";
        String userName = "newMysqlRemoteuser";
        String password = "mypassword";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager
                    .getConnection(url + dbName, userName, password);

            pst = conn
                    .prepareStatement("select entries from login where user=?");
            pst.setString(1, name);    
            rs = pst.executeQuery();
            rs.next();
            
            result = rs.getString("entries");
            //int i = Integer.parseInt(result);
            //rs.updateInt(3, a);
            a+=1;
            conn.prepareStatement("insert into login (user, password, entries) values ('"+name+"', '"+pass+"', a)");
            

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}