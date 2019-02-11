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

	public List<Sample> getSampleOne() {

		return null;
	}

	public int addSample(Sample sample) {
		
		return 0;
	}

	public int removeSample(Sample sample) {

		return 0;
	}

	public int modifySample(Sample sample) {

		return 0;
	}// 리턴값은 나중에 수정하기 , 모양만 존재

}
