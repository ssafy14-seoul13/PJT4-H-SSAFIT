package com.ssafit.DaoImpl;

import java.util.*;

import com.ssafit.Dao.VideoDao;
import com.ssafit.Dto.Video;

public class VideoDaoImpl implements VideoDao {
	
	private List<Video> videoList = new ArrayList<>();

	// 싱글턴으로 구현
	private static VideoDao VideoDao = new VideoDaoImpl();
	
	private VideoDaoImpl() {
		putDummyVideo();
	}
	
	private void putDummyVideo() {
		videoList.add(new Video("전신 다이어트 최고의 운동 [칼소폭 찐 핵핵매운맛]", "https://www.youtube.com/embed/gMaB-fG4u4g", "전신", "ThankyouBUBU"));
		videoList.add(new Video("하루 15분! 전신 칼로리 불태우는 다이어트 운동", "https://www.youtube.com/embed/swRNeYw1JkY", "전신",  "ThankyouBUBU"));
		videoList.add(new Video("상체 다이어트 최고의 운동 BEST [팔뚝살/겨드랑이살/등살/가슴어깨라인]", "https://www.youtube.com/embed/54tTYO-vU2E", "상체","ThankyouBUBU"));
		videoList.add(new Video( "상체비만 다이어트 최고의 운동 [상체 핵매운맛]", "https://www.youtube.com/embed/QqqZH3j_vH0", "상체",  "ThankyouBUBU"));
		videoList.add(new Video("하체운동이 중요한 이유? 이것만 보고 따라하자 ! [하체운동 교과서]", "https://www.youtube.com/embed/tzN6ypk6Sps", "하체", "김강민"));
		videoList.add(new Video( "저는 하체 식주의자 입니다",  "https://www.youtube.com/embed/u5OgcZdNbMo", "하체", "GYM종국"));
		videoList.add(new Video("11자복근 복부 최고의 운동 [복근 핵매운맛]", "https://www.youtube.com/embed/PjGcOP-TQPE",  "복부", "ThankyouBUBU"));
		videoList.add(new Video("(Sub)누워서하는 5분 복부운동!! 효과보장! (매일 2주만 해보세요!)", "https://www.youtube.com/embed/7TLk7pscICk",  "복부", "SomiFit"));
	}

	public static VideoDao getInstance() {
		return VideoDao;
	}
	
	@Override
	public void insert(Video video) {
		videoList.add(video);
	}

	@Override
	public Video select(int id) {
		return videoList.get(id);
	}

	@Override
	public void updateViewCount(int id) {
		Video nowVideo = videoList.get(id);
		nowVideo.setViewCnt(nowVideo.getViewCnt()+1);
	}

	@Override
	public List<Video> selectAll() {
		return videoList;
	}

	@Override
	public void delete(int id) {
		videoList.remove(id);
	}

	@Override
	public void update(Video video) {
		
		int n = videoList.indexOf(video);
		videoList.remove(n);
		videoList.add(n,video);
		
	}

}
