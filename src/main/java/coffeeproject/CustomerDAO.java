package coffeeproject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;//Statement를 상속받음, 바인딩변수를 지원
	ResultSet rs;
	
	//1, 회원가입
	public int customInsert(CustomerDTO cus) {
		int result = 0; //insert 실패 시 -1, insert할 것이 없을 시 0
		String sql = "insert into customer(customerid, nickname, pword, phone)"
				+ " values(?, ?, ?, ?)";
		conn = DBUtil.dbConnection();//setAutoCommit(true)되어있음
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, cus.getCustomerid());
			pst.setString(2, cus.getNickname());
			pst.setString(3, cus.getPword());
			pst.setString(4, cus.getPhone());
			result = pst.executeUpdate();
			//DML문장은 excuteUpdate, select문은 excuteQuery
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("회원등록 실패!!");
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	//1, 커피 선호도 입력
	public int customFavor(CustomerFavorDTO cusf) {
		int result = 0;
		String sql = "insert into customer_favor values(?, ?, ?, ?, ?, ?)";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, cusf.getCustomerid());
			pst.setInt(2, cusf.getPrice());
			pst.setInt(3, cusf.getCaffeine());
			pst.setInt(4, cusf.getSugar());
			pst.setInt(5, cusf.getQuality());
			pst.setInt(6, cusf.getDistance());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	
	//2, 로그인
	public CustomerDTO customLogin(String Id, String Pw) {
		CustomerDTO ccus = null;
		String sql = "select nickname, dist_x, dist_y, pword, phone "
				+ " from customer "
				+ " where customerid = ?";
		conn = DBUtil.dbConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, Id);
			rs = pst.executeQuery();		
			if(rs.next()) {
				if(rs.getString("pword").equals(Pw)) {
					ccus = new CustomerDTO();
					ccus.setNickname(rs.getString("nickname"));
					ccus.setDist_x(rs.getInt("dist_x"));
					ccus.setDist_y(rs.getInt("dist_y"));
					ccus.setPhone(rs.getString("phone"));
					ccus.setPword(Pw);
					ccus.setCustomerid(Id);
				} else {
					ccus = new CustomerDTO();
					ccus.setCustomerid("-2");// 비밀번호 오류
				}
			} else {
				ccus = new CustomerDTO();
				ccus.setCustomerid("-1");// 존재하지 않는 직원
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("로그인 실패!!!");
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		System.out.println(ccus);
		return ccus;
	}
	

	//3, 추천값 반환
	public Map<String, String> customRecommend(String id){
		Map<String, String> recommendlist = new HashMap<>();
		String sql = "select * from (\r\n"
				+ "select coffee_name, coffee_brandname,  (cuf.price - (fe.price/900-10/9) + fe.quality - cuf.quality - (ABS(cuf.caffeine-0.025*fe.caffeine)+ABS(cuf.sugar-0.2*fe.sugar))+(power(cus.dist_x - cb.dist_x, 2)+power(cus.dist_y - cb.dist_y, 2))/18) + 100 추천값 "
				+ "from customer_favor cuf, customer cus, coffee fe left outer join coffeebrand cb using(coffee_brandid) "
				+ "where cuf.customerid = ? "
				+ "order by 3 desc) "
				+ "where rownum = 1 ";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				recommendlist.put("coffeename", rs.getString("coffee_name"));
				recommendlist.put("coffeebrand", rs.getString("coffee_brandname"));
				//hm.put("추천값", Integer.toString(rs.getInt("추천값")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return recommendlist;
	}
	

	
	//4-1, 고객ID 입력 시 로그인이 된 상태인지 확인하는 용도
	public CustomerDTO customLogin2(String Id) {
		CustomerDTO ccus = new CustomerDTO();
		String sql = "select customerid, nickname, dist_x, dist_y "
				+ " from customer "
				+ " where customerid = ?";
		conn = DBUtil.dbConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, Id);
			rs = pst.executeQuery();		
			while(rs.next()) {
				ccus.setCustomerid(rs.getString("customerid"));
				ccus.setNickname(rs.getString("nickname"));
				ccus.setDist_x(rs.getInt("dist_x"));
				ccus.setDist_y(rs.getInt("dist_y"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("로그인 실패!!!");
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return ccus;
	}

	
	//4, 커피 선호도 갱신
	public int customFavorUpdate(CustomerFavorDTO cusf) {
		int result = 0;
		String sql = "update customer_favor "
				+ "set price = ?, caffeine = ?, sugar = ?, quality = ?, distance = ? "
				+ "where customerid = ?";
		conn = DBUtil.dbConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cusf.getPrice());
			pst.setInt(2, cusf.getCaffeine());
			pst.setInt(3, cusf.getSugar());
			pst.setInt(4, cusf.getQuality());
			pst.setInt(5, cusf.getDistance());
			pst.setString(6, cusf.getCustomerid());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	//4.5. 유저 목적지 찾기
	public int customLocationUpdate(CustomerDTO cus) {
		int result = 0;
		String sql = "update customer "
				+ "set dist_x = ?, dist_y = ? "
				+ "where customerid = ?";
		conn = DBUtil.dbConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cus.getDist_x());
			pst.setInt(2, cus.getDist_y());
			pst.setString(3, cus.getCustomerid());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	
	//5, 커피 메뉴판
	public List<Object> customMenu() {
		List<Object> menuboard = new ArrayList<Object>();
		String sql = "SELECT COFFEE_NAME AS 커피명, COFFEE_BRANDNAME as 가게명, fe.price as 가격, fe.caffeine as 카페인양, fe.sugar as 당분, fe.quality as 원두품질 "
				+ "FROM coffee fe left outer join coffeebrand using(coffee_brandid) "
				+ "order by 2";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Map<String, Object> hm = new HashMap<>();
				hm.put("name", rs.getString("커피명"));
				hm.put("brand", rs.getString("가게명"));
				hm.put("price", rs.getString("가격"));
				hm.put("caffeine", rs.getString("카페인양"));
				hm.put("sugar", rs.getString("당분"));
				hm.put("quality", rs.getInt("원두품질"));
				menuboard.add(hm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return menuboard;
	}
	
	//6, 회원탈퇴
	public int customDelete(String id, String pw, String phone) {
		int result = 0;
		String sql = "delete from customer "
				+ "where customerid = ? and pword = ? and phone = ?";
		conn = DBUtil.dbConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			pst.setString(3, phone);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	
	//6-2, 회원 선호도 삭제
	public int customFavorDelete(String id) {
		int result = 0;
		String sql = "delete from customer_favor "
				+ "where customerid = ?";
		conn = DBUtil.dbConnection();
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
}
