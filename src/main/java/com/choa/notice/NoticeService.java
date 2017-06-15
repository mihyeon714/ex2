package com.choa.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.choa.util.PageMaker;

//NoticeService noticeService = new NoticeService();
@Service
public class NoticeService {
	
	//NoticeDAO 객체는 계속 사용할거니까 한번만 생성하면된다 
	@Inject
	private NoticeDAO noticeDAO;
	
	/*
	public NoticeService() {}
	
	//Constructor
	public NoticeService(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	
	
	//Setter
	public void setNoticeDAO(NoticeDAO noticeDAO) {
		this.noticeDAO = noticeDAO;
	}
	*/
	
	//view
	public NoticeDTO noticeView(int num) throws Exception{
		return noticeDAO.noticeView(num);
	}

	
	//List
	public List<NoticeDTO> noticeList(int curPage) throws Exception{
		//curPage, Paging처리 해야함
		int totalCount = noticeDAO.noticeCount();
		PageMaker pageMaker = new PageMaker(curPage);
		pageMaker.getMakePage(totalCount);
		
		return noticeDAO.noticeList(pageMaker.getRowMaker("", ""));
	}
	
	
	//write
	public int noticeWrite(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.noticeWrite(noticeDTO);
	}
	
	
	//update
	public int noticeUpdate(NoticeDTO noticeDTO) throws Exception{
		return noticeDAO.noticeUpdate(noticeDTO);
	}
	
	
	//delete
	public int noticeDelete(int num) throws Exception{
		return noticeDAO.noticeDelete(num);
	}
	
	
}
