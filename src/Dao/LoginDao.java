package Dao;

import DataBase.DBConnection;
import Select.AllStateSession;

public class LoginDao extends DBConnection {

 //   AllStateSession LoginSession = new AllStateSession();
    public LoginDao() {

    }
    public int Login(String Getid, String Getpw) {
        System.out.println(Getid);
        System.out.println(Getpw);
        try {
            if (Getid.length() == 5) {
                System.out.println("어드민 들어옴");
                dbConn();
                String sql = "select * from ADMIN Where ADMIN_CODE=?";
                System.out.println(sql);
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, Getid);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("들어옴");
                    if (Getid.equals(rs.getString(1)) == true && Getpw.equals(rs.getString(2)) == true) {

                        AllStateSession.login_id = Getid;
                        AllStateSession.login_state=1;
                        return 1;
                    } else if (Getpw.equals(rs.getString(2)) == false) {
                        System.out.println("어드민 로그인 실패");
                        return 5;
                    }
                }
            }
            else if(Getid.length()==6)
            {
                dbConn();
                System.out.println("교수 들어옴");
                String sql = "select * from PROFESSOR Where PROF_CODE=?";
                System.out.println(sql);
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, Getid);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                  
                    if (Getid.equals(rs.getString(1)) == true && Getpw.equals(rs.getString(3)) == true) {
                        System.out.println("교수 로그인 성공");

                        AllStateSession.login_id = Getid;
                        AllStateSession.login_state=2;
                        return 2;
                    } else if (Getpw.equals(rs.getString(2)) == false) {
                        System.out.println("\"교수 로그인 실패");
                        return 5;
                    }
                }
            }
            else if(Getid.length()==10)
            {
                dbConn();
                System.out.println("학생 들어옴");
                String sql = "select * from STUDENT Where STU_CODE=?";
                System.out.println(sql);
                pstmt = con.prepareStatement(sql);
                pstmt.setString(1, Getid);
                rs = pstmt.executeQuery();
                if (rs.next()) {
                    System.out.println("들어옴");
                    if (Getid.equals(rs.getString(1)) == true && Getpw.equals(rs.getString(3)) == true) {
                        System.out.println("학생 로그인 성공");

                        AllStateSession.login_id = Getid;
                        AllStateSession.login_state=3;
                        return 3;
                    } else if (Getpw.equals(rs.getString(2)) == false) {
                        System.out.println("학생 로그인 실패");
                        return 5;
                    }
                }
            }
        }catch (Exception e)
        {
            System.out.println("예외사항 발생");
        }
        finally {
            dbClose();
        }
        AllStateSession.login_id = null;
        AllStateSession.login_state=0;
        System.out.println("아무도 로그인 조회에 목록에 없음 확인해야됨");
        return 5;
    }



//    public int AdminLogin(String Getid, String Getpw) {
//
//        try {
//            dbConn();
//            String sql = "select * from ADMIN Where ADMIN_CODE=?";
//            System.out.println(sql);
//            pstmt = con.prepareStatement(sql);
//            pstmt.setString(1, Getid);
//            rs = pstmt.executeQuery();
//            if (rs.next()) {
//                System.out.println("들어옴");
//                if (Getid.equals(rs.getString(1)) == true && Getpw.equals(rs.getString(2)) == true) {
//                    System.out.println("어드민 로그인 성공");
//                    return 1;
//                } else if (Getpw.equals(rs.getString(2)) == false) {
//                    System.out.println("어드민 로그인 실패");
//                    return 2;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//        }
//        return 2;
//    }


}
