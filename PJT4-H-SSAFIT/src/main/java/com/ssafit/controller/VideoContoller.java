package com.ssafit.controller;

import java.io.IOException;

import com.ssafit.service.VideoService;
import com.ssaft.Dto.Video;
import com.ssaft.serviceImpl.VideoServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/video")
public class VideoContoller extends HttpServlet{
	
	private static VideoService videoService = VideoServiceImpl.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		service(request, response);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		service(request, response);
		
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		switch (action) {
		case "selectVideoList":
			selectVideoList(request, response);
			break;
		
		case "selectVideoDetail":
			selectVideoDetail(request, response);
			break;
			
		case "insertVideo":
			insertVideo(request, response);
			break;
			
		case "updateVideo":
			updateVideo(request, response);
			break;
			
		case "deleteVideo":
			deleteVideo(request, response);
			break;
		}
		
	}


	private void deleteVideo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("videoId"));
		
		videoService.del(id);
		response.sendRedirect("/video?action=selectVideoList");
		
	}


	private void updateVideo(HttpServletRequest request, HttpServletResponse response) {
		
		String title = request.getParameter("title");
		String url = request.getParameter("url");
		String part = request.getParameter("part");
		String channelName = request.getParameter("channelName");
		
		Video video = new Video(title, url, part, channelName);
		videoService.ins(video);
		
	}


	private void insertVideo(HttpServletRequest request, HttpServletResponse response) {
		
		String title = request.getParameter("title");
		String url = request.getParameter("url");
		String part = request.getParameter("part");
		String channelName = request.getParameter("channelName");
		
		Video video = new Video(title, url, part, channelName);
		videoService.ins(video);
		
	}


	private void selectVideoDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("videoId"));
		
		videoService.updViewCnt(id);
		
		request.setAttribute("video", videoService.selDtl(id));
		request.getRequestDispatcher("/video/videoDetail.jsp").forward(request, response);
		
	}


	private void selectVideoList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("videos", videoService.selList());
		request.getRequestDispatcher("/video/videoDetail.jsp").forward(request, response);
	}
	
	
	
}
