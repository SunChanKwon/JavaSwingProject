//package Dao;
//
//package Data_Jdbc.Data0719;
//
//import Data_Jdbc.Data0719.DBCON;
//import Data_Jdbc.Data0719.MemberVO;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MemberDAO extends DBCON {
//
//    public MemberDAO() {
//
//    }
//    //회원전체선택
//    public List<MemberVO> allRecord() {
//        List<MemberVO> list	= new ArrayList<MemberVO>();
//        try {
//            //1.db연결
//            dbConn();
//            String sql = "select mem_no, username, tel, email, addr, "
//                    + "to_char(write_date,'YYYY-MM-DD')write_date from member order by username asc";
//            //2. preparestatement 생성
//            pstmt = conn.prepareStatement(sql);
//
//            rs = pstmt.executeQuery();
//            while(rs.next()) {
//                MemberVO vo = new MemberVO();
//                vo.setMem_no(rs.getInt(1));
//                vo.setUsername(rs.getString(2));
//                vo.setTel(rs.getString(3));
//                vo.setEmail(rs.getString(4));
//                vo.setAddr(rs.getString(5));
//                vo.setWrite_date(rs.getString(6));
//                list.add(vo);
//            }
//        }catch(Exception e) {
//            System.out.println("전체회원 선택 에러발생....");
//            e.printStackTrace();
//        }finally{
//            dbClose();
//        }
//        return list;
//    }
//    //회원추가
//    public void excelInsert(){
//        int cnt=0;
//        try {
//            dbConn();
//        }catch(Exception e) {
//            System.out.println("엑셀데이터 집어넣기 오류남...");
//            e.printStackTrace();
//        }finally {
//            dbClose();
//        }
//    }
//
//    public int insertRecord(MemberVO vo) {
//        int cnt=0;
//        try {
//            dbConn();
//            String sql="insert into member(mem_no,username,email, addr,tel,WRITE_DATE) "
//                    + "values(mem_sq.nextval,?,?,?,?,sysdate)";
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1,  vo.getUsername());
//            pstmt.setString(2,  vo.getEmail());
//            pstmt.setString(3,  vo.getAddr());
//            pstmt.setString(4,  vo.getTel());
//
//            cnt = pstmt.executeUpdate();
//
//        }catch(Exception e) {
//            System.out.println("회원추가에러발생...");
//            e.printStackTrace();
//        }finally {
//            dbClose();
//        }
//        return cnt;
//    }
//    //회원수정
//    public int updateRecord(MemberVO vo) {
//
//        int cnt = 0;
//        try {
//            dbConn();
//
//            String sql = "update member set tel=?, email=?, addr=? where mem_no=?";
//
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, vo.getTel());
//            pstmt.setString(2, vo.getEmail());
//            pstmt.setString(3, vo.getAddr());
//            pstmt.setInt(4, vo.getMem_no());
//
//            cnt = pstmt.executeUpdate();
//
//        }catch(Exception e) {
//            System.out.println("회원수정 에러 발생....");
//            e.printStackTrace();
//        }finally {
//            dbClose();
//        }
//        return cnt;
//    }
//    //회원삭제
//    public int deleteRecord(int meo_no){
//        int cnt =0;
//
//        try {
//            dbConn();
//            String sql = "delete from member where mem_no=?";
//            pstmt =conn.prepareStatement(sql);
//            pstmt.setInt(1,meo_no);
//            cnt =pstmt.executeUpdate();
//
//        }catch (Exception e){
//            System.out.println("사원삭제 에러 발생..");
//            e.printStackTrace();
//        }finally {
//            dbClose();
//        }
//        return cnt;
//    }
//    //회원추가
//    //회원검색
//    public List<MemberVO> searchRecord(String search,String fielldName)
//    {
//        List<MemberVO> list = new ArrayList<MemberVO>();//리스트로 만들어준다
//
//        try{
//            dbConn();
//            String sql="select mem_no,username,tel,email,addr,"+"" +
//                    "to_char(write_date,'YYYY-MM-DD'write_date from member"+
//                    "where"+fielldName+"like ? order by username asc";//전달된 값에 따라서 변경됨
//            System.out.println("sql->"+sql);
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1,"%"+search+"%");
//            rs = pstmt.executeQuery();
//
//            while (rs.next())
//            {
//                MemberVO vo =new MemberVO();
//                vo.setMem_no(rs.getInt(1));
//                vo.setUsername(rs.getString(2));
//                vo.setTel(rs.getString(3));
//                vo.setEmail(rs.getString(4));
//                vo.setAddr(rs.getString(5));
//                vo.setWrite_date(rs.getString(6));
//
//                list.add(vo);
//            }
//
//        }catch (Exception e)
//        {
//            System.out.println("회원 검색에러러");
//        }finally {
//
//        }
//        return list;
//    }
//}
