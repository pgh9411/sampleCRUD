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
	public String addSample() {
		System.out.println("get mapping");
		return "addSample"; // view이름은 templates폴더에 addSample.html 
	}
	//Get이기 때문에 GetMapping
	// 2. 입력 액션
	@PostMapping("/addSample")
	public String addSample(@RequestParam(value="sampleName") String sampleName) {
		System.out.println("post mapping");
		sampleService.addSample(sampleName);
		return "redirect:/sampleList";
	}
	//Post이기 때문에 PostMapping,
	//첫번째.뒤의 sampleName을 먼저 만들고 초기 null값
	//두번째.@RequestParam이용해 request.getParameter로  sampleName을 채운다
	
	// 3. 목록
	
	@GetMapping(value="/sampleList")
	public String sampleList(Model model) {
		List<Sample> list = sampleService.getSampleList();

		model.addAttribute("list", list);
		return "sampleList";
	}
	//request.setAttribute는 model 사용
	// 4. 삭제 액션
	@GetMapping("/removeSample")
	//get으로 받은것을 매핑해준다 
	//애노테이션@GetMapping 안해주면? 404에러 페이지 뜬다
	public String removeSample(@RequestParam(value="sampleId") int sampleId) {
		sampleService.removeSample(sampleId);
		//리턴은 String 타입, 리스트로 이동
		return "redirect:/sampleList";
		//삭제 액션 후 다시 리스트로 이동시킨다
	}
	// 5. 수정 폼
	@GetMapping("/modifySample")
	//get으로 정보 sampleId값을 받아서 수정 폼을 출력하는 역할
	//getSampleOne 메서드 이용해서 데이터 하나만 수정화면에 이동
	//전달받은 sampleId를 인자로 list에 저장하여 한 객체만 세팅해준다
	public String getSampleOne(Model model, @RequestParam(value="sampleId")int sampleId) {
		
		List<Sample> list = sampleService.getSampleOne(sampleId);
		model.addAttribute("list_one", list);
		//sampleService.getSampleOne(sampleId);
		
		return "modifySample";
	}
	// 6. 수정 액션
	@PostMapping("/modifySample")
	public String modifySample(@RequestParam(value="sampleName")String sampleName,@RequestParam(value="sampleId")int sampleId) {
			
		sampleService.modifySample(sampleId,sampleName);
		
		return "redirect:/sampleList";
	}

}