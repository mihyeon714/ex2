package com.choa.ex2;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.choa.notice.NoticeDTO;
import com.choa.notice.NoticeService;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {
	
	//service객체는 하나뿐이면 된다 
	//@Inject 는 어딘가에 만들어진 객체를 주입해주셈 이라는 말임 
	@Inject
	private NoticeService noticeService;
	

	@RequestMapping(value="noticeList",method=RequestMethod.GET)
	public void noticeList(Model model, @RequestParam(defaultValue="1")Integer curPage) throws Exception{
		List<NoticeDTO> ar = noticeService.noticeList(curPage);
		//System.out.println("ar="+ar.get(0).getContents());
		model.addAttribute("list", ar);
	}
	
	
	@RequestMapping(value="noticeView",method=RequestMethod.GET)
	public void noticeView(Integer num, Model model) throws Exception{
		if(num == null){
			num = 1;
		}
		NoticeDTO noticeDTO = noticeService.noticeView(num);
		model.addAttribute("noticeDTO", noticeDTO);
	}
	
	@RequestMapping(value="noticeWrite",method=RequestMethod.GET)
	public void noticeWrite(){}
	
	@RequestMapping(value="noticeWrite",method=RequestMethod.POST)
	public String noticeWrite(NoticeDTO noticeDTO, Model model,RedirectAttributes rd) throws Exception{
		int result = noticeService.noticeWrite(noticeDTO);
		String message = "Write FAIL";
		if(result > 0){
			message = "Write SUCCESS";
		}
		//model.addAttribute("message", message);
		//return "notice/noticeList?curPage=1";//이렇게 해도 리스트로 안감 기본적으로 forward 이기 때문임
		//return "notice/result"; // WEB-INF/views/notice/result.jsp //이건 fowarding 한것이고
		
		//바로 listpage로 가고싶다 //이때는 message 는 못사용한다 //redirect의 개념은 니가 주소에 쳐라 의미임
		
		
		rd.addFlashAttribute("message", message);
		return "redirect:/notice/noticeList?curPage=1"; //여기는 서버단이기 때문에 /ex1 이 아니라 / 로 쳐주면 된다
		//현재 위치가 /notice 이기 때문에 상대경로로 ./noticeList 라고 해도된다 
		//spring에서는 redirect 할 때도 message 를 보낼 수 있도록 객체를 제공한다 RedirectAttributes
	}
	
	
	//Form 호출
	@RequestMapping(value="noticeUpdate",method=RequestMethod.GET)
	public void noticeUpdate(Integer num, Model model) throws Exception{
		NoticeDTO noticeDTO = noticeService.noticeView(num); //DTO 하나를 받아오는것
		model.addAttribute("dto", noticeDTO);
	}
	

	//처리
	@RequestMapping(value="noticeUpdate",method=RequestMethod.POST)
	public String noticeUpdate(NoticeDTO noticeDTO, RedirectAttributes rd) throws Exception{
		int result = noticeService.noticeUpdate(noticeDTO);
		String message = "Update FAIL";
		if(result > 0){
			message = "Update SUCCESS";
		}
		
		rd.addFlashAttribute("message", message);
		return "redirect:/notice/noticeList?curPage=1";
	}
	
	@RequestMapping(value="noticeDelete",method=RequestMethod.GET)
	public String noticeDelete(Integer num,RedirectAttributes rd) throws Exception{
		if(num == null){}
		int result = noticeService.noticeDelete(num);
		String message = "Delete FAIL";
		if(result > 0){
			message = "Delete SUCCESS";
		}
		
		rd.addFlashAttribute("message", message);
		return "redirect:/notice/noticeList?curPage=1";
	}
	
	
	
	
}
