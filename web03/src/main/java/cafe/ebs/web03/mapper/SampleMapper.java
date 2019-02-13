package cafe.ebs.web03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cafe.ebs.web03.vo.Sample;

@Mapper
public interface SampleMapper {
	List<Sample> selectSampleList();
	List<Sample> selectSampleOne(int sampleId);
	int insertSample(String sampleName);
	int deleteSample(int sampleId);
	int updateSample(int sampleId, String sampleName);

}
