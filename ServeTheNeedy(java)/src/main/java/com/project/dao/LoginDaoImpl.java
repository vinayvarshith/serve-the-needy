package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.dbutil.PostgresConnection;
import com.project.model.NgoMember;

public class LoginDaoImpl implements LoginDao {

	NgoMember ngomember = null;

	@Override
	public NgoMember loginMember(int memberId, long aadhar) {
		boolean z = false;
		try (Connection connection = PostgresConnection.getConnection()) {
			String sql = "select * from project.ngo_member where member_id =? and aadhar =?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, memberId);
			System.out.println(memberId);
			preparedStatement.setLong(2, aadhar);
			System.out.println(aadhar);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				ngomember = new NgoMember();
				ngomember.setGender(resultSet.getString("gender"));
				ngomember.setMemberAddress(resultSet.getString("memberAddress"));
				ngomember.setMemberName(resultSet.getString("memberName"));
				ngomember.setMemberAge(resultSet.getInt("memberAge"));
				ngomember.setMemberPhone(resultSet.getLong("memberPhone"));
			} 
		} catch (ClassNotFoundException | SQLException e) {
		}
		System.out.println(z);
		return ngomember;

	}

}
