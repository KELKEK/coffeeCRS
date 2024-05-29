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

public class CoffeeDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;// Statement를 상속받음, 바인딩변수를 지원
	ResultSet rs;
	// 0, 커피메뉴판
	public List<CoffeeDTO> coffeeMenu(int brandid) {
		List<CoffeeDTO> coflist = new ArrayList<CoffeeDTO>();
		String sql = "select * from coffee where coffee_brandid = ?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, brandid);
			rs = pst.executeQuery();
			while(rs.next()) {
				CoffeeDTO cof = new CoffeeDTO();
				cof.setCoffee_id(rs.getInt("coffee_id"));
				cof.setCoffee_name(rs.getString("coffee_name"));
				cof.setPrice(rs.getInt("price"));
				cof.setCaffeine(rs.getInt("caffeine"));
				cof.setSugar(rs.getInt("sugar"));
				cof.setQuality(rs.getInt("quality"));
				coflist.add(cof);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return coflist;
	}

	// 1, 커피집 등록
	public int coffeebrandInsert(CoffeeBrandDTO coffeebrand) {
		int result = 0;
		String sql = "insert into coffeebrand values(?, ?, ?, ?, ?, ?, ?, ?)";
		conn = DBUtil.dbConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, coffeebrand.getCoffee_brandid());
			pst.setString(2, coffeebrand.getSellerid());
			pst.setString(3, coffeebrand.getNickname());
			pst.setString(4, coffeebrand.getPword());
			pst.setString(5, coffeebrand.getPhone());
			pst.setString(6, coffeebrand.getCoffee_brandname());
			pst.setInt(7, coffeebrand.getDist_x());
			pst.setInt(8, coffeebrand.getDist_y());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return result;
	}

	// 2, 로그인
	public CoffeeBrandDTO sellerLogin(String Id, String Pw) {
		CoffeeBrandDTO ccus = null;
		String sql = "select nickname, coffee_brandname, pword, phone, coffee_brandid from coffeebrand where sellerid = ?";
		conn = DBUtil.dbConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, Id);
			rs = pst.executeQuery();
			if (rs.next()) {
				if (rs.getString("pword").equals(Pw)) {
					ccus = new CoffeeBrandDTO();
					ccus.setCoffee_brandid(rs.getInt("coffee_brandid"));
					ccus.setCoffee_brandname(rs.getString("coffee_brandname"));
					ccus.setNickname(rs.getString("nickname"));
					ccus.setPword(rs.getString("pword"));
					ccus.setPhone(rs.getString("phone"));
					ccus.setSellerid(Id);
				} else {
					ccus = new CoffeeBrandDTO();
					ccus.setSellerid("-2");// 비밀번호 오류
				}
			} else {
				ccus = new CoffeeBrandDTO();
				ccus.setSellerid("-1");// 존재하지 않는 직원
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// System.out.println("로그인 실패!!!");
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		System.out.println(ccus);
		return ccus;
	}

	// 3, 커피 등록
	public int coffeeInsert(CoffeeDTO coffee) {
		int result = 0;
		String sql = "insert into coffee values(seq_coffee_coffeeid.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		conn = DBUtil.dbConnection();

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, coffee.getCoffee_brandid());
			pst.setString(2, coffee.getCoffee_name());
			pst.setInt(3, coffee.getPrice());
			pst.setInt(4, coffee.getCaffeine());
			pst.setInt(5, coffee.getSugar());
			pst.setInt(6, coffee.getQuality());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}

		return result;
	}
	
	// 4, 커피 삭제
		public int coffeeDelete(int coffee_id) {
			int result = 0;
			String sql = "delete from coffee where coffee_id = ?";
			conn = DBUtil.dbConnection();

			try {
				pst = conn.prepareStatement(sql);
				pst.setInt(1, coffee_id);
				result = pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtil.dbDisconnect(conn, pst, rs);
			}
			return result;
		}

	// 5, 회원탈퇴(커피집 탈퇴)
	public int sellerDelete(String id, String pw, String phone) {
		int result = 0;
		String sql = "delete from coffeebrand where sellerid = ? and pword = ? and phone = ?";
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
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	


}
