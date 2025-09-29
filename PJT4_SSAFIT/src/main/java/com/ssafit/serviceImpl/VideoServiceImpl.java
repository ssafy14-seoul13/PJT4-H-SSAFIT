package com.ssafit.serviceImpl;

import java.util.List;

import com.ssafit.Dao.VideoDao;
import com.ssafit.DaoImpl.VideoDaoImpl;
import com.ssafit.Dto.Video;
import com.ssafit.service.VideoService;

public class VideoServiceImpl implements VideoService {
	
	
	// 싱글턴으로 구현
	private static VideoService service = new VideoServiceImpl();
	
	private VideoServiceImpl() {
	}
	
	public static VideoService getInstance() {
		return service;
	}
	
	private VideoDao dao = VideoDaoImpl.getInstance();
	

	@Override
	public void ins(Video video) {
		
		dao.insert(video);
	}

	@Override
	public Video selDtl(int id) {

		return dao.select(id);
	}

	@Override
	public void updViewCnt(int id) {

		dao.updateViewCount(id);
	}

	@Override
	public List<Video> selList() {
		return dao.selectAll();
	}

	@Override
	public void del(int id) {
		dao.delete(id);
	}

	@Override
	public void upd(Video video) {
		
		dao.update(video);
	}

}
