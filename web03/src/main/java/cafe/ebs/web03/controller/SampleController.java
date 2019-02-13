package cafe.ebs.web03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.ebs.web03.service.SampleService;
import cafe.ebs.web03.vo.Sample;

@Controller
public class SampleController {
	@Autowired private SampleService sampleService;
	
	
	
	// 1. 입력폼
	@GetMapping(value="/addSample")
	//get으로 addSample을 들어오면 입력폼을 출력한다
	//Get이기 때문에 GetMapping
	public String addSample() {
		System.out.println("get mapping addSample");
		System.out.println("입력화면 출력");
		return "addSample"; // view이름은 templates폴더에 addSample.html 
	}
	
	// 2. 입력 액션
	@PostMapping("/addSample")
	//입력은 post로 들어와서 입력액션을 한다
	//Post이기 때문에 PostMapping
	public String addSample(@RequestParam(value="sampleName") String sampleName) {
		//어노테이션을 RequestParam sampleName 객체에 입력받은 sampleName값을 저장한다
		System.out.println("post mapping addSample");
		sampleService.addSample(sampleName);
		//
		System.out.println("추가한 NAME : " + sampleName);
		return "redirect:/sampleList";
		//입력 후 sampleList로 경로 요청한다
	}
	
	//첫번째.뒤의 sampleName을 먼저 만들고 초기 null값
	
	//두번째.@RequestParam이용해 request.getParameter로  sampleName을 채운다
	
	// 3. 목록
	
	@GetMapping(value="/sampleList")
	public String sampleList(Model model) {
		System.out.println("get mapping sampleList");
		List<Sample> list = sampleService.getSampleList();
		//List<Sample>타입 list 객체에 getSampleList메서드 호출하여 리턴값을 넣는다 
		model.addAttribute("list", list);
		//model 이용해서 "list"에 세팅하는 역할
		System.out.println("리스트 출력");
		return "sampleList";
	}
	
	//request.setAttribute는 model 사용
	// 4. 삭제 액션
	@GetMapping("/removeSample")
	//get으로 받은것을 매핑해준다 
	//애노테이션@GetMapping 안해주면? 404에러 페이지 뜬다
	public String removeSample(@RequestParam(value="sampleId") int sampleId) {
		System.out.println("get mapping removeSample");
		sampleService.removeSample(sampleId);
		//리턴은 String 타입, 리스트로 이동
		System.out.println("삭제한 ID : " + sampleId);
		return "redirect:/sampleList";
		//삭제 액션 후 다시 리스트로 이동시킨다
	}
	// 5. 수정 폼
	@GetMapping("/modifySample")
	//get으로 정보 sampleId값을 받아서 수정 폼을 출력하는 역할
	//getSampleOne 메서드 이용해서 데이터 하나만 수정화면에 이동
	//전달받은 sampleId를 인자로 list에 저장하여 한 객체만 세팅해준다
	public String getSampleOne(Model model, @RequestParam(value="sampleId")int sampleId) {
		System.out.println("get mapping getSampleOne");
		List<Sample> list = sampleService.getSampleOne(sampleId);
		model.addAttribute("list_one", list);
		System.out.println("ID : "+sampleId+"  수정화면 출력");
		//sampleService.getSampleOne(sampleId);
		
		return "modifySample";
	}
	// 6. 수정 액션
	@PostMapping("/modifySample")
	//post로 /modifySample 을 들어오면 수정 액션을 한다
	public String modifySample(@RequestParam(value="sampleName")String sampleName,@RequestParam(value="sampleId")int sampleId) {
		//어노테이션 RequestParam 을 이용해 sampleName에 sampleName 입력값을 넣고, sampleId객체에 sampleId 입력값을 넣는다
		System.out.println("post mapping modifySample");
		sampleService.modifySample(sampleId,sampleName);
		//modifySample메서드에 입력받은 sampleId와 sampleName을 넣는다
		System.out.println("ID : "+sampleId);
		System.out.println("수정한 NAME : "+sampleName);
		return "redirect:/sampleList";
		//수정 후 sampleList로 경로 요청한다.
	}

}