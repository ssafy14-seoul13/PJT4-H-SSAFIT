package com.ssafit.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import com.ssafit.Dao.VideoDao;
import com.ssafit.Dto.Video;
import com.ssafy.board.util.DBUtil;

public class VideoDaoImpl implements VideoDao {
	
	private DBUtil util = DBUtil.getInstance();

	// 싱글턴으로 구현
	private static VideoDao VideoDao = new VideoDaoImpl();
	
	private VideoDaoImpl() {
	}

	public static VideoDao getInstance() {
		return VideoDao;
	}
	// 싱글턴
	
	@Override
	public void insert(Video video) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		Statement stmt = null;
		
		String sql = "INSERT INTO video (title, url, part, channel_name) VALUES(?, ?, ?, ?)";
		
		try {
			conn = util.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, video.getTitle());
			pstmt.setString(2, video.getUrl());
			pstmt.setString(3, video.getPart());
			pstmt.setString(4, video.getChannelName());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			util.close(pstmt, conn);
		}
	
	}

	@Override
	public Video select(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM video WHERE id=?";
		Video video = null;
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				video = new Video();
				video.setId(rs.getInt(1));
				video.setViewCnt(rs.getInt(2));
				video.setTitle(rs.getString(3));
				video.setUrl(rs.getString(4));
				video.setPart(rs.getString(5));
				video.setChannelName(rs.getString(6));
				video.setRegDate(rs.getTimestamp(7));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			util.close(rs,pstmt,conn);
		}
		
		return video;
	}

	@Override
	public void updateViewCount(int id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE board SET view_cnt = view_cnt+1 WHERE id=?";
		
		try {
			conn = util.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			util.close(pstmt, conn);
		}
		
	}

	@Override
	public List<Video> selectAll() {
		
		List<Video> videoList = new ArrayList<>();
		
		String sql = "SELECT * FROM video";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = util.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				Video video = new Video();
				
				video.setId(rs.getInt(1));
				video.setViewCnt(rs.getInt(2));
				video.setTitle(rs.getString(3));
				video.setUrl(rs.getString(4));
				video.setPart(rs.getString(5));
				video.setChannelName(rs.getString(6));
				video.setRegDate(rs.getTimestamp(7));
				
				videoList.add(video);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			util.close(rs, stmt, conn);
		}
		
		return videoList;
	}

	@Override
	public void delete(int id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM video WHERE id=?";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			util.close(pstmt, conn);
		}
		
	}

	@Override
	public void update(Video video) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE video SET title=?, url=?, part=?, channel_name=?";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, video.getTitle());
			pstmt.setString(2, video.getUrl());
			pstmt.setString(3, video.getPart());
			pstmt.setString(4, video.getChannelName());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			util.close(pstmt, conn);
		}
		
	} 

}
