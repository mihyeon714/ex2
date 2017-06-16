package com.choa.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.choa.util.PageMaker;

//NoticeService noticeService = new NoticeService();
@Service
public class NoticeService {

	//@Inject
	@Autowired //타입으로 찾지만
	@Qualifier("notice")  //이름이 이거인 친구를 찾아요
	private NoticeDAO noticeDAO;
	
	
	public void test(){
		System.out.println("noticeDAO= "+noticeDAO);
	}
	
	
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
