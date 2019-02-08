package cafe.ebs.web03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.ebs.web03.service.SampleService;

public class SampleController {
	@Autowired private SampleService sampleService;
	// 1. 입력폼
	@GetMapping("/addSample")
	public String addSample() {
		
		return "addSample"; // view이름은 templates폴더에 addSample.html 
	}//Get이기 때문에 GetMapping
	// 2. 입력 액션
	@PostMapping
	public String addSample(@RequestParam(value="sampleName") String sampleName) {
		
		
		return "redirect:/sampleList";
	}
	//Post이기 때문에 PostMapping,
	//첫번째.뒤의 sampleName을 먼저 만들고 초기 null값
	//두번째.@RequestParam이용해 request.getParameter로  sampleName을 채운다
	
	// 3. 목록
	@GetMapping("/sampleList")
	public String sampleList(Model model) {
		return "sampleList";
	}
	//request.setAttribute는 model 사용
	// 4. 삭제 액션
	
	// 5. 수정 폼
	
	// 6. 수정 액션
}
