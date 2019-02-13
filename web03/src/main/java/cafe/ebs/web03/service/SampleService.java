package cafe.ebs.web03.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cafe.ebs.web03.mapper.SampleMapper;
import cafe.ebs.web03.vo.Sample;

@Service
public class SampleService {
	@Autowired
	private SampleMapper sampleMapper;
	// 애노테이션 사이에 주석 넣지 않기.

	
	public List<Sample> getSampleList() {
		List<Sample> list = sampleMapper.selectSampleList();
		//List<Sample> list 안에 selectSampleList 메서드 호출한 리턴값을 넣는다
		//호출 한 값들이 들어 있는  list를 리턴한다
		return list;
	}

	public List<Sample> getSampleOne(int sampleId) {
		List<Sample> list = sampleMapper.selectSampleOne(sampleId);
		//List<Sample> list 안에 selectSampleOne 메서드에 sampleId 입력 후  호출한 리턴값을 넣는다
		//호출 한 값들이 들어 있는  list를 리턴한다
		return list;
	}

	public int addSample(String sampleName) {
		int result = sampleMapper.insertSample(sampleName);
		//insertSample메서드에 sampleName을 입력값으로 하여 메서드 호출한다
		//id를 자동 증가하고 name을 리스트에 추가한다
		//리턴값을 result객체에 넣어 메서드 실행되는지 확인할 수 있다
		//return 유무?
		return result;
	}

	public int removeSample(int sampleId) {
		int result = sampleMapper.deleteSample(sampleId);
		//deleteSample메서드에 sampleId을 입력값으로 하여 메서드 호출한다
		//삭제할 id를 가져와 삭제시킨다
		//리턴값을 result객체에 넣어 메서드 실행되는지 확인할 수 있다
		//return 유무?
		return result;
	}

	public int modifySample(int sampleId, String sampleName) {
		//sampleId와 sampleName을 입력값으로 받아 수정액션을 한다
		int result = sampleMapper.updateSample(sampleId,sampleName);
		//updateSample메서드에 수정 폼에서 입력받은  sampleId, sampleName을 이용하여 수정 한다 
		//리턴값을 result객체에 넣어 메서드 실행되는지 확인할 수 있다

		return result;
	}// 리턴값은 나중에 수정하기 완료

}
