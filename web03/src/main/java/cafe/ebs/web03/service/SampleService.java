package cafe.ebs.web03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.ebs.web03.mapper.SampleMapper;
import cafe.ebs.web03.vo.Sample;

@Service
public class SampleService {
	@Autowired
	private SampleMapper sampleMapper;
	// 애노테이션 사이에 주석 넣지 않기

	public List<Sample> getSampleList() {
		List<Sample> list = sampleMapper.selectSampleList();
		return list;
	}

	public List<Sample> getSampleOne(int sampleId) {
		List<Sample> list = sampleMapper.selectSampleOne(sampleId);
		return list;
	}

	public int addSample(String sample) {
		int result = sampleMapper.insertSample(sample);
		System.out.println("입력 값 :" + result);
		//return 유무?
		return result;
	}

	public int removeSample(int sampleId) {
		int result = sampleMapper.deleteSample(sampleId);
		System.out.println("입력 값 :" + result);
		//return 유무?
		return result;
	}

	public int modifySample(int sampleId, String sampleName) {
		//sampleId와 sampleName을 입력값으로 받아 수정액션을 한다
		int result = sampleMapper.updateSample(sampleId,sampleName);
		System.out.println(result + " : 입력 결과는?");
		return result;
	}// 리턴값은 나중에 수정하기 o

}
