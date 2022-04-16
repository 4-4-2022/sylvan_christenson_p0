package com.p0.ringRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.p0.model.Rings;
import com.p0.util.Connector;

public class RingsRepositoryImpl implements RingRepository {

	public void seeMenu() {

	}

	public void giveRing(String receivingUser) {

	}

	public void customRing() {

	}

	public void buyRing() {

	}

	public List<Rings> findAllRings() {

		List<Rings> ringList = new ArrayList<Rings>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet set = null;
		final String SQL = "select * from rings";

		try {
			conn = Connector.getConnection();
			stmt = conn.createStatement();
			set = stmt.executeQuery(SQL);
			while (set.next()) {
				ringList.add(new Rings(set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5), set.getString(6), set.getString(7), set.getDouble(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				stmt.close();
				set.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return ringList;
	}
	
	@Override
	public void printRings() {
		for(Rings ring : findAllRings()) {
			System.out.println(ring);
		}
	}

	public void setEngraving() {
		
		
	}

}
